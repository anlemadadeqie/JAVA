<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加公告</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body class="mian_bj">
<div class="mian_top_01">
    <div class="mian_top_r"></div>
    <div class="mian_top_l"></div>
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
        <form action="/notice/addnotice" method="post">
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg_xz">
                <tr>
                    <td width="5%" class="mian_b_bg_lm">&nbsp;</td>
                    <td colspan="3" class="mian_b_bg_lm">添加公告</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td width="10%" valign="top">公告名字：</td>
                    <td width="55%">
                        <input type="text" class="input_01" name="noticename" id="textfield"> </td>
                    <td width="35%">&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td valign="top">公告内容：</td>
                    <td>
                        <textarea style="width:400px;height:130px;" name="noticeintro"></textarea>
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
                            <input type="image" src="/images/bnt_03.gif" style="margin-right:10px;" width="80" height="22">
                            <img src="/images/bnt_05.gif" alt="" width="80" height="22"  style="margin-bottom: 10px;" onclick="javascript:window.history.go(-1);">
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
