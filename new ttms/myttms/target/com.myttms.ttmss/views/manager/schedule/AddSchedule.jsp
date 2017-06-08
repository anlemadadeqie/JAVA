<%@ page import="java.util.List" %>
<%@ page import="com.ttms.entity.Studio" %>
<%@ page import="com.ttms.entity.Play" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加影厅</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body class="mian_bj">
<div class="mian_top_01">
    <div class="mian_top_r"></div>
    <div class="mian_top_l"></div>
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
    <%
        List<Studio> studios = (List<Studio>)request.getAttribute("studio");
        List<Play> plays = (List<Play>)request.getAttribute("play");

    %>
    <div class="mian_b">
        <form action="/schedule/addsched" method="post">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg_xz">
                <tr>
                    <td width="5%" class="mian_b_bg_lm">&nbsp;</td>
                    <td colspan="3" class="mian_b_bg_lm">添加演出计划</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td width="10%" valign="top">影厅名称：</td>
                    <td width="55%">
                    <select name="studioid">
                        <%
                            for(Studio studio:studios){

                        %>
                        <option value="<%=studio.getStudio_id()%>"><%=studio.getStudio_name()%></option>
                        <%
                            }
                        %>
                    </select>
                    </td>
                    <td width="35%">&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td valign="top">影片名称：</td>
                    <td>
                        <%--<input type="text" class="input_01" name="playname">--%>
                        <select name="playid">
                            <%
                                for(Play play:plays){
                            %>
                            <option value="<%=play.getPlay_id()%>"><%=play.getPlay_name()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td valign="top">演出时间：</td>
                    <td>
                        <input type="text" class="input_01" name="schedtime" placeholder="yyyy-mm-dd hh:mm"></td>
                     <td>&nbsp;</td>

                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td valign="top">电影票价：</td>
                    <td>
                        <input type="text" class="input_01" name="schedprice"></td>
                    <td>&nbsp;</td>
                    </td>

                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>
                        <div align="center">
                            <%--<img src="/images/bnt_03.gif" style="margin-right:10px;" width="80" height="22">--%>
                            <input type="image" src="/images/bnt_03.gif" style="margin-right:10px;" width="80" height="22">
                                <img src="/images/bnt_05.gif" alt="" width="80" height="22" style="margin-bottom: 10px;"　onclick="javascript:window.history.go(-1);">
                        </div>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <span style="color: red">${requestScope.errors}</span>
                </tr>
            </table>
        </form>
    </div>

</div>
</body>
</html>
<script src="/js/common.js"></script>
