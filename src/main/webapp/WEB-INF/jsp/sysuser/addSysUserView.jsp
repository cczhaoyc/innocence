﻿
<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>苏夏未来</title>
</head>
<body style="text-align: center;color: #00B83F">
<div >
    <form id="maintainForm" action="/sys/addSysUser" method="post">
        <div>
            <span>用户名:</span>
            <input id="nickName" type="text" name="nickName" />
        </div>
        <div>
            <span>用户昵称:</span>
            <input id="userName" type="text" name="userName" />
        </div>
        <div>
            <span>密码:</span>
            <input id="password" type="text" name="password" />
        </div>
        <div>
            <span>联系方式:</span>
            <input id="mobile" type="text" name="mobile" />
        </div>
        <div id="administrator">
            <span>是否管理员:</span>
            <label><input name="administrator" type="radio" value="1" />是 </label>
            <label><input name="administrator" type="radio" value="0" checked="checked"/>否 </label>
        </div>
        <div>
            <input id="addSysUser" type="submit" value="保存"/>
        </div>
    </form>
</div>
</body>
</html>