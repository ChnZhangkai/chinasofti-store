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
	$.messager.progress({
		text:'数据正在加载中'
	});
};

//调用方法
function getData(pageNumber, pageSize, tableID, pageId, url) {
	$.ajax({
		type : 'POST',
		url : url, // 用户请求数据的URL
		data : "pageNumber=" + pageNumber + "&pageSize=" + pageSize ,
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("数据加载失败,请刷新页面");
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
