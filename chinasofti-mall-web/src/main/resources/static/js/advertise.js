//$(function() {
//	// 获取表格datagrid的ID属性
//	var tableID = $("table.easyui-datagrid").attr("id");
//	// alert(tableID);
//	// 获取分页工具条元素
//	var pageId = $('#pagination');
//
//	// 此处设置自己的url地址
//	var url = '/advertise/findByPage';
//
//	tdload(tableID, pageId, url);
//});

// 图片转换
/*
 * function imgFormatter(value,row){ //alert(123) var str = ""; if(value != "" ||
 * value != null){ str = "<img style=\"height: 80px;width: 150px;\"
 * src=\""+value+"\"/>"; return str; } }
 */
// 搜索
//function ad_search() {
//	$.ajax({
//		type : 'POST',
//		url : '/advertise/findByPage', // 用户请求数据的URL
//		data : {
//			'title' : $('#ad_search_title').val(),
//			'positionId' : $('#ad_search_position').val(),
//			'type' : $('#ad_search_type').val()
//		},
//		error : function(XMLHttpRequest, textStatus, errorThrown) {
//			alert(textStatus);
//		},
//		success : function(data) {
//			data = eval("(" + data + ")");
//			$('#ad-datagrid').datagrid('loadData', data.rows);
//			$('#pagination').pagination({
//				total : data.total
//			});
//		}
//	});
//}

function ad_search() {
	$("#ad-datagrid").datagrid("load",{
		'title' : $('#ad_search_title').val(),
		'positionId' : $('#ad_search_position').val(),
		'type' : $('#ad_search_type').val()
	});
}



// 状态转换
function statesFormatter(value) {
	if (value == "0") {
		return '<span style="color:gray">未显示</span>';
	} else {
		return '<span>已显示</span>';
	}
}

// 广告类型转换
function typeFormatter(value) {
	if (value == "0") {
		return '<span style="color:gray">备用</span>';
	} else {
		return '<span >正常</span>';
	}
}
//图片转换
function imgFormatter(value,row){
	var str = "";
	if(value != "" || value != null){
		str = "<img style=\"height: 80px;width: 117px;\" src=\""+value+"\"/>";
        return str;
	}
}

// 清空搜索框
function ad_clear() {
//	$("#ad_search_title").val("");
//	$("#ad_search_type").val("");
//	$("#ad_search_position").val("");
	$("#searchForm").form('reset');
	$('#ad-datagrid').datagrid('load',{});
}

// 添加
function addAdvertise() {
	$('#ad-edit-dialog').dialog('open').dialog('setTitle', '添加广告');
	$('#ad-edit-form').form('clear');
	url = 'advertise/add';
}
// 编辑
function editAdvertise() {
	$('#ad-edit-form').form('clear');
	var row = $('#ad-datagrid').datagrid('getSelected');
	if (row <= 0) {
		$.messager.alert('提示', '请选择要编辑的条目!');
	} else {
		$('#ad-edit-dialog').dialog('open').dialog('setTitle', '编辑广告');
		$('#ad-edit-form').form('load', row);
		url = 'advertise/update';
	}
}
// 保存
function saveAdvertise() {
	$('#ad-edit-form').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.errorMsg) {
				$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});
			} else {
				$('#ad-edit-dialog').dialog('close'); // close the dialog
				$('#ad-datagrid').datagrid('reload'); // reload the user data
			}
		}
	});
}
// 删除
function deleteAdvertise() {
	var row = $('#ad-datagrid').datagrid('getSelected');
	debugger
	if (row) {
		$.messager.confirm('Confirm', '确定要删除此条广告吗？', function(r) {
			if (r) {
				$.post('advertise/deleteById', {
					id : row.ids
				}, function(result) {
					if (result.success) {
						$('#ad-datagrid').datagrid('reload');
					} else {
						$.messager.show({ // show error message
							title : '错误提示',
							msg : result.errorMsg
						});
					}
				}, 'json');
			}
		});
	}
}
//广告查看
function showAdvertise() {
	var row = $('#ad-datagrid').datagrid('getSelected');
	if (row <= 0) {
		$.messager.alert('提示', '请选择查看的条目!');
	} else {
		$('#ad-show-dialog').dialog('open').dialog('setTitle', '广告查看');
		$('#ad-show-form').form('load', row);
		$("#showImg").attr("src",row.imageurl);
	}
}
//广告发布
function showAdvertise(){
	
}
// 图片预览
function previewImage(file) {
	var MAXWIDTH = 235;
	var MAXHEIGHT = 125;
	var div = document.getElementById('preview');
	if (file.files && file.files[0]) {
		div.innerHTML = '<img style="max-width:235px;max-height:125px;width:135;height:75" id=imghead>';
		var img = document.getElementById('imghead');
		img.onload = function() {
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			img.width = rect.width;
			img.height = rect.height;
			// img.style.marginLeft = rect.left+'px';
			// img.style.marginTop = rect.top+'px';
		}
		var reader = new FileReader();
		reader.onload = function(evt) {
			img.src = evt.target.result;
		}
		reader.readAsDataURL(file.files[0]);
	} else {
		var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
		file.select();
		var src = document.selection.createRange().text;
		div.innerHTML = '<img style="max-width:235px;max-height:125px;width:135;height:75" id=imghead>';
		var img = document.getElementById('imghead');
		img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
		var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
				img.offsetHeight);
		status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width + ',' + rect.height);
		div.innerHTML = "<div id=divhead style='width:" + rect.width
				+ "px;height:" + rect.height + "px;" + sFilter + src
				+ "\"'></div>";
	}

	var tpwarnobj = document.getElementById('tpwanrInfo');
	tpwarnobj.innerText = "上传的预览图片如下：";
}