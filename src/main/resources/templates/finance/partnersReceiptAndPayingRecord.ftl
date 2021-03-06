
<#include "../publicPart/layout.ftl">

<#import "../publicPart/headNavigationBars.ftl" as c>

<#import "../publicPart/tools.ftl" as d>

<#import "../publicPart/publicJs.ftl" as puj>

<@layout ; section>
    <#if section = "head">

    <#elseif section = "content" >

    <div class="page-content">

        <div class="container-fluid">

            <@c.navigationBars></@c.navigationBars>

            <div class="row-fluid">

                <div class="span12">

                    <div class="pull-left head-search-bottom head-search-display">

                        <label class="control-label">合作公司Id</label>

                        <div class="controls">

                            <input class="m-wrap" <#if partnerId??>value="${partnerId}" </#if> type="text" id="partnerId" name="partnerId">

                        </div>

                    </div>

                    <div class="pull-left head-search-bottom head-search-display">

                        <label class="control-label">类型Id</label>

                        <div class="controls">

                            <input class="m-wrap" <#if reasonId??>value="${reasonId}" </#if> type="text" id="reasonId" name="reasonId">

                        </div>

                    </div>

                <#--表单-->
                    <div class="portlet box grey">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-user"></i><#if partnerName??>${partnerName}</#if></div>

                            <@d.tools idName="exportExcel" hrefName="/partner/find-all-partner-financial-account/income-and-expenditure-record?export=true"></@d.tools>

                        </div>

                        <div class="portlet-body no-more-tables">

                            <div class="clearfix margin-bottom-20">

                                <div class="pull-left table-top-bottom">

                                    <label class="control-label">金额共计&yen;：<#if totleAmount??><span>${(totleAmount/100.0)?c}元</span><#else ><span>0元</span></#if></label>

                                </div>

                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover table-condensed" id="sample_4">
                                    <thead>
                                    <tr>
                                        <th>金额（单位：元）</th>
                                        <th>创建时间</th>
                                        <th>备注</th>
                                        <th>类型</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#if partnerIncomeExpenditureLogList??>
                                            <#list partnerIncomeExpenditureLogList as partnerIncomeExpenditureLog>
                                            <tr>
                                                <td data-title="金额"><#if partnerIncomeExpenditureLog.amount??>${(partnerIncomeExpenditureLog.amount/100.0)?c}<#else >0</#if></td>
                                                <td data-title="创建时间">${partnerIncomeExpenditureLog.createTime?date}</td>
                                                <td data-title="备注">${partnerIncomeExpenditureLog.remark!'无'}</td>
                                                <td data-title="类型">${(partnerIncomeExpenditureLog.partnerIncomeExpenditureReason.name)!"无"}</td>
                                            </tr>
                                            </#list>
                                        </#if>
                                    </tbody>

                                </table>
                            </div>
                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <#elseif section = "footer">

    <#elseif section = "publicJs">

    <#elseif section = "privateJs">

        <@puj.publicJs></@puj.publicJs>

    <script src="/js/myjs/partners-receipt-paying-record.js?v=${ver}"></script>

    <script src="/js/oldlocal/partner-receipt-paying-record.js?v=${ver}"></script>

    <script>

        jQuery(document).ready(function() {
            PartnersReceiptPayingRecord.init();
        });

    </script>

    </#if>

</@layout>
