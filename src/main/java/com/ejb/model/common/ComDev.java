/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.common;

import com.ejb.model.entity.Bank;
import com.ejb.model.entity.BrancheOfTheBank;
import com.ejb.model.entity.ChequeConditionController;
import com.ejb.model.entity.ChequeDetails;
import com.ejb.model.entity.GeneralOrganizationProfile;
import com.ejb.model.entity.GeneralUserProfile;
import com.ejb.model.entity.GupGopManager;
import com.ejb.model.entity.ItemCategory;
import com.ejb.model.entity.ItemClass;
import com.ejb.model.entity.ItemMaster;
import com.ejb.model.entity.ItemModel;
import com.ejb.model.entity.ItemSubCategory;
import com.ejb.model.entity.ItemType;
import com.ejb.model.entity.LoginSession;
import com.ejb.model.entity.OrgItem;
import com.ejb.model.entity.OrganizationType;
import com.ejb.model.entity.OrganizationTypeManager;
import com.ejb.model.entity.PaymentHistory;
import com.ejb.model.entity.ReferenceVoucher;
import com.ejb.model.entity.RegistrationType;
import com.ejb.model.entity.SubChartOfAccount;
import com.ejb.model.entity.UnitOfMeasure;
import com.ejb.model.entity.UniversalPaymentMode;
import com.ejb.model.entity.UniversalPersonOrOrgTypeManager;
import com.ejb.model.entity.UserLogin;
import com.ejb.model.entity.Voucher;
import com.ejb.model.entity.VoucherItem;
import com.ejb.model.entity.VoucherPaymentMode;
import com.ejb.model.entity.VoucherReceiptManager;
import com.ejb.model.entity.VoucherTaxDetails;
import com.ejb.model.entity.VoucherTotalManager;
import com.ejb.model.entity.VoucherType;
import com.webapps.controller.managebeans.print.InvoicePrint;
import com.webapps.controller.managebeans.print.orderPrint;
import com.webapps.controller.managebeans.task.CreditNote;
import com.webapps.controller.managebeans.task.InvoiceCop;
import com.webapps.controller.managebeans.task.ReceiptCop;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Sameera
 */
@Stateless
@LocalBean
public class ComDev {

 

    @EJB
    private ComLib comLib;

    @EJB
    private UniDBLocal uniDB;

    public Voucher CreateVoucher(String voucher_id, String date, String payment_date, double voucher_total, double total_paid, double due, double discount, String description, int is_active, int gop_gup_type, int gop_gup_id, int gup, int ls, int ul, int vt, int gop, int payment_mod) {

        GeneralOrganizationProfile generalOrganizationProfile = (GeneralOrganizationProfile) uniDB.find(gop, GeneralOrganizationProfile.class);
        VoucherType voucherType = (VoucherType) uniDB.find(vt, VoucherType.class);
        GeneralUserProfile generalUserProfile = (GeneralUserProfile) uniDB.find(gup, GeneralUserProfile.class);
        LoginSession loginSession = (LoginSession) uniDB.find(ls, LoginSession.class);

        VoucherTotalManager vtm = null;

        List vtml = uniDB.searchByQuery("SELECT v FROM VoucherTotalManager v WHERE v.generalOrganizationProfileId.id='" + gop + "' and v.voucherTypeId.id='" + vt + "'");
        if (vtml.iterator().hasNext()) {

            vtm = (VoucherTotalManager) vtml.iterator().next();
            vtm.setAccumulatedTotal(vtm.getAccumulatedTotal() + voucher_total);
            uniDB.update(vtm);

        } else {

            vtm = new VoucherTotalManager();
            vtm.setAccumulatedDiscount(discount);
            vtm.setAccumulatedDue(due);
            vtm.setAccumulatedTotal(voucher_total);
            vtm.setFooterImageUrl("");
            vtm.setGeneralOrganizationProfileId(generalOrganizationProfile);
            vtm.setHeaderImageUrl("");
            vtm.setVoucherTypeId(voucherType);
            uniDB.create(vtm);

        }

        Date voucher_date = ((date.equals("")) ? new Date() : comLib.getDateObject(date));
//        voucher_id = ((voucher_id.equals("")) ? comLib.VIDGenerator(gop, vt) : voucher_id);

        switch (vt) {
            case 1:
                voucher_id = comLib.ComTIDGenerator(gop, vt);
                break;
            case 92:
                voucher_id = comLib.ComTIDGenerator(gop, vt);
                break;
            default:
                voucher_id = comLib.VIDGenerator(gop, vt);
        }

        Voucher v = new Voucher();
        v.setDate(voucher_date);
        v.setVoucherId(voucher_id);
        v.setDiscount(discount);
        v.setDue(due);
        v.setTotalPaid(total_paid);
        v.setVoucherTotal(voucher_total);
        v.setIsActive(is_active);
        if (!date.equals("no")) {
            Date p_date = ((date.equals("")) ? new Date() : comLib.getDateObject(payment_date));
            v.setPaymentDate(p_date);
        }
        if (payment_mod != 0) {
            v.setUniversalPaymentModeId((UniversalPaymentMode) uniDB.find(payment_mod, UniversalPaymentMode.class));
        }
        v.setDescription(description);
        v.setGeneralOrganizationProfileId(generalOrganizationProfile);
        v.setGeneralUserProfileId(generalUserProfile);
        v.setVoucherTypeId(voucherType);
        v.setVoucherMasterId(vtm);
        v.setLoginSessionId(loginSession);
        v.setUserLoginId(loginSession.getUserLoginId());
        uniDB.create(v);

        PaymentHistory ph = new PaymentHistory();
        ph.setPaymentRecever(generalOrganizationProfile);
        ph.setReferenceId(gop_gup_id);
        ph.setUniversalPersonOrOrgTypeManagerId((UniversalPersonOrOrgTypeManager) uniDB.find(gop_gup_type, UniversalPersonOrOrgTypeManager.class));
        ph.setVoucherId(v);
        ph.setVoucherTypeId(voucherType);
        uniDB.create(ph);

        return v;
    }

    public void CreateVoucherItem(double qty, double RecevedQty, double Amount, double DueAmount, double Discount, String date, int IsActive, int IsPaid, String description, int WorrentyPeriod, double UnitPrice, Voucher Voucher, VoucherType voucherType, LoginSession loginSession, UserLogin userLogin, SubChartOfAccount subChartOfAccount, GeneralOrganizationProfile generalOrganizationProfile, OrgItem orgItem) {

        VoucherItem vi = new VoucherItem();
        vi.setQty(qty);
        vi.setRecevedQty(RecevedQty);
        vi.setAmount(Amount);
        vi.setUnitPrice(UnitPrice);
        vi.setDueAmount(DueAmount);
        vi.setDiscount(Discount);
        vi.setDate(ComLib.getDateObject(date));
        vi.setIsActive(IsActive);
        vi.setIsPaid(IsPaid);
        vi.setDescription(description);
        vi.setWorrentyPeriod(WorrentyPeriod);
        vi.setVoucherId1(Voucher);
        vi.setVoucherTypeId(voucherType);
        vi.setLoginSessionId(loginSession);
        vi.setUserLoginId(userLogin);
        vi.setSubChartOfAccountId(subChartOfAccount);
        vi.setGeneralOrganizationProfileId(generalOrganizationProfile);
        vi.setOrgItemId(orgItem);
        uniDB.create(vi);

    }

    public OrgItem CreateItem(String name, String description, String image, int unitOfMeasure, int itemCategory, int itemClass, int itemType, int itemModel, int itemSubCategory, int reference, int universalPersonOrOrgTypeManager, String orgItemId, double reorderLevel, double maxStock, double materialCost, double vatAmountEligibleForClaim, double sellingPrice, int worrentyPeriod) {

        ItemMaster im = null;

        List<ItemMaster> itemMasters = uniDB.searchByQuerySingle("SELECT i FROM ItemMaster i WHERE i.name='" + name + "'");
        for (ItemMaster i : itemMasters) {
            im = i;
        }

        if (itemMasters.isEmpty()) {

            im = new ItemMaster();
            im.setName(name);
            im.setDescription(description);
            im.setImage(image);
            im.setUnitOfMeasureId((UnitOfMeasure) uniDB.find(unitOfMeasure, UnitOfMeasure.class));
            im.setItemCategoryId((ItemCategory) uniDB.find(itemCategory, ItemCategory.class));
            im.setItemClassId((ItemClass) uniDB.find(itemClass, ItemClass.class));
            im.setItemTypeId((ItemType) uniDB.find(itemType, ItemType.class));
            if (itemModel != 0) {
                im.setItemModelId((ItemModel) uniDB.find(itemModel, ItemModel.class));
            }
            if (itemSubCategory != 0) {
                im.setItemSubCategoryId((ItemSubCategory) uniDB.find(itemSubCategory, ItemSubCategory.class));
            }
            uniDB.create(im);

        }

        OrgItem oi = null;
        List<OrgItem> orgItems = uniDB.searchByQuerySingle("SELECT o FROM OrgItem o WHERE o.itemMasterId.id='" + im.getId() + "' AND o.reference='" + reference + "' AND o.universalPersonOrOrgTypeManagerId.id='" + universalPersonOrOrgTypeManager + "'");
        for (OrgItem o : orgItems) {
            oi = o;
        }

        if (orgItems.isEmpty()) {
            oi = new OrgItem();
            oi.setReference(reference);
            oi.setItemId(orgItemId);
            oi.setReorderLevel(reorderLevel);
            oi.setMaxStock(maxStock);
            oi.setMaterialCost(materialCost);
            oi.setVatAmountEligibleForClaim(vatAmountEligibleForClaim);
            oi.setSellingPrice(sellingPrice);
            oi.setWorrentyPeriod(worrentyPeriod);
            oi.setItemMasterId(im);
            oi.setItemTypeId((ItemType) uniDB.find(itemType, ItemType.class));
            oi.setUniversalPersonOrOrgTypeManagerId((UniversalPersonOrOrgTypeManager) uniDB.find(universalPersonOrOrgTypeManager, UniversalPersonOrOrgTypeManager.class));
            oi.setItemCategoryId((ItemCategory) uniDB.find(itemCategory, ItemCategory.class));
            oi.setItemClassId((ItemClass) uniDB.find(itemClass, ItemClass.class));
            uniDB.create(oi);
        }
        return oi;
    }

    public SubChartOfAccount CreateSubChartOfAccount(String reference, String name, String isActive, double balance, int gop) {

        SubChartOfAccount scoa = null;

        List<SubChartOfAccount> subChartOfAccounts = uniDB.searchByQuerySingle("SELECT s FROM SubChartOfAccount s WHERE s.name='" + name + "'");
        for (SubChartOfAccount s : subChartOfAccounts) {
            scoa = s;
        }

        if (subChartOfAccounts.isEmpty()) {

            scoa = new SubChartOfAccount();
            scoa.setReference(name);
            scoa.setName(name);
            scoa.setStatus("Active");
            scoa.setBalance(balance);
            scoa.setGeneralOrganizationProfileId((GeneralOrganizationProfile) uniDB.find(gop, GeneralOrganizationProfile.class));
            uniDB.create(scoa);

        }

        return scoa;

    }

    public List<String> getGOPnameList(String query, int gop) {

        ArrayList<String> list = new ArrayList<>();

        List<OrganizationTypeManager> otms = uniDB.searchByQueryLimit("SELECT o FROM OrganizationTypeManager o WHERE o.generalOrganizationProfileId.id='" + gop + "' AND o.organizationTypeId.id='18' AND o.generalOrganizationProfileId1.name like '%" + query + "%'", 50);
        for (OrganizationTypeManager o : otms) {
            list.add(o.getGeneralOrganizationProfileId1().getName() + " %" + o.getGeneralOrganizationProfileId1().getId());
        }

        return list;
    }

    public List<String> getIndividualCorporateList(String query, int gop) {

        ArrayList<String> list = new ArrayList<>();

        List<OrganizationTypeManager> otms = uniDB.searchByQueryLimit("SELECT o FROM OrganizationTypeManager o WHERE o.generalOrganizationProfileId.id='" + gop + "' AND o.organizationTypeId.id='28' AND o.generalOrganizationProfileId1.name like '%" + query + "%'", 50);
        for (OrganizationTypeManager o : otms) {
            list.add(o.getGeneralOrganizationProfileId1().getName() + " %" + o.getGeneralOrganizationProfileId1().getId());
        }

        return list;
    }

    public List<String> getBankBranchList(String query, int bank) {

        ArrayList<String> list = new ArrayList<>();

        List<BrancheOfTheBank> otms = uniDB.searchByQueryLimit("SELECT o FROM BrancheOfTheBank o WHERE o.bankId.id='" + bank + "' AND o.generalOrganizationProfileId.name like '%" + query + "%'", 50);
        for (BrancheOfTheBank o : otms) {
            list.add(o.getGeneralOrganizationProfileId().getName());
        }

        return list;
    }

    public List<String> getGOPnameListAll(String query) {

        ArrayList<String> list = new ArrayList<>();

        List<GeneralOrganizationProfile> ol = uniDB.searchByQuery("SELECT g FROM GeneralOrganizationProfile g WHERE g.name like '%" + query + "%'");
        for (GeneralOrganizationProfile org : ol) {
            list.add(org.getName() + " %" + org.getId());
        }

        return list;
    }

    public List<String> getGUPnameList(String query,int gop) {

        ArrayList<String> list = new ArrayList<>();

        List<GupGopManager> ggms = uniDB.searchByQueryLimit("SELECT u FROM GupGopManager u WHERE u.generalOrganizationProfileId.id='" + gop + "' AND u.generalUserProfileId.firstName like '%" + query + "%' OR u.generalUserProfileId.nic like '%" + query + "%' OR u.generalUserProfileId.mobilePhone like '%" + query + "%' ", 50);
        for (GupGopManager g : ggms) {
            String nic = ((g.getGeneralUserProfileId().getNic() == null) ? "" : g.getGeneralUserProfileId().getNic());
            list.add(g.getGeneralUserProfileId().getFirstName() + " " + g.getGeneralUserProfileId().getLastName() + " - " + nic + " %" + g.getGeneralUserProfileId().getId());
        }

        return list;
    }

    public List<String> getGUPnameListAll(String query) {

        ArrayList<String> list = new ArrayList<>();
        List<GeneralUserProfile> gup = uniDB.searchByQueryLimit("SELECT u FROM GeneralUserProfile u WHERE u.firstName like '%" + query + "%' OR u.nic like '%" + query + "%' OR u.mobilePhone like '%" + query + "%'", 50);
        for (GeneralUserProfile g : gup) {
            String nic = ((g.getNic() == null) ? "" : g.getNic());
            list.add(g.getFirstName() + " " + g.getLastName() + " - " + nic + " %" + g.getGeneralUserProfileGupId().getId());
        }
//        System.out.println("list: " + list);
        return list;
    }

    public List<String> getProductnameList(String query, int gop) {

        ArrayList<String> itemList = new ArrayList<>();
        List<OrgItem> oi = uniDB.searchByQuery("SELECT o FROM OrgItem o WHERE o.itemMasterId.name like '%" + query + "%' AND o.reference='" + gop + "' AND o.universalPersonOrOrgTypeManagerId.id='1'");
        for (OrgItem o : oi) {
            itemList.add(o.getItemMasterId().getName());
        }

        return itemList;
    }

    public int getGopGupId(int type, String name) {

        int customer_id = 0;

        List<GeneralOrganizationProfile> ol = uniDB.searchByQuery("SELECT g FROM GeneralOrganizationProfile g WHERE g.name='" + name + "'");
        for (GeneralOrganizationProfile org : ol) {
            customer_id = org.getId();
        }

        List<GeneralUserProfile> gup = uniDB.searchByQuery("SELECT g FROM GeneralUserProfile g WHERE g.first_name='" + name + "'");
        for (GeneralUserProfile g : gup) {
            customer_id = g.getId();
        }

        return customer_id;
    }

    public String getGOPGUPName(int id, int type) {

        String name = "";
        if (type == 1) {
            GeneralOrganizationProfile gop = (GeneralOrganizationProfile) uniDB.find(id, GeneralOrganizationProfile.class);
            name = gop.getName();
        } else {
            GeneralUserProfile gup = (GeneralUserProfile) uniDB.find(id, GeneralUserProfile.class);
            name = gup.getFirstName() + "  " + gup.getLastName();
        }
        return name;
    }

    public String getGOPGUPAddress(int id, int type) {

        String name = "";
        if (type == 1) {
            GeneralOrganizationProfile gop = (GeneralOrganizationProfile) uniDB.find(id, GeneralOrganizationProfile.class);
            name = gop.getAddress1() + " " + gop.getAddress2() + " " + gop.getAddress3();
        } else {
            GeneralUserProfile gup = (GeneralUserProfile) uniDB.find(id, GeneralUserProfile.class);
            name = gup.getAddress1() + "  " + gup.getAddress2() + "  " + gup.getAddress3();
        }
        return name;
    }

    public String getGOPGUPAddressNoStreet(int id, int type) {

        String name = "";
        if (type == 1) {
            GeneralOrganizationProfile gop = (GeneralOrganizationProfile) uniDB.find(id, GeneralOrganizationProfile.class);
            name = gop.getAddress1() + ", " + gop.getAddress2();
        } else {
            GeneralUserProfile gup = (GeneralUserProfile) uniDB.find(id, GeneralUserProfile.class);
            name = gup.getAddress1() + "  " + gup.getAddress2();
        }
        return name;
    }

    public String getGOPGUPAddressCity(int id, int type) {

        String name = "";
        if (type == 1) {
            GeneralOrganizationProfile gop = (GeneralOrganizationProfile) uniDB.find(id, GeneralOrganizationProfile.class);
            name = gop.getAddress3();
        } else {
            GeneralUserProfile gup = (GeneralUserProfile) uniDB.find(id, GeneralUserProfile.class);
            name = gup.getAddress3();
        }
        return name;
    }

//        public ArrayList<InvoiceCop> getVoucherItem(int vocherId) {
//
//        int customer_id = 0;
//
//        List<VoucherItem> vi = uniDB.searchByQuery("SELECT v FROM VoucherItem v WHERE v.voucherId1='" + vocherId + "'");
//        for (VoucherItem v : vi) {
//            customer_id = org.getId();
//        }
//
//        List<GeneralUserProfile> gup = uniDB.searchByQuery("SELECT g FROM GeneralUserProfile g WHERE g.first_name='" + name + "'");
//        for (GeneralUserProfile g : gup) {
//            customer_id = g.getId();
//        }
//
//        return customer_id;
//    }
    public void getinvoiceItemList() {

        InvoiceCop.invoiceItemList.clear();
        List<VoucherItem> vi = uniDB.searchByQuery("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + InvoiceCop.voucherId + "'");
        for (VoucherItem v : vi) {
            InvoiceCop.InvoiceItem invoiceItem = new InvoiceCop.InvoiceItem(v.getId() + "", v.getOrgItemId().getItemMasterId().getName(), v.getQty(), v.getUnitPrice(), v.getAmount());
            InvoiceCop.invoiceItemList.add(invoiceItem);
        }

        List<Voucher> vouchers = uniDB.searchByQuery("SELECT v FROM Voucher v WHERE v.id='" + InvoiceCop.voucherId + "'");
        for (Voucher v : vouchers) {
            InvoiceCop.orderNo = v.getVoucherId();
            InvoiceCop.voucherId = v.getId();
            InvoiceCop.advance = v.getTotalPaid();
            InvoiceCop.invoiceTotalDouble = v.getVoucherTotal();
            InvoiceCop.invoiceDue = v.getDue();
            InvoiceCop.invoiceNo = comLib.ComTIDGenerator(v.getGeneralOrganizationProfileId().getId(), 1);
            InvoiceCop.invoiceTotal = ((v.getVoucherTotal() > 0) ? ComLib.getDouble(v.getVoucherTotal()) : "0.00");
        }

    }

    public void getIndividualInvoiceItemList() {

        InvoiceCop.invoiceItemList.clear();
        List<VoucherItem> vi = uniDB.searchByQuery("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + InvoiceCop.voucherId + "'");
        for (VoucherItem v : vi) {
            InvoiceCop.InvoiceItem invoiceItem = new InvoiceCop.InvoiceItem(v.getId() + "", v.getOrgItemId().getItemMasterId().getName(), v.getQty(), v.getUnitPrice(), v.getAmount());
            InvoiceCop.invoiceItemList.add(invoiceItem);
        }

        List<Voucher> vouchers = uniDB.searchByQuery("SELECT v FROM Voucher v WHERE v.id='" + InvoiceCop.voucherId + "'");
        for (Voucher v : vouchers) {
            InvoiceCop.orderNo = v.getVoucherId();
            InvoiceCop.voucherId = v.getId();
            InvoiceCop.advance = v.getTotalPaid();
            InvoiceCop.invoiceTotalDouble = v.getVoucherTotal();
            InvoiceCop.invoiceDue = v.getDue();
            InvoiceCop.invoiceNo = comLib.VIDGenerator(v.getGeneralOrganizationProfileId().getId(), 94);
            InvoiceCop.invoiceTotal = ((v.getVoucherTotal() > 0) ? ComLib.getDouble(v.getVoucherTotal()) : "0.00");
        }

    }

    public void getOrderPrint(int orderId) {

        try {

            Voucher order = (Voucher) uniDB.find(orderId, Voucher.class);

            orderPrint.orderItemList.clear();
            List<VoucherItem> vi = uniDB.searchByQuery("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + order.getId() + "'");
            for (VoucherItem v : vi) {

                orderPrint.OrderItem invoiceItem = new orderPrint.OrderItem(v.getId() + "", v.getOrgItemId().getItemMasterId().getName(), ComLib.getDoubleWithoutDes(v.getQty()), ComLib.getDouble(v.getUnitPrice()), ComLib.getDouble(v.getAmount()));
                orderPrint.orderItemList.add(invoiceItem);
            }

            for (int x = vi.size(); x < 12; x++) {

                orderPrint.OrderItem invoiceItem = new orderPrint.OrderItem("", "-", "", "", "");
                orderPrint.orderItemList.add(invoiceItem);
            }

            List<ReferenceVoucher> rvs = uniDB.searchByQuery("SELECT r FROM ReferenceVoucher r WHERE r.voucherId.id='" + order.getId() + "'");
            for (ReferenceVoucher v : rvs) {
                if (v.getValue() == 1) {
                    orderPrint.poNo = v.getName();
                } else if (v.getValue() == 2) {
                    orderPrint.dnNo = v.getName();
                }

            }

            orderPrint.orderDescription = order.getDescription();
            orderPrint.orderNo = order.getVoucherId();
            orderPrint.orderTotal = ComLib.getDouble(order.getVoucherTotal());
            orderPrint.orderDue = ComLib.getDouble(order.getDue());
            orderPrint.orderPaid = ComLib.getDouble(order.getTotalPaid());
            orderPrint.orderDate = ComLib.getDateFormated(order.getDate());

            List<PaymentHistory> historys = uniDB.searchByQuerySingle("SELECT v FROM PaymentHistory v WHERE v.voucherId.id='" + order.getId() + "'");
            for (PaymentHistory ph : historys) {

                orderPrint.customerName = getGOPGUPName(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
                orderPrint.customerAddress = getGOPGUPAddress(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadCreditNote(int invoiceId) {

        CreditNote.invoiceItemList.clear();
        List<VoucherItem> vi = uniDB.searchByQuery("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + invoiceId + "'");
        for (VoucherItem v : vi) {
            CreditNote.InvoiceItem invoiceItem = new CreditNote.InvoiceItem(v.getId() + "", v.getOrgItemId().getItemMasterId().getName(), v.getQty(), v.getUnitPrice(), v.getAmount());
            CreditNote.invoiceItemList.add(invoiceItem);
        }

//        System.out.println("request: " + request.getSession().getAttribute("userloin"));
    }

    public void getinvoicePrint(int invoiceId) {

        try {

            Voucher invoice = (Voucher) uniDB.find(invoiceId, Voucher.class);

            InvoicePrint.invoiceItemList.clear();
            List<VoucherItem> vi = uniDB.searchByQuery("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + invoice.getId() + "'");
            for (VoucherItem v : vi) {

                String amount = ComLib.getDouble(v.getAmount());
                String[] convert = amount.split("\\.");

                String num = convert[0];
                String des = convert[1];

                InvoicePrint.InvoiceItem invoiceItem = new InvoicePrint.InvoiceItem(v.getId() + "", v.getOrgItemId().getItemMasterId().getName(), ComLib.getDoubleWithoutDes(v.getQty()), ComLib.getDouble(v.getUnitPrice()), num, des);
                InvoicePrint.invoiceItemList.add(invoiceItem);
            }

            int rowLength = 15;
            if (vi.isEmpty()) {

                rowLength = 14;
                String id = "";

                List<VoucherReceiptManager> vr = uniDB.searchByQuerySingle("SELECT r FROM VoucherReceiptManager r WHERE r.receipt.id='" + invoice.getId() + "'");
                for (VoucherReceiptManager v : vr) {
                    id = v.getVoucher().getVoucherId();
                }

                String amount = ComLib.getDouble(invoice.getVoucherTotal());
                String[] convert = amount.split("\\.");

                String num = convert[0];
                String des = convert[1];

                InvoicePrint.InvoiceItem invoiceItem = new InvoicePrint.InvoiceItem("", "Part payment for Invoice: " + id + "", "1", ComLib.getDouble(invoice.getVoucherTotal()), num, des);
                InvoicePrint.invoiceItemList.add(invoiceItem);

            }

            for (int x = vi.size(); x < rowLength; x++) {

                InvoicePrint.InvoiceItem invoiceItem = new InvoicePrint.InvoiceItem("", "", "", "", "", "");
                InvoicePrint.invoiceItemList.add(invoiceItem);
            }

            List<VoucherReceiptManager> vr = uniDB.searchByQuerySingle("SELECT r FROM VoucherReceiptManager r WHERE r.receipt.id='" + invoice.getId() + "'");
            for (VoucherReceiptManager v : vr) {
                InvoicePrint.orderNo = v.getVoucher().getVoucherId();
            }

            List<ReferenceVoucher> rvs = uniDB.searchByQuery("SELECT r FROM ReferenceVoucher r WHERE r.voucherId.id='" + invoice.getId() + "'");
            for (ReferenceVoucher v : rvs) {
                if (v.getValue() == 1) {
                    InvoicePrint.poNo = v.getName();
                } else if (v.getValue() == 2) {
                    InvoicePrint.dnNo = v.getName();
                }

            }
            double vat = 0;
            double nbt = 0;

            InvoicePrint.vatNo = "";
            InvoicePrint.vatNum = "";
            InvoicePrint.vatDes = "";
            InvoicePrint.nbtNum = "";
            InvoicePrint.nbtDes = "";
            InvoicePrint.grossNum = "";
            InvoicePrint.grossDes = "";

            List<VoucherTaxDetails> vtds = uniDB.searchByQuery("SELECT r FROM VoucherTaxDetails r WHERE r.voucherId.id='" + invoice.getId() + "'");
            for (VoucherTaxDetails v : vtds) {

                if (v.getVoucherTaxDetailsTypeId().getId() == 1) {

                    vat = v.getValue();

                    String amount = ComLib.getDouble(v.getValue());
                    String[] convert = amount.split("\\.");

                    String num = convert[0];
                    String des = convert[1];

                    InvoicePrint.vatNo = "VAT No: " + v.getTaxNo();
                    InvoicePrint.vatNum = num;
                    InvoicePrint.vatDes = des;
                }

                if (v.getVoucherTaxDetailsTypeId().getId() == 5) {

                    nbt = v.getValue();

                    String amount = ComLib.getDouble(v.getValue());
                    String[] convert = amount.split("\\.");

                    String num = convert[0];
                    String des = convert[1];

                    InvoicePrint.nbtNum = num;
                    InvoicePrint.nbtDes = des;
                }

            }

            try {

                String amount = ComLib.getDouble(invoice.getVoucherTotal() - vat);
                String[] convert = amount.split("\\.");

                String num = convert[0];
                String des = convert[1];

                InvoicePrint.grossNum = num;
                InvoicePrint.grossDes = des;

            } catch (Exception e) {
                e.printStackTrace();
            }

            String amount = ComLib.getDouble(invoice.getVoucherTotal());
            String[] convert = amount.split("\\.");

            String num = convert[0];
            String des = convert[1];

            InvoicePrint.invoiceTotal = num;
            InvoicePrint.invoiceTotalDes = des;
            InvoicePrint.invoiceDue = ComLib.getDouble(invoice.getDue());
            InvoicePrint.invoicePaid = ComLib.getDouble(invoice.getTotalPaid());
            InvoicePrint.invoiceDate = ComLib.getDateFormated(invoice.getDate());

//            PaymentHistory ph = invoice.getPaymentHistoryCollection().iterator().next();
            List<PaymentHistory> historys = uniDB.searchByQuerySingle("SELECT v FROM PaymentHistory v WHERE v.voucherId.id='" + invoice.getId() + "'");
            for (PaymentHistory ph : historys) {
                InvoicePrint.customerName = getGOPGUPName(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
                InvoicePrint.customerAddress = getGOPGUPAddressNoStreet(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
                InvoicePrint.customerCity = getGOPGUPAddressCity(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
            }

            //------------------------------------------------------------------
            InvoicePrint.phs.clear();

            double totalPaid = 0;
            List<VoucherPaymentMode> vpms = uniDB.searchByQuerySingle("SELECT v FROM VoucherPaymentMode v WHERE v.voucherId.id='" + invoice.getId() + "'");
            for (VoucherPaymentMode v : vpms) {
                totalPaid = v.getAmount();
            }

            InvoicePrint.PaymentHistory ph1 = new InvoicePrint.PaymentHistory(invoice.getVoucherId(), ComLib.getDate(invoice.getDate()), ComLib.getDouble(totalPaid));
            InvoicePrint.phs.add(ph1);

            List<VoucherReceiptManager> vrms = uniDB.searchByQuery("SELECT v FROM VoucherReceiptManager v WHERE v.voucher.id='" + invoice.getId() + "'");
            for (VoucherReceiptManager v : vrms) {
                InvoicePrint.PaymentHistory paymentHistory = new InvoicePrint.PaymentHistory(v.getReceipt().getVoucherId(), ComLib.getDate(v.getReceipt().getDate()), ComLib.getDouble(v.getReceipt().getVoucherTotal()));
                InvoicePrint.phs.add(paymentHistory);
            }

            InvoicePrint.PaymentHistory ph2 = new InvoicePrint.PaymentHistory("", "Total", ComLib.getDouble(invoice.getTotalPaid()));
            InvoicePrint.phs.add(ph2);

            ReceiptCop.voucherId = invoiceId;
            ReceiptCop.dnNo = InvoicePrint.dnNo;
            ReceiptCop.poNo = InvoicePrint.poNo;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getReceiptPrintDetails(int receiptId) {

        Voucher receipt = (Voucher) uniDB.find(receiptId, Voucher.class
        );
        Voucher invoice = null;

        List<PaymentHistory> historys = uniDB.searchByQuerySingle("SELECT v FROM PaymentHistory v WHERE v.voucherId.id='" + receipt.getId() + "'");
        for (PaymentHistory ph : historys) {
            InvoicePrint.customerName = getGOPGUPName(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
            InvoicePrint.customerAddress = getGOPGUPAddressNoStreet(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
            InvoicePrint.customerCity = getGOPGUPAddressCity(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
        }

        //-----------------------------------------------------------------------
        List<VoucherReceiptManager> vr = uniDB.searchByQuerySingle("SELECT r FROM VoucherReceiptManager r WHERE r.receipt.id='" + receipt.getId() + "'");

        for (VoucherReceiptManager v : vr) {
            invoice = (Voucher) uniDB.find(v.getVoucher().getId(), Voucher.class
            );
        }

        InvoicePrint.invoiceTotal = ComLib.getDouble(invoice.getVoucherTotal());
        InvoicePrint.invoicePaid = ComLib.getDouble(invoice.getTotalPaid());
        InvoicePrint.invoiceDue = ComLib.getDouble(invoice.getDue());
        InvoicePrint.invoiceDate = ComLib.getDateFormated(invoice.getDate());
        InvoicePrint.invoiceNo = invoice.getVoucherId();

        List<VoucherReceiptManager> vr1 = uniDB.searchByQuerySingle("SELECT r FROM VoucherReceiptManager r WHERE r.receipt.id='" + invoice.getId() + "'");
        for (VoucherReceiptManager v : vr1) {
            InvoicePrint.orderNo = v.getVoucher().getVoucherId();
        }

        List<ReferenceVoucher> rvs = uniDB.searchByQuery("SELECT r FROM ReferenceVoucher r WHERE r.voucherId.id='" + invoice.getId() + "'");
        for (ReferenceVoucher v : rvs) {
            if (v.getValue() == 1) {
                InvoicePrint.poNo = v.getName();
            } else if (v.getValue() == 2) {
                InvoicePrint.dnNo = v.getName();
            }

        }

        //----------------------------------------------------------------------
        InvoicePrint.receiptNo = receipt.getVoucherId();
        InvoicePrint.receiptDate = ComLib.getDateFormated(receipt.getDate());;
        InvoicePrint.receiptAmount = ComLib.getDouble(receipt.getVoucherTotal());

        List<ReferenceVoucher> rvsr = uniDB.searchByQuery("SELECT r FROM ReferenceVoucher r WHERE r.voucherId.id='" + receipt.getId() + "'");
        for (ReferenceVoucher v : rvsr) {
            if (v.getValue() == 1) {
                InvoicePrint.receiptPoNo = v.getName();
            } else if (v.getValue() == 2) {
                InvoicePrint.receiptDnNo = v.getName();
            }

        }

        InvoicePrint.receiptPaymentMode = "Cash";
        List<ChequeDetails> cds = uniDB.searchByQuery("SELECT r FROM ChequeDetails r WHERE r.voucherId.id='" + receipt.getId() + "'");
        for (ChequeDetails v : cds) {
            System.out.println("bank: " + v.getBankId().getName());
            InvoicePrint.receiptPaymentMode = "Cheque";
            InvoicePrint.receiptChequeBank = v.getBankId().getName();
            InvoicePrint.receiptChequeBankBranch = v.getGeneralOrganizationProfileId().getName();
            InvoicePrint.receiptChequeDate = ComLib.getDateFormated(v.getChequeDate());
            InvoicePrint.receiptChequeNumber = v.getChequeNo();

            List<ChequeConditionController> cccs = uniDB.searchByQuery("SELECT c FROM ChequeConditionController c WHERE c.chequeDetailsId.id='" + v.getId() + "'");
            for (ChequeConditionController c : cccs) {
                InvoicePrint.receiptChequeController = c.getChequeCoditionId().getName();
            }

        }

        //----------------------------------------------------------------------
        InvoicePrint.phs.clear();

        double totalPaid = 0;
        List<VoucherPaymentMode> vpms = uniDB.searchByQuerySingle("SELECT v FROM VoucherPaymentMode v WHERE v.voucherId.id='" + invoice.getId() + "'");
        for (VoucherPaymentMode v : vpms) {
            totalPaid = v.getAmount();
        }

        InvoicePrint.PaymentHistory ph1 = new InvoicePrint.PaymentHistory(invoice.getVoucherId(), ComLib.getDate(invoice.getDate()), ComLib.getDouble(totalPaid));
        InvoicePrint.phs.add(ph1);

        List<VoucherReceiptManager> vrms = uniDB.searchByQuery("SELECT v FROM VoucherReceiptManager v WHERE v.voucher.id='" + invoice.getId() + "'");
        for (VoucherReceiptManager v : vrms) {
            InvoicePrint.PaymentHistory paymentHistory = new InvoicePrint.PaymentHistory(v.getReceipt().getVoucherId(), ComLib.getDate(v.getReceipt().getDate()), ComLib.getDouble(v.getReceipt().getVoucherTotal()));
            InvoicePrint.phs.add(paymentHistory);
        }

        InvoicePrint.PaymentHistory ph2 = new InvoicePrint.PaymentHistory("", "Total", ComLib.getDouble(invoice.getTotalPaid()));
        InvoicePrint.phs.add(ph2);

    }

    public void getReceiptPrint(int invoiceId) {

        try {

            Voucher receipt = (Voucher) uniDB.find(invoiceId, Voucher.class
            );

            InvoicePrint.invoiceItemList.clear();
            List<VoucherItem> vi = uniDB.searchByQuery("SELECT v FROM VoucherItem v WHERE v.voucherId1.id='" + receipt.getId() + "'");
            for (VoucherItem v : vi) {

                String amount = ComLib.getDouble(v.getAmount());
                String[] convert = amount.split("\\.");

                String num = convert[0];
                String des = convert[1];

                InvoicePrint.InvoiceItem invoiceItem = new InvoicePrint.InvoiceItem(v.getId() + "", v.getOrgItemId().getItemMasterId().getName(), ComLib.getDoubleWithoutDes(v.getQty()), ComLib.getDouble(v.getUnitPrice()), num, des);
                InvoicePrint.invoiceItemList.add(invoiceItem);
            }

            try {
                String amount = ComLib.getDouble(receipt.getVoucherTotal());
                String[] convert = amount.split("\\.");

                String num = convert[0];
                String des = convert[1];

                InvoicePrint.InvoiceItem invoiceItem = new InvoicePrint.InvoiceItem("", "Part payment for Invoice: " + InvoicePrint.invoiceNo + "", "1", ComLib.getDouble(receipt.getVoucherTotal()), num, des);
                InvoicePrint.invoiceItemList.add(invoiceItem);
            } catch (Exception e) {
            }

            for (int x = vi.size(); x < 14; x++) {

                InvoicePrint.InvoiceItem invoiceItem2 = new InvoicePrint.InvoiceItem("", "", "", "", "", "");
                InvoicePrint.invoiceItemList.add(invoiceItem2);
            }

            List<ReferenceVoucher> rvs = uniDB.searchByQuery("SELECT r FROM ReferenceVoucher r WHERE r.voucherId.id='" + receipt.getId() + "'");
            for (ReferenceVoucher v : rvs) {
                if (v.getValue() == 1) {
                    InvoicePrint.poNo = v.getName();
                } else if (v.getValue() == 2) {
                    InvoicePrint.dnNo = v.getName();
                }

            }

            String amount = ComLib.getDouble(receipt.getVoucherTotal());
            String[] convert = amount.split("\\.");

            String num = convert[0];
            String des = convert[1];

            InvoicePrint.invoiceTotal = num;
            InvoicePrint.invoiceTotalDes = des;
            InvoicePrint.invoiceDue = ComLib.getDouble(receipt.getDue());
            InvoicePrint.invoicePaid = ComLib.getDouble(receipt.getTotalPaid());
            InvoicePrint.invoiceDate = ComLib.getDateFormated(receipt.getDate());

//            PaymentHistory ph = invoice.getPaymentHistoryCollection().iterator().next();
            List<PaymentHistory> historys = uniDB.searchByQuerySingle("SELECT v FROM PaymentHistory v WHERE v.voucherId.id='" + receipt.getId() + "'");
            for (PaymentHistory ph : historys) {
                InvoicePrint.customerName = getGOPGUPName(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
                InvoicePrint.customerAddress = getGOPGUPAddressNoStreet(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
                InvoicePrint.customerCity = getGOPGUPAddressCity(ph.getReferenceId(), ph.getUniversalPersonOrOrgTypeManagerId().getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public GeneralOrganizationProfile SaveBankBranch(String name, String no, String street, String city, String postal_code, String phone_i, String phone_ii, String email, String fax, int RegType, int OrgType, int bank) {

        GeneralOrganizationProfile g = null;

        try {

            RegistrationType RT = (RegistrationType) uniDB.find(RegType, RegistrationType.class
            );
            OrganizationType OT = (OrganizationType) uniDB.find(OrgType, OrganizationType.class
            );

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

                BrancheOfTheBank botb = new BrancheOfTheBank();
                botb
                        .setBankId((Bank) uniDB.find(bank, Bank.class
                        ));
                botb.setGeneralOrganizationProfileId(g);
                uniDB.create(botb);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return g;
    }

//    public void getOrdersList() {
//
//        ReportOrderRequest.orderlist.clear();
//
//        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.date BETWEEN '" + ComLib.getDate(new Date()) + "' AND '" + ComLib.getDate(new Date()) + "' AND v.voucherId.generalOrganizationProfileId.id='1563' ORDER BY v.voucherId.id ASC", 500);
//        int i = 0;
//        for (PaymentHistory p : ph) {
//            i++;
//            String delivery_date = "";
//
//            List<UncommonVoucherDetails> uvdc = uniDB.searchByQuerySingle("SELECT uv FROM UncommonVoucherDetails uv WHERE uv.voucherId.id='" + p.getVoucherId().getId() + "'");
//            for (UncommonVoucherDetails uv : uvdc) {
//                delivery_date = ((uv.getDateOfSold() == null) ? "" : comLib.getDateFormated(uv.getDateOfSold()));
//            }
//
//            String visible_status = "";
//            List<VoucherReceiptManager> vrms = uniDB.searchByQuerySingle("SELECT ur FROM VoucherReceiptManager ur WHERE ur.voucher.id='" + p.getVoucherId().getId() + "'");
//            for (VoucherReceiptManager uv : vrms) {
//                visible_status = "hide-button";
//            }
//
//            ReportOrderRequest.Orders orders = new ReportOrderRequest.Orders(i + "", comLib.getDateFormated(p.getVoucherId().getDate()), getGOPGUPName(p.getReferenceId(), p.getUniversalPersonOrOrgTypeManagerId().getId()), delivery_date, comLib.getDouble(p.getVoucherId().getVoucherTotal()), p.getVoucherId().getId(), visible_status);
//            ReportOrderRequest.orderlist.add(orders);
//        }
//
//    }
}
