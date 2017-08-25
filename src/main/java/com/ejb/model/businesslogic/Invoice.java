/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.businesslogic;

import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.OrgItem;
import com.ejb.model.entity.PaymentHistory;
import com.ejb.model.entity.ReferenceVoucher;
import com.ejb.model.entity.SubChartOfAccount;
import com.ejb.model.entity.UncommonVoucherDetails;
import com.ejb.model.entity.UniversalPaymentMode;
import com.ejb.model.entity.Voucher;
import com.ejb.model.entity.VoucherItem;
import com.ejb.model.entity.VoucherPaymentMode;
import com.ejb.model.entity.VoucherReceiptManager;
import com.ejb.model.entity.VoucherTaxDetails;
import com.ejb.model.entity.VoucherTaxDetailsType;
import com.webapps.controller.managebeans.print.InvoicePrint;
import com.webapps.controller.managebeans.task.InvoiceCop;
import com.webapps.controller.managebeans.task.OutstandingEntryForm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sameera
 */
@Stateless
public class Invoice {

    @EJB
    private UniDBLocal uniDB;

    @EJB
    private ComDev comDev;

    public boolean SaveInvoiceCorporate(String voucherNo, int voucherId, double voucher_total, double total_paid, double due, double discount, String description, int is_active, int gup, int ls, int ul, int vt, int gop, int payment_mod, ArrayList<InvoiceCop.InvoiceItem> invoiceItemList, String dn_no, String po_no, boolean vat, boolean nbt, double vat_amount, double nbt_amount, String vat_no) {

        Voucher order = (Voucher) uniDB.find(voucherId, Voucher.class);

//        int gop_gup_type = ((order.getPaymentHistoryCollection().iterator().hasNext()) ? order.getPaymentHistoryCollection().iterator().next().getUniversalPersonOrOrgTypeManagerId().getId() : 0);
//        int gop_gup_id = ((order.getPaymentHistoryCollection().iterator().hasNext()) ? order.getPaymentHistoryCollection().iterator().next().getReferenceId() : 0);
        int gop_gup_type = 0;
        int gop_gup_id = 0;
        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.id='" + voucherId + "'", 500);
        for (PaymentHistory p : ph) {
            gop_gup_type = p.getUniversalPersonOrOrgTypeManagerId().getId();
            gop_gup_id = p.getReferenceId();

        }

        Voucher voucher = comDev.CreateVoucher(voucherNo, ComLib.getDate(new Date()), "", voucher_total, total_paid, due, discount, description, is_active, gop_gup_type, gop_gup_id, gup, ls, ul, vt, gop, payment_mod);

        ReferenceVoucher rv_po = new ReferenceVoucher();
        rv_po.setName(po_no);
        rv_po.setValue(1.0);
        rv_po.setVoucherId(voucher);
        uniDB.create(rv_po);

        ReferenceVoucher rv_dn = new ReferenceVoucher();
        rv_dn.setName(dn_no);
        rv_dn.setValue(2.0);
        rv_dn.setVoucherId(voucher);
        uniDB.create(rv_dn);

        VoucherReceiptManager vrm = new VoucherReceiptManager();
        vrm.setVoucher(order);
        vrm.setReceipt(voucher);
        uniDB.create(vrm);

        VoucherPaymentMode vpm = new VoucherPaymentMode();
        vpm.setAmount(total_paid);
        vpm.setVoucherId(voucher);
        vpm.setUniversalPaymentModeId((UniversalPaymentMode) uniDB.find(1, UniversalPaymentMode.class));
        uniDB.create(vpm);

        if (vat_amount > 0) {
            VoucherTaxDetails vtd = new VoucherTaxDetails();
            vtd.setValue(vat_amount);
            vtd.setVoucherId(voucher);
            vtd.setTaxNo(vat_no);
            vtd.setVoucherTaxDetailsTypeId((VoucherTaxDetailsType) uniDB.find(1, VoucherTaxDetailsType.class));
            uniDB.create(vtd);
        }

        if (nbt_amount > 0) {
            VoucherTaxDetails vtd = new VoucherTaxDetails();
            vtd.setValue(nbt_amount);
            vtd.setVoucherId(voucher);
            vtd.setTaxNo("");
            vtd.setVoucherTaxDetailsTypeId((VoucherTaxDetailsType) uniDB.find(5, VoucherTaxDetailsType.class));
            uniDB.create(vtd);
        }

        for (InvoiceCop.InvoiceItem in : invoiceItemList) {

            OrgItem orgItem = comDev.CreateItem(in.getProductName(), "", "", 1, 132, 2, 6, 0, 0, gop, 1, in.getProductName(), 0, 0, 0, 0, in.getPrice(), 0);

            SubChartOfAccount scoa = comDev.CreateSubChartOfAccount(in.getProductName(), in.getProductName(), "Active", 0.0, gop);

            comDev.CreateVoucherItem(in.getQty(), 0, in.getLine_total(), 0, 0, ComLib.getDate(new Date()), 1, 0, "", 0, in.getPrice(), voucher, voucher.getVoucherTypeId(), voucher.getLoginSessionId(), voucher.getUserLoginId(), scoa, voucher.getGeneralOrganizationProfileId(), orgItem);
        }

        InvoicePrint.invoiceNo = voucher.getVoucherId();
        InvoicePrint.invoiceId = voucher.getId();
        comDev.getinvoicePrint(voucher.getId());

        return true;

    }

    public boolean SaveOutstandingInvoice(int gop_gup_type, int gop_gup_id, int gup, int ls, int ul, int vt, int gop, int payment_mod, ArrayList<OutstandingEntryForm.InvoiceList> invoiceList) {

        for (OutstandingEntryForm.InvoiceList in : invoiceList) {

            double total = Double.parseDouble(in.getInvoiceTotal());
            double due = Double.parseDouble(in.getOutstandingAmount());

            Voucher voucher = comDev.CreateVoucher(in.getInvoiceNo(), in.getDate(), "", total, (total - due), due, 0, "", 1, gop_gup_type, gop_gup_id, gup, ls, ul, vt, gop, payment_mod);

            VoucherPaymentMode vpm = new VoucherPaymentMode();
            vpm.setAmount((total - due));
            vpm.setVoucherId(voucher);
            vpm.setUniversalPaymentModeId((UniversalPaymentMode) uniDB.find(1, UniversalPaymentMode.class));
            uniDB.create(vpm);

        }

//        comDev.getinvoiceItemList(gop);
        return true;

    }

    public void deleteInvoice(int id) {

        List<PaymentHistory> ph = uniDB.searchByQuery("SELECT v FROM PaymentHistory v WHERE v.voucherId.id='" + id + "' ");
        for (PaymentHistory p : ph) {
            uniDB.remove(p.getId(), PaymentHistory.class);
        }

        List<UncommonVoucherDetails> uvdc = uniDB.searchByQuery("SELECT uv FROM UncommonVoucherDetails uv WHERE uv.voucherId.id='" + id + "'");
        for (UncommonVoucherDetails uv : uvdc) {
            uniDB.remove(uv.getId(), UncommonVoucherDetails.class);
        }

        List<ReferenceVoucher> vrms = uniDB.searchByQuery("SELECT ur FROM ReferenceVoucher ur WHERE ur.voucherId.id='" + id + "'");
        for (ReferenceVoucher uv : vrms) {
            uniDB.remove(uv.getId(), ReferenceVoucher.class);
        }

        List<VoucherItem> item = uniDB.searchByQuery("SELECT ur FROM VoucherItem ur WHERE ur.voucherId1.id='" + id + "'");
        for (VoucherItem uv : item) {
            uniDB.remove(uv.getId(), VoucherItem.class);
        }

        List<VoucherPaymentMode> vpm = uniDB.searchByQuery("SELECT ur FROM VoucherPaymentMode ur WHERE ur.voucherId.id='" + id + "'");
        for (VoucherPaymentMode uv : vpm) {
            uniDB.remove(uv.getId(), VoucherPaymentMode.class);
        }

        List<VoucherTaxDetails> vtds = uniDB.searchByQuery("SELECT ur FROM VoucherTaxDetails ur WHERE ur.voucherId.id='" + id + "'");
        for (VoucherTaxDetails uv : vtds) {
            uniDB.remove(uv.getId(), VoucherTaxDetails.class);
        }

        uniDB.remove(id, Voucher.class);
    

    }

}
