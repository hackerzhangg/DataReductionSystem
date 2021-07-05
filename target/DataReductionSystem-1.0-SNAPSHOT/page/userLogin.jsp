<%--
  Created by IntelliJ IDEA.
  User: zgp
  Date: 2021/6/30
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登录</title>
    <script>
        //对表单数据进行校验
        function checkData() {
            var username=document.getElementById("username").value;
            var password=document.getElementById("password").value;
            if (username == ""){
                alert("用户登录姓名不能为空!");
                return;
            }
            if (password == ""){
                alert("用户登录密码不能为空!");
                return;
            }
        }
    </script>
    <style>
        #div1{
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <div id="div1">
        <h2>用户登录</h2>
        <form action="/DataReductionSystem/user/userLogin" method="post" onsubmit="checkData()">
            用户姓名：<input type="text" name="username" id="username"><br/>
            用户密码：<input type="password" name="password" id="password"><br/>
            <input type="submit" value="提交数据">
            <input type="reset" value="清除数据">
            <br/>
        </form>
    </div>
</div>
</body>
</html>
