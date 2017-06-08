<%@ page import="com.ttms.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ttms.entity.Page" %>
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

    <style type="text/css">

        #pagenum{

            margin-left: 380px;
            margin-top:100%;
        }

        .pagenum a{
            display: inline-block;
            height: 22px;
            margin:0 2px;
            padding: 0 8px;
            border:solid 1px #dbe5ee;
            border-radius: 2px;
            background: #fff;
            color: #333;
            font:normal 12px Arial, Helvetica,Sans-Serif;
            cursor: pointer;
        }

    </style>
</head>
<body class="mian_bj">
<div class="mian_top_01">
    <div class="mian_top_r"></div>
    <div class="mian_top_l"></div>
    <div class="mian_top_c">
        <ul>
            <li><a href="/employee/showemp">
                <p>
                    用户信息</p>
            </a></li>
            <li><a href="/employee/showtopemp">
                <p>
                    管理员信息</p>
            </a></li>

        </ul>
    </div>
    <form action="/employee/delemp" method="post">
    <div class="mian_b">
        <div class="mian_b1">
            <a href="/views/manager/rsxz/AddEmployee.jsp" title="添加">
                <p class="mian_b1_a1">
                </p>
            </a>
            <input type="submit" name="submit" class="mian_b1_a2" value=""/>
            <%--<p class="mian_b1_sousuo">--%>
                <%--<input name="" type="text" id="searchcontent"></p>--%>
            <%--<a href="#" title="搜索" onclick="checkcontent();">--%>
                <%--<p class="mian_b1_a3">--%>
                <%--</p>--%>
            <%--</a>--%>
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
                    <span></span>用戶名
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    <span></span>密码
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
                    <%=list.getEmp_no()%>
                </td>
                <td>
                    <%=list.getEmp_pass()%>
                </td>
                <td width="5%" class="mian_b_icon_01">
                    <a href="/employee/editemp?id=<%=list.getEmp_id()%>">编辑</a>
                </td>
                <td width="5%" class="mian_b_icon_02">
                    <a href="/employee/lookemp?id=<%=list.getEmp_id()%>">查看</a>
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
                    <span></span>密码
                </td>
                <td colspan="2" class="mian_b_bg_lm">
                    <span></span>操作
                </td>
            </tr>
        </table>

    </div>
    </form>
</div>
<div>

    <%
        Page pages = (Page)request.getAttribute("pages");
        int pagenow = pages.getPageNow();
    %>

    <div id="pagenum" class="pagenum">


        <strong style="color:black;padding-right: 8px;">第<%=pagenow%>页</strong>

        <a href="/employee/showemp?pageNow=1">首页</a>

        <% if(pagenow - 1 > 0){ %>

        <a href="/employee/showemp?pageNow=<%=pagenow - 1%>">上一页</a>
        <% } %>

        <% if(pagenow - 1 <= 0){ %>
        <a href="/employee/showemp?pageNow=1">上一页</a>
        <% } %>

        <%
            int pagecount = pages.getTotalPageCount();
            for(int i = 1; i <= pagecount; i++ ){

        %>
        <a href="/employee/showemp?pageNow=<%=i%>"><%=i%></a>

        <%}%>
        <%
            if(pagecount == 0){
        %>
        <a href="/employee/showemp?pageNow=<%=pagenow%>">下一页</a>
        <%
            }
            if(pagenow + 1 < pagecount){
        %>
        <a href="/employee/showemp?pageNow=<%=pagenow + 1%>">下一页</a>
        <%
            }
            if(pagenow + 1 >= pagecount){
        %>
        <a href="/employee/showemp?pageNow=<%=pagecount%>">下一页</a>
        <% } %>
        <a href="/employee/showemp?pageNow=<%=pagecount%>">尾页</a>



    </div>
</div>
</body>
</html>

