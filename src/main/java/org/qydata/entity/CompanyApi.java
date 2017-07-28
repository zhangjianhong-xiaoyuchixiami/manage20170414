package org.qydata.entity;

import org.qydata.dst.CompanyApiCount;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by jonhn on 2017/1/21.
 */
public class CompanyApi implements Serializable {

    private Integer id;
    private Integer companyId;
    private Integer apiTypeId;
    private Integer subTypeId;
    private Integer price;
    private Integer enabled;
    private Timestamp createTime;
    private String type_stid_name;
    private String btypeName;
    private String cvendorName;
    private Integer apiId;
    private ApiType apiType;
    private MobileOperator mobileOperator;
    private CompanyApiCount companyApiCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getApiTypeId() {
        return apiTypeId;
    }

    public void setApiTypeId(Integer apiTypeId) {
        this.apiTypeId = apiTypeId;
    }

    public Integer getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(Integer subTypeId) {
        this.subTypeId = subTypeId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public ApiType getApiType() {
        return apiType;
    }

    public void setApiType(ApiType apiType) {
        this.apiType = apiType;
    }

    public MobileOperator getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(MobileOperator mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public CompanyApiCount getCompanyApiCount() {
        return companyApiCount;
    }

    public void setCompanyApiCount(CompanyApiCount companyApiCount) {
        this.companyApiCount = companyApiCount;
    }

    public String getType_stid_name() {
        return type_stid_name;
    }

    public void setType_stid_name(String type_stid_name) {
        this.type_stid_name = type_stid_name;
    }

    public String getBtypeName() {
        return btypeName;
    }

    public void setBtypeName(String btypeName) {
        this.btypeName = btypeName;
    }

    public String getCvendorName() {
        return cvendorName;
    }

    public void setCvendorName(String cvendorName) {
        this.cvendorName = cvendorName;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }
}
