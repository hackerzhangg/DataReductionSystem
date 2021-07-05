<%--
  Created by IntelliJ IDEA.
  User: zgp
  Date: 2021/7/3
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询Excel数据</title>
</head>
<body>
        <div style="text-align: center">
            <h2><a href="/DataReductionSystem/user/excel">如果信息确定导完,请点击导出Excel表格</a></h2>
            <h2><a href="/DataReductionSystem/user/deleteDataExcel">如果数据有误，你可以选择清空数据，重新导入</a></h2>
            <h2><a href="/DataReductionSystem/user/toAddDataPage">如果群信息没导完，请继续导入数据</a></h2>
            <table border="1" cellpadding="28" cellspacing="0" align="center">
                <tr>
                    <td>抖音名称</td>
                    <td>抖音号码</td>
                    <td>抖音群号</td>
                    <td>抖音代号</td>
                </tr>
                <c:forEach items="${tiktokList}" var="list">
                    <tr>
                        <td>${list.tikTokUserName1}</td>
                        <td>${list.tikTokUserName2}</td>
                        <td>${list.tikTokUserName3}</td>
                        <td>${list.tikTokUserName4}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>
