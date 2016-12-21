<%@ page import="com.ttms.entity.Notice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告详情</title>
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
    </div>
    <div class="mian_b">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg_xz">
            <tr>
                <td width="5%" class="mian_b_bg_lm">&nbsp;

                </td>
                <td colspan="3" class="mian_b_bg_lm">
                    公告详情
                </td>
            </tr>
            <tr>
                <%
                    Notice notice = (Notice)request.getAttribute("notice");
                %>
                <td colspan="4" align="left">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                        <tr>

                            <td width="73" align="right" valign="top">
                                发 布 人：
                            </td>
                            <td valign="top">
                                管理员
                            </td>
                        </tr>
                        <tr>
                            <td width="73" align="right" valign="top">
                                发布时间：
                            </td>
                            <td valign="top">
                                <%=notice.getNotice_time().substring(0,19)%>
                            </td>
                        </tr>
                        <tr>
                            <td width="73" align="right" valign="top">
                                主 题：
                            </td>
                            <td valign="top">
                                <%=notice.getNotice_title()%>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td width="73" align="right" valign="top">
                    内容：

                </td>
                <td colspan="4">
                <%=notice.getNotice_content()%>
                </td>
                <td>
                </td>
            </tr>
            <tr>
                <td>&nbsp;

                </td>
                <td>&nbsp;

                </td>
                <td>
                    <div align="center">
                        <img src="/images/bnt_05.gif" alt="" width="80" height="22"  style="margin-bottom: 10px;" onclick="javascript:window.history.go(-1);">
                    </div>
                </td>
                <td>&nbsp;

                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
