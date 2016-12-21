
<%@ page import="java.util.List" %>
<%@ page import="com.ttms.entity.Studio" %>
<%@ page import="com.ttms.entity.Seat" %>
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
        #use{
            height: 20px;
            width: 20px;
            border:1px solid #AAA;
            border-radius: 20px;
            float: left;
            background-color: green;

        }
        #huai{
            height: 20px;
            width: 20px;
            border:1px solid #AAA;
            border-radius: 20px;
            float: left;
            background-color: red;
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
            text-align:center;
        }

        .seet0{
            height: 20px;
            width: 20px;
            border:1px solid #AAA;
            border-radius: 20px;
            margin-top: 20px;
            margin-left: 20px;
            float:left;
            display: inline-block;
        }
        .seet0:hover{
            border:1px solid black;
        }
        .seet1{
            height: 20px;
            width: 20px;
            border:1px solid #AAA;
            border-radius: 20px;
            margin-top: 20px;
            margin-left: 20px;
            float:left;
            display: inline-block;
            background-color: green;
        }
        .seet1:hover{
            border:1px solid black;
        }

        .seet2{
            height: 20px;
            width: 20px;
            border:1px solid #AAA;
            border-radius: 20px;
            margin-top: 20px;
            margin-left: 20px;
            float:left;
            display: inline-block;
            background-color: red;
        }
        .seet2:hover{
            border:1px solid black;
        }

        .seet3{

            height: 20px;
            width: 20px;
            margin-top: 20px;
            margin-left: 20px;
            float:left;
            display: inline-block;
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

        .mysit{
            font-size: 17px;
            color: #c3c3c3;
            margin-right: 50px;
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
            <li><a href="/seat/tochangeseat">
                <p>
                    修改座位</p>
            </a></li>
            <li><a href="/seat/todelseat">
                <p>
                    删除座位</p>
            </a></li>
        </ul>
    </div>
    <%
        List<Studio> lists = (List<Studio>)request.getAttribute("list");
        Studio studio = (Studio)request.getAttribute("studio");
        int [][] seat_statu =  (int[][])request.getAttribute("seat_statu");
    %>
    <form action="/seat/seatsshow" method="post">
        <div class="mian_b">
            <div class="mian_b1">
                &nbsp;
                &nbsp;
                <select name="studioid">
                    <option value="<%=studio.getStudio_id()%>"><%=studio.getStudio_name()%></option>
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
                                <div id="seat">
                                    <div>
                                        <span class="myspan"><span class="seet3"></span></span>
                                        <%

                                            int row = studio.getStudio_row_count();
                                            int col = studio.getStudio_col_count();
                                            for(int k=1; k< col+1; k++){

                                        %>
                                         <span class="myspan"><span class="seet3" style="font-size: 17px;color: #c3c3c3;"><%=k%></span></span>
                                        <%
                                            }
                                        %>
                                        <br/>
                                        <%
                                            for(int i = 1; i < row+1; i++){
                                        %>
                                        <span class="myspan"><span class="seet3" style="font-size: 17px;color: #c3c3c3;"><%=i%></span></span>
                                        <%        for(int j = 1; j < col+1; j++ ){
                                             if(seat_statu[i][j] == 0){

                                        %>
                                        <span class="myspan"><span class="seet0"></span></span>

                                        <%
                                        }
                                        else if(seat_statu[i][j] == 1){

                                        %>
                                        <span class="myspan"><span class="seet1"></span></span>
                                        <%
                                        }
                                        else if(seat_statu[i][j] == -1){


                                        %>
                                        <span class="myspan"><span class="seet2"></span></span>
                                        <%

                                        }
                                        else{
                                        %>
                                        <span class="myspan"><span class="seet3"></span></span>

                                        <%
                                                }

                                            }
                                        %>


                                    </div>
                                    <div>
                                        <%
                                            }

                                        %>
                                    </div>

                                </div>
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
</body>
</html>

