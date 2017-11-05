
function switchMain(){
	window.document.location.reload()
}

function swicthOperationCenter(){
	if($('#user').length>0){
		$('#acc').accordion('remove','用户管理')	
	}
	if($('#merchant').length>0){
		$('#acc').accordion('remove','商户管理')	
	}
	if($('#role').length>0){
		$('#acc').accordion('remove','角色管理')	
	}
	if($('#permission').length>0){
		$('#acc').accordion('remove','权限管理')	
	}
	if($('#parameter').length>0){
		$('#acc').accordion('remove','参数管理')	
	}
	if($('#wechat').length>0){
		$('#acc').accordion('remove','微信管理')	
	}
	$("#acc").accordion('add',{
		id:'goods',
		title:'商品管理',
		content:'<ul class="easyui-tree zk-side-tree">'+
		    	'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" class="easyui-tree zk-side-tree" data-icon="icon-chart-organisation" data-link="/goods/index" iframe="0">商品分类管理</a></li>'+
		        '<li iconCls="icon-check-error"><a href="javascript:void(0)" class="easyui-tree zk-side-tree" data-icon="icon-users" data-link="/goodscheck/index" iframe="0">商品审核管理</a></li>'+
		        '<li iconCls="icon-save"><a href="javascript:void(0)" class="easyui-tree zk-side-tree" data-icon="icon-save" data-link="/goodsonline/index" iframe="0">商品在线管理</a></li></ul>',
		selected:true
	})
	$("#acc").accordion('add',{
		id:'order',
		title:'订单管理',
		content:'<ul class="easyui-tree zk-side-tree">'+
				'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="/mainorder/index" iframe="0">订单在线管理</a></li>'+
		        '<li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html" iframe="0">批量发货管理</a></li>'+
		        '<li iconCls="icon-user-group"><a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">退换订单管理</a></li></ul>',
		selected:false
	})
	$("#acc").accordion('add',{
		id:'advertise',
		title:'广告管理',
		content:'<ul class="easyui-tree zk-side-tree">'+
    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="/advertise/index" iframe="0">广告管理</a></li></ul>',
		selected:false
	})
	addt();
}

function swicthWechatCenter(){
	if($('#user').length>0){
		$('#acc').accordion('remove','用户管理')	
	}
	if($('#merchant').length>0){
		$('#acc').accordion('remove','商户管理')	
	}
	if($('#role').length>0){
		$('#acc').accordion('remove','角色管理')	
	}
	if($('#permission').length>0){
		$('#acc').accordion('remove','权限管理')	
	}
	if($('#parameter').length>0){
		$('#acc').accordion('remove','参数管理')	
	}
	if($('#wechat').length>0){
		$('#acc').accordion('remove','微信管理')	
	}
	if($('#goods').length>0){
		$('#acc').accordion('remove','商品管理')	
	}
	if($('#order').length>0){
		$('#acc').accordion('remove','订单管理')	
	}
	if($('#advertise').length>0){
		$('#acc').accordion('remove','广告管理')	
	}
	$("#acc").accordion('add',{
		title:'微信平台管理',
		content:'<ul class="easyui-tree zk-side-tree">'+
    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" class="easyui-tree zk-side-tree" data-icon="icon-chart-organisation" data-link="/wechat/index" iframe="0">公众号管理</a></li></ul>',
		selected:true
	})
	addt();
}

function addt() {
	$('.zk-side-tree a').bind("click", function() {
		var title = $(this).text();
		var url = $(this).attr('data-link');
		var iconCls = $(this).attr('data-icon');
		var iframe = $(this).attr('iframe') == 1 ? true : false;
		addTab(title, url, iconCls, iframe);
	});
}