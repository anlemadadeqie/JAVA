<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>失败页面</title>
    <style type="text/css">
        body {
            text-align:center;
            margin-top:150px;
            background-color: #EEE9E9;
        }
    </style>
</head>
<body>
<h1>注册失败！</h1>
<ul style='color:rgb(255,0,0);'>
    <%
        List<String> errors = (List<String>) request.getAttribute("errors");
        for(String error:errors)
        {
    %>
    <li><%= error %></li>
    <%
        }
    %>
</ul>
返回<a href="index.jsp">注册</a>页面
</body>
</html>
