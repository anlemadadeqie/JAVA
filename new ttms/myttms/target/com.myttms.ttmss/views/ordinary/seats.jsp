<%@ page import="com.ttms.entity.Studio" %>
<%@ page import="com.ttms.entity.Schedule" %>
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
        @media screen and (min-width : 1280px){

            .myspan{
                text-align: center;
                display: inline-block;
            }
            .seats{
                width: 100%;
                padding:15px 30px;
                /*margin-top: 80px;*/
                overflow: hidden;
            }
            .pingmu{
                position: relative;
                width: 750px;
                height: 50px;
                background-color: #AAAAAA;
                border-radius: 0 0 50px 50px;
                text-align: center;
            }
            .pingmu label{
                font-size: 20px;
                color: #fff;
            }
            #seat{
                width: 630px;
                margin-left: 50px;
                text-align: center;
            }
            .form_left{

                background: #fff;
                height:670px;
            }
            .seets{
                height: 20px;
                width: 20px;
                border:1px solid #AAA;
                border-radius: 20px;
                float: left;
                margin-left: 20px;
                margin-top: 20px;
            }
            .seets:hover{
                border:1px solid black;
            }
            #kexuan{
                height: 20px;
                width: 20px;
                border:1px solid #AAA;
                border-radius: 20px;
                float: left;
                background-color: #fff;
            }
            #yixuan{
                height: 20px;
                width: 20px;
                border:1px solid #AAA;
                border-radius: 20px;
                float: left;
                background-color: #aaa;
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
            .yuan{
                float: left;
                margin-left: 50px;
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
            .pay{
                position: absolute;
                width:250px;
                height:300px;
                background-color:red;
                right: 150px;
                top: 200px;
            }

            #choice{
                width: 250px;
                height: 100px;
            }

            .seat_numbers{
                width: 250px;
                height: 200px;
                overflow: hidden;
                background-color: #f2f2f2;
                border-bottom: 2px solid #fff;
                margin-top: -33px;
            }
            .seat_numbers label{
                font-size: 20px;
                font-family: "微软雅黑";
                color: #AAA;
            }
            .phone{
                overflow: hidden;
                width: 250px;
                height: 200px;
                background-color: #f2f2f2;
                border-bottom: 2px solid #fff;
            }
            .phone label{
                line-height: 60px;
                margin-left: 30px;
                font-size: 20px;
                font-family: "微软雅黑";
                color: #AAA;
            }
            .phone input{
                margin-left: 30px;
                height: 30px;
                width: 200px;
                font-size: 20px;
            }
            .buy{
                overflow: hidden;
                width: 250px;
                height: 200px;
                background-color: #f2f2f2;
            }
            .buy label{
                line-height: 40px;
                margin-left: 50px;
                font-size: 20px;
                font-family: "微软雅黑";
                color: #AAA;
            }
            .buy a{
                color: #fff;
                font-size: 20px;
                padding: 10px 20px;
                background-color: #FF4747;
                opacity: 0.8;
                margin-left:50px;
                position: relative;
                top: 30px;
            }
            .buy a:hover{
                opacity: 1;
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
        }
        @media screen and (max-width : 1280px){
            .myspan{
                text-align: center;
                display: inline-block;
            }
            .seats{
                width: 100%;
                padding:15px 30px;
                /*margin-top: 80px;*/
                overflow: hidden;
            }
            .pingmu{
                position: relative;
                width: 600px;
                height: 50px;
                background-color: #AAAAAA;
                border-radius: 0 0 50px 50px;
                text-align: center;
            }
            .pingmu label{
                font-size: 20px;
                color: #fff;
            }
            #seat{
                width: 600px;
                margin-left: 10px;
                text-align: center;
            }
            .seets{
                height: 20px;
                width: 20px;
                border:1px solid #AAA;
                border-radius: 20px;
                float: left;
                margin-left: 18px;
                margin-top: 20px;
            }
            .seets:hover{
                border:1px solid black;
            }
            #kexuan{
                height: 20px;
                width: 20px;
                border:1px solid #AAA;
                border-radius: 20px;
                float: left;
                background-color: #fff;
            }
            #yixuan{
                height: 20px;
                width: 20px;
                border:1px solid #AAA;
                border-radius: 20px;
                float: left;
                background-color: #aaa;
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
            .yuan{
                float: left;
                margin-left: 50px;
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
            .pay{
                position: absolute;
                width:250px;
                height:300px;
                background-color:red;
                right: 50px;
                top: 200px;
            }

            #choice{
                width: 250px;
                height: 100px;
            }

            .seat_numbers{
                width: 250px;
                height: 200px;
                overflow: hidden;
                background-color: #f2f2f2;
                border-bottom: 2px solid #fff;
                margin-top: -33px;
            }
            .seat_numbers label{
                font-size: 20px;
                font-family: "微软雅黑";
                color: #AAA;
            }
            .phone{
                overflow: hidden;
                width: 250px;
                height: 200px;
                background-color: #f2f2f2;
                border-bottom: 2px solid #fff;
            }
            .phone label{
                line-height: 60px;
                margin-left: 30px;
                font-size: 20px;
                font-family: "微软雅黑";
                color: #AAA;
            }
            .phone input{
                margin-left: 30px;
                height: 30px;
                width: 200px;
                font-size: 20px;
            }
            .buy{
                overflow: hidden;
                width: 250px;
                height: 200px;
                background-color: #f2f2f2;
            }
            .buy label{
                line-height: 40px;
                margin-left: 50px;
                font-size: 20px;
                font-family: "微软雅黑";
                color: #AAA;
            }
            .buy a{
                color: #fff;
                font-size: 20px;
                padding: 10px 20px;
                background-color: #FF4747;
                opacity: 0.8;
                margin-left:50px;
                position: relative;
                top: 30px;
            }
            .buy a:hover{
                opacity: 1;
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
        }
    </style>
</head>
<body>
<div class="container">
    <%--<div class="container_wrap">--%>
        <div class="header_top">
            <div class="col-sm-3 logo"><a href="../show.jsp"><img src="/images/1.png" alt=""/></a></div>
            <div class="col-sm-6 nav">
                <ul class="ulul">
                    <a href="/play/showAllPlay"><li>首页</li></a>
                    <a href="#tt"><li>影片</li></a>
                    <!-- a href="single.html"><li>信息</li></a> -->
                    <a href="/ticket/searchbySale"><li>订单</li></a>
                </ul>
            </div>
            <div class="col-sm-3 header_right">
                <ul class="header_right_box">
                    <li><img src="/images/1.png" alt=""/></li>
                </ul>
            </div>
        </div>



        <%
            Studio studio = (Studio)request.getAttribute("studio");
            int [][] seat_statu =  (int[][])request.getAttribute("seat_statu");
            Schedule schedule = (Schedule)request.getAttribute("schedule");
        %>
        <div class="container_wrap" style="padding: 0em;">
            <div class = "form_left">
                <%--<form action="/seat/seatsshow" method="post">--%>
            <%--<div class="mian_b">--%>
                <%--<div class="mian_b1">--%>
                    <%--<div class="container">--%>
                        <div class="container_wrap" style="margin-right: 15px;">
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
                                            <span class="myspan"><span class="seet0" onclick="test1(this,<%=i%>,<%=j%>,<%=studio.getStudio_id()%>,<%=schedule.getSched_id()%>)"></span></span>

                                            <%
                                            }
                                            else if(seat_statu[i][j] == 1){

                                            %>
                                            <span class="myspan"><span class="seet1" onclick="test1(this,<%=i%>,<%=j%>,<%=studio.getStudio_id()%>,<%=schedule.getSched_id()%>)"></span></span>
                                            <%
                                            }
                                            else if(seat_statu[i][j] == -1){


                                            %>
                                            <span class="myspan"><span class="seet2" onclick="test1(this,<%=i%>,<%=j%>,<%=studio.getStudio_id()%>,<%=schedule.getSched_id()%>)"></span></span>
                                            <%

                                            }
                                            else{
                                            %>
                                            <span class="myspan"><span class="seet3" onclick="test1(this,<%=i%>,<%=j%>,<%=studio.getStudio_id()%>,<%=schedule.getSched_id()%>)"></span></span>

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
                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>
                <%--</form>--%>
            </div>


        <div class="pay">
            <div class="seat_numbers">
                <label>你选择的座位:</label>
                <div id="choice"></div>
            </div>
            <div class="phone">
                <label>请输入取票的手机号:</label>
                <input type="text">
            </div>
            <div class="buy">
                <label>票价:58元</label></br>
                <label class="Price">共计:0元</label></br>
                <a href="#" onclick="sendResult(<%=studio.getStudio_id()%>,<%=schedule.getSched_id()%>)">提交订单</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery-2.2.2.min.js"></script>

<script type="text/javascript">

    var k = 0;
    var data={};
    var data1={};
    var order="";


    function sendResult(studio_id,sched_id) {

        data1.studio = studio_id;
        data1.sched = sched_id;

        var link = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");
        link.open("post","/ticket/Saleitem",true);
        link.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        link.onreadystatechange=function(){
            if(link.readyState == 4 && link.status == 200){

                alert("您已订票成功!");
            }

        };
        data1.orders = order;
        link.send("data="+ JSON.stringify(data1));

    }

    function change(m,i, j, studio_id, sched_id) {

        var str = "第" + i + "排第" + j + "列";
        order += i+","+j+"|";

        if ($(m).css("background-color") === "rgb(0, 128, 0)") {

            $(m).css("background-color", "#fff");
            k--;
            var st = "#" + str;
            $(st).remove();
            data.row = i;
            data.col = j;
            data.studio = studio_id;
            data.sched = sched_id;
            data.flag = 0;
        }

//        if ($(m).css("background-color") === "rgb(255, 255, 255)")
        else
        {
            $(m).css("background-color", "#008000");
            k++;
            var s = $("<div id='"+str+"'>" + str + "</div>");
            s.addClass("seatt");
            $("#choice").append(s);
            data.row = i;
            data.col = j;
            data.studio = studio_id;
            data.sched = sched_id;
            data.flag = -1;
        }
        var suns = 58 * k;
        $(".Price").html("共计:" + suns + "元");
        return data;
    }


    function test1(m,i, j, studio_id, sched_id){
        var link = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");
        link.open("post","/ticket/lockTicket",true);
        link.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        link.onreadystatechange=function(){
            if(link.readyState == 4 && link.status == 200){

                    alert("success!");
            }

        };
        var datas = change(m,i, j, studio_id, sched_id);
        link.send("data="+JSON.stringify(datas));
    }
</script>
</body>
</html>
