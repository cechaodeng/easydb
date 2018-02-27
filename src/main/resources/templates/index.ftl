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
            <table class="table">
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
            <ul class="pagination">
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
            </ul>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        console.log("加载完毕");
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
                dataType: "text",
                success: function(result) {
                    //将字符串转换成json对象
                    var dataJson = eval('(' + result + ')');
                    //根据json对象拼装成table
                    $.each(dataJson,function (index,rowObj) {
                        //console.log(rowObj.);
                        //console.log($(this).text());
                        console.log(dataJson[index]);
                        console.log(dataJson[index].COL0);

                    })
                    //console.log(dataJson);
                    //console.log(result);
                },
                error: function () {
                    console.log("error");
                }
            });
        });
    })
</script>
</html>