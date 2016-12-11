<%@ page import="com.ttms.entity.Notice" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 16-12-10
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告一览</title>
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
    <div class="mian_b">
        <div class="mian_b1">

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
</div>
</body>
</html>

