<%--
  Created by IntelliJ IDEA.
  User: shiyi
  Date: 2016/12/19
  Time: 下午6:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.web.entity.Lostmess" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>寻亲网——发布寻亲信息</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">
    <link href="/css/filllostmess.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->


    <script type="text/javascript">

        var path;

        function test(){

            var fileObj = document.getElementById("lostpicture").files[0];
            var form = new FormData();
            form.append("picture_list", fileObj);
            var link = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");
            link.open('post','/lostmess/upload',true);
            link.onreadystatechange = function(){
                if(link.readyState == 4 && link.status == 200){

                    alert("图片上传成功！");
                    path = link.responseText;
                }
            };
            link.send(form);

        }



        function test1(){

            var data={};
            var link = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");
            link.open("post","/lostmess/add",true);
            link.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            link.onreadystatechange=function(){
                if(link.readyState == 4 && link.status == 200){

                    alert("上传成功！");
                }
            };
            data.name = document.getElementById("lostname").value;
            var sexs = document.getElementsByName("lostsex");
            for(var i = 0; i < sexs.length; i++){
                if(sexs[i].checked){

                    data.sex = sexs[i].value;
                    break;
                }
            }
            data.height = document.getElementById("lostheight").value;
            data.birthday = document.getElementById("lostbirthday").value;
            data.native_place = document.getElementById("lostaddress").value;
            var bloodtype = document.getElementsByName("lostbloodtype");
            for(var i = 0; i < bloodtype.length; i++){
                if(bloodtype[i].checked){

                    data.blood_type = bloodtype[i].value;
                    break;
                }
            }
            data.lost_place = document.getElementById("lostplace").value;
            data.lost_date = document.getElementById("lostdate").value;
            if(document.getElementById("lostfeature").value == "" || document.getElementById("lostfeature").value == null ){

                data.feature = "无";
            }else{

                data.feature = document.getElementById("lostfeature").value;
            }
            var findtype = document.getElementsByName("losttype");
            for(var i = 0; i < findtype.length; i++){
                if(findtype[i].checked){

                    data.find_type = findtype[i].value;
                    break;
                }
            }
            if(document.getElementById("lostothermess").value == "" || document.getElementById("lostothermess").value == null){

                data.other_message = "无";
            }else{

                data.other_message = document.getElementById("lostothermess").value;
            }
            data.picture_list = path;
            link.send("data="+JSON.stringify(data));

        }
    </script>


</head>

<body>
<!-- 顶部导航 -->
<div class="container">
    <div class="navbar navbar-fixed-top" role="navigation" style="background:#1b435d">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/home/"><font style="font-size:36px">寻亲网</font></a>
            </div>

            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="#">资料库</a></li>
                    <li><a href="#">悬赏库</a></li>
                    <li><a href="#">论坛</a></li>
                    <li><a href="#">关于</a></li>
                </ul>
                <form class="navbar-form navbar-right">
                    <a href="#" class="btn btn-hover">登录</a></li>
                    <a href="#" class="btn btn-hover">注册</a>
                </form>
            </div>
        </div>
    </div>
</div>
<!--主要内容-->

<div class="container" style="margin-top:30px;margin-left:0;margin-right:0">
    <h1 class="h1-header">填写失踪者信息</h1>
    <%--<form class="form-horizontal" role="form" action="" method="post" style="margin-top:30px">--%>

        <div class="form-group" id="input-name">
            <label for="lostname" class="col-sm-3 control-label">姓名:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control mess" id="lostname" name="lostname" autofocus>
            </div>
        </div>
        &nbsp;
        &nbsp;
        <div class="form-group" id="input-type">
            <label class="col-sm-3 control-label">寻亲类型:</label>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <label class="radio-inline">
                <input type="radio"  value="0" name="losttype">家寻宝贝
            </label>
            <label class="radio-inline">
                <input type="radio"  value="1" name="losttype">宝贝寻家
            </label>

        </div>

        <div class="form-group" id="input-sex">
            <label class="col-sm-3 control-label">性别:</label>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <label class="radio-inline">
                <input type="radio"  value="0" name="lostsex">男&nbsp;&nbsp;&nbsp;
            </label>
            <label class="radio-inline">
                <input type="radio"  value="1" name="lostsex">女
            </label>
        </div>

        <div class="form-group" id="input-picture">
            <label for="lostpicture" class="col-sm-3 control-label">照片:</label>
            <div class="col-sm-9">
                <div class="file-style col-md-3">
                    <input type="file" onChange="add_files(this.files)" style="width:200px;
			height:250px;opacity:0;cursor:pointer" id="lostpicture" name="lostpicture">
                </div>
                <div class="col-md-3 pic-style">
                    <img src="" id="pic" style="width:200px; height:250px;">
                </div>
                <div class="col-sm-3">
                    <button type="button" class="btn btn-primary" onclick="test();" style="margin-left: 50px;
                    margin-top:200px;">确认图片</button>
                </div>
            </div>
        </div>
        &nbsp;
        &nbsp;
        <div class="form-group" id="input-birthday">
            <label for="lostbirthday" class="col-sm-3 control-label">生日:</label>
            <div class="col-sm-9">
                <input type="date" class="form-control mess" id="lostbirthday" name="lostbirthday">
            </div>
        </div>
        &nbsp;
        &nbsp;
        <div class="form-group" id="a-address">
            <label for="lostaddress" class="col-sm-3 control-label">籍贯:</label>
            <div class="col-sm-9">
                <div class="col-sm-3">
                    <select class="form-control" id="s_province" name="s_province"></select>
                </div>
                <div class="col-sm-3">
                    <select class="form-control" id="s_city" name="s_city"></select> 
                </div>
                <div class="col-sm-3">
                    <select class="form-control" id="s_county" name="s_county" onChange="showArea()">
                    </select>
                </div>
                <div id="show"></div>
            </div>
        </div>
        <div class="form-group" id="b-address">
            <label for="lostaddress" class="col-sm-3 control-label">详细地址:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control mess" id="lostaddress" name="lostaddress">
            </div>
        </div>
        &nbsp;
        &nbsp;
        <div class="form-group" id="input-height">

            <label for="lostheight" class="col-sm-3 control-label">身高:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control mess" id="lostheight" name="lostheight">
            </div>
        </div>
        &nbsp;
        &nbsp;

        <div class="form-group" id="input-blood-type">
            <label class="col-sm-3 control-label">血型:</label>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <label class="radio-inline">
                <input type="radio"  value="0" name="lostbloodtype">A型
            </label>
            <label class="radio-inline">
                <input type="radio"  value="1" name="lostbloodtype">B型
            </label>
            <label class="radio-inline">
                <input type="radio"  value="2" name="lostbloodtype">AB型
            </label>
            <label class="radio-inline">
                <input type="radio"  value="3" name="lostbloodtype">O型
            </label>
            <label class="radio-inline">
                <input type="radio"  value="4" name="lostbloodtype">其它
            </label>
        </div>
        <div class="form-group" id="input-date">
            <label for="lostdate" class="col-sm-3 control-label">失踪日期:</label>
            <div class="col-sm-9">
                <input type="date" class="form-control mess" id="lostdate" name="lostdate">
            </div>
        </div>
        &nbsp;
        &nbsp;
        <div class="form-group" id="a-place">
            <label class="col-sm-3 control-label">丢失地址:</label>
            <div class="col-sm-9">
                <div class="col-sm-3">
                    <select class="form-control" id="l_province" name="l_province"></select>
                </div>
                <div class="col-sm-3">
                    <select class="form-control" id="l_city" name="l_city"></select> 
                </div>
                <div class="col-sm-3">
                    <select class="form-control" id="l_county" name="l_county" onChange="showPlace()"></select></div>
                <div id="show2"></div>
            </div>
        </div>
        <div class="form-group" id="b-place">
            <label for="lostplace" class="col-sm-3 control-label">详细丢失地址:</label>
            <div class="col-sm-9">
                <input type="text" class="form-control mess" id="lostplace" name="lostplace">
            </div>
        </div>
        &nbsp;
        &nbsp;
        <div class="form-group" id="input-feature">
            <label for="lostfeature" class="col-sm-3 control-label">特征描述:</label>
            <div class="col-sm-9">
                <textarea rows="4" type="text" class="form-control mess" id="lostfeature" name="lostfeature"></textarea>
            </div>
        </div>
        &nbsp;
        &nbsp;
        <div class="form-group" id="input-othermess">
            <label for="lostothermess" class="col-sm-3 control-label">其他备注信息:</label>
            <div class="col-sm-9">
                <textarea rows="4" type="text" class="form-control mess" id="lostothermess" name="lostothermess"></textarea>
            </div>
        </div>
        <br><br><br>
        &nbsp;
        &nbsp;
        <div class="form-group">
            <div class="col-sm-offset-6 col-sm-9">
                <button type="button" class="btn btn-primary" onclick="test1();">提交</button>

                <button type="button" class="btn btn-primary" style="margin-left:50px">重置</button>
            </div>
        </div>

    <%--</form>--%>

</div>



<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/filllostmess.js"></script>
<script src="/js/area.js" type="text/javascript"></script>

<script type="text/javascript">
    _init_area();
    _init_place();


</script>

</body>
</html>
