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
            margin-top: 120px;
            left: 230px;
        }
        .footer_right input{
            border: none;
            background-color: #ededee;
            width: 300px;
            height: 40px;
            margin: 6px 8px;
            border-radius: 5px;
            padding-left: 55px;
        }
        .footer_right textarea{
            background-color: #ededee;
            border: none;
            border-radius: 5px;
            margin-left: 40px;
            padding:10px;
            width: 560px;
        }
        .footer_right textarea:hover{
            box-shadow: 1px 1px 3px #E74F4D;
        }
        .footer_right span{
            position: relative;
            left: 57px;
        }
        #submit{
            width: 150px;
            margin-left: 250px;
            padding-right: 60px;
            margin-top: 40px;
        }
        .footer_right input:hover{
            box-shadow: 1px 1px 3px #E74F4D;
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
                    <a href="#"><li>订单</li></a>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li><img src="/images/1.png" alt=""/></li>
                </ul>
            </div>
            <div class="footer_right">
                <form method="post" action="/user/registers" name="joinForm">
                    <label style="margin-left: 150px;"><span>姓名:</span><input type="text" name="name" placeholder="请输入您的姓名"/></label><br/>
                    <label style="margin-left: 150px;"><span>密码:</span><input type="password" name="password" placeholder="请输入您的密码"/></label><br/>
                    <label style="margin-left: 150px;"><span>邮箱:</span><input type="text" name="mail" placeholder="请输入您的邮箱"/></label><br/>
                    <input id="submit" type="submit" value="提交申请"/>
                </form>
                <span style="color: red">${requestScope.errors}</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
