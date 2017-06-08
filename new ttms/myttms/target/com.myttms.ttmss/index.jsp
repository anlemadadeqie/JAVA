<%@ page pageEncoding="UTF-8"%>

<html lang="en" class="login-content" data-ng-app="materialAdmin">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>登录界面</title>

    <link href="/css/material-design-iconic-font.min.css" rel="stylesheet">
    <!-- CSS -->
    <link href="/css/app.min.1.css" rel="stylesheet">
    <script type="text/javascript">
        function checkuser(){
            var name = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var regex = /^\w{3,16}$/;
            var regex1 = /^\w{6,16}$/;
            if(!name.match(regex)){

                document.getElementById("nameerror").innerHTML="用户名长度不正确或格式不正确！";
                var a = document.getElementById("username");
                a.value = "";
                a.focus();
                return false;
            }else{
                document.getElementById("nameerror").innerHTML="";
            }

            if(!password.match(regex1)){

                document.getElementById("passworderror").innerHTML="密码长度不正确或格式不正确！";
                var b = document.getElementById("username");
                b.focus();
                return false;
            }else{
                document.getElementById("passworderror").innerHTML="";
            }
        }

        function checkadduser(){
            var name = document.getElementById("adduser").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("addpassword1").value;
            var password2 = document.getElementById("addpassword2").value;
            var regex = /^\w{3,16}$/;
            var regex1 = /^\w+@\w+\.[a-zA-Z]+(\.[a-zA-Z]+)?$/;
            var regex2 = /^\w{6,16}$/;
            if(!name.match(regex)){
                document.getElementById("nameerrors").innerHTML="用户名长度不正确或格式不正确！";
                var a = document.getElementById("adduser");
                a.value = "";
                a.focus();
                return false;
            }else{
                document.getElementById("nameerrors").innerHTML="";
            }

            if(!email.match(regex1)){
                document.getElementById("mailerrors").innerHTML="邮箱格式不正确！";
                var a = document.getElementById("email");
                a.value = "";
                a.focus();
                return false;
            }else{
                document.getElementById("mailerrors").innerHTML="";
            }

            if(!password.match(regex2)){

                document.getElementById("passworderror1").innerHTML="密码长度不正确或格式不正确！";
                var a = document.getElementById("addpassword1");
                a.value = "";
                a.focus();
                return false;
            }else{
                document.getElementById("passworderror1").innerHTML="";
            }

            if(!password.match(password2)){

                document.getElementById("passworderror2").innerHTML="两次密码输入不一致！";
                var a = document.getElementById("addpassword2");
                a.value = "";
                a.focus();
                return false;
            }else{
                document.getElementById("passworderror2").innerHTML="";
            }


        }

        function checkemail(){
            var email = document.getElementById("email1").value;
            var regex = /^\w+@\w+\.[a-zA-Z]+(\.[a-zA-Z]+)?$/;

            if(!email.match(regex)){
                document.getElementById("mailerrors1").innerHTML="邮箱格式不正确！";
                var a = document.getElementById("email1");
                a.value = "";
                a.focus();
                return false;
            }else{
                document.getElementById("mailerrors1").innerHTML="";
            }

        }


    </script>
</head>
<body class="login-content" data-ng-controller="loginCtrl as lctrl">

<%--<li style="color: red">${requestScope.errors}</li>--%>

<div class="lc-block" id="l-login" data-ng-class="{'toggled':lctrl.login === 1}">
    <h1 class="lean">Azrael</h1>

    <form action="/user/login" method="post"  id="formid" name="myform">
        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-account"></i>
    		</span>
            <div class="fg-line">
                <input type="text" class="form-control" id="username" placeholder="Username" name="username" regex="^\w{3,16}$" onchange="checkuser();"/>
                <strong><span id="nameerror" style="color:red; "></span></strong>

            </div>
        </div>

        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-male"></i>
    		</span>
            <div class="fg-line">
                <input type="password" class="form-control" id="password" placeholder="Password" name="password" regex="^\w{6,16}$" onchange="checkuser();"/>
                <strong><span id="passworderror" style="color:red; "></span></strong>
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

        <%--<div>--%>

        <%--<span style="color: red">${requestScope.errors}</span>--%>

        <%--</div>--%>

        <ul class="login-navigation">
            <li class="bgm-red" data-ng-click="lctrl.login = 0; lctrl.register = 1">Register</li>
            <li data-block="#l-forget-password" class="bgm-orange" data-ng-click="lctrl.login = 0; lctrl.forgot = 1">Forgot Password?</li>
        </ul>
    </form>
</div>


<div class="lc-block" id="l-register" data-ng-class="{ 'toggled': lctrl.register === 1 }" data-ng-if="lctrl.register === 1">
    <h1 class="lean">Azrael</h1>
    <form action="registerjudge.do" method="post">
        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-account"></i>
    		</span>
            <div class="fg-line">
                <input type="text" class="form-control" placeholder="Username(长度为3-16且为字母,下划线)" id="adduser"  name="name" regex="^\w{3,16}$" onchange="checkadduser();"/>
                <strong><span id="nameerrors" style="color:red; "></span></strong>
            </div>
        </div>

        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-email"></i>
    		</span>
            <div class="fg-line">
                <input type="text" class="form-control" id="email" placeholder="Email Address" name="mail" regex="^\w+@\w+\.[a-zA-Z]+(\.[a-zA-Z]+)?$"  onchange="checkadduser();"/>
                <strong><span id="mailerrors" style="color:red; "></span></strong>
            </div>
        </div>

        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-male"></i>
    		</span>
            <div class="fg-line">
                <input type="password" class="form-control"  id="addpassword1"  name="password" placeholder="Password(长度为6-16且为字母，下划线)" regex="^\w{6,16}$" onchange="checkadduser();"/>
                <strong><span id="passworderror1" style="color:red; "></span></strong>
            </div>
        </div>

        <div class="input-group m-b-20">
            <span class="input-group-addon">
                <i class="zmdi zmdi-male"></i>
            </span>
            <div class="fg-line">
                <input type="password" class="form-control"  id="addpassword2"  name="password2" placeholder="Password(请再输入密码)" regex="^\w{6,16}$"  onchange="checkadduser();"/>
                <strong><span id="passworderror2" style="color:red; "></span></strong>
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
    </form>
</div>

<div class="lc-block" id="l-forget-password" data-ng-class="{ 'toggled': lctrl.forgot === 1 }" data-ng-if="lctrl.forgot === 1">
    <h1 class="lean">Azrael</h1>
    <form action="" method="post">
        <p class="text-left">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla eu risus. Curabitur commodo lorem fringilla enim feugiat commodo sed ac lacus.</p>
        <div class="input-group m-b-20">
            <span class="input-group-addon"><i class="zmdi zmdi-email"></i></span>
            <div class="fg-line">
                <input type="text" class="form-control" id="email1" placeholder="Email Address" regex="^\w+@\w+\.[a-zA-Z]+(\.[a-zA-Z]+)?$"  onchange="checkemail();"/>
                <strong><span id="mailerrors1" style="color:red; "></span></strong>
            </div>
        </div>

        <div>
            <input type="submit"  name="submit" value="" class="btn btn-login btn-danger btn-float"
                   onclick="return checkemail();"/>
        </div>

        <ul class="login-navigation">
            <li data-block="#l-login" class="bgm-green" data-ng-click="lctrl.forgot = 0; lctrl.login = 1">Login</li>
            <li data-block="#l-register" class="bgm-red" data-ng-click="lctrl.forgot = 0; lctrl.register = 1">Register</li>
        </ul>
    </form>
</div>

<li style="color: red">${requestScope.errors}</li>
</body>

<script src="/js/jquery.min.js"></script>
<!-- Angular -->
<script src="/js/angular.min.js"></script>
<script src="/js/angular-resource.min.js"></script>
<script src="/js/angular-animate.min.js"></script>


<!-- Angular Modules -->
<script src="/js/angular-ui-router.min.js"></script>
<script src="/js/loading-bar.js"></script>
<script src="/js/ocLazyLoad.min.js"></script>
<script src="/js/ui-bootstrap-tpls.min.js"></script>

<!-- Common js -->
<script src="/js/nouislider.min.js"></script>
<script src="/js/ng-table.min.js"></script>

<!-- Placeholder for IE9 -->
<!--[if IE 9 ]>
<script src="/js/jquery.placeholder.min.js"></script>
<![endif]-->
<!-- App level -->
<script src="/js/app.js"></script>
<script src="/js/main.js"></script>
<script src="/js/ui-bootstrap.js"></script>


<!-- Template Modules -->
<script src="/js/form.js"></script>
</html>