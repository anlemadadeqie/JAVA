
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="UTF-8" class="login-content" data-ng-app="materialAdmin">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>密码重置</title>

    <link href="/css/material-design-iconic-font.min.css" rel="stylesheet" type="text/css">
    <!-- CSS -->
    <link href="/css/app.min.3.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function changepassword(){
            var password = document.getElementById("password").value;
            var password2 = document.getElementById("password2").value;
            var regex = /^\w{6,16}$/;
            if(!password.match(regex)){
                alert("密码长度不正确或格式不正确!");
                return false;
            }

            if(password != password2){
                alert("两次密码输入不一致！");
                return false;
            }

        }

    </script>
</head>
<body class="login-content" data-ng-controller="loginCtrl as lctrl">

<div class="lc-block" id="l-login" data-ng-class="{'toggled':lctrl.login === 1}">
    <h1 class="lean">Reset Password</h1>

    <form action="/user/updatepass" method="post"  id="formid" name="myform"  enctype="multipart/form-data">
        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-male"></i>
    		</span>
            <div class="fg-line">
                <input type="password" name="pa1" class="form-control" id="password" placeholder="Password(长度6-16的字母，数字，汉字，下划线）" regex="^\w{6,16}$"/>
            </div>
        </div>

        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-male"></i>
    		</span>
            <div class="fg-line">
                <input type="password"  class="form-control" id="password2" placeholder="Input Password again" regex="^\w{6,16}$"/>
            </div>
        </div>


        <div class="input-group m-b-20">
    		<span class="input-group-addon">
    			<i class="zmdi zmdi-male"></i>
    		</span>
            <div class="fg-line">
                更新头像: <input type="file" name="emp_pic">
            </div>
        </div>


        <div class="clearfix"></div>

        <div>
            <input type="submit"  name="submit" value="" class="btn btn-login btn-danger btn-float"
                   onclick="return changepassword();"/>
        </div>

</form>
</div>

</body>

<script src="/js/jquery.min.js"></script>
<script src="/js/log.js"></script>
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


<!-- App level -->
<script src="/js/app.js"></script>
<script src="/js/main.js"></script>
<script src="/js/ui-bootstrap.js"></script>


<!-- Template Modules -->
<script src="/js/modules/form.js"></script>
</html>

