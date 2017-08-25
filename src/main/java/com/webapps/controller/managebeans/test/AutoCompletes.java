/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.test;

/**
 *
 * @author Sameera
 */
import com.ejb.model.common.ComDev;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
public class AutoCompletes {

    @EJB
    private ComDev comDev;

    String countryName;

    public List<String> countryList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("India");
        list.add("Australia");
        list.add("Germany");
        list.add("Italy");
        list.add("United States");
        list.add("Russia");
//        List<String> list = comDev.getORGnameList();
        System.out.println("list=" + list);
        return list;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String CountryName) {
        this.countryName = CountryName;
    }

    public void onItemSelect(SelectEvent event) {
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }

//    	public void handleSelect(SelectEvent e){
//		AutoCompletes p = (AutoCompletes)e.getObject();
//		FacesContext.getCurrentInstance().addMessage(null,
//				new FacesMessage(FacesMessage.SEVERITY_INFO,
//					"Add Player :: Player Info: ID  :: Name :: "+p.getCountryName(),""));
//	}
}
