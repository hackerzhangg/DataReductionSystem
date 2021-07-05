<%--
  Created by IntelliJ IDEA.
  User: zgp
  Date: 2021/7/3
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导出Excel表</title>
    <script>
        function dataCheck() {
            var TikTokUserName1=document.getElementById("TikTokUserName1").value;
            var TikTokUserName2=document.getElementById("TikTokUserName2").value;
            var TikTokUserName3=document.getElementById("TikTokUserName3").value;
            if (TikTokUserName1 == ""){
                alert("抖音数据(抖音名 单空格 抖音号)不能为空！");
                return;
            }
            if (TikTokUserName2 == ""){
                alert("抖音群号不能为空！");
                return;
            }
            if (TikTokUserName3 == ""){
                alert("抖音数据(抖音代号不能为空！");
                return;
            }
        }
    </script>
</head>
<body>
<div>
    <form action="/DataReductionSystem/user/submitDatas" method="post" onsubmit="dataCheck()">
        抖音数据(抖音名 单空格 抖音号)：<br/><textarea rows="80" cols="100" name="TikTokUserName1" id="TikTokUserName1"></textarea><br/>
        抖音群号：<br/><textarea rows="20" cols="100" name="TikTokUserName2" id="TikTokUserName2"></textarea><br/>
        抖音代号：<br/><textarea rows="20" cols="100" name="TikTokUserName3" id="TikTokUserName3"></textarea><br/>
        <input type="submit" value="提交数据">
        <input type="reset" value="清除数据"><br/>
    </form>
</div>
</body>
</html>
