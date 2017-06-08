<%--
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
        body{
            overflow: hidden;
        }
        .footer_right{
            overflow: hidden;
            position: relative;
            margin-top: 70px;
            left: 230px;
        }
        .footer_right input{
            border: none;
            background-color: #ededee;
            width: 255px;
            height: 40px;
            /*margin: 6px 8px;*/
            margin-top:20px;
            margin-left: 130px;
            margin-bottom: 8px;
            border-radius: 5px;
            padding-left: 55px;
        }


        .footer_right span{
            position: relative;
            left: 184px;
        }
        .submits{
            width: 20px;
            margin-left: 150px;
            padding-right: 60px;
            padding-left: 37px;
        }

        @media screen and (max-width : 1280px){
            .footer_right{
                overflow: hidden;
                position: relative;
                margin-top: 70px;
                left: 150px;
            }
        }
    </style>
    <script language="javascript">

        function register(){
            window.location.href="userregister.jsp";
        }

    </script>

</head>
<body>
<div class="container">
    <div class="container_wrap">
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="show.jsp"><img src="/images/1.png" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul class="ulul">
                    <a href="/play/showAllPlay"><li>首页</li></a>
                    <a href="#tt"><li>影片</li></a>
                    <!-- <a href="single.html"><li>信息</li></a> -->
                    <a href="#"><li>订单</li></a>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li><img src="/images/1.png" alt=""/></li>
                </ul>
            </div>
            <div class="footer_right">
                <form method="post" action="/user/logins" name="joinForm">
                    <br/>
                    <label><span>账号:</span><input type="text" name="username" placeholder="请输入您的账号"/></label><br/>
                    <label><span>密码:</span><input type="password" name="password" placeholder="请输入您的密码"/></label><br/>
                    <br/><br/><br/>
                    <input class="submits" type="submit" value="登录"/>
                    <input class="submits" type="button" value="注册" onclick="register()" style="margin-left: 70px;" />
                </form>
                <span style="color: red">${requestScope.errors}</span>
                <%--<input class="submits" type="submit" value="登录"/>--%>
                <!-- <a href="" id="submit" style="color: black;">注册</a> -->
                <%--<input class="submits" type="button" value="注册" onclick="register()" style="margin-left: 70px;" />--%>
                <br/>
                <br/>

            </div>
        </div>
    </div>
</div>
</body>
</html>
