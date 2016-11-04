<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<%@page pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en" class="login-content" data-ng-app="materialAdmin">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录界面</title>

    <link href="css/material-design-iconic-font.min.css" rel="stylesheet" type="text/css">
    <!-- CSS -->
    <link href="css/app.min.1.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function checkuser(){
            var name = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var regex = /^\w{3,16}$/;
            var regex1 = /^\w{6,16}$/;
            if(!name.match(regex)){
                alert("用户名长度不正确或格式不正确!");
                return false;
            }

            if(!password.match(regex1)){
                alert("密码长度不正确或格式不正确!");
                return false;
            }

            window.location.href='index-x.html';
        }

        function checkadduser(){
            var name = document.getElementById("adduser").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("addpassword").value;
            var regex = /^\w{3,16}$/;
            var regex1 = /^\w+@\w+\.[a-zA-Z]+(\.[a-zA-Z]+)?$/;
            var regex2 = /^\w{6,16}$/;
            if(!name.match(regex)){
                alert("用户名长度不正确或格式不正确!");
                return false;
            }

            if(!email.match(regex1)){
                alert("邮箱格式不正确!");
                return false;
            }

            if(!password.match(regex2)){
                alert("密码长度不正确或格式不正确！");
                return false;
            }

            alert("注册成功!");

        }

    </script>
</head>
<body class="login-content" data-ng-controller="loginCtrl as lctrl">
<div class="lc-block" id="l-login" data-ng-class="{'toggled':lctrl.login === 1}">
    <h1 class="lean">Azrael</h1>

    <form action="loginctrl.do" method="post"  id="formid" name="myform">
        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-account"></i>
    		</span>
            <div class="fg-line">
                <input type="text" class="form-control" id="username" placeholder="Username"  name="username" regex="^\w{3,16}$"/>
            </div>
        </div>

        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-male"></i>
    		</span>
            <div class="fg-line">
                <input type="password" class="form-control" id="password" placeholder="Password"  name="password" regex="^\w{6,16}$"/>
            </div>
        </div>


        <div class="clearfix"></div>

        <div class="checkbox">
            <label>
                <input type="checkbox" value="" />
                <i class="input-helper">
                    保持登录状态
                </i>
            </label>
        </div>

        <div>
            <input type="submit"  name="submit" value="" class="btn btn-login btn-danger btn-float"
                   onclick="return checkuser();"/>
        </div>

        <ul class="login-navigation">
            <li class="bgm-red" data-ng-click="lctrl.login = 0; lctrl.register = 1">Register</li>
            <li data-block="#l-forget-password" class="bgm-orange" data-ng-click="lctrl.login = 0; lctrl.forgot = 1">Forgot Password?</li>
        </ul>
</div>
</form>

<div class="lc-block" id="l-register" data-ng-class="{ 'toggled': lctrl.register === 1 }" data-ng-if="lctrl.register === 1">
    <h1 class="lean">Azrael</h1>

    <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-account"></i>
    		</span>
        <div class="fg-line">
            <input type="text" class="form-control" placeholder="Username(长度为3-16且为字母,下划线)" id="adduser" regex="^\w{3,16}$"/>
        </div>
    </div>

    <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-email"></i>
    		</span>
        <div class="fg-line">
            <input type="text" class="form-control" id="email" placeholder="Email Address" regex="^\w+@\w+\.[a-zA-Z]+(\.[a-zA-Z]+)?$"/>
        </div>
    </div>

    <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-male"></i>
    		</span>
        <div class="fg-line">
            <input type="password" class="form-control"  id="addpassword" placeholder="Password(长度为6-16且为字母，下划线)" regex="^\w{6,16}$"/>
        </div>
    </div>

    <div class="clearfix"></div>

    <div>
        <input type="submit"  name="submit" value="" class="btn btn-login btn-danger btn-float"
               onclick="return checkadduser();"/>
    </div>

    <ul class="login-navigation">
        <li data-block="#l-login" class="bgm-green" data-ng-click="lctrl.register = 0; lctrl.login = 1">Login</li>
        <li data-block="#l-forget-password" class="bgm-orange" data-ng-click="lctrl.register = 0; lctrl.forgot = 1">Forgot Password?</li>
    </ul>
</div>

<div class="lc-block" id="l-forget-password" data-ng-class="{ 'toggled': lctrl.forgot === 1 }" data-ng-if="lctrl.forgot === 1">
    <h1 class="lean">Azrael</h1>
    <p class="text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla eu risus. Curabitur commodo lorem fringilla enim feugiat commodo sed ac lacus.</p>
    <div class="input-group m-b-20">
        <span class="input-group-addon"><i class="zmdi zmdi-email"></i></span>
        <div class="fg-line">
            <input type="text" class="form-control" placeholder="Email Address" regex="^\w+@\w+\.[a-zA-Z]+(\.[a-zA-Z]+)?$"/>
        </div>
    </div>

    <a href="" class="btn btn-login btn-danger btn-float"><i class="zmdi zmdi-arrow-forward"></i></a>

    <ul class="login-navigation">
        <li data-block="#l-login" class="bgm-green" data-ng-click="lctrl.forgot = 0; lctrl.login = 1">Login</li>
        <li data-block="#l-register" class="bgm-red" data-ng-click="lctrl.forgot = 0; lctrl.register = 1">Register</li>
    </ul>
</div>
</body>

<script src="js/bower_components/jquery/dist/jquery.min.js"></script>
<script src="js/log.js"></script>
<!-- Angular -->
<script src="js/bower_components/angular/angular.min.js"></script>
<script src="js/bower_components/angular-resource/angular-resource.min.js"></script>
<script src="js/bower_components/angular-animate/angular-animate.min.js"></script>


<!-- Angular Modules -->
<script src="js/bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
<script src="js/bower_components/angular-loading-bar/src/loading-bar.js"></script>
<script src="js/bower_components/oclazyload/dist/ocLazyLoad.min.js"></script>
<script src="js/bower_components/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>

<!-- Common js -->
<script src="js/bower_components/angular-nouislider/src/nouislider.min.js"></script>
<script src="js/bower_components/ng-table/dist/ng-table.min.js"></script>

<!-- Placeholder for IE9 -->
<!--[if IE 9 ]>
<script src="js/bower_components/jquery-placeholder/jquery.placeholder.min.js"></script>
<![endif]-->
<!-- App level -->
<script src="js/app.js"></script>
<script src="js/controllers/main.js"></script>
<script src="js/controllers/ui-bootstrap.js"></script>


<!-- Template Modules -->
<script src="js/modules/form.js"></script>
</html>