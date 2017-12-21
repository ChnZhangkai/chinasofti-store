/*
 * 左侧菜单初始化
 * */
/**
 * 主菜单ID 目前只支持二级菜单
 */
var JCMENUPID="000";
var YYMENUPID="001";
var WXMENUPID="002";
$(function(){
	
	$.messager.show({
		title : '提示',
		msg : '欢迎登录中软商城后台管理系统!</br>本次登录时间为:'+ getNowFormatDate(),
	});
	
	/**
	 * 查询基础平台菜单
	 */
	 switchMain();
})
function addMenuAll(pids){
	/**
	 * 查询基础平台菜单
	 */
	 $.ajax({
		  url:'menu/getMenu?pIds='+pids,
		  type:'POST',
		  dataType:'json',
		  data:"",
		  success:function(data){
		   if(data){
			   for ( var index in data) {
				  var menudata=data[index]
				   if($('#'+menudata.ids).length<=0){
					   var childMenu=menudata.childMenu;
					   var childMenuHtml="";
					   for ( var i in childMenu) {
						   childMenuHtml+='<ul class="easyui-tree zk-side-tree">'+
			    			'<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="'+childMenu[i].url+'" iframe="0">'+childMenu[i].menuname+'</a></li></ul>';
					   }
						$("#acc").accordion('add',{
							id:menudata.ids,
							title:menudata.menuname,
							content:childMenuHtml,
							selected:1
						})
					}
			}
				addt();   
		   }else{
		    alert("系统繁忙,请稍候再试");
		   }
		  },
		  error:function(){
		   alert("系统繁忙,请稍候再试");
		  }
		 });
}
/*
 * 切换到基础平台
 * */
function switchMain(){
	removeAll();
	addMenuAll(JCMENUPID);
	
	
}

/*
 * 运营中心
 * */
function swicthOperationCenter(){
	removeAll();
	addMenuAll(YYMENUPID);

}

/*
 * 切换到微信平台
 * */
function swicthWechatCenter(){
	removeAll();
	addMenuAll(WXMENUPID);
}
/**
 * 移除所有菜单
 */
function removeAll(){
	var pnl = $("#acc").accordion("panels");  
    var titles='';  
    if (pnl){  
        $.each(pnl, function(i) {  
            var title = pnl[i].panel("options").title;  
            titles += title+',';  
        })  
    }   
    var arr_title = new Array();   
    arr_title = titles.split(",");  
    for (i=0;i<arr_title.length ;i++ )   
    {   
        if(arr_title[i] != ""){  
            $('#acc').accordion("remove",arr_title[i]);  
        }  
    }  
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

/**
* 获取时间
*/
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}
