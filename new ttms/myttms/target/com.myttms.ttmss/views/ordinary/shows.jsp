<%@ page import="java.util.List" %>
<%@ page import="com.ttms.entity.Play" %>
<%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 2017/5/31
  Time: 上午11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>电影院</title>
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
    <script src="/js/responsiveslides.min.js"></script>
    <script>
        $(function () {
            $("#slider").responsiveSlides({
                auto: true,
                nav: true,
                speed: 500,
                namespace: "callbacks",
                pager: true,
            });
        });
    </script>
    <style type="text/css">

        .movie__title{

            font-weight: bold;
        }
        .movie_actor{

            font-weight: bold;
        }
        .video img{
            margin-top: 10px;
        }
        .weizhi{
            margin-top: 45px;
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
        #picc{
            width: 20px;
        }
        #zhuce,#denglu
        {
            color: #aaa;
            margin-left: 20px;
            text-decoration: none;
        }
        #zhuce:hover,#denglu:hover{
            color: red;
        }
    </style>
</head>
<%
    List<Play> lists = (List<Play>) request.getAttribute("play");
%>
<body>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><img src="/images/1.png" alt=""/></div>
            <div class="col-sm-6 nav">
                <ul class="ulul">
                    <a href="/play/showAllPlay"><li>首页</li></a>
                    <a href="#tt"><li>影片</li></a>
                    <!--  <a href="single.html"><li>信息</li></a> -->
                    <a href="/ticket/searchbySale"><li>订单</li></a>
                </ul>
            </div>
            <%--<div class="col-sm-3 header_right">--%>
            <%--<img src="/images/14.png" id="picc">--%>
            <%--<a href="register.jsp" id="zhuce">注册</a>--%>
            <%--<a href="userlogin.jsp" id="denglu">登录</a>--%>
            <%--</div>--%>
            <div class="clearfix"> </div>
        </div>
        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li><img src="/images/jlbhd.jpg" class="img-responsive" alt=""/>
                    </li>
                    <li><img src="/images/bxjg2.jpg" class="img-responsive" alt=""/>
                    </li>
                    <li><img src="/images/sqnx2.jpg" class="img-responsive" alt=""/>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="container_wrap">
        <div class="content">
            <h2 class="m_3" id="tt">热映电影</h2>
                <div class="movie_top">
                    <div class="col-md-9 movie_box">
                        <!-- Movie variant with time -->
                        <%
                            int i=0;
                            int j=0;
                            for(Play list:lists){

                                String[] actor = list.getPlay_actor().split(",");

                                if(i % 2== 0){

                                    ++j;
                        %>
                        <div class="movie movie-test movie-test-dark movie-test-left">
                            <div class="movie__images">
                                <a href="/play/detailplay?play=<%=list.getPlay_id()%>" class="movie-beta__link">
                                    <img alt="" src="<%=list.getPlay_image()%>" class="img-responsive" width="100%"/>
                                </a>
                            </div>

                            <div class="movie__info">
                                <span class="movie__title"><%=list.getPlay_name()%> </span>
                                <p class="movie__time"><%=list.getPlay_length()%></p>
                                <p class="movie__option">
                                    <%
                                        for(int k=0; k<actor.length; k++){

                                            if(k == actor.length-1){
                                    %>
                                                <span class="movie_actor"><%=actor[k]%></span>
                                    <%
                                            }
                                            else{
                                    %>
                                                <span class="movie_actor"><%=actor[k]%></span>|

                                    <%
                                            }
                                        }
                                    %>
                                </p>
                                <ul class="list_6">
                                    <li><i class="icon1"> </i><p>2,548</p></li>
                                    <li><i class="icon2"> </i><p>546</p></li>
                                    <li>评价 : &nbsp;&nbsp;<p><img src="/images/rating1.png" alt=""></p></li>
                                    <li><p>上映日期:<%=list.getPlay_up_time()%></p></li>
                                    <li><p>下架日期:<%=list.getPlay_down_time()%></p></li>
                                    <div class="clearfix"> </div>
                                </ul>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <%
                                if(j == 2){
                                    j = 0;
                                    ++i;

                                }else{
                                    continue;
                                }
                            }
                            else{
                                    ++j;

                        %>

                        <div class="movie movie-test movie-test-light movie-test-right">
                            <div class="movie__images">
                                <a href="/play/detailplay?play=<%=list.getPlay_id()%>" class="movie-beta__link">
                                    <img alt="" src="<%=list.getPlay_image()%>" class="img-responsive" width="100%"/>
                                </a>
                            </div>
                            <div class="movie__info">
                                <span class="movie__title"><%=list.getPlay_name()%></span>
                                <p class="movie__time"><%=list.getPlay_length()%></p>
                                <p class="movie__option">
                                    <%
                                        for(int k=0; k<actor.length; k++){

                                            if(k == actor.length-1){
                                    %>
                                                <span class="movie_actor"><%=actor[k]%></span>
                                    <%
                                    }
                                    else{
                                    %>
                                                <span class="movie_actor"><%=actor[k]%></span>|

                                    <%
                                            }
                                        }
                                    %>
                                </p>
                                <ul class="list_6">
                                    <li><i class="icon1"> </i><p>2,548</p></li>
                                    <li><i class="icon2"> </i><p>546</p></li>
                                    <li>评价 : &nbsp;&nbsp;<p><img src="/images/rating1.png" alt=""></p></li>
                                    <li><p>上映日期:<%=list.getPlay_up_time()%></p></li>
                                    <li><p>下架日期:<%=list.getPlay_down_time()%></p></li>
                                    <div class="clearfix"> </div>
                                </ul>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <%
                                if(j == 2){
                                    j = 0;
                                    ++i;

                                }else{
                                    continue;
                                }
                            }
                            }

                        %>
                        <div class="clearfix"> </div>
                        <!-- Movie variant with time -->
                    </div>
                    <div class="col-md-3">
                        <div class="movie_img" class="weizhi"><div class="grid_2">
                            <img src="/images/dyy1.jpg" class="img-responsive" alt="">
                            <div class="caption1">
                            </div>
                        </div>
                        </div>

                        <div class="movie_img" class="weizhi"><div class="grid_2">
                            <img src="/images/dyy2.jpg" class="img-responsive" alt="">
                            <div class="caption1">
                            </div>
                        </div>
                        </div>

                        <div class="movie_img" class="weizhi"><div class="grid_2">
                            <img src="/images/dyy3.jpg" class="img-responsive" alt="">
                            <div class="caption1">
                            </div>
                        </div>
                        </div>

                        <div class="movie_img" class="weizhi"><div class="grid_2">
                            <img src="/images/dyy4.jpg" class="img-responsive" alt="">
                            <div class="caption1">
                            </div>
                        </div>
                        </div>

                        <div class="movie_img" class="weizhi"><div class="grid_2">
                            <img src="/images/dyy6.jpg" class="img-responsive" alt="">
                            <div class="caption1">
                            </div>
                        </div>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <h1 class="recent">即将上映</h1>
            <ul id="flexiselDemo3">
                <li><img src="/images/xmny0609.jpg"  style="height: 320px;" class="img-responsive"/><div class="grid-flex"><a href="#">新木乃伊</a><p>2017.6.9</p></div></li>
                <li><img src="/images/yx0616.jpg" style="height: 320px;" class="img-responsive"/><div class="grid-flex"><a href="#">异形</a><p>2017.6.16</p></div></li>
                <li><img src="/images/nsyj0630.jpg" style="height: 320px;" class="img-responsive"/><div class="grid-flex"><a href="#">逆时营救</a><p>2017.6.30</p></div></li>
                <li><img src="/images/stnb0707.jpg" style="height: 320px;" class="img-responsive"/><div class="grid-flex"><a href="#">神偷奶爸3</a><p>2017.7.7</p></div></li>
                <li><img src="/images/ssss0727.jpg" style="height: 320px;" class="img-responsive"/><div class="grid-flex"><a href="#">三生三世十里桃花</a><p>2017.7.27</p></div></li>
            </ul>
                    <script type="text/javascript">
                        $(window).load(function() {
                            $("#flexiselDemo3").flexisel({
                                visibleItems: 4,
                                animationSpeed: 1000,
                                autoPlay: true,
                                autoPlaySpeed: 3000,
                                pauseOnHover: true,
                                enableResponsiveBreakpoints: true,
                                responsiveBreakpoints: {
                                    portrait: {
                                        changePoint:480,
                                        visibleItems: 1
                                    },
                                    landscape: {
                                        changePoint:640,
                                        visibleItems: 2
                                    },
                                    tablet: {
                                        changePoint:768,
                                        visibleItems: 3
                                    }
                                }
                            });

                        });
                    </script>
                    <script type="text/javascript" src="/js/jquery.flexisel.js"></script>
        </div>
    </div>
</div>
</body>
</html>
