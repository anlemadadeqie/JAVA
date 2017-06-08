<%@ page import="com.ttms.entity.Play" %>
<%@ page import="com.ttms.entity.Schedule" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ttms.entity.ScheduleDetail" %><%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 2017/5/31
  Time: 上午11:54
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
    <link href="/css/style1.css" rel="stylesheet" type="text/css" media="all" />
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
            ul,li{
                list-style-type: none;
            }
            .film li{
                width: 920px;
                padding:15px 0px;
                border-radius: 5px;
                border:1px solid #AAAAAA;
                text-align: center;
            }
            .film label{
                margin-left: 45px;
                margin-right: 80px;
            }
            .film a{
                color: #fff;
                padding: 5px 5px;
                background-color: #FC5242;
            }
            #tit label{
                margin-left: 80px;
                margin-right: 50px;
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
            ul,li{
                list-style-type: none;
            }
            .film{
                position: relative;
                left: 50px;
            }
            .film li{
                width: 750px;
                padding:15px 0px;
                border-radius: 5px;
                border:1px solid #AAAAAA;
            }
            .film label{
                margin-left: 50px;
                margin-right: 62px;
            }
            .film a{
                color: #fff;
                padding: 10px 10px;
                margin-left: 15px;
                background-color: #FC5242;
            }
            #tit label{
                margin-left: 50px;
                margin-right: 60px;
            }
            .down_btn{
                position: relative;
                top: -20px;
            }
        }
    </style>
</head>
<%
    List<ScheduleDetail> lists = (List<ScheduleDetail>) request.getAttribute("scheduledetail");
    Play play = (Play) request.getAttribute("play");
    String[] type = play.getPlay_type().split(",");
    String[] actor = play.getPlay_actor().split(",");
%>
<body>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="../show.jsp"><img src="/images/1.png" alt=""/></a></div>
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
                <div class="col-md-9 movie_box">
                    <div class="grid images_3_of_2">
                        <div class="movie_image">
                            <img src="<%=play.getPlay_image()%>" class="img-responsive" alt="" width="100%"/>
                        </div>
                    </div>
                    <div class="desc1 span_3_of_2">

                        <p class="movie_option"><strong>电影名称: </strong><span><%=play.getPlay_name()%></span></p>
                        <p class="movie_option"><strong>国家: </strong><span><%=play.getPlay_orign()%></span></p>
                        <p class="movie_option"><strong>类别: </strong>
                            <%
                                for(int i=0; i<type.length; i++){
                                    if(i == type.length-1){
                            %>
                                        <span><%=type[i]%></span>
                            <%
                                    }
                                    else{

                            %>
                                        <span><%=type[i]%></span>|
                            <%
                                    }
                                }
                            %>
                        </p>
                        <p class="movie_option"><strong>上映日期: </strong><%=play.getPlay_up_time()%></p>
                        <p class="movie_option"><strong>导演: </strong><span><%=play.getPlay_director()%></span></p>
                        <p class="movie_option"><strong>演员: </strong>
                            <%
                                for(int i=0; i<actor.length; i++){
                                    if(i == actor.length-1){
                            %>
                                         <span><%=actor[i]%></span>
                            <%
                                    }
                                    else{

                            %>
                                        <span><%=actor[i]%></span>|
                            <%
                                    }
                                }
                            %>
                        </p>
                        <p class="movie_option"><strong>时长: </strong><%=play.getPlay_length()%></p>
                    </div>
                    <div class="clearfix"> </div>
                    <p class="m_4"><strong style="color: black;">影片简介:&nbsp;&nbsp;</strong><%=play.getPlay_introduction()%></p>

                </div>
                <div class="choice">
                        <div class="film">
                            <table class="table table-hover table-striped" style="width: 920px;margin-left: 80px;margin-top: 40px;">
                                <tr>
                                    <th><lable>时间</lable></th>
                                    <th><lable>语言</lable></th>
                                    <th><lable>放映厅</lable></th>
                                    <th><lable>价格</lable></th>
                                    <th><lable>选座预览</lable></th>
                                </tr>
                                <%
                                    for(ScheduleDetail list:lists){

                                        String[] studio = list.getStudio_name().split("\\|");

                                %>
                                <tr>
                                    <td><lable><%=list.getSched_time().substring(0,16)%></lable></td>
                                    <td><lable><%=play.getPlay_lang()%></lable></td>
                                    <td><lable><%=studio[0]%></lable></td>
                                    <td><lable><%=list.getSched_ticket_price()%></lable></td>
                                    <td><lable><a href="/seat/seatss?stu=<%=studio[1]%>&&sche=<%=list.getSched_id()%>" target="_blank">选座订票</a></lable></td>
                                </tr>
                                <%
                                    }
                                %>

                            </table>
                        </div>
                </div>
            </div>

            <div class="clearfix"> </div>
        </div>
    </div>
</div>
</div>
</body>
</html>

