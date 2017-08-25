/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.businesslogic;

import com.ejb.model.common.ComLib;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.GeneralOrganizationProfile;
import com.ejb.model.entity.GeneralUserProfile;
import com.ejb.model.entity.GupGopManager;
import com.ejb.model.entity.OrganizationType;
import com.ejb.model.entity.OrganizationTypeManager;
import com.ejb.model.entity.RegistrationType;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Sameera
 */
@Stateless
@LocalBean
public class CustomerRegistration {

    @EJB
    private ComLib comLib;

    @EJB
    private UniDBLocal uniDB;

    public List<GeneralOrganizationProfile> getGeneralOrganizationProfile() {
        return uniDB.findAll(GeneralOrganizationProfile.class);
    }

    public boolean SaveGOPCorporate(String name, String no, String street, String city, String postal_code, String phone_i, String phone_ii, String email, String fax, int main_gop) {

        boolean status = false;
        try {

            RegistrationType RT = (RegistrationType) uniDB.find(1, RegistrationType.class);
            OrganizationType OT = (OrganizationType) uniDB.find(18, OrganizationType.class);
            String code = comLib.ORGCodeGenerator(main_gop, 1);

            GeneralOrganizationProfile g = null;
            List<GeneralOrganizationProfile> gops = uniDB.searchByQuerySingle("SELECT o FROM GeneralOrganizationProfile o WHERE o.name='" + name + "'");
            for (GeneralOrganizationProfile gop : gops) {
                g = gop;
            }

            if (g == null) {
                g = new GeneralOrganizationProfile();
                g.setAddress1(no);
                g.setAddress2(street);
                g.setAddress3(city);
                g.setName(name);
                g.setEmail(email);
                g.setPostalCode(postal_code);
                g.setPhone(phone_i);
                g.setPhoneOther(phone_ii);
                g.setRegistrationTypeId(RT);
                g.setOrganizationTypeId(OT);
                g.setFax(fax);
                uniDB.create(g);
            } else {
                g.setAddress1(no);
                g.setAddress2(street);
                g.setAddress3(city);
                g.setName(name);
                g.setEmail(email);
                g.setPostalCode(postal_code);
                g.setPhone(phone_i);
                g.setPhoneOther(phone_ii);
                g.setFax(fax);
                uniDB.update(g);
            }

            OrganizationTypeManager otm = null;
            List<OrganizationTypeManager> otms = uniDB.searchByQueryLimit("SELECT o FROM OrganizationTypeManager o WHERE o.generalOrganizationProfileId.id='" + main_gop + "' AND o.organizationTypeId.id='18' AND o.generalOrganizationProfileId1.id='" + g.getId() + "'", 500);
            for (OrganizationTypeManager o : otms) {
                otm = o;
            }

            if (otm == null) {
                otm = new OrganizationTypeManager();
                otm.setCode(code);
                otm.setGeneralOrganizationProfileId((GeneralOrganizationProfile) uniDB.find(main_gop, GeneralOrganizationProfile.class));
                otm.setGeneralOrganizationProfileId1(g);
                otm.setOrganizationTypeId(OT);
                uniDB.create(otm);
            }

            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean SaveGUP(String nic, String title, String first_name, String mid_name, String last_name, String no, String street, String city, String gender, String phone_i, String phone_ii, String email, int main_gop) {

        boolean status = false;
        try {

            GeneralOrganizationProfile gop = (GeneralOrganizationProfile) uniDB.find(main_gop, GeneralOrganizationProfile.class);
            String code = comLib.ORGCodeGenerator(main_gop, 2);

            GeneralUserProfile g = null;
            List<GeneralUserProfile> gups = uniDB.searchByQuerySingle("SELECT g FROM GeneralUserProfile g WHERE g.nic='" + nic + "'");
            for (GeneralUserProfile gup : gups) {
                g = gup;
            }

            if (g == null) {

                g = new GeneralUserProfile();
                g.setNic(nic);
                g.setAddress1(no);
                g.setAddress2(street);
                g.setAddress3(city);
                g.setTitle(title);
                g.setFirstName(first_name);
                g.setMidName(mid_name);
                g.setLastName(last_name);
                g.setFullName(first_name + " " + mid_name + " " + last_name);
                g.setEmail(email);
                g.setGender(gender);
                g.setMobilePhone(phone_i);
                g.setHomePhone(phone_ii);
                g.setGeneralOrganizationProfileIdGop(gop);
                uniDB.create(g);
            } else {
//                g.setNic(nic);
                g.setAddress1(no);
                g.setAddress2(street);
                g.setAddress3(city);
                g.setTitle(title);
                g.setFirstName(first_name);
                g.setMidName(mid_name);
                g.setLastName(last_name);
                g.setFullName(first_name + " " + mid_name + " " + last_name);
                g.setEmail(email);
                g.setGender(gender);
                g.setMobilePhone(phone_i);
                g.setHomePhone(phone_ii);
                g.setGeneralOrganizationProfileIdGop(gop);
                uniDB.update(g);
            }

            GupGopManager otm = null;
            List<GupGopManager> otms = uniDB.searchByQuerySingle("SELECT o FROM GupGopManager o WHERE o.generalOrganizationProfileId.id='" + main_gop + "' AND o.generalUserProfileId.id='" + g.getId() + "'");
            for (GupGopManager o : otms) {
                otm = o;
            }

            if (otm == null) {
                GupGopManager ggm = new GupGopManager();
                ggm.setCode(code);
                ggm.setGeneralOrganizationProfileId((GeneralOrganizationProfile) uniDB.find(main_gop, GeneralOrganizationProfile.class));
                ggm.setGeneralUserProfileId(g);
                uniDB.create(ggm);
            }

            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean SaveIndividualCompany(String name, String no, String street, String city, String postal_code, String phone_i, String phone_ii, String email, String fax, int main_gop) {

        boolean status = false;
        try {

            RegistrationType RT = (RegistrationType) uniDB.find(1, RegistrationType.class);
            OrganizationType OT = (OrganizationType) uniDB.find(28, OrganizationType.class);
            String code = comLib.ORGCodeGenerator(main_gop, 3);

            GeneralOrganizationProfile g = null;
            List<GeneralOrganizationProfile> gops = uniDB.searchByQuerySingle("SELECT o FROM GeneralOrganizationProfile o WHERE o.name='" + name + "'");
            for (GeneralOrganizationProfile gop : gops) {
                g = gop;
            }

            if (g == null) {
                g = new GeneralOrganizationProfile();
                g.setAddress1(no);
                g.setAddress2(street);
                g.setAddress3(city);
                g.setName(name);
                g.setEmail(email);
                g.setPostalCode(postal_code);
                g.setPhone(phone_i);
                g.setPhoneOther(phone_ii);
                g.setRegistrationTypeId(RT);
                g.setOrganizationTypeId(OT);
                g.setFax(fax);
                uniDB.create(g);
            } else {
                g.setAddress1(no);
                g.setAddress2(street);
                g.setAddress3(city);
                g.setName(name);
                g.setEmail(email);
                g.setPostalCode(postal_code);
                g.setPhone(phone_i);
                g.setPhoneOther(phone_ii);
                g.setFax(fax);
                uniDB.update(g);
            }

            OrganizationTypeManager otm = null;
            List<OrganizationTypeManager> otms = uniDB.searchByQuerySingle("SELECT o FROM OrganizationTypeManager o WHERE o.generalOrganizationProfileId.id='" + main_gop + "' AND o.organizationTypeId.id='28' AND o.generalOrganizationProfileId1.id='" + g.getId() + "'");
            for (OrganizationTypeManager o : otms) {
                otm = o;
            }

            if (otm == null) {
                otm = new OrganizationTypeManager();
                otm.setCode(code);
                otm.setGeneralOrganizationProfileId((GeneralOrganizationProfile) uniDB.find(main_gop, GeneralOrganizationProfile.class));
                otm.setGeneralOrganizationProfileId1(g);
                otm.setOrganizationTypeId(OT);
                uniDB.create(otm);
            }

            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

}
