<%@ page import="java.util.List" %>
<%@ page import="com.ttms.entity.Studio" %>
<%@ page import="com.ttms.entity.Page" %><%--
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
    <style type="text/css">

        #pagenum{

            margin-left: 380px;
            margin-top:1500px;
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
    <div class="mian_top_r">
    </div>
    <div class="mian_top_l">
    </div>
    <div class="mian_top_c">
        <ul>
            <li><a href="/studio/showstudio">
                <p>
                    影厅一览</p>
            </a></li>
            <li><a href="/studio/addstudioshow">
                <p>
                    修改影厅</p>
            </a></li>
            <li><a href="/studio/delstudioshow">
                <p>
                    删除影厅</p>
            </a></li>
        </ul>
    </div>
    <div class="mian_b">
        <div class="mian_b1">

            <a href="/views/manager/knowledge/AddStudio.jsp" title="添加">
                <p class="mian_b1_a1">
                </p>
            </a>
            <%--<p class="mian_b1_sousuo">--%>
                <%--<input name="" type="text"></p>--%>
            <%--<a href="#" title="搜索">--%>
                <%--<p class="mian_b1_a3">--%>
                <%--</p>--%>
            <%--</a>--%>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg">
            <tr>
                <td width="3%" class="mian_b_bg_lm">&nbsp;

                </td>
                <td width="87%" class="mian_b_bg_lm">
                    影厅列表
                </td>
                <td width="10%" class="mian_b_bg_lm">
                    操作
                </td>
            </tr>
            <%
                List<Studio> lists= (List<Studio>)request.getAttribute("list");
                for(Studio list : lists){
            %>
            <tr>
                <td>&nbsp;

                </td>
                <td>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="mian_b_lb">
                        <tr>
                            <td rowspan="8" width="98">
                                <img src="/images/影厅.jpg" width="98" height="120" style="margin-right: 25px;">
                            </td>
                            <td width="70" valign="top">
                                影厅名称：
                            </td>
                            <td width="aotu" valign="top">
                                <%=list.getStudio_name()%>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                影厅大小：
                            </td>
                            <td valign="top">
                                <%=list.getStudio_row_count()%>排,<%=list.getStudio_col_count()%>列
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                影厅状态
                            </td>
                            <td valign="top">
                                <%
                                    if(list.getStudio_flag() == 0){
                                %>
                                空闲
                                <%}%>
                                <%
                                    if(list.getStudio_flag() == 1){
                                %>
                                使用
                                <%}%>
                                <%
                                    if(list.getStudio_flag() == -1){
                                %>
                                损坏
                                <%}%>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                影厅介绍：
                            </td>
                            <td valign="top">
                                <%=list.getStudio_introduction()%>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>
                    <div class="mian_b_icon_03">
                        <a href="/studio/editstudio?id=<%=list.getStudio_id()%>">编辑</a>
                    </div>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
<div>

    <%
        Page pages = (Page)request.getAttribute("pages");
        int pagenow = pages.getPageNow();
    %>

    <div id="pagenum" class="pagenum">


        <strong style="color:black;padding-right: 8px;">第<%=pagenow%>页</strong>

        <a href="/studio/addstudioshow?pageNow=1">首页</a>

        <% if(pagenow - 1 > 0){ %>

        <a href="/studio/addstudioshow?pageNow=<%=pagenow - 1%>">上一页</a>
        <% } %>

        <% if(pagenow - 1 <= 0){ %>
        <a href="/studio/addstudioshow?pageNow=1">上一页</a>
        <% } %>

        <%
            int pagecount = pages.getTotalPageCount();
            for(int i = 1; i <= pagecount; i++ ){

        %>
        <a href="/studio/addstudioshow?pageNow=<%=i%>"><%=i%></a>

        <%}%>
        <%
            if(pagecount == 0){
        %>
        <a href="/studio/addstudioshow?pageNow=<%=pagenow%>">下一页</a>
        <%
            }
            if(pagenow + 1 < pagecount){
        %>
        <a href="/studio/addstudioshow?pageNow=<%=pagenow + 1%>">下一页</a>
        <%
            }
            if(pagenow + 1 >= pagecount){
        %>
        <a href="/studio/addstudioshow?pageNow=<%=pagecount%>">下一页</a>
        <% } %>
        <a href="/studio/addstudioshow?pageNow=<%=pagecount%>">尾页</a>



    </div>
</div>
</body>
</html>


