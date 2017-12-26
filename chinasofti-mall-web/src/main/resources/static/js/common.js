//$(function(){
//	
//	$('#mainDiv').panel({
//		 width:350,    
//		 height:250,    
//		 title: '日程安排',
//		 content:'<div id="cc" class="easyui-calendar" style="width:280px;height:180px;"></div>',
//		 tools: [{    
//		    iconCls:'icon-add',    
//		    handler:function(){alert('暂未实现')}    
//		 }]
//	});
//
//	
//})



























//搜索条件formid
var seachId = "";
//加载方法
function tdload(tableID, pageId, url){
	$('#' + tableID).datagrid({
		nowrap : true,
		striped : true,
		collapsible : true,
		border : true,
		showFooter : true,
		rownumbers : false,
		fitColumns : false,
		singleSelect : true,
		//fit:true,
	})
	getData(1,10,tableID,pageId,url)
	
};

//调用方法
function getData(pageNumber, pageSize, tableID, pageId, url) {
	var conditions = $(seachId).serialize();
	$.ajax({
		type : 'POST',
		url : url, // 用户请求数据的URL
		data : "pageNumber=" + pageNumber + "&pageSize=" + pageSize + "&" + conditions,
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			$.messager.confirm('温馨提醒', '数据加载异常,点击确定刷新页面.', function(r){
				if (r){
				    // 刷新操作
					window.document.location.reload();
				}
			});
		},
		success : function(data) {
			$.messager.progress('close');
			data = eval("(" + data + ")");
			$('#' + tableID).datagrid('loadData', data.rows);
			$(pageId).pagination({
				total:data.total,
				onSelectPage : function(pageNumber, pageSize) {
					getData(pageNumber, pageSize,tableID, pageId, url);
				},
				onChangePageSize : function(pageNumber, pageSizel) {
					getData(pageNumber, pageSize,tableID, pageId, url);
				},
				onRefresh : function(pageNumber, pageSize) {
					getData(pageNumber, pageSize,tableID, pageId, url);
				}
			});
		}
	});
};

function successShow(){
	$.messager.show({
		title:'提示',
		msg:'<font style="color:green">操作成功</font>',
		showType:'slide',
		timeout:3000,
	});
}

function errorShow(){
	$.messager.show({
		title:'提示',
		msg:'<font style="color:red">操作失败</font>',
		showType:'slide',
		timeout:3000,
	});
}

