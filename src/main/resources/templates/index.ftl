<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf=8">
    <title>数据库查询</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form">
                <div class="form-group">
                    <label for="exampleInputEmail1">sql:</label>
                    <textarea class="text-area" id="sql" name="sql" style="width: 100%;" rows="10"></textarea>
                    <#--<input type="text" class="form-control" id="exampleInputEmail1" />-->
                </div>
                <#--<button id="btnExecute" class="btn btn-default">Execute</button>-->
                <input type="button" class="button" id="btnExecute" value="Execute"/>
            </form>
            <table class="table" id="content">
                <thead>
                <tr>
                    <th>
                        编号
                    </th>
                    <th>
                        产品
                    </th>
                    <th>
                        交付时间
                    </th>
                    <th>
                        状态
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        TB - Monthly
                    </td>
                    <td>
                        01/04/2012
                    </td>
                    <td>
                        Default
                    </td>
                </tr>
                <tr class="success">
                    <td>
                        1
                    </td>
                    <td>
                        TB - Monthly
                    </td>
                    <td>
                        01/04/2012
                    </td>
                    <td>
                        Approved
                    </td>
                </tr>
                <tr class="error">
                    <td>
                        2
                    </td>
                    <td>
                        TB - Monthly
                    </td>
                    <td>
                        02/04/2012
                    </td>
                    <td>
                        Declined
                    </td>
                </tr>
                <tr class="warning">
                    <td>
                        3
                    </td>
                    <td>
                        TB - Monthly
                    </td>
                    <td>
                        03/04/2012
                    </td>
                    <td>
                        Pending
                    </td>
                </tr>
                <tr class="info">
                    <td>
                        4
                    </td>
                    <td>
                        TB - Monthly
                    </td>
                    <td>
                        04/04/2012
                    </td>
                    <td>
                        Call in to confirm
                    </td>
                </tr>
                </tbody>
            </table>
            <#--<ul class="pagination" id="pageUl">
                <li>
                    <a href="#">Prev</a>
                </li>
                <li>
                    <a href="#">1</a>
                </li>
                <li>
                    <a href="#">2</a>
                </li>
                <li>
                    <a href="#">3</a>
                </li>
                <li>
                    <a href="#">4</a>
                </li>
                <li>
                    <a href="#">5</a>
                </li>
                <li>
                    <a href="#">Next</a>
                </li>
            </ul>-->
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        console.log("加载完毕");
        var curPageNum = 0;
        $("#btnExecute").on("click",function () {
            var sql = $("#sql").val();
            //console.log(sql);
            //return;
            $.ajax({
                type: "POST",
                url: "/db/execute",
                data: {
                    sql: sql
                },
                dataType: "json",
                success: function(result) {
                    //当前页为第一页
                    curPageNum = 1;
                    var rowNum = result.rowNum;
                    var colNum = result.colNum;
                    setPageInfo(rowNum,colNum);
                    //console.log(colNum);
                    var dataJsonStr = result.dataJsonStr;
                    //将字符串转换成json对象
                    var dataJson = eval('(' + dataJsonStr + ')');
                    //根据json对象拼装成table
                    var tableHtml = "";
                    $.each(dataJson,function (index,rowObj) {
                        if (index == 0) {
                            tableHtml += genThead(colNum, index, rowObj);
                        } else {
                            tableHtml += genTbody(colNum, index, rowObj);
                        }
                    })
                    //将html片段插入到table中
                    $("#content").html(tableHtml);
                },
                error: function () {
                    console.log("error");
                }
            });
        });
    });
    function setPageInfo(rowNum) {
        var pageNum = 1 + (rowNum / 15);
        if


    }

    /**
     * 生成表格head内容
     * @param colNum
     * @param index
     * @param rowObj
     * @returns {string}
     */
    function genThead(colNum, index, rowObj) {
        var rowHtml = "<thead><tr>";

        //对每一行遍历，获得每一个字段的值
        for (var i = 0; i < colNum ; i++) {
            var value = rowObj["COL" + i];
            var colHtml = "<th>" + value + "</th>";
            rowHtml += colHtml;
            //console.log(rowObj["COL"+i]);
        }
        //表头要用thead
        rowHtml += "</tr></thead>";
        return rowHtml;
    }

    /**
     * 生成表格body内容
     * @param colNum
     * @param index
     * @param rowObj
     * @returns {string}
     */
    function genTbody(colNum, index, rowObj) {
        var rowHtml = "";
        if (index % 2 == 0) {
            rowHtml = "<tbody><tr class='success'>";
        } else {
            rowHtml = "<tbody><tr>";
        }
        //对每一行遍历，获得每一个字段的值
        for (var i = 0; i < colNum ; i++) {
            var value = rowObj["COL" + i];
            var colHtml = "<td>" + value + "</td>";
            rowHtml += colHtml;
        }
        rowHtml += "</tr></tbody>";
        return rowHtml;
    }
</script>
</html>