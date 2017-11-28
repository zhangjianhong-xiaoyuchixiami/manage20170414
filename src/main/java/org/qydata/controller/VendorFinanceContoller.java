package org.qydata.controller;

import org.qydata.dst.ApiFinance;
import org.qydata.dst.VendorHistoryBill;
import org.qydata.dst.vendor.VendorFinance;
import org.qydata.service.VendorFinanceService;
import org.qydata.service.VendorHistoryBillService;
import org.qydata.tools.CalendarTools;
import org.qydata.tools.date.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;
@Controller
@RequestMapping("/api")
public class VendorFinanceContoller {

    @Autowired
    private VendorFinanceService service;

    @Autowired
    private VendorHistoryBillService billService;

    /**
     * 统计供应商消费信息
     */
    @RequestMapping("/find-all-api-vendor-consume")
    public ModelAndView findVendorConsume(String export, Integer vendorId, Integer partnerId, String beginDate, String endDate, String [] status, Model model)throws Exception{
        Map<String,Object> map = new HashMap<>();
        if(vendorId != null){
            map.put("vendorId",vendorId);
            model.addAttribute("vendorId",vendorId);
        }
        if(partnerId != null){
            map.put("partnerId",partnerId);
            model.addAttribute("partnerId",partnerId);
        }
        if(beginDate != null && beginDate != ""){
            map.put("beginDate", CalendarUtil.getTranByInputTime(beginDate));
            model.addAttribute("beginDate",beginDate);
        }
        if(endDate != null && endDate != ""){
            map.put("endDate", CalendarUtil.getAfterDayByInputTime(endDate));
            model.addAttribute("endDate",endDate);
        }
        List<String> statusList = new ArrayList();
        if (status != null && status.length >0) {
            for(int i=0;i<status.length;i++){
                statusList.add(status[i]);
            }
        }else {
            statusList.add("0");
            statusList.add("-1");
        }
        map.put("statusList", statusList);
        model.addAttribute("statusArray",statusList);
        Map<String,Object> mapResult = service.queryVendor(map);
        Map<String,Object> mapBill = billService.queryVendorHistoryBill(null);
        List<VendorFinance> financeList = null;
        List<VendorHistoryBill> billList = null;
        if (mapResult != null){
            for (Map.Entry<String,Object> me : mapResult.entrySet()) {
                if (me.getKey().equals("financeList")){
                    financeList = (List<VendorFinance>) me.getValue();
                }
                if (me.getKey().equals("lastWeekConsume")){
                   model.addAttribute("lastWeekConsume",me.getValue());
                }
                if (me.getKey().equals("lastMonthConsume")){
                    model.addAttribute("lastMonthConsume",me.getValue());
                }
                if (me.getKey().equals("currMonthConsume")){
                    model.addAttribute("currMonthConsume",me.getValue());
                }
                if (me.getKey().equals("currDayConsume")){
                    model.addAttribute("currDayConsume",me.getValue());
                }
                if (me.getKey().equals("totleConsume")){
                    model.addAttribute("totleConsume",me.getValue());
                }
            }
        }
        if (mapBill != null){
            for (Map.Entry<String,Object> me : mapBill.entrySet()) {
                if (me.getKey().equals("billList")){
                    billList = (List<VendorHistoryBill>) me.getValue();
                }
            }
        }
        if (financeList != null && billList != null){
            for (VendorFinance finance : financeList) {
                for (VendorHistoryBill bill : billList) {
                    if (finance.getVendorId() == bill.getVendorId() ||
                            finance.getVendorId().equals(bill.getVendorId()))
                    {
                        finance.setBalance(bill.getBalance());
                    }
                }
            }
        }

        model.addAttribute("financeList",financeList);
        model.addAttribute("apiVendorList",service.queryApiVendorName());
        return new ModelAndView("/finance/vendor_finance");
    }
}
