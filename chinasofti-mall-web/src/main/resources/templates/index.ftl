<!DOCTYPE html>
<html>  
	<body>
	<h2>Hello World!</h2>
	    <h1>欢迎光临!${user.username}请选择你的操作:</h1><br>
	    <ul>
	    <@shiro.hasPermission name="add">
	    <li>增加</li>
	    </@shiro.hasPermission>
	    <@shiro.hasPermission name="param_delete"><li>删除</li></@shiro.hasPermission>
	    <@shiro.hasPermission name="update"><li>修改</li></@shiro.hasPermission>
	    <@shiro.hasPermission name="query"><li>查询</li></@shiro.hasPermission>
	    </ul>
	    <a href="/logOut">点我注销</a>
	</body>
</html>