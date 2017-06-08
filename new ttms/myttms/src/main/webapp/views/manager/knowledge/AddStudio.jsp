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
        <form action="/studio/addstudio" method="post">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg_xz">
            <tr>
                <td width="5%" class="mian_b_bg_lm">&nbsp;</td>
                <td colspan="3" class="mian_b_bg_lm">添加影厅</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td width="10%" valign="top">影厅名称：</td>
                <td width="55%">
                    <input type="text" class="input_01" name="studioname" id="textfield"> </td>
                <td width="35%">&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td valign="top">影厅大小：</td>
                <td>
                    <input type="text" class="input_01" name="studiorow" id="text1">-<input type="text" class="input_01" name="studiocol" id="text2"></td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td valign="top">影厅状态：</td>
                <td>
                    <select style="width:200px; height:20px;" name="studiostatu">
                        <option value="0">空闲</option>
                        <option value="1">使用</option>
                        <option value="-1">损坏</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td valign="top">影厅介绍：</td>
                <td>
                    <textarea style="width:400px;height:130px;" name="studiointro"></textarea>
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
                            <img src="/images/bnt_05.gif" alt="" width="80" height="22" style="margin-bottom: 10px;" onclick="javascript:window.history.go(-1);">
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
