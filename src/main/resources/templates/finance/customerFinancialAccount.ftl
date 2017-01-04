
<#include "../customer/layout.ftl">

<@layout ; section>
    <#if section = "head">

    <#elseif section = "content" >

    <div class="page-content">

        <div class="container-fluid">

            <div class="row-fluid">

                <div class="span12">

                    <h3 class="page-title">

                    <#--客户信息-->

                    </h3>

                <ul class="breadcrumb">

                <li>

                <i class="icon-home"></i>

                <a href="/view/successUrl">首页</a>

                <i class="icon-angle-right"></i>

                </li>

                <li>

                <a href="#">财务管理</a>

                <i class="icon-angle-right"></i>

                </li>

                <li><a href="#">账号列表</a></li>

                </ul>

                    <!-- END PAGE TITLE & BREADCRUMB-->

                </div>

            </div>

            <div class="row-fluid">

                <div class="span12">

                <#--搜索框-->
                    <#if deptIdList??>
                        <form action="/customer-balance/find-all-customer-by-dept-id" method="get">

                            <div class="clearfix margin-bottom-20" style="border: 1px solid red">

                                <div class="control-group pull-left" style="margin-bottom: -25px">

                                    <label class="control-label">&nbsp;&nbsp;</label>

                                    <div class="controls">

                                        <div class="input-append">

                                            <input class="m-wrap" <#if content??>value="${content}" </#if> type="text" name="content" placeholder="请输入公司名称">

                                            <button class="btn black" type="submit">搜索</button>

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </form>
                    <#else >
                        <form action="/customer-balance/find-all-customer" method="get">

                            <div class="clearfix margin-bottom-20">

                                <div class="control-group pull-left" style="margin-bottom: -25px">

                                    <label class="control-label">&nbsp;&nbsp;</label>

                                    <div class="controls">

                                        <div class="input-append">

                                            <input class="m-wrap" <#if content??>value="${content}" </#if> type="text" name="content" placeholder="请输入公司名称">

                                            <button class="btn black" type="submit">搜索</button>

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </form>
                    </#if>
                <#--表单-->
                    <div class="portlet box grey">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-cogs"></i></div>

                            <div class="tools">

                            <#--<a href="javascript:;" class="collapse"></a>-->

                                <#--<a href="#portlet-config" data-toggle="modal" class="config"></a>-->

                                <#--<a href="javascript:;" class="reload"></a>-->

                                <#--<a href="javascript:;" class="remove"></a>-->

                            </div>

                        </div>

                        <div class="portlet-body no-more-tables">

                            <table class="table table-striped table-bordered table-hover table-condensed" id="sample_2">

                                <thead>
                                <tr>
                                    <th style="text-align: center; width: 15%">公司名称</th>
                                    <th>周充值总额（单位：元</th>
                                    <th>周消费总额（单位：元</th>
                                    <th>月充值总额（单位：元</th>
                                    <th>月消费总额（单位：元</th>
                                    <th>充值总额（单位：元</th>
                                    <th>消费总额（单位：元</th>
                                    <th>余额（单位：元</th>
                                    <th style="text-align: center; width: 15%">操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                    <#if customerList??>
                                        <#list customerList as customer>
                                        <tr class="odd gradeX">
                                            <td data-title="公司名称">${customer.company.name}</td>
                                            <td data-title="周充值总额">123</td>
                                            <td data-title="周消费总额">123</td>
                                            <td data-title="月充值总额">123</td>
                                            <td data-title="月消费总额">123</td>
                                            <td data-title="充值总额">123</td>
                                            <td data-title="消费总额">123</td>
                                            <td data-title="账号余额">${customer.balance/100.0}</td>
                                            <td data-title="操作" style="text-align: center">
                                                <p>
                                                    <a href="/finance/find-all-customer/find-all-customer-recharge-log-by-customer-id/${customer.id}?reasonId=1">充值记录</a>
                                                    |
                                                    <a href="/finance/find-all-customer/find-all-customer-api-consume-record-by-customer-id">消费明细</a>
                                                </p>
                                            </td>
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

    <#elseif section = "footer">

    <#elseif section = "publicJs">

    <#elseif section = "privateJs">
    <script type="text/javascript" src="/js/jquery.dataTables.js"></script>

    <script type="text/javascript" src="/js/DT_bootstrap.js"></script>

    <script src="/js/table-managed.js"></script>

    <script>

        jQuery(document).ready(function() {
            TableManaged.init();
        });

    </script>

    <script>
        $(document).ready(function() {
            $('#customerBalance').addClass('active');

            $('#customerListBalanceLog').addClass('active');

            $('#customerBalanceSelect').addClass('selected');

            $('#customerBalanceArrow').addClass('arrow open');
        });
    </script>
    </#if>

</@layout>
