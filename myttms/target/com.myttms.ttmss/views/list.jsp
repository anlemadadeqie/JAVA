<%@ page pageEncoding="UTF-8"%>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme() + "://" + request.getServerName() + ":"
            + request.getServerPort() + path + "/";
    
    String login=(String) session.getAttribute("login");
    if(login == null || !login.equals("yes"))
    {
        request.setAttribute("errors", "请输入用户名、密码");
        RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
        rd.forward(request, response);
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	font-size: 24pt;
	background-color: #3c3c3c;
	text-align: center;
	margin-top:160px;
	color: #7e7e7e;

}

a{
	color: #cc9900;
	font-size: 21px;
}
.mydiv{
	margin-top: 20px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<div style="font-size: 30px;">${desc}</div>
	<div class="mydiv">
		<a href="/views/ordinary/ChangePass.jsp">普通用户通道</a>
	</div>
	<div>
	<a href="/views/manager/index-x.jsp">管理员通道</a>
	</div>
</body>
</html>