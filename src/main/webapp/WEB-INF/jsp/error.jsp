<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%-- -------------------------------------------------------------------------------- --%>
<%-- 通用JS --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/base/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/base/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jqgrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jqgrid/grid.locale-cn.js"></script>
<%-- 通用CSS --%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/iconfont/iconfont.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/innocence/innocence.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jqgrid/ui.jqgrid.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jqueryui/jquery-ui.min.css" type="text/css">
<%-- -------------------------------------------------------------------------------- --%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>苏夏未来</title>
</head>
<body style="color: #00B83F">
<div style="text-align: center;color: #00B83F">
    <h2>苏夏未来</h2>
    <div style="margin-right: 20px;width: 50px;height: 20px;">
        <a href="/loginManager/logout">退出</a>
    </div>
</div>
<div style="margin-top: 100px;text-align: center">
    <ul>
        <li><span>异常级别：</span>${exceptionResult.errLevel}</li>
        <li><span>异常编码：</span>${exceptionResult.errCode}</li>
        <li><span>异常信息：</span>${exceptionResult.errMsg}</li>
    </ul>
</div>
</body>
</html>