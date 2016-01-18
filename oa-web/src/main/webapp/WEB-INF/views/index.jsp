<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<header>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <style type="text/css">
        .login{
            width:100px;
            height:80px;
            position:absolute;
            top:20%;
            left:40%;
            margin-left:50px;
            margin-top:40px
        }
    </style>
</header>
<body>
    <div class="login">
        <form action="login" method="POST">
            <input type="text" name="loginName"/><br>
            <input type="password" name="password"/>
            <input type="submit" value="登陆"/>
        </form>
    </div>
    </body>
</html>
