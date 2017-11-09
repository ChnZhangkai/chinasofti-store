
$(function(){
	$('#sub').click(function(){
		var username = $('#u').val();
		var password = $('#p').val();
		if(username == null || username == ""){
			$('#tip').html("<font color = 'red' size = '4'>用户名不能为空</font>");
			return;
		}
		if(password == null || password == ""){
			$('#tip').html("<font color = 'red' size = '4'>密码不能为空</font>");
			return;
		}
		
		var formdata = {"username":username,"password":password};
		
		$.ajax({
			url:'checkuser',
			data:formdata,
			type:'post',
			success:function(data){
				if(data == 200){
					window.location.href = "main";
				}else {
					$('#tip').html("<font color = 'red' size = '4'>用户名或密码错误</font>");
				}
			}
		})
	})
})