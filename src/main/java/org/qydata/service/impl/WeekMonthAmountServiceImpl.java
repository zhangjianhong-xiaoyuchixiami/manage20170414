package org.qydata.service.impl;

import org.qydata.entity.WeekMonthAmount;
import org.qydata.mapper.WeekMonthAmountMapper;
import org.qydata.service.WeekMonthAmountService;
import org.qydata.tools.IpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jonhn on 2017/1/6.
 */
@Service
public class WeekMonthAmountServiceImpl implements WeekMonthAmountService {

    @Autowired
    private WeekMonthAmountMapper weekMonthAmountMapper;

    @Override
    public  boolean getAllCustomerWeekRechargeRecordAndAddWeekMonthAmount() throws Exception {
        List<WeekMonthAmount> weekAmountList = weekMonthAmountMapper.getAllCustomerWeekRechargeRecord();
        List<WeekMonthAmount> weekAmounts = new ArrayList<>();
        Iterator<WeekMonthAmount> iterator = weekAmountList.iterator();
        while (iterator.hasNext()){
            WeekMonthAmount weekMonthAmount = iterator.next();
            List<String> temporalList = IpTool.spiltStr(weekMonthAmount.getTemporal());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tableName = "CustomerBalanceLog";
            Integer weekMonthTypeId = 1;
            WeekMonthAmount weekMonthAmountOne = new WeekMonthAmount();
            weekMonthAmountOne.setYears(weekMonthAmount.getYears());
            weekMonthAmountOne.setMonths(weekMonthAmount.getMonths());
            weekMonthAmountOne.setWeeks(weekMonthAmount.getWeeks());
            weekMonthAmountOne.setTotleAmount(weekMonthAmount.getTotleAmount());
            weekMonthAmountOne.setCustomerId(weekMonthAmount.getCustomerId());
            weekMonthAmountOne.setTableName(tableName);
            weekMonthAmountOne.setWeekMonthTypeId(weekMonthTypeId);
            weekMonthAmountOne.setBeginTime(sdf.parse(temporalList.get(0)));
            weekMonthAmountOne.setEndTime(sdf.parse(temporalList.get(temporalList.size()-1)));
            weekAmounts.add(weekMonthAmountOne);
        }
        return weekMonthAmountMapper.addCustomerWeekRechargeRecord(weekAmounts);
    }


    @Override
    public boolean getAllCustomerMonthRechargeRecordAndAddWeekMonthAmount() throws Exception {
        List<WeekMonthAmount> monthAmountList = weekMonthAmountMapper.getAllCustomerMonthRechargeRecord();
        List<WeekMonthAmount> monthAmounts = new ArrayList<>();
        Iterator<WeekMonthAmount> iterator = monthAmountList.iterator();
        while (iterator.hasNext()){
            WeekMonthAmount weekMonthAmount = iterator.next();
            List<String> temporalList = IpTool.spiltStr(weekMonthAmount.getTemporal());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tableName = "CustomerBalanceLog";
            Integer weekMonthTypeId = 2;
            WeekMonthAmount weekMonthAmountOne = new WeekMonthAmount();
            weekMonthAmountOne.setYears(weekMonthAmount.getYears());
            weekMonthAmountOne.setMonths(weekMonthAmount.getMonths());
            weekMonthAmountOne.setTotleAmount(weekMonthAmount.getTotleAmount());
            weekMonthAmountOne.setCustomerId(weekMonthAmount.getCustomerId());
            weekMonthAmountOne.setTableName(tableName);
            weekMonthAmountOne.setWeekMonthTypeId(weekMonthTypeId);
            weekMonthAmountOne.setBeginTime(sdf.parse(temporalList.get(0)));
            weekMonthAmountOne.setEndTime(sdf.parse(temporalList.get(temporalList.size()-1)));
            monthAmounts.add(weekMonthAmountOne);
        }
        return weekMonthAmountMapper.addCustomerMonthRechargeRecord(monthAmounts);
    }
}
