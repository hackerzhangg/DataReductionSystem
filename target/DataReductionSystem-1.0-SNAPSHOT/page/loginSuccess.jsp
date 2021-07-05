<%--
  Created by IntelliJ IDEA.
  User: zgp
  Date: 2021/6/30
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台系统首页</title>
</head>
<body>
    <div>
        <form action="/DataReductionSystem/user/submitData" method="post">
            抖音姓名：<textarea rows="100" cols="100" name="TikTokUserName1"></textarea><br/>
            抖音称号：<textarea rows="100" cols="100" name="TikTokUserName2"></textarea><br/>
            <input type="submit" value="提交数据"><br/>
        </form>
    </div>
</body>
</html>
