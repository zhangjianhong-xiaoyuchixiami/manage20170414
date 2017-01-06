
<#include "../customer/layout.ftl">

<#import "../publicPart/headNavigationBars.ftl" as c>

<@layout ; section>
    <#if section = "head">

    <#elseif section = "content" >

    <div class="page-content">

        <div class="container-fluid">

            <@c.navigationBars></@c.navigationBars>

            <div class="row-fluid">

                <div class="span12">

                <#--搜索框-->
                    <#if deptIdList??>
                        <form action="/customer-balance/find-all-customer-by-dept-id" method="get">

                            <div class="clearfix margin-bottom-20">

                                <div class="control-group pull-left" style="margin-bottom: -20px;margin-top: -25px;">

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

                                <div class="control-group pull-left" style="margin-bottom: -20px;margin-top: -25px;">

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

                            <div class="caption"><i class="icon-user"></i></div>

                            <div class="actions">

                                <div class="btn-group">

                                    <a class="btn white" href="#" data-toggle="dropdown">

                                        工具

                                        <i class="icon-angle-down"></i>

                                    </a>

                                    <ul class="dropdown-menu pull-right">

                                        <li><a href="#"><i class="icon-print"></i> 打印</a></li>

                                        <li><a href="#"><i class="icon-share icon-black"></i> 导出Excel</a></li>

                                        <#--<li><a href="#"><i class="icon-ban-circle"></i> Ban</a></li>-->

                                        <#--<li class="divider"></li>-->

                                        <#--<li><a href="#"><i class="i"></i> Make admin</a></li>-->

                                    </ul>

                                </div>

                            </div>

                        </div>

                        <div class="portlet-body no-more-tables">

                            <table class="table table-striped table-bordered table-hover table-condensed" id="sample_2">

                                <thead>
                                <tr>
                                    <th style="text-align: center; width: 10%;">公司名称</th>
                                    <th>周充值总额（单位：元</th>
                                    <th>周消费总额（单位：元</th>
                                    <th>月充值总额（单位：元</th>
                                    <th>月消费总额（单位：元</th>
                                    <th>充值总额（单位：元</th>
                                    <th>消费总额（单位：元</th>
                                    <th>余额（单位：元</th>
                                    <th style="text-align: center; width: 10%;">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#if customerList??>
                                        <#list customerList as customer>
                                        <tr>
                                            <td data-title="公司名称">${customer.company.name}</td>
                                            <td data-title="周充值总额">123</td>
                                            <td data-title="周消费总额">123</td>
                                            <td data-title="月充值总额">123</td>
                                            <td data-title="月消费总额">123</td>
                                            <td data-title="充值总额">123</td>
                                            <td data-title="消费总额">123</td>
                                            <td data-title="账号余额">${customer.balance/100.0}</td>
                                            <td data-title="操作" style="text-align: center">
                                                <#--<p>-->
                                                    <#--<a href="/finance/find-all-customer/find-all-customer-recharge-log-by-customer-id/${customer.id}?reasonId=1">充值记录</a>-->
                                                    <#--|-->
                                                    <#--<a href="/finance/find-all-customer/find-all-customer-api-consume-record-by-customer-id">消费明细</a>-->
                                                <#--</p>-->
                                                    <ul class="nav nav-tabs">
                                                        <li class="dropdown">
                                                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                                                充值记录 <span class="caret"></span>
                                                            </a>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="#">消费记录</a></li>
                                                                <li><a href="#">周历史数据</a></li>
                                                                <li><a href="#">月历史数据</a></li>
                                                            </ul>
                                                        </li>
                                                    </ul>
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
