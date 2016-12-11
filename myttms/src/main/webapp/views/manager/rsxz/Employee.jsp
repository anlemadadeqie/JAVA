<%@ page import="com.ttms.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户管理页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css">
    <script language="javascript" type="text/javascript">
        function click1(num){

            if(document.getElementById(num).style.display=="block")
            {
                document.getElementById(num).style.display="none";
            }
            else
            {
                document.getElementById(num).style.display="block";

            }

        }

        function checkcontent(){
            var content = document.getElementById("searchcontent").value;
            var regex = /^\w+$/;

            if(!content.match(regex)){
                alert("搜索内容格式不合法!");
                return false;
            }

        }

    </script>
</head>
<body class="mian_bj">
<div class="mian_top_01">
    <div class="mian_top_r"></div>
    <div class="mian_top_l"></div>
    <div class="mian_top_c">
        <ul>
            <li><a href="/employee/showcommonemp">
                <p>
                    用户信息</p>
            </a></li>
            <li><a href="/employee/showemp">
                <p>
                    管理员信息</p>
            </a></li>

        </ul>
    </div>
    <form action="/employee/delcommonemp" method="post">
    <div class="mian_b">
        <div class="mian_b1">
            <a href="/views/manager/rsxz/AddEmployee.jsp" title="添加">
                <p class="mian_b1_a1">
                </p>
            </a>
            <input type="submit" name="submit" class="mian_b1_a2" value=""/>
            <p class="mian_b1_sousuo">
                <input name="" type="text" id="searchcontent"></p>
            <a href="#" title="搜索" onclick="checkcontent();">
                <p class="mian_b1_a3">
                </p>
            </a>
            <p class="mian_b1_a9">
                <a href="#" onclick="click1('search')">高级搜索>></a></p>
            <a href="#" title="最后">
                <p class="mian_b1_a4">
                </p>
            </a><a href="#" title="下一页">
            <p class="mian_b1_a5">
            </p>
        </a>
            <p class="mian_b1_list">
                1 2 3 4……</p>
            <a href="#" title="上一页">
                <p class="mian_b1_a6">
                </p>
            </a><a href="#" title="最前">
            <p class="mian_b1_a7">
            </p>
        </a>
        </div>
        <%--<form action="/employee/delemp" method="post">--%>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg">
            <tr id="search" style="display: none;">
                <td colspan="8" style="height: 35px; background-color: #DBDBDB;margin-left:20px">
                    <select>
                        <option>性别</option>
                        <option>男</option>
                        <option>女</option>
                    </select>&nbsp;
                    <select>
                        <option>所属部门</option>
                        <option>行政部</option>
                        <option>人事部</option>
                    </select>&nbsp;
                    <select>
                        <option>状态</option>
                        <option>在职</option>
                        <option>离职</option>
                    </select>&nbsp;
                    <input name="" type="text" value="工号、姓名、职位、手机" class="input_03">&nbsp;<input name="" type="text" value="起始日期" class="input_03">&nbsp;-&nbsp;<input name="" type="text" value="结束日期" class="input_03">
                </td>
                <td colspan="3" style="height: 35px; background-color: #DBDBDB;">
                    <a href="#" title="高级搜索">
                        <p class="mian_b1_a8" onclick="click('search');">
                        </p>
                    </a>
                </td>
            </tr>

            <tr>
                <td width="3%" class="mian_b_bg_lm">
                    <%--<input name="" type="checkbox" value="1">&nbsp;--%>
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>员工姓名
                </td>
                <td width="5%" class="mian_b_bg_lm">
                    <span></span>性别
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>籍贯
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>手机
                </td>
                <td width="20%" class="mian_b_bg_lm">
                    <span></span>邮箱
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>生日
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>状态
                </td>
                <td colspan="2" class="mian_b_bg_lm">
                    <span></span>操作
                </td>
            </tr>
            <%
                List<Employee> lists = (List<Employee>)request.getAttribute("list");
                for(Employee list : lists){
            %>
            <tr>
                <td>
                    <input name="type" type="checkbox" value="<%=list.getEmp_id()%>">
                    &nbsp;
                </td>
                <td>
                    <%=list.getEmp_name()%>
                </td>
                <td>
                    <%=list.getEmp_sex()%>
                </td>
                <td>
                    <%=list.getEmp_native()%>
                </td>
                <td>
                    <%=list.getEmp_tel_num()%>
                </td>
                <td>
                    <%=list.getEmp_email()%>
                </td>
                <td>
                    <%=list.getEmp_birth()%>
                </td>
                <td>
                    在职
                </td>
                <td width="5%" class="mian_b_icon_01">
                    <a href="AddEmployee.jsp">编辑</a>
                </td>
                <td width="5%" class="mian_b_icon_02">
                    <a href="EmployeeDetail.jsp">查看</a>
                </td>
            </tr>
            <% } %>
            <tr>
                <td width="3%" class="mian_b_bg_lm">&nbsp;

                </td>
                <td width="5%" class="mian_b_bg_lm">
                    <span></span>员工名称
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>性别
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>籍贯
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>手机
                </td>
                <td width="20%" class="mian_b_bg_lm">
                    <span></span>邮箱
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>生日
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>状态
                </td>
                <td colspan="2" class="mian_b_bg_lm">
                    <span></span>操作
                </td>
            </tr>
        </table>

    </div>
    </form>
</div>
</body>
</html>

