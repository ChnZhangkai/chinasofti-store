<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
<h1>欢迎登录!${user.username }</h1>
    <form action="${pageContext.request.contextPath }/loginUser" method="post">
        用户名：<input type="text" name="username"><br>
      密   码：<input type="password" name="password"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>