package org.qydata.service.impl;

import org.qydata.entity.CompanyApi;
import org.qydata.entity.agency.AgencyBillDetail;
import org.qydata.entity.agency.AgencyCustomer;
import org.qydata.entity.agency.RebateAgency;
import org.qydata.mapper.AgencyMapper;
import org.qydata.service.AgencyService;
import org.qydata.tools.finance.AgencyBillUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/9/14.
 */
@Service
public class AgencyServiceImpl implements AgencyService {

    @Autowired
    private AgencyMapper agencyMapper;

    @Override
    public List<RebateAgency> queryAgency() {
        List<RebateAgency> agencyList = agencyMapper.queryAgency();
        if (agencyList == null){
            return null;
        }
        for (RebateAgency agency : agencyList) {
            if (agency.getTaxRate() != null){
                agency.setTaxRateName(agency.getTaxRate() + "%");
            }else {
                agency.setTaxRateName("无");
            }
        }
        return agencyList;
    }

    @Override
    public String queryRebateRuleById(Integer id) {
        return agencyMapper.queryRebateRuleById(id);
    }

    @Override
    public Map<String, Object> queryAgencyBill(Map<String, Object> map) {
        Map<String,Object> param = new HashMap<>();
        Integer agencyId = null;
        if (map != null){
            for (Map.Entry<String,Object> me : map.entrySet()) {
                if (me.getKey().equals("cid")){
                    param.put("cidList",me.getValue());
                }
                if (me.getKey().equals("cyc")){
                    param.put("cycList",me.getValue());
                }
                if (me.getKey().equals("agencyId")){
                    param.put("agencyId",me.getValue());
                    agencyId = (Integer) me.getValue();
                }
                if (me.getKey().equals("tid")){
                    String tid_stid [] = (String[]) me.getValue();
                    List<String> tidList = new ArrayList<>();
                    List<String> stidList = new ArrayList<>();
                    for (String s : tid_stid) {
                        if (s.contains("-")){
                            String tid_stids [] = s.split("-");
                            tidList.add(tid_stids[0]);
                            stidList.add(tid_stids[1]);
                        }
                    }
                    param.put("tidList",tidList);
                    param.put("stidList",stidList);
                }
            }
        }

        List<AgencyBillDetail> detailList = agencyMapper.queryAgencyBillDetailUserOur(param);
        if (detailList != null){
            for (AgencyBillDetail detail : detailList) {
                if (detail.getCost() != null){
                    detail.setCost(detail.getCost()/100.0);
                }
                if (detail.getPrice() != null){
                    detail.setPrice(detail.getPrice()/100.0);
                }
                if (detail.getRebateBegPrice() != null){
                    detail.setRebateBegPrice(detail.getRebateBegPrice()/100.0);
                }
                if (detail.getRebateEndPrice() != null){
                    detail.setRebateEndPrice(detail.getRebateEndPrice()/100.0);
                }

            }
        }
        List<AgencyBillDetail> detailListOppo = agencyMapper.queryAgencyBillDetailUserOpposite(param);
        if (detailListOppo != null){
            for (AgencyBillDetail detail : detailListOppo) {
                if (detail.getCost() != null){
                    detail.setCost(detail.getCost()/100.0);
                }
                if (detail.getCost() != null && detail.getCostCount() != null){
                    detail.setCostMoney(detail.getCost() * detail.getCostCount());
                }
            }
        }
        List<AgencyBillDetail> detailListCache = agencyMapper.queryAgencyBillDetailCache(param);
        if (detailListCache != null){
            for (AgencyBillDetail detail : detailListCache) {
                if (detail.getPrice() != null){
                    detail.setPrice(detail.getPrice()/100.0);
                }
                if (detail.getPrice() != null && detail.getCostCount() != null){
                    detail.setPriceMoney(detail.getPrice() * detail.getCostCount());
                }
            }
        }
        Map<String,Object> data = AgencyBillUtil.dataProcessing(agencyId,detailList,detailListOppo,detailListCache);
        Map<String,Object> resu = new HashMap<>();
        resu.put("detailList",detailList);
        resu.put("detailListOppo",detailListOppo);
        resu.put("detailListCache",detailListCache);
        resu.put("data",data);
        return resu;
    }

    @Override
    public List<AgencyCustomer> queryAgencyCustomer(Map<String,Object> map) {
        List<AgencyCustomer> list = agencyMapper.queryAgencyCustomer(map);
        return list;
    }

    @Override
    public List<String> queryConsumeCycle() {
        return agencyMapper.queryConsumeCycle();
    }

    @Override
    public List<CompanyApi> queryConsumeApiType() {
        return agencyMapper.queryConsumeApiType();
    }

    @Override
    public boolean updateRebateBillAmount(Integer id, Integer amount) {
        return agencyMapper.updateRebateBillAmount(id,amount);
    }

    @Override
    public boolean updateRebateBillCost(Integer id, Double cost) {
        return agencyMapper.updateRebateBillCost(id, (int) (cost*100));
    }

    @Override
    public boolean updateRebateBillPrice(Integer id, Double price) {
        return agencyMapper.updateRebateBillPrice(id, (int) (price*100));
    }

    @Override
    public boolean updateRebateBillBeginPrice(Integer id, Double price) {
        return agencyMapper.updateRebateBillBeginPrice(id, (int) (price*100));
    }

    @Override
    public boolean updateRebateBillEndPrice(Integer id, Double price) {
        return agencyMapper.updateRebateBillEndPrice(id, (int) (price*100));
    }

    @Override
    public boolean deleteRebateDetail(String[] id) {
        List<String> list = new ArrayList<>();
        if (id != null){
            for (String s : id) {
                list.add(s);
            }
        }
        return agencyMapper.deleteRebateDetail(list);
    }

    @Override
    public boolean updateCachePrice(Integer id, Double price) {
        return agencyMapper.updateCachePrice(id, (int) (price * 100));
    }

    @Override
    public boolean updateCacheCount(Integer id, Integer count) {
        return agencyMapper.updateCacheCount(id,count);
    }

    @Override
    public boolean deleteCacheDetail(String[] id) {
        List<String> list = new ArrayList<>();
        if (id != null){
            for (String s : id) {
                list.add(s);
            }
        }
        return agencyMapper.deleteCacheDetail(list);
    }

}
