
<%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 16-12-8
  Time: 上午11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加影片</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css">
    <link href="/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <script type="application/x-javascript">
        addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
        function hideURLbar(){ window.scrollTo(0,1); }
    </script>

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
        .footer_right{
            overflow: hidden;
            position: relative;
            margin-top: 37px;
        }
        .footer_right input{
            border: none;
            background-color: #ededee;
            width: 320px;
            height: 40px;
            margin: 14px 8px;
            border-radius: 5px;
            padding-left: 55px;
        }
        .footer_right span{
            position: relative;
            left: 57px;
        }
        .foot_left{
            overflow: hidden;
            position: relative;
            left: 145px;
            margin-right: 130px;
        }
        .foot_left input{
            border: none;
            background-color: #ededee;
            width: 320px;
            height: 40px;
            border-radius: 5px;
        }
        .foot_left textarea{
            background-color: #ededee;
            border: none;
            border-radius: 5px;
            padding:10px;
            width: 790px;
            overflow: hidden;
        }
        .foot_left textarea:hover{
            box-shadow: 1px 1px 3px #E74F4D;
        }
        #submit{
            width: 750px;
        }
        .foot_left input:hover{
            box-shadow: 1px 1px 3px #E74F4D;
        }


        .box1
        {
            position: relative;
            width: 250px;
            height: 400px;
            background-color: #ededee;
            background-repeat: no-repeat;
            background-position: 0 0;
            background-attachment: scroll;
            line-height: 400px;
            text-align: center;
            color: #AAA;
            font-size: 22px;
            font-family: "微软雅黑";
            cursor: pointer;
            overflow: hidden;
            z-index: 1;
            left: -150px;
            top: 50px;
            float: left;
        }
        .box1 input
        {
            position: absolute;
            width: 250px;
            height: 400px;
            line-height: 40px;
            font-size: 23px;
            opacity: 0;
            filter: "alpha(opacity=0)";
            filter: alpha(opacity=0);
            -moz-opacity: 0;
            left: -5px;
            top: -2px;
            cursor: pointer;
            z-index: 2;
        }

        @media screen and (max-width : 1280px){
            .foot_left{
                overflow: hidden;
                position: relative;
                left:145px;
                margin-right: 130px;
            }
            .foot_left input{
                border: none;
                background-color: #ededee;
                width: 320px;
                height: 40px;
                border-radius: 5px;
            }
            .foot_left textarea{
                background-color: #ededee;
                border: none;
                border-radius: 5px;
                padding:10px;
                width: 790px;
                overflow: hidden;
            }
            .foot_left textarea:hover{
                box-shadow: 1px 1px 3px #E74F4D;
            }
            #submit{
                width: 750px;
            }
            .foot_left input:hover{
                box-shadow: 1px 1px 3px #E74F4D;
            }

            .myspan{
                background-color: #ededee;
                width: 320px;
                height: 40px;
                margin:14px 8px;
                border:none;
                border-radius: 5px;
                padding-left: 55px;
            }

            #mybody{
                background-color: #3c3c3c;
            }

        }
    </style>
</head>
<body class="mian_bj" id="mybody">
<div class="mian_top_r"></div>
<div class="mian_top_l"></div>
<div class="mian_top_c">
    <ul>
        <li><a href="/play/showplay">
            <p>
                影片一览</p>
        </a></li>
        <li><a href="/play/addplayshow">
            <p>
                修改影片</p>
        </a></li>
        <li><a href="/play/delplayshow">
            <p>
                删除影片</p>
        </a></li>
    </ul>
</div>
<div class="mian_b">
    <div class="mian_b1">

        <p class="mian_b1_sousuo">
            <input name="" type="text" id="searchcontent"></p>
        <a href="#" title="搜索" onclick="checkcontent();">
            <p class="mian_b1_a3">
            </p>
        </a><a href="#" title="最后">
        <p class="mian_b1_a4">
        </p>
    </a><a href="#" title="下一页">
        <p class="mian_b1_a5">
        </p>
    </a>
        <p class="mian_b1_list">
            1 2 3 4……</p>
        <a href="#" title="上一页">
            <p class="mian_b1_a6">
            </p>
        </a><a href="#" title="最前">
        <p class="mian_b1_a7">
        </p>
    </a>
    </div>
    <form method="post" action="/play/addplay" name="joinForm" enctype="multipart/form-data">
        <div class="header_top">
            <div class="col-sm-3 header_right">
            </div>
            <div class="box1">
                <input type="file" name="play_image">
                选择图片
            </div>
            <div class="footer_right">
                <label><span>名字:</span><input type="text" name="play_name" placeholder="请输入电影的名字"/></label>
                <label><span>类别:</span><input type="text" name="play_type" placeholder="请输入电影的类别"/></label><br/>
                <label><span>语言:</span><input type="text" name="play_lang" placeholder="请输入电影的语言"/></label>
                <label><span>时长:</span><input type="text" name="play_length" placeholder="请输入电影的时长"/></label><br/>
                <label><span>价格:</span><input type="text" name="play_price" placeholder="请输入电影的价格"/></label>
                <label><span>状态:</span>
                    <select  name="play_status" class="myspan">
                        <option value="0">未上映</option>
                        <option value="1">上映中</option>
                        <option value="-1">下架</option>
                    </select>

                </label><br/>
            </div>
            <div class="foot_left">
                <textarea cols="8" rows="8" placeholder="请输入电影的内容信息"></textarea><br/>
            </div>
            &nbsp;
            &nbsp;
            &nbsp;

            <div style="margin-left:400px;">
                <input type="image" src="/images/bnt_03.gif" style="margin-right:10px;" width="80" height="22">
                <a href="" ><input type="image" src="/images/bnt_05.gif" width="80" height="22"></a>

            </div>
            <div>
                <span style="color: red">${requestScope.errors}</span>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script src="/js/common.js"></script>


