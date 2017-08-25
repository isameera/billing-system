package com.webapps.filterlogin.beans;

import com.ejb.model.businesslogic.Login;
import com.ejb.model.common.ComLib;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.common.Util;
import com.ejb.model.entity.LoginSession;
import com.ejb.model.entity.UserLogin;
import com.ejb.model.entity.UserLoginGroup;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 * Simple login bean.
 *
 * @author itcuties
 */
//@Named(value = "login")
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    @EJB
    private UniDBLocal uniDB;

    @EJB
    private Login login;

    @EJB
    private ComLib comLib;

    private static final long serialVersionUID = 7765876811740798583L;

    private String username;
    private String password;
    private int loginsession;
    private String date;
    public static String order_no;
    private String company_name;
    private String company_add1;
    private String company_add2;
    private String company_add3;
    private String company_email;
    private String company_phone;
    private String company_fax;
    private String company_logo;
    private String profileName;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getCompany_add1() {
        return company_add1;
    }

    public void setCompany_add1(String company_add1) {
        this.company_add1 = company_add1;
    }

    public String getCompany_add2() {
        return company_add2;
    }

    public void setCompany_add2(String company_add2) {
        this.company_add2 = company_add2;
    }

    public String getCompany_add3() {
        return company_add3;
    }

    public void setCompany_add3(String company_add3) {
        this.company_add3 = company_add3;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public String getCompany_phone() {
        return company_phone;
    }

    public void setCompany_phone(String company_phone) {
        this.company_phone = company_phone;
    }

    public String getCompany_fax() {
        return company_fax;
    }

    public void setCompany_fax(String company_fax) {
        this.company_fax = company_fax;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public int getLoginsession() {
        return loginsession;
    }

    public void setLoginsession(int loginsession) {
        this.loginsession = loginsession;
    }

    private boolean loggedIn;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    /**
     * Login operation.
     *
     * @return
     */
    public String doLogin() {
        // Get every user from our sample database :)
//        for (String user : users) {
//            String dbUsername = user.split(":")[0];
//            String dbPassword = user.split(":")[1];

        // Successful login
        if (login.ValidateUserLogin(username, password)) {

            loggedIn = true;
            UserLogin userLogin = Util.ul;

            setProfileName(userLogin.getGeneralUserProfileId().getFirstName()+" "+ userLogin.getGeneralUserProfileId().getLastName());

            UserLoginGroup ulg = new UserLoginGroup();
            ulg.setGeneralOrganizationProfileId(userLogin.getGeneralOrganizationProfileId());
            ulg.setUserLoginId(userLogin);
            ulg.setUserRoleId(userLogin.getUserRoleId());
            ulg.setIsActive(1);
            ulg.setIsFirstTime(false);
            ulg.setMaxLoginAttempt(0);
            ulg.setCountAttempt(0);
            uniDB.create(ulg);

            LoginSession ls = new LoginSession();
            ls.setGeneralOrganizationProfileId(userLogin.getGeneralOrganizationProfileId());
            ls.setUserLoginId(userLogin);
            ls.setStartTime(new Date());
            ls.setUserLoginGroupId(ulg);
            uniDB.create(ls);

            setLoginsession(ls.getId());

            date = ComLib.getDate(new Date());
            order_no = comLib.VIDGenerator(userLogin.getGeneralOrganizationProfileId().getId(), 91);

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.getSession().setAttribute("loginsession", ls);
            request.getSession().setAttribute("userloin", userLogin);
            request.getSession().setAttribute("gop", userLogin.getGeneralOrganizationProfileId());
            request.getSession().setAttribute("gopId", userLogin.getGeneralOrganizationProfileId().getId());
            request.getSession().setAttribute("gup", userLogin.getGeneralUserProfileId());
            request.getSession().setAttribute("gopMainId", userLogin.getGeneralOrganizationProfileId().getId() - 1);

            Util.gopId = userLogin.getGeneralOrganizationProfileId().getId();
            Util.gopIdMain = Util.gopId - 1;
            Util.gupId = userLogin.getGeneralUserProfileId().getId();
            Util.ulId = userLogin.getId();
            Util.lsId = ls.getId();

            Util.gop = userLogin.getGeneralOrganizationProfileId();
            Util.gup = userLogin.getGeneralUserProfileId();
            Util.ul = userLogin;
            Util.ls = ls;

            company_name = userLogin.getGeneralOrganizationProfileId().getName();
            company_add1 = userLogin.getGeneralOrganizationProfileId().getAddress1();
            company_add2 = userLogin.getGeneralOrganizationProfileId().getAddress2();
            company_add3 = userLogin.getGeneralOrganizationProfileId().getAddress3();
            company_email = userLogin.getGeneralOrganizationProfileId().getEmail();
            company_phone = userLogin.getGeneralOrganizationProfileId().getPhone();
            company_fax = userLogin.getGeneralOrganizationProfileId().getFax();
            company_logo = userLogin.getGeneralOrganizationProfileId().getLogo();

            return navigationBean.redirectToWelcome();
        } else {
            System.out.println("errrrrrrrror.......");
            // Set login ERROR
            RequestContext contex = RequestContext.getCurrentInstance();
            contex.execute("swal('Oops...','Usename or password is invalid!','error')");
        }
//        }

        // To to login page
        return null;

    }

    /**
     * Logout operation.
     *
     * @return
     */
    public void doLogout() throws IOException {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;

        // Set logout message
//		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
//		msg.setSeverity(FacesMessage.SEVERITY_INFO);
//		FacesContext.getCurrentInstance().addMessage(null, msg);
        RequestContext contex = RequestContext.getCurrentInstance();
        contex.execute("swal('Logout success!','','success')");

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("../login.xhtml");
        //    return navigationBean.toLogin();
    }

    public void doLogoutSecond() throws IOException {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;

        // Set logout message
//		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
//		msg.setSeverity(FacesMessage.SEVERITY_INFO);
//		FacesContext.getCurrentInstance().addMessage(null, msg);
        RequestContext contex = RequestContext.getCurrentInstance();
        contex.execute("swal('Logout success!','','success')");

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("login.xhtml");
        //    return navigationBean.toLogin();
    }

    // ------------------------------
    // Getters & Setters 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

}
