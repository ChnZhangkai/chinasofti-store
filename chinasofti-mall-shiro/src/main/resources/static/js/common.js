//加载方法
function tdload(tableID, pageId, url){
	//alert(tableID);
	$('#' + tableID).datagrid({
		title : '信息列表',
//		width : 600,
		nowrap : true,
//		height : 200,
		striped : true,
		collapsible : true,
		border : true,
		showFooter : true,
		pagination : true,
		rownumbers : false,
		fitColumns : false,
		singleSelect : true,
		pageNumber:1,
		pageList:[10,20,30],
		fit:true,
	})
	getData(1,10,tableID,pageId,url)
};

//调用方法
function getData(pageNumber, pageSize, tableID, pageId, url) {
	$.ajax({
		type : 'POST',
		url : '/goods/list', // 用户请求数据的URL
		data : "pageNumber=" + pageNumber + "&pageSize=" + pageSize ,
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(textStatus);
		},
		success : function(data) {
			data = eval("(" + data + ")");
			
//			var total = data.total;
//			alert(total),
			$('#' + tableID).datagrid('loadData', data.rows);
			
			$(pageId).pagination({
				total:data.total,
				onSelectPage : function(pageNumber, pageSize,tableID, pageId, url) {
					getData(pageNumber, pageSize,tableID, pageId, url);
				},
				onChangePageSize : function(pageNumber, pageSize,tableID, pageId, url) {
					getData(pageNumber, pageSize,tableID, pageId, url);
				},
				onRefresh : function(pageNumber, pageSize,tableID, pageId, url) {
					getData(pageNumber, pageSize,tableID, pageId, url);
				}
			});
		}
	});
};
