<%@ page import="com.ttms.entity.Employee" %><%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 16-12-5
  Time: 下午6:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>无标题页</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css">
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
    <div class="mian_b">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="mian_b_bg_xz">
            <tr>
                <td width="5%" class="mian_b_bg_lm">&nbsp;

                </td>
                <td colspan="4" class="mian_b_bg_lm">
                    查看员工信息
                </td>
            </tr>
        </table>
        <%
            Employee employee = (Employee)request.getAttribute("employee");
        %>
        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#B1C4F3">
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    基本信息
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td style="width: 8%;" align="center">
                    姓名
                </td>
                <td style="width: 8%" align="center">
                    性别
                </td>
                <td style="width: 8%" align="center">
                    出生年月
                </td>
                <td style="width: 8%" align="center">
                    用戶名
                </td>
                <td style="width: 8%" align="center">
                    密碼
                </td>
                <td style="width: 8%" align="center">
                    工作年限
                </td>
                <td style="width: 8%" align="center">
                    政治面貌
                </td>
                <td style="width: 8%" rowspan="5" align="center" valign="middle">
                    <img src="/images/head_pic.png">
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td style="text-align:center">
                    <%=employee.getEmp_name()%>
                </td>
                <td style="text-align:center">
                    <%=employee.getEmp_sex()%>
                </td>
                <td>
                    <%=employee.getEmp_birth()%>
                </td>
                <td>
                    <%=employee.getEmp_no()%>
                </td>
                <td>
                    <%=employee.getEmp_pass()%>
                </td>
                <td>
                    <input id="Text5" type="text" style="border: 0px; width: 100px">
                </td>
                <td>
                    <input id="Text6" type="text" style="border: 0px; width: 100px">
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td>
                    籍贯
                </td>
                <td colspan="2">
                    手机
                </td>
                <td colspan="3">
                    邮箱
                </td>
                <td>
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td>
                    <%=employee.getEmp_native()%>
                </td>
                <td colspan="2">
                    <%=employee.getEmp_tel_num()%>
                </td>
                <td colspan="3">
                    <%=employee.getEmp_email()%>
                </td>
                <td>
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td>
                    家庭住址：
                </td>
                <td colspan="4">
                    <%=employee.getEmp_addr()%>
                </td>
                <td>
                    邮编：
                </td>
                <td>
                    <input id="Text8" type="text" style="border: 0px; width: 100px">
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td>
                    户口所在地：
                </td>
                <td colspan="4">
                    <input id="Text9" type="text" style="border: 0px; width: 300px">
                </td>
                <td>
                    邮编：
                </td>
                <td>
                    <input id="Text10" type="text" style="border: 0px; width: 100px">
                </td>
                <td align="center">&nbsp;
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    教育经历</td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#B1C4F3" style="text-align: center;">
                        <tr>
                            <td rowspan="2">
                                序号
                            </td>
                            <td colspan="2">
                                时间
                            </td>
                            <td rowspan="2">
                                学校
                            </td>
                            <td rowspan="2">
                                专业
                            </td>
                            <td rowspan="2">
                                学历、学位
                            </td>
                            <td rowspan="2">
                                备注
                            </td>
                        </tr>
                        <tr>
                            <td>
                                开始时间
                            </td>
                            <td>
                                结束时间
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    培训经历
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#B1C4F3" style="text-align: center;">
                        <tr>
                            <td rowspan="2">
                                序号
                            </td>
                            <td colspan="2">
                                时间
                            </td>
                            <td rowspan="2">
                                培训机构
                            </td>
                            <td rowspan="2">
                                培训项目
                            </td>
                            <td rowspan="2">
                                备注
                            </td>
                        </tr>
                        <tr>
                            <td>
                                开始时间
                            </td>
                            <td>
                                结束时间
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                            <td>&nbsp;
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    其它经历
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#B1C4F3" style="text-align: center;">
                        <tr>
                            <td rowspan="2">
                                序号
                            </td>
                            <td colspan="2">
                                时间
                            </td>
                            <td rowspan="2">
                                事项
                            </td>
                            <td rowspan="2">
                                描述
                            </td>
                            <td rowspan="2">
                                证明材料
                            </td>
                            <td rowspan="2">
                                备注
                            </td>
                        </tr>
                        <tr>
                            <td>
                                开始时间
                            </td>
                            <td>
                                结束时间
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>&nbsp;

                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>&nbsp;

                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>&nbsp;

                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    职位信息
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td align="center">
                    部门
                </td>
                <td align="center">
                    职位
                </td>
                <td align="center">
                    入职时间
                </td>
                <td align="center">
                    工作年限
                </td>
                <td align="center">
                    座机号码
                </td>
                <td align="center" colspan="2">
                    公司邮箱
                </td>
                <td align="center" valign="middle">
                    备注
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td align="center">
                    软装部
                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center" colspan="2">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    薪资结构
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td align="center" rowspan="2">
                    基本工资
                </td>
                <td align="center" rowspan="2">
                    &nbsp; &nbsp; 岗位工资
                </td>
                <td align="center" rowspan="2">
                    绩效奖金
                </td>
                <td align="center" rowspan="2">
                    四金
                </td>
                <td align="center" colspan="3">
                    福利补贴
                </td>
                <td align="center" rowspan="2">
                    合计
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td align="center">
                    通讯费
                </td>
                <td align="center">
                    车费
                </td>
                <td align="center">
                    午餐费
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
                <td align="center">&nbsp;

                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    工作记录
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td colspan="8">
                    <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#B1C4F3" style="text-align: center;">
                        <tr>
                            <td rowspan="2">
                                序号
                            </td>
                            <td colspan="2">
                                时间
                            </td>
                            <td rowspan="2">
                                职位
                            </td>
                            <td rowspan="2">
                                描述
                            </td>
                            <td rowspan="2">
                                备注
                            </td>
                        </tr>
                        <tr>
                            <td>
                                开始时间
                            </td>
                            <td>
                                结束时间
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>&nbsp;

                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>&nbsp;

                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                            <td>&nbsp;

                            </td>
                            <td>
                            </td>
                            <td>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td style="text-align: left" colspan="7">
                    人事部确认
                </td>
                <td align="center">
                    张三
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td style="text-align: left" colspan="7">
                    人事部负责人确认
                </td>
                <td align="center">
                    李四
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td style="text-align: left" colspan="7">
                    填表日期
                </td>
                <td align="center">
                    2012-03-21
                </td>
            </tr>
            <tr style="background-color: White; height: 30px">
                <td align="center" colspan="8">
                    <img src="/images/bnt_05.gif" alt="" width="80" height="22" style="margin-bottom: 10px;" onclick="javascript:window.history.go(-1);">
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>


