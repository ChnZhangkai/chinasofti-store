/*
 * 左侧菜单初始化
 * */
$(function(){
	if($('#wechat').length>0){
		$('#acc').accordion('remove','微信平台管理')	
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
	
	if($('#user').length<=0){
		$("#acc").accordion('add',{
			id:'user',
			title:'用户管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="user/user" iframe="0">用户管理</a></li></ul>',
			selected:true
		})
	}
	if($('#merchant').length<=0){
		$("#acc").accordion('add',{
			id:'merchant',
			title:'商户管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">商户管理</a></ul>',
			selected:false
		})
	}
	if($('#role').length<=0){
		$("#acc").accordion('add',{
			id:'role',
			title:'角色管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">角色管理</a></ul>',
			selected:false
		})
	}
	if($('#permission').length<=0){
		$("#acc").accordion('add',{
			id:'permission',
			title:'权限管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">权限管理</a></ul>',
			selected:false
		})
	}
	if($('#parameter').length<=0){
		$("#acc").accordion('add',{
			id:'parameter',
			title:'参数管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">参数管理</a></ul>',
			selected:false
		})
	}
	addt();
	//window.document.location.reload()
})

/*
 * 切换到基础平台
 * */
function switchMain(){
	if($('#wechat').length>0){
		$('#acc').accordion('remove','微信平台管理')	
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
	
	if($('#user').length<=0){
		$("#acc").accordion('add',{
			id:'user',
			title:'用户管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="user/user" iframe="0">用户管理</a></li></ul>',
			selected:true
		})
	}
	if($('#merchant').length<=0){
		$("#acc").accordion('add',{
			id:'merchant',
			title:'商户管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">商户管理</a></ul>',
			selected:false
		})
	}
	if($('#role').length<=0){
		$("#acc").accordion('add',{
			id:'role',
			title:'角色管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">角色管理</a></ul>',
			selected:false
		})
	}
	if($('#permission').length<=0){
		$("#acc").accordion('add',{
			id:'permission',
			title:'权限管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">权限管理</a></ul>',
			selected:false
		})
	}
	if($('#parameter').length<=0){
		$("#acc").accordion('add',{
			id:'parameter',
			title:'参数管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">参数管理</a></ul>',
			selected:false
		})
	}
	addt();
	//window.document.location.reload()
}

/*
 * 切换到数据中心
 * */
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
		$('#acc').accordion('remove','微信平台管理')	
	}
	
	if($('#goods').length<=0){
		$("#acc").accordion('add',{
			id:'goods',
			title:'商品管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
			    	'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" class="easyui-tree zk-side-tree" data-icon="icon-chart-organisation" data-link="/goods/index" iframe="0">商品分类管理</a></li>'+
			        '<li iconCls="icon-check-error"><a href="javascript:void(0)" class="easyui-tree zk-side-tree" data-icon="icon-users" data-link="/goodscheck/index" iframe="0">商品审核管理</a></li>'+
			        '<li iconCls="icon-chart-line"><a href="javascript:void(0)" class="easyui-tree zk-side-tree" data-icon="icon-save" data-link="/goodsonline/index" iframe="0">商品在线管理</a></li></ul>',
			selected:true
		})
	}
	if($('#order').length<=0){
		$("#acc").accordion('add',{
			id:'order',
			title:'订单管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
					'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="/mainorder/index" iframe="0">订单在线管理</a></li>'+
			        '<li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html" iframe="0">批量发货管理</a></li>'+
			        '<li iconCls="icon-user-group"><a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">退换订单管理</a></li></ul>',
			selected:false
		})
	}
	if($('#advertise').length<=0){
		$("#acc").accordion('add',{
			id:'advertise',
			title:'广告管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="/advertise/index" iframe="0">广告管理</a></li></ul>',
			selected:false
		})
	}
	addt();
}

/*
 * 切换到微信平台
 * */
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
	if($('#wechat').length<=0){
		$("#acc").accordion('add',{
			id:'wechat',
			title:'微信平台管理',
			content:'<ul class="easyui-tree zk-side-tree">'+
	    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" class="easyui-tree zk-side-tree" data-icon="icon-chart-organisation" data-link="/wechat/index" iframe="0">公众号管理</a></li></ul>',
			selected:true
		})
	}
	addt();
}

/*
 * 选中菜单栏，添加tabs，以内嵌ifame形式
 * */
function addt() {
	$('.zk-side-tree a').bind("click", function() {
		var title = $(this).text();
		var url = $(this).attr('data-link');
		var iconCls = $(this).attr('data-icon');
		var iframe = $(this).attr('iframe') == 1 ? true : false;
		addTab(title, url, iconCls, iframe);
	});
}

/**
 * Name 添加菜单选项
 * Param title 名称
 * Param href 链接
 * Param iconCls 图标样式
 * Param iframe 链接跳转方式（true为iframe，false为href）
 */
function addTab(title, href, iconCls, iframe) {
	var tabPanel = $('#zk-tabs');
	if (!tabPanel.tabs('exists', title)) {
		var content = '<iframe scrolling="auto" frameborder="0"  src="'
				+ href + '" style="width:100%;height:100%;"></iframe>';
		if (iframe) {
			tabPanel.tabs('add', {
				title : title,
				content : content,
				iconCls : iconCls,
				fit : true,
				cls : 'pd3',
				closable : true
			});
		} else {
			tabPanel.tabs('add', {
				title : title,
				href : href,
				iconCls : iconCls,
				fit : true,
				cls : 'pd3',
				closable : true
			});
		}
	} else {
		tabPanel.tabs('select', title);
	}
}

/**
* 移除菜单选项
*/
function removeTab(){
	var tabPanel = $('#zk-tabs');
	var tab = tabPanel.tabs('getSelected');
	if (tab){
		var index = tabPanel.tabs('getTabIndex', tab);
		tabPanel.tabs('close', index);
	}
}