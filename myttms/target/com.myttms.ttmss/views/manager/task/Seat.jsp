<%@ page import="java.util.List" %>
<%@ page import="com.ttms.entity.Studio" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 16-12-6
  Time: 下午9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>座位管理</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript">
        addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
        function hideURLbar(){ window.scrollTo(0,1); }
    </script>

    <style type="text/css">


        .myspan{
            text-align: center;
            display: inline-block;
        }
        .seats{
            width: 100%;
            margin-top: 80px;
            overflow: hidden;
        }
        #kexuan{
            height: 20px;
            width: 20px;
            border:1px solid #AAA;
            border-radius: 20px;
            float: left;
            background-color: #fff;
        }
        #huai{
            height: 20px;
            width: 20px;
            border:1px solid #AAA;
            border-radius: 20px;
            float: left;
            background-color: red;
        }
        #use{
            height: 20px;
            width: 20px;
            border:1px solid #AAA;
            border-radius: 20px;
            float: left;
            background-color: green;

        }
        .pingmu{
            position: relative;
            width: 750px;
            height: 50px;
            background-color: #AAAAAA;
            border-radius: 0 0 50px 50px;
            text-align: center;
            overflow: hidden;
            margin-left:120px;
        }
        .pingmu label{
            font-size: 20px;
            color: #fff;
        }
        #seat{
            width: 630px;
            margin-left: 160px;
        }
        .seets{
            height: 20px;
            width: 20px;
            border:1px solid #AAA;
            border-radius: 20px;
            margin-top: 20px;
            margin-left: 20px;
            float:left;
            display: inline-block;
        }
        .seets:hover{
            border:1px solid black;
        }
        .yuan{
            float: left;
            margin-left: 180px;
            margin-right: -40px;
            margin-bottom: 50px;
        }
        .body_seat{
            margin-top: 50px;
            margin-left: 150px;
        }
        .seatt{
            width: 90px;
            height: 20px;
            text-align: center;
            float: left;
            background-color: #FF4747;
            margin-left: 20px;
            margin-top: 10px;
        }

        #choice{
            width: 250px;
            height: 100px;
        }
        #sbutton{
            background: #f3f3f3;
            width: 90px;
            height: 35px;
            border-radius: 5px;
            margin-left: 10px;
            margin-top: 10px;

        }

        .seat_numbers{
            width: 250px;
            height: 300px;
            overflow: hidden;
            background-color: #f2f2f2;
            border-bottom: 2px solid #fff;
        }
        .seat_numbers label{
            font-size: 20px;
            font-family: "微软雅黑";
            color: #AAA;
        }

    </style>

</head>
<body class="mian_bj">
<div class="mian_top_01">
    <div class="mian_top_r"></div>
    <div class="mian_top_l"></div>
    <div class="mian_top_c">
        <ul>
            <li><a href="/seat/seatshow">
                <p>
                    座位一览</p>
            </a></li>
            <li><a href="/views/manager/task/AddSeat.jsp">
                <p>
                    增加座位</p>
            </a></li>
            <li><a href="/views/manager/task/ChangeSeat.jsp">
                <p>
                    修改座位</p>
            </a></li>
            <li><a href="/views/manager/task/DeleteSeat.jsp">
                <p>
                    删除座位</p>
            </a></li>
        </ul>
    </div>
    <%
        List<Studio> lists = (List<Studio>)request.getAttribute("list");
    %>
    <form action="/seat/seatsshow" method="post">
    <div class="mian_b">
        <div class="mian_b1">
            &nbsp;
            &nbsp;
            <select name="studioid">
                <option value=""></option>
                <%
                    for(Studio list : lists){
                %>
                <option value="<%=list.getStudio_id()%>"><%=list.getStudio_name()%></option>
                <% } %>
            </select>
            &nbsp;
            &nbsp;
            &nbsp;
            &nbsp;
            <input type="submit" value="确认"　id="sbutton"/>



            <div class="container">
                <div class="container_wrap">
                    <div class="header_top">
                        <div class="seats">
                            <div class="pingmu"><label>影厅荧幕</label></div>
                            <div id="seat"></div>
                        </div>
                        <div class="body_seat">
                            <div class="yuan">
                                <div id="kexuan"></div><label>空置的座位</label>
                            </div>
                            <div class="yuan">
                                <div id="use"></div><label>使用的座位</label>
                            </div>
                            <div class="yuan">
                                <div id="huai"></div><label>损坏的座位</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    </form>
</div>


<script type="text/javascript" src="/js/jquery-2.2.2.min.js"></script>
<script type="text/javascript">
    var set = $("#seat");

    var k = 0;
    for(var i=0;i < 12;i++)
    {
        var seets = $("<div></div>");


        for(var j = 0; j< 15;j++)
        {
            (function(i,j){

                var a = $("<span></span>");
                a.addClass("myspan");
                var seet = $("<span></span>");
                seet.addClass("seets");
                a.append(seet);
                seets.append(a);
                set.append(seets);

            })(i,j);

        }

    }
</script>
</body>
</html>

