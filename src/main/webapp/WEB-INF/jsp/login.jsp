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
<body style="color: #1E90FF;font-family: Microsoft YaHei;background: black;">
<div style="margin: 0 auto;margin-top: 150px;margin-right: 100px; background: white;width: 400px;height: 350px;">
    <div style="margin-left: 10px;">
        <div style="padding-top: 2px">
            <P>苏夏未来</P>
        </div>
    </div>
    <form id="loginForm" action="/loginManager/login" method="post">
        <div style="width: auto;height: 350px;text-align: center">
            <div style="margin-top: 20px;padding-top: 35px;">
                <i class="iconfont">&#xe66c;</i> 账号：<input type="text" name="userName" maxlength="12"/>
            </div>
            <div style="margin-top: 35px;">
                <i class="iconfont">&#xe603;</i> 密码：<input type="password" name="password" maxlength="12"/>
            </div>
            <div style="margin-top: 35px;">
                <button class="i-button" onclick="login();">登录</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script>
    function login() {
        $("#loginForm").submit();
    }
</script>