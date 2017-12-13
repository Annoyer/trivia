<%--
  Created by IntelliJ IDEA.
  User: 86761
  Date: 2017/12/13
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/const.jsp" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/jquery.min.js"></script>
</head>
<body>
<div id="myForm">
    <div>
        用户名:
        <input type="text" id="username"  placeholder="用户名"></br>
        密  码:
        <input type="password" id="password" placeholder="密码"><br>
        </br>
        <button onclick="signup()">注册</button>
    </div>
</div>
</body>
<script>
    function signup() {
        var username=$("#username").val();
        var password=$("#password").val();
        $.ajax({
            type:"post",
            url: '/user/signup',
            dataType: "json",
            data: {
                "username":username,
                "password":password
            },
            success:function (data) {
                if(data.success==true){
                    location.href="${path}/game/tables";
                }
                else{
                    alert(data.error);
                }
            },
            error: function () {
                alert("请求出错！");
            }
        });
    }
</script>
</html>
