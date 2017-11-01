<html>
<head>
<title>客户关系管理系统-用户登录页面</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link rel="stylesheet" type="text/css" href="css/login.css" />
</head>
<body>
<h1>中信信用卡后台管理中心<sup>2017</sup></h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a><span id="tip"></span>
			<!-- <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div> -->
        </div>
    </div>    
  
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    
   	<!--登录-->
      <div class="web_login" id="web_login">
         <div class="login-box">
			<div class="login_form">
				<form  name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">
					<input type="hidden" name="did" value="0"/>
              		<input type="hidden" name="to" value="log"/>
              		
		            <div class="uinArea" id="uinArea">
		                <label class="input-tips" for="u">帐号：</label>
		                <div class="inputOuter" id="uArea">
	                    	<input type="text" id="u" name="username" class="inputstyle"/>
	               		</div>
	                </div>
	                
	                <div class="pwdArea" id="pwdArea">
		               <label class="input-tips" for="p">密码：</label> 
		               <div class="inputOuter" id="pArea">
		                    <input type="password" id="p" name="password" class="inputstyle"/>
		                </div>
	                </div>
               
	                <div style="padding-left:50px;margin-top:20px;">
	                	<input type="button" value="登 录" style="width:150px;" class="button_blue" id="sub"/>
	                </div>
                </form>
           </div>
         </div>
    </div>
    <!--登录end-->
  </div>
    
</div>
<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>
</html>