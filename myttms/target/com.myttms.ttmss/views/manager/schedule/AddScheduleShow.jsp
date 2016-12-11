<%@ page import="java.util.List" %>
<%@ page import="com.ttms.entity.Studio" %>
<%@ page import="com.ttms.entity.ScheduleDetail" %><%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 16-12-5
  Time: 下午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加影厅</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body class="mian_bj">
<div class="mian_top_01">
    <div class="mian_top_r">
    </div>
    <div class="mian_top_l">
    </div>
    <div class="mian_top_c">
            <ul>

                <li><a href="/schedule/showsched">
                    <p>
                        演出计划一览</p>
                </a></li>
                <li><a href="/schedule/addschedshow">
                    <p>
                        修改演出计划</p>
                </a></li>
                <li><a href="/schedule/delschedshow">
                    <p>
                        删除演出计划</p>
                </a></li>
            </ul>
    </div>
    <div class="mian_b">
        <div class="mian_b1">

            <a href="/views/manager/knowledge/AddStudio.jsp" title="添加">
                <p class="mian_b1_a1">
                </p>
            </a>
            <p class="mian_b1_sousuo">
                <input name="" type="text"></p>
            <a href="#" title="搜索">
                <p class="mian_b1_a3">
                </p>
            </a><a href="#" title="最后">
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
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg">
            <tr>
                <td width="3%" class="mian_b_bg_lm">&nbsp;

                </td>
                <td width="87%" class="mian_b_bg_lm">
                    演出计划列表
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    操作
                </td>
            </tr>
            <%
                List<ScheduleDetail> lists= (List<ScheduleDetail>)request.getAttribute("list");
                for(ScheduleDetail list : lists){
            %>
            <tr>
                <td>&nbsp;

                </td>
                <td>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="mian_b_lb">
                        <tr>
                            <td width="70" valign="top">
                                影厅名称：
                            </td>
                            <td width="aotu" valign="top">
                                <%=list.getStudio_name()%>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                影片名称：
                            </td>
                            <td valign="top">
                                <%=list.getPlay_name()%>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                演出时间
                            </td>
                            <td valign="top">
                                <%=list.getSched_time().substring(0,19)%>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                电影票价：
                            </td>
                            <td valign="top">
                                <%=list.getSched_ticket_price()%>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <div class="mian_b_icon_03">
                        <a href="/views/manager/schedule/UpdateSchedule.jsp?id=<%=list.getSched_id()%>">编辑</a>
                    </div>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>


