var CustomerFinanceAccount = function () {

    return {

        init: function () {

            if (!jQuery().dataTable) {
                return;
            }

            function fnFormatDetails ( oTable, nTr )
            {
                var aData = oTable.fnGetData( nTr );
                var sOut = '<table>';
                sOut += '<tr><th style="width: 8%;">购买产品:</th><th style="width: 30%;">产品类型</th><th style="width: 62%;">价格</th></tr>';
                sOut += '<tr><td style="width: 8%;"></td><td style="width: 30%;">'+aData[10]+'</td><td style="width: 62%;">'+aData[11]+'</td></tr>';
                sOut += '</table>';
                return sOut;
            }

            var nCloneTh = document.createElement( 'th' );
            var nCloneTd = document.createElement( 'td' );
            nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';
            // nCloneTh.innerHTML = '<span class="row-details row-details-close"></span>';
            $('#sample_2 thead tr').each( function () {
                this.insertBefore( nCloneTh, this.childNodes[0] );
            } );

            $('#sample_2 tbody tr').each( function () {
                this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
            } );

            $('#sample_2').on('click', ' tbody td .row-details', function () {
                var nTr = $(this).parents('tr')[0];
                if ( oTable.fnIsOpen(nTr) )
                {
                    /* This row is already open - close it */
                    $(this).addClass("row-details-close").removeClass("row-details-open");
                    oTable.fnClose( nTr );
                }
                else
                {
                    /* Open this row */
                    $(this).addClass("row-details-open").removeClass("row-details-close");
                    oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
                }
            });

            //customerFinancialAccount表格配置
            var oTable = $('#sample_2').dataTable({
                "aoColumns": [
                    {"bSortable": false},  //0
                    null,  //1
                    null,  //2
                    null,  //3
                    null,  //4
                    null,  //5
                    { "bVisible": false},  //6
                    { "bVisible": false},  //7
                    null,  //8
                    null,  //9
                    { "bVisible": false },  //10
                    { "bVisible": false }  //11
                ],
                "aoColumnDefs": [
                    {
                        //充值总额
                        "aTargets": [ 4 ],
                        "sType": "html-percent"
                    },
                    {
                        //消费总额
                        "aTargets": [ 5 ],
                        "sType": "html-percent"
                    },
                    {
                        //上周充值
                        "aTargets": [ 6 ],
                        "sType": "html-percent"
                    },
                    {
                        //上周消费
                        "aTargets": [ 7 ],
                        "sType": "html-percent"
                    },
                    {
                        //上月充值
                        "aTargets": [ 8 ],
                        "sType": "html-percent"
                    },
                    {
                        //上月消费
                        "aTargets": [ 9 ],
                        "sType": "html-percent"
                    }

                ],
                "aaSorting": [[3, 'desc']],
                "aLengthMenu": [
                    [10, 15, 20, -1],
                    [10, 15, 20, "全部"] // change per page values here
                ],
                "bFilter" : false, //设置全文搜索框，默认true

                "iDisplayLength": 15, //每页显示多少行
                "sDom": "t<'row-fluid'<'span6'il><'span6'p>>",
                "sPaginationType": "bootstrap",

                "oLanguage" : {  //设置语言
                    "sLengthMenu" : "每页显示 _MENU_ 条记录",
                    "sZeroRecords" : "对不起，没有匹配的数据",
                    "sInfo" : "第 _START_ - _END_ 条 / 共 _TOTAL_ 条数据",
                    "sInfoEmpty" : "没有匹配的数据",
                    "sInfoFiltered" : "(数据表中共 _MAX_ 条记录)",
                    "sProcessing" : "正在加载中...",
                    "sSearch" : "全文搜索：",
                    "oPaginate" : {
                        "sFirst" : "第一页",
                        "sPrevious" : " 上一页 ",
                        "sNext" : " 下一页 ",
                        "sLast" : " 最后一页 "
                    }
                }


            });

            /*表格显示列控制*/
            $('#sample_2_column_toggler input[type="checkbox"]').change(function(){
                /* Get the DataTables object again - this is not a recreation, just a get of the object */
                var iCol = parseInt($(this).attr("data-column"));
                var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
                oTable.fnSetColumnVis(iCol, (bVis ? false : true));
            });

        }

    };

}();