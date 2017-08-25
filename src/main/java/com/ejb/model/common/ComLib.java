/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.common;

import com.ejb.model.entity.GeneralOrganizationProfile;
import com.ejb.model.entity.GupGopManager;
import com.ejb.model.entity.OrganizationTypeManager;
import com.ejb.model.entity.PaymentHistory;
import com.ejb.model.entity.UncommonVoucherDetails;
import com.ejb.model.entity.Voucher;
import com.ejb.model.entity.VoucherItem;
import com.ejb.model.entity.VoucherType;
import com.ejb.model.superclasses.VoucherListSuper;
import com.ejb.model.superclasses.UniversalSearchResource;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Sameera
 */
@Stateless
@LocalBean
public class ComLib {

    @EJB
    private ComDev comDev1;

    @EJB
    private ComDev comDev;

    @EJB
    private UniDBLocal uniDB;

    public static Date getDateObject(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date FormattedDate = null;
        try {
            FormattedDate = formatter.parse(date);
        } catch (Exception e) {
        }

        return FormattedDate;
    }

    public static Date getDateObjectUltima(String date) {

        Date FormattedDate = null;
        try {

            SimpleDateFormat parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
            FormattedDate = parser.parse(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return FormattedDate;
    }

    public static String getDate(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(date);

    }

    public static String getDateFormated(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd");

        return formatter.format(date);

    }

    public static String getDouble(double value) {

        DecimalFormat myFormatter = new DecimalFormat("###,###,###.00");
        String output = myFormatter.format(value);
        return output;

    }

    public static String getDoubleWithoutDes(double value) {

        DecimalFormat myFormatter = new DecimalFormat("###,###,###");
        String output = myFormatter.format(value);
        return output;

    }

    public static String getFullDate(Date time) {

        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US);

        return formatter.format(time);
    }

    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH)
                || (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    public static long getDayCount(String start, String end) {
        long diff = -1;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateStart = simpleDateFormat.parse(start);
            Date dateEnd = simpleDateFormat.parse(end);

            //time is always 00:00:00 so rounding should help to ignore the missing hour when going from winter to summer time as well as the extra hour in the other direction
            diff = Math.round((dateEnd.getTime() - dateStart.getTime()) / (double) 86400000);
        } catch (Exception e) {
            //handle the exception according to your own situation
        }
        return diff;
    }

    public static double getRounded(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public String VIDGenerator(int gop_id, int vt_id) {

        GeneralOrganizationProfile gop = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        VoucherType vt = (VoucherType) uniDB.find(vt_id, VoucherType.class);

        int id = 0;
        String abrivation = "";
        String generated_id = "";
        abrivation = vt.getIdAbbreviation();

        String voucher_id = "";
        String v = null;

        try {
            List<Voucher> VoucherList = uniDB.searchByQuerySingle("SELECT v FROM Voucher v WHERE v.voucherTypeId.id='" + vt.getId() + "' AND v.generalOrganizationProfileId.id='" + gop.getId() + "' ORDER BY v.voucherId DESC");
            for (Voucher voucher : VoucherList) {
                v = voucher.getVoucherId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (v == null) {
            id = 0;
        } else {
            String vid = v;

            String number = "";

            for (int x = 0; x < vid.length(); x++) {
                if (Character.isDigit(vid.charAt(x))) {
                    number += vid.charAt(x);
                }
            }

            id = ((number.equals("")) ? 0 : Integer.parseInt(number));
        }

        id++;

        String idlen = "" + id;

        for (int x = idlen.length(); x < 6; x++) {
            generated_id += "0";
        }

        generated_id += "" + id;

        voucher_id = abrivation + generated_id + gop.getCode();

        return voucher_id;
    }

    public String ComTIDGenerator(int gop_id, int vt_id) {

        GeneralOrganizationProfile gop = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);
        VoucherType vt = (VoucherType) uniDB.find(vt_id, VoucherType.class);

        int id = 0;
        String abrivation = "";
        String generated_id = "";
        abrivation = "T/";

        String voucher_id = "";
        String v = null;

        try {
            List<Voucher> VoucherList = uniDB.searchByQuerySingle("SELECT v FROM Voucher v WHERE v.voucherTypeId.id='" + vt.getId() + "' AND v.generalOrganizationProfileId.id='" + gop.getId() + "' ORDER BY v.voucherId DESC");
            for (Voucher voucher : VoucherList) {
                v = voucher.getVoucherId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (v == null) {
            id = 0;
        } else {
            String vid = v;

            String number = "";

            for (int x = 0; x < vid.length(); x++) {
                if (Character.isDigit(vid.charAt(x))) {
                    number += vid.charAt(x);
                }
            }

            id = ((number.equals("")) ? 0 : Integer.parseInt(number));
        }

        id++;

        String idlen = "" + id;

        for (int x = idlen.length(); x < 6; x++) {
            generated_id += "0";
        }

        generated_id += "" + id;

        voucher_id = abrivation + generated_id;

        return voucher_id;
    }

    public String ORGCodeGenerator(int gop_id, int type) {

        GeneralOrganizationProfile gop = (GeneralOrganizationProfile) uniDB.find(gop_id, GeneralOrganizationProfile.class);

        int id = 0;
        String abrivation = "";//((type == 1) ? "T/" : "I/");
        switch (type) {
            case 1:
                abrivation = "T/";
                break;
            case 2:
                abrivation = "I/";
                break;
            case 3:
                abrivation = "IC/";
                break;
            default:
                System.out.println("Invalid Type!");
        }
        String generated_id = "";

        String customer_code = "";
        String v = null;

        try {

            switch (type) {
                case 1: {
                    List<OrganizationTypeManager> otms = uniDB.searchByQuerySingle("SELECT o FROM OrganizationTypeManager o WHERE o.generalOrganizationProfileId.id='" + gop.getId() + "' AND o.organizationTypeId.id='18' ORDER BY o.code DESC");
                    for (OrganizationTypeManager o : otms) {
                        v = o.getCode();
                    }
                    break;
                }
                case 2: {
                    List<GupGopManager> ggms = uniDB.searchByQuerySingle("SELECT u FROM GupGopManager u WHERE u.generalOrganizationProfileId.id='" + gop.getId() + "' ORDER BY u.code DESC");
                    for (GupGopManager g : ggms) {
                        v = g.getCode();
                    }
                    break;
                }
                case 3: {
                    List<OrganizationTypeManager> otms = uniDB.searchByQuerySingle("SELECT o FROM OrganizationTypeManager o WHERE o.generalOrganizationProfileId.id='" + gop.getId() + "' AND o.organizationTypeId.id='28' ORDER BY o.code DESC");
                    for (OrganizationTypeManager o : otms) {
                        v = o.getCode();
                    }
                    break;
                }
                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (v == null) {
            id = 0;
        } else {
            String vid = v;

            String number = "";

            for (int x = 0; x < vid.length(); x++) {
                if (Character.isDigit(vid.charAt(x))) {
                    number += vid.charAt(x);
                }
            }

            id = ((number.equals("")) ? 0 : Integer.parseInt(number));
        }

        id++;

        String idlen = "" + id;

        for (int x = idlen.length(); x < 4; x++) {
            generated_id += "0";
        }

        generated_id += "" + id;
        customer_code = abrivation + generated_id;
        return customer_code;
    }

    public List<String> completeList(String query, int main_gop, int gop_gup_type) {

        List<String> list = null;// ((gop_gup_type == 1) ? comDev.getGOPnameList(query) : comDev.getGUPnameList(query));

        switch (gop_gup_type) {
            case 1:
                list = comDev.getGOPnameList(query, main_gop);
                break;
            case 2:
                list = comDev.getGUPnameList(query, main_gop);
                break;
            case 3:
                list = comDev.getIndividualCorporateList(query, main_gop);
                break;
            default:
                System.out.println("Invalid Type!");
        }

        return list;
    }

    public Map<Integer, UniversalSearchResource> UniversalVoucherSearch(int gop, int vt, int customer_id, int gop_gup_type, Date date_from, Date date_to) {

        Map<Integer, UniversalSearchResource> map = new HashMap<>();

        double tottal = 0;
        double due = 0;
        List<VoucherListSuper> voucherList = new ArrayList<>();

        gop_gup_type = ((gop_gup_type == 3 || gop_gup_type == 1) ? 1 : 2);

        String query1 = ((customer_id == 0) ? "" : " AND v.universalPersonOrOrgTypeManagerId.id='" + gop_gup_type + "' AND v.referenceId='" + customer_id + "'");
        String query2 = ((date_from == null && date_to == null) ? "" : " AND v.voucherId.date BETWEEN '" + getDate(date_from) + "' AND '" + getDate(date_to) + "'");

        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.generalOrganizationProfileId.id='" + gop + "' " + query1 + " " + query2 + " AND v.voucherTypeId.id='" + vt + "' ORDER BY v.voucherId.id ASC", 500);
        for (PaymentHistory p : ph) {
            String description = "";
            List<VoucherItem> vi = uniDB.searchByQueryLimit("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + p.getVoucherId().getId() + "'", 500);
            for (VoucherItem item : vi) {
                description += item.getOrgItemId().getItemId() + ", ";
            }

            String delivery_date = "";
            List<UncommonVoucherDetails> uvdc = uniDB.searchByQuerySingle("SELECT uv FROM UncommonVoucherDetails uv WHERE uv.voucherId.id='" + p.getVoucherId().getId() + "'");
            for (UncommonVoucherDetails uv : uvdc) {
                delivery_date = ((uv.getDateOfSold() == null) ? "" : getDateFormated(uv.getDateOfSold()));
            }

            voucherList.add(new VoucherListSuper(p.getVoucherId().getId(), p.getVoucherId().getVoucherId(), getDateFormated(p.getVoucherId().getDate()), comDev.getGOPGUPName(p.getReferenceId(), p.getUniversalPersonOrOrgTypeManagerId().getId()), getDouble(p.getVoucherId().getVoucherTotal()), getDouble(p.getVoucherId().getDue()), description, delivery_date));
            tottal += p.getVoucherId().getVoucherTotal();
            due += p.getVoucherId().getDue();
        }

        UniversalSearchResource resource = new UniversalSearchResource(voucherList, getDouble(tottal), getDouble(due));

        map.put(1, resource);

        return map;
    }

    public Map<Integer, UniversalSearchResource> UniversalVoucherSearchByDefaultDate(int gop, int vt) {

        Map<Integer, UniversalSearchResource> map = new HashMap<>();

        double tottal = 0;
        double due = 0;
        List<VoucherListSuper> invoiceItemsesList = new ArrayList<>();

        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.date BETWEEN '" + getDate(new Date()) + "' AND '" + getDate(new Date()) + "' AND v.voucherId.generalOrganizationProfileId.id='" + gop + "'  AND v.voucherTypeId.id='" + vt + "'", 500);
        for (PaymentHistory p : ph) {
            String description = "";
            List<VoucherItem> vi = uniDB.searchByQuery("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + p.getVoucherId().getId() + "'");
            for (VoucherItem item : vi) {
                description += item.getOrgItemId().getItemId() + ", ";

            }

            String delivery_date = "";
            List<UncommonVoucherDetails> uvdc = uniDB.searchByQuerySingle("SELECT uv FROM UncommonVoucherDetails uv WHERE uv.voucherId.id='" + p.getVoucherId().getId() + "'");
            for (UncommonVoucherDetails uv : uvdc) {
                delivery_date = ((uv.getDateOfSold() == null) ? "" : getDateFormated(uv.getDateOfSold()));
            }

            invoiceItemsesList.add(new VoucherListSuper(p.getVoucherId().getId(), p.getVoucherId().getVoucherId(), getDateFormated(p.getVoucherId().getDate()), comDev.getGOPGUPName(p.getReferenceId(), p.getUniversalPersonOrOrgTypeManagerId().getId()), getDouble(p.getVoucherId().getVoucherTotal()), getDouble(p.getVoucherId().getDue()), description, delivery_date));
            tottal += p.getVoucherId().getVoucherTotal();
            due += p.getVoucherId().getDue();
        }

        UniversalSearchResource resource = new UniversalSearchResource(invoiceItemsesList, getDouble(tottal), getDouble(due));
        map.put(1, resource);

        return map;
    }

}
