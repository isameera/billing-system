/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.businesslogic;

import com.ejb.model.common.ComDev;
import com.ejb.model.common.ComLib;
import com.ejb.model.common.UniDBLocal;
import com.ejb.model.entity.Bank;
import com.ejb.model.entity.ChequeCodition;
import com.ejb.model.entity.ChequeConditionController;
import com.ejb.model.entity.ChequeDetails;
import com.ejb.model.entity.ChequeDetailsType;
import com.ejb.model.entity.GeneralOrganizationProfile;
import com.ejb.model.entity.PaymentHistory;
import com.ejb.model.entity.ReferenceVoucher;
import com.ejb.model.entity.UniversalPersonOrOrgTypeManager;
import com.ejb.model.entity.Voucher;
import com.ejb.model.entity.VoucherReceiptManager;
import com.ejb.model.superclasses.VoucherListSuper;
import com.webapps.controller.managebeans.print.InvoicePrint;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sameera
 */
@Stateless
public class Receipt {

    @EJB
    private UniDBLocal uniDB;

    @EJB
    private ComDev comDev;

    public boolean SaveReceiptCorporate(String voucherNo, int voucherId, double current_payment, String description, int is_active, int gup, int ls, int ul, int vt, int gop, int payment_mod, String dn_no, String po_no, String chequeNo, String chequeDate, int bank, String bank_branch, int cc, int coc) {

        Voucher invoice = (Voucher) uniDB.find(voucherId, Voucher.class);

        int gop_gup_type = 0;
        int gop_gup_id = 0;
        List<PaymentHistory> ph = uniDB.searchByQueryLimit("SELECT v FROM PaymentHistory v WHERE v.voucherId.id='" + voucherId + "'", 500);
        for (PaymentHistory p : ph) {
            gop_gup_type = p.getUniversalPersonOrOrgTypeManagerId().getId();
            gop_gup_id = p.getReferenceId();
        }

        Voucher voucher = comDev.CreateVoucher(voucherNo, ComLib.getDate(new Date()), "", current_payment, current_payment, 0, 0, description, is_active, gop_gup_type, gop_gup_id, gup, ls, ul, vt, gop, payment_mod);

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
        vrm.setVoucher(invoice);
        vrm.setReceipt(voucher);
        uniDB.create(vrm);

        invoice.setTotalPaid(invoice.getTotalPaid() + current_payment);
        invoice.setDue(invoice.getDue() - current_payment);
        uniDB.update(invoice);

        if (coc == 2) {
            GeneralOrganizationProfile bankBranch = comDev.SaveBankBranch(bank_branch, "-", "-", "-", "-", "-", "-", "-", "-", 2, 24, bank);

            ChequeDetails cd = new ChequeDetails();
            cd.setChequeAmount(current_payment);
            cd.setChequeDate(ComLib.getDateObject(chequeDate));
            cd.setChequeNo(chequeNo);
            cd.setGeneralOrganizationProfileId(bankBranch);
            cd.setReference(gop);
            cd.setUniversalPersonOrOrgTypeManagerId((UniversalPersonOrOrgTypeManager) uniDB.find(1, UniversalPersonOrOrgTypeManager.class));
            cd.setBankId((Bank) uniDB.find(bank, Bank.class));
            cd.setChequeDetailTypeId((ChequeDetailsType) uniDB.find(2, ChequeDetailsType.class));
            cd.setVoucherId(voucher);
            uniDB.create(cd);

            ChequeConditionController ccc = new ChequeConditionController();
            ccc.setChequeCoditionId((ChequeCodition) uniDB.find(cc, ChequeCodition.class));
            ccc.setChequeDetailsId(cd);
            uniDB.create(ccc);
        }

        List<VoucherReceiptManager> vr = uniDB.searchByQuerySingle("SELECT r FROM VoucherReceiptManager r WHERE r.receipt.id='" + invoice.getId() + "'");
        for (VoucherReceiptManager v : vr) {
            InvoicePrint.orderNo = v.getVoucher().getVoucherId();

        }

        comDev.getReceiptPrintDetails(voucher.getId());

        InvoicePrint.invoiceNo = invoice.getVoucherId();
        InvoicePrint.receiptNo = voucher.getVoucherId();
        InvoicePrint.receiptId = voucher.getId();

        return true;

    }

    public void deleteAction(int id){

        Voucher invoice = null;
        Voucher receipt = (Voucher) uniDB.find(id, Voucher.class);;

        List<PaymentHistory> ph = uniDB.searchByQuery("SELECT v FROM PaymentHistory v WHERE v.voucherId.id='" + id + "' ");
        for (PaymentHistory p : ph) {
            uniDB.remove(p.getId(), PaymentHistory.class);
        }

        List<ReferenceVoucher> vrms = uniDB.searchByQuery("SELECT ur FROM ReferenceVoucher ur WHERE ur.voucherId.id='" + id + "'");
        for (ReferenceVoucher uv : vrms) {
            uniDB.remove(uv.getId(), ReferenceVoucher.class);
        }

        List<VoucherReceiptManager> vr = uniDB.searchByQuerySingle("SELECT r FROM VoucherReceiptManager r WHERE r.receipt.id='" + id + "'");
        for (VoucherReceiptManager v : vr) {

            invoice = (Voucher) uniDB.find(v.getVoucher().getId(), Voucher.class);

        }

        invoice.setTotalPaid(invoice.getTotalPaid() - receipt.getVoucherTotal());
        invoice.setDue(invoice.getDue() + receipt.getVoucherTotal());
        uniDB.update(invoice);

        uniDB.remove(id, Voucher.class);

    }

}
