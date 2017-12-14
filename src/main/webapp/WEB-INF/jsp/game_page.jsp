<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86761
  Date: 2017/12/13
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/const.jsp" %>
<html>
<head>
    <title>Game page</title>
</head>
<body>
<p>game page</p>
<c:forEach items="${players}" var="p">
    <p>${p.user.username}</p>
</c:forEach>
</body>
</html>
