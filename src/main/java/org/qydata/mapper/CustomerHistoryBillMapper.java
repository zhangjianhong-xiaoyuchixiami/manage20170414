package org.qydata.mapper;

import org.qydata.dst.CustomerHistoryBill;
import org.qydata.dst.CustomerHistoryBillDetail;
import org.qydata.entity.*;

import java.util.List;
import java.util.Map;

/**
 * Created by jonhn on 2017/7/31.
 */
public interface CustomerHistoryBillMapper {


    /**
     * 查询客户历史消费账单
     * @param map
     * @return
     */
    public List<CustomerHistoryBill> queryCustomerHistoryBill(Map<String,Object> map);

    /**
     * 查询充值总额（至昨天）
     * @param map
     * @return
     */
    public List<CustomerHistoryBill> queryCustomerChargeTotle(Map<String,Object> map);

    /**
     * 查询当天充值总额
     * @param map
     * @return
     */
    public List<CustomerHistoryBill> queryCustomerChargeCurrDay(Map<String,Object> map);

    /**
     * 查询客户截止上月静态消费
     * @return
     */
    public List<CustomerHistoryBill> queryCustomerStaticConsumeAmount();

    /**
     * 查询客户当月实时消费（不包括当天）
     * @param map
     * @return
     */
    public List<CustomerHistoryBill> queryCustomerCurrMonthRealTimeConsume(Map<String,Object> map);

    /**
     * 查询客户当天实时消费
     * @param map
     * @return
     */
    public List<CustomerHistoryBill> queryCustomerCurrDayRealTimeConsume(Map<String,Object> map);

    /**
     * 根据公司companyId查询正式账号id
     * @param cid
     * @return
     */
    public Integer queryCustomerIdByCompanyId(Integer cid);

    /**
     * 查询所有客户
     * @return
     */
    public List<Company> queryAllCompany();

    /**
     * 查询所有合作伙伴
     * @return
     */
    public List<Partner> queryAllPartner();

    /**
     * 查询消费的月份
     * @return
     */
    public List<String> queryAllConsumeTime();

    /**
     * 查询客户历史消费账单明细
     * @param map
     * @return
     */
    public List<CustomerHistoryBillDetail> queryCustomerHistoryBillDetail(Map<String,Object> map);

    /**
     * 修改单价
     * @param id
     * @param cost
     * @return
     */
    public boolean updateCustomerHistoryBillCost(Integer id,Integer cost);

    /**
     * 修改扣费量
     * @param id
     * @param amount
     * @return
     */
    public boolean updateCustomerHistoryBillAmount(Integer id,Integer amount);

    /**
     * 新增历史记录
     * @param bill
     * @return
     */
    public boolean addCustomerHistoryBill(CustomerHistoryBillDetail bill);

    /**
     * 删除历史记录
     * @param list
     * @return
     */
    public boolean deleteCustomerHistoryBill(List<String> list);

    /**
     * 客户历史账单消费走势加载数据---加载月消费量
     * @param map
     * @return
     */
    public List<CustomerHistoryBillDetail> queryCustomerHistoryBillTrendDataConsume(Map<String,Object> map);


    /**
     * 客户历史账单消费走势加载数据---加载上月各产品扣费量
     * @param map
     * @return
     */
    public List<CustomerHistoryBillDetail> queryCustomerHistoryBillTrendDataAmount(Map<String,Object> map);

    /**
     * 根据客户公司Id查询产品权限
     * @param cid
     * @return
     */
    public List<CompanyApi> queryCompanyApiByCompanyId(Integer cid);

    /**
     * 根据客户账号Id查询公司Id
     * @param map
     * @return
     */
    public Integer queryCompanyIdByCustomerId(Map<String,Object> map);

    /**
     * 修改锁定/解锁状态
     * @param map
     * @return
     */
    public boolean updateCustomerHistoryBillIsLock(Map<String,Object> map);

    /**
     * 添加修改日志
     * @param log
     * @return
     */
    public boolean insertCustomerHistoryBillUpdateLog(CustomerHistoryBillUpdateLog log);

    /**
     * 根据Id查看锁定状态
     * @param id
     * @return
     */
    public Integer queryCustomerHistoryBillLockById(Integer id);

    /**
     * 查看修改日志
     * @param map
     * @return
     */
    public List<CustomerHistoryBillUpdateLog> queryCustomerHistoryBillDetailUpdateLog(Map<String,Object> map);


}
