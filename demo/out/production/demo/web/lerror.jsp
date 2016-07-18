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
<h1>签到失败！</h1>
<ul style='color:rgb(255,0,0);'>
    <%
        List<String> errorss = (List<String>) request.getAttribute("errorss");
        for(String error:errorss)
        {
    %>
    <li><%=error%></li>
    <%
        }
    %>
</ul>
<a href="index.jsp">返回签到页面</a>
</body>
</html>




