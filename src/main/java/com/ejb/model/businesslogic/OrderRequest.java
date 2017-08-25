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
import com.ejb.model.entity.Voucher;
import com.ejb.model.entity.VoucherItem;
import com.ejb.model.superclasses.VoucherListSuper;
import com.webapps.controller.managebeans.task.OrderBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
public class OrderRequest {

    @EJB
    private UniDBLocal uniDB;

    @EJB
    private ComDev comDev;

    public boolean SaveOrderRequest(String voucher_id, String date, String delivery_date, double voucher_total, double total_paid, double due, double discount, String description, int is_active, int gop_gup_type, int gop_gup_id, int gup, int ls, int ul, int vt, int gop, int payment_mod, ArrayList<OrderBean.Order> orderList, String dn_no, String po_no) {

        Voucher voucher = comDev.CreateVoucher(voucher_id, ComLib.getDate(new Date()), "", voucher_total, total_paid, due, discount, description, is_active, gop_gup_type, gop_gup_id, gup, ls, ul, vt, gop, payment_mod);

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

        UncommonVoucherDetails uc = new UncommonVoucherDetails();
        uc.setVoucherId(voucher);
        uc.setDateOfSold(ComLib.getDateObject(delivery_date));
        uniDB.create(uc);

        for (OrderBean.Order order : orderList) {

            OrgItem orgItem = comDev.CreateItem(order.getProductName(), description, "", 1, 132, 2, 6, 0, 0, gop, 1, order.getProductName(), 0, 0, 0, 0, order.getPrice(), 0);

            SubChartOfAccount scoa = comDev.CreateSubChartOfAccount(order.getProductName(), order.getProductName(), "Active", 0.0, gop);

            comDev.CreateVoucherItem(order.getQty(), 0, order.getLine_total(), 0, 0, ComLib.getDate(new Date()), 1, 0, description, 0, order.getPrice(), voucher, voucher.getVoucherTypeId(), voucher.getLoginSessionId(), voucher.getUserLoginId(), scoa, voucher.getGeneralOrganizationProfileId(), orgItem);
        }

        comDev.getOrderPrint(voucher.getId());

        return true;

    }

    public void deleteAction(int id){

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

        uniDB.remove(id, Voucher.class);

    }

}
