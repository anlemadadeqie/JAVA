<%@ page import="com.ttms.entity.Ticket" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ttms.entity.Seat" %>
<%@ page import="com.ttms.entity.Schedule" %>
<%@ page import="com.ttms.entity.User_sale" %><%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 2017/6/2
  Time: 上午11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Movie_store A Entertainment Category Flat Bootstarp Resposive Website Template | Single :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href="/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- start plugins -->
    <script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
    <style type="text/css">
        @media screen and (min-width : 1280px){
            .video img{
                margin-top: 10px;
            }
            #weizhi{
                margin-top: 30px;
            }
            .col-sm-3 img{
                width: 100px;
            }
            .ulul a{
                margin-top: 15px;
                color: #333;
                padding: 10px 20px;
            }
            .ulul a:hover{
                color: red;
            }
            .rslides img{
                height: 450px;
            }
            .movie_box{
                margin-left: 150px;
            }
            .desc1{
                padding-left: 80px;
            }

            .choice{
                margin-top: 60px;
                width: 100%;
                overflow:hidden;
                margin-bottom: 60px;
            }
            .mybutton{
                color: #fff;
                padding: 10px 10px;
                margin-left: 15px;
                background-color: #FC5242;
            }

        }

        @media screen and (max-width : 1280px){
            .list_4{
                display: none;
            }
            .video img{
                margin-top: 10px;
            }
            #weizhi{
                margin-top: 30px;
            }
            .col-sm-3 img{
                width: 100px;
            }
            .ulul a{
                margin-top: 15px;
                color: #333;
                padding: 10px 20px;
            }
            .ulul a:hover{
                color: red;
            }
            .rslides img{
                height: 450px;
            }
            .movie_box{
                margin-left: 150px;
            }
            .desc1{
                padding-left: 80px;
            }

            .choice{
                margin-top: 60px;
                width: 100%;
                overflow:hidden;
                margin-bottom: 60px;
            }


            .down_btn{
                position: relative;
                top: -20px;
            }

        }
    </style>
</head>
<%
    List<User_sale> lists = (List<User_sale>)request.getAttribute("ticketdetail");

%>
<body>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="index.html"><img src="/images/1.png" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul class="ulul">
                    <a href="/play/showAllPlay"><li>首页</li></a>
                    <a href="#tt"><li>影片</li></a>
                    <!--  <a href="single.html"><li>信息</li></a> -->
                    <a href="/ticket/searchbySale"><li>订单</li></a>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li><img src="/images/1.png" alt=""/></li>
                </ul>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="content">
            <div class="movie_top">

                <table class="table table-hover table-striped">
                    <tr>
                        <th><lable>影片名称</lable></th>
                        <th><lable>场次</lable></th>
                        <th><lable>座位</lable></th>
                        <th><lable>价格</lable></th>
                        <th><lable></lable></th>
                    </tr>
                    <%
                        for(User_sale list:lists){
                    %>
                    <tr>
                        <td><lable><%=list.getPlay_name()%></lable></td>
                        <td><lable><%=list.getSced_time().substring(0,16)%></lable></td>
                        <td><lable><%=list.getStudio_name()%>号厅 <%=list.getRow()%>排<%=list.getCol()%>列</lable></td>
                        <td><lable><%=list.getPrices()%></lable></td>
                        <td><lable><a href="/ticket/backticket?sale=<%=list.getSale_id()%>">退票</a></lable></td>
                    </tr>
                    <%
                        }
                    %>

                </table>

                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
