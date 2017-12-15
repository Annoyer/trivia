<%--
  Created by IntelliJ IDEA.
  User: joy12
  Date: 2017/12/12
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/const.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>当前userId=1</h5>
<div>有${players.length}个玩家</div>
<c:forEach items="${players}" var="p">
    <div>玩家：${p.playerName}</div>
</c:forEach>
</body>
</html>
<script type="text/javascript">
    $(function() {
        var websocket;
        if('WebSocket' in window) {
            console.log("此浏览器支持websocket");
            websocket = new WebSocket("ws://localhost:8080/websocket/1");//1是userId
        } else if('MozWebSocket' in window) {
            alert("此浏览器只支持MozWebSocket");
        } else {
            alert("此浏览器只支持SockJS");
        }
        websocket.onopen = function(evnt) {
            alert("链接服务器成功!");
        };

        websocket.onmessage = function(evnt) {
            alert("onmessage!");
        };
        websocket.onerror = function(evnt) {
            alert("onerror!");
        };
        websocket.onclose = function(evnt) {
            alert("与服务器断开了链接!")
        }


        function send() {
            if(websocket != null) {
                var message = document.getElementById('message').value;
                websocket.send(message);
            } else {
                alert('未与服务器链接.');
            }
        }
    });
</script>
