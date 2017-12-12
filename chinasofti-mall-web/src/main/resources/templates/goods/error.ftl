<script type="text/javascript">
	var time = 5; //时间,秒
		function Redirect() {
		　window.location.href = "login";
		}
	var i = 0;
	function dis() {
	　document.all.s.innerHTML = (time - i) + "秒后跳转回登录页面";
	　i++;
	}
	timer = setInterval('dis()', 1000); //显示时间
	timer = setTimeout('Redirect()', time * 1000); //跳转
</script>

<div style="margin-left: 400px">
	<img style="width: 500px;height: 400px" src="../images/imageNotFound.png">
</div>

<div style="margin-left: 320px">
	<h1>噢噢~，账号不存在或未启用,请检查账号或联系管理员</h1>
</div>

<div style="margin-left: 600px">
	<span id="s"></span>
</div>