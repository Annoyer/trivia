<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@include file="../common/const.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>选桌</title>
</head>
<body>
<h5>当前userId=1</h5>
<c:forEach items="${tables}" var="t">
    <button onclick="chooseTable(${t.tableId})">加入${t.tableId}号桌</button>
</c:forEach>

</body>
</html>
<script type="text/javascript">
    function chooseTable(id) {
        alert(id);
        $.ajax({
            method: 'POST',
            url: '${path}/game/chooseTable',
            data: {
                tableId: id
            },
            dataType: "json",
            success: function (data) {
                if (data.success==true){
                    window.location.href='${path}/game/gamePage?tableId='+id;
                } else {
                    alert(data.error);
                }
            },
            error:function () {
                alert("请求出错！");
            }
        });
    }
</script>
