<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>失败页面</title>
    <style type="text/css">
        #errorpage{
            margin-top: 200px;
            margin-left: 450px;
            line-height:29px;
            background-color:#3C3C3C;
        }

        #a{ color: #a86400;
        }
    </style>
</head>
<body id="errorpage">
<h1>失败页面</h1>
<div>
    <li style="color: red">${requestScope.errors}</li>
</div>
&nbsp;
<a href="index.jsp" id="a">返回登录页面</a>
</body>
</html>
