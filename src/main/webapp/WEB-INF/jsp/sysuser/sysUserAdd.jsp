﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
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

<html>
<head>
    <meta charset="utf-8"/>
    <title>苏夏未来</title>
</head>
<body style="text-align: center;color: #00B83F">
<div style="margin-top: 40px;">
    <h3>新增系统用户</h3>
</div>
<div style="margin-top: 70px">
    <form id="maintainForm" action="/sys/addSysUser" method="post">
        <div>
            <i class="iconfont">&#xe66c;</i><span>账号：</span>
            <input class="i-input" id="userName" type="text" name="userName" value="test1"/>
        </div>
        <br/>
        <div>
            <span class="iconfont">&#xe603;</span><span>密码：</span>
            <input id="password" type="password" name="password" value="123456"/>
        </div>
        <br/>
        <div>
            <span class="iconfont">&#xe66b;</span><span>昵称：</span>
            <input id="nickName" type="text" name="nickName" value="测试1"/>
        </div>
        <br/>
        <div>
            <span class="iconfont">&#xe638;</span><span>电话：</span>
            <input id="mobile" type="text" name="mobile" value="13145201234"/>
        </div>
        <br/>
        <div id="administrator">
            <span>是否管理员：</span>
            <label><input name="administrator" type="radio" value="1"/>是 </label>
            <label><input name="administrator" type="radio" value="0" checked="checked"/>否 </label>
        </div>
        <br/>
        <div>
            <button class="i-button" onclick="subForm();">保存</button>
        </div>
    </form>
</div>
</body>

</html>
<script>
    function subForm() {
        $("#maintainForm").submit();
    }
</script>