<%@ page import="com.ttms.entity.Studio" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.NavigableMap" %>
<%@ page import="com.ttms.entity.Notice" %>
<%@ page import="com.ttms.entity.Page" %>
<%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 16-12-5
  Time: 下午10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>公告管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/index.css">
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
    <div class="mian_top_r">
    </div>
    <div class="mian_top_l">
    </div>
    <div class="mian_top_c">
        <ul>
            <li><a href="/notice/shownotice">
                <p>
                    公告一览</p>
            </a></li>
            <li><a href="/notice/changeshow">
                <p>
                    公告管理</p>
            </a></li>
        </ul>
    </div>
    <form action="/notice/delnotice" method="post">
        <div class="mian_b">
            <div class="mian_b1">
                <a href="/views/manager/notice/AddNotice.jsp" title="添加">
                    <p class="mian_b1_a1">
                    </p>
                </a>
                <input type="submit" name="submit" class="mian_b1_a2" value=""/>
                <%--<p class="mian_b1_sousuo">--%>
                    <%--<input name="" type="text"></p>--%>
                <%--<a href="#" title="搜索">--%>
                    <%--<p class="mian_b1_a3">--%>
                    <%--</p>--%>
                <%--</a>--%>
            </div>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg">
                <tr>
                    <td width="3%" class="mian_b_bg_lm">
                    </td>
                    <td width="70%" class="mian_b_bg_lm">
                        公告主题
                    </td>
                    <td width="16%" class="mian_b_bg_lm">
                        公告时间
                    </td>
                    <td width="11%" class="mian_b_bg_lm">
                        操作
                    </td>
                </tr>
                <%
                    List<Notice> lists = (List<Notice>)request.getAttribute("list");
                    for(Notice list : lists){
                %>
                <tr>
                    <td>
                        <input  name="type" type="checkbox" value="<%=list.getNotice_id()%>"/>
                    </td>
                    <td>
                        <span style="color: #307d74;"><%=list.getNotice_title()%></span>:
                        <%
                            if(list.getNotice_content().length() >= 20){
                        %>
                            <%=list.getNotice_content().substring(0,20)%>

                        <%
                            }else{
                        %>
                            <%=list.getNotice_content()%>

                        <%
                            }
                        %>
                    </td>
                    <td>
                        <%=list.getNotice_time().substring(0,19)%>
                    </td>
                    <td>
                        <div class="mian_b_icon_03">
                            <a href="/notice/noticedetail?id=<%=list.getNotice_id()%>">查看</a></div>
                        <div class="mian_b_icon_03">
                            <a href="/notice/editnotice?id=<%=list.getNotice_id()%>">编辑</a></div>

                    </td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td width="3%" class="mian_b_bg_lm">
                    </td>
                    <td width="70%" class="mian_b_bg_lm">
                        公告主题
                    </td>
                    <td width="16%" class="mian_b_bg_lm">
                        公告时间
                    </td>
                    <td width="11%" class="mian_b_bg_lm">
                        操作
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

        <a href="/notice/changeshow">首页</a>

        <% if(pagenow - 1 > 0){ %>

        <a href="/notice/changeshow?pageNow=<%=pagenow - 1%>">上一页</a>
        <% } %>

        <% if(pagenow - 1 <= 0){ %>
        <a href="/notice/changeshow?pageNow=1">上一页</a>
        <% } %>

        <%
            int pagecount = pages.getTotalPageCount();
            for(int i = 1; i <= pagecount; i++ ){

        %>
        <a href="/notice/changeshow?pageNow=<%=i%>"><%=i%></a>

        <%}%>
        <%
            if(pagecount == 0){
        %>
        <a href="/notice/changeshow?pageNow=<%=pagenow%>">下一页</a>
        <%
            }
            if(pagenow + 1 < pagecount){
        %>
        <a href="/notice/changeshow?pageNow=<%=pagenow + 1%>">下一页</a>
        <%
            }
            if(pagenow + 1 >= pagecount){
        %>
        <a href="/notice/changeshow?pageNow=<%=pagecount%>">下一页</a>
        <% } %>
        <a href="/notice/changeshow?pageNow=<%=pagecount%>">尾页</a>



    </div>
</div>
</body>
</html>
