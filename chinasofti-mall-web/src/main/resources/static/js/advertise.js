// 搜索
function ad_search() {
	$("#ad-datagrid").datagrid("load", {
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
		return '<span style="color:blue">已显示</span>';
	}
}

// 广告类型转换
function typeFormatter(value) {
	if (value == "0") {
		return '<span style="color:gray">备用</span>';
	} else {
		return '<span style="color:blue">正常</span>';
	}
}
// 操作栏
function OperatorFormatter(value, row, index) {
	if (row.states == 0) {
		return '<button id="publicButton" style="color:blue" onclick="publicAdvertise(\''
				+ row.ids + '\',\'' + row.states + '\')">发布广告</button>';
	} else {
		return '<button style="color:gray" class="easyui-linkbutton" onclick="cancleAdvertise(\''
				+ row.ids + '\',\'' + row.states + '\')">取消发布广告</button>';
	}
}

// 广告发布
function publicAdvertise(id, states) {

	$.messager.confirm('操作确认', '确定要发布广告吗?', function(r) {
		if (r) {
			$.post("advertise/pubOrCanAdvertise", {
				ids : id,
				states : states
			}, function(data) {
				$('#ad-datagrid').datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '发布成功',
					showType : 'slide'
				});
			});
		}
	});
}

// 取消发布广告
function cancleAdvertise(id, states) {
	$.messager.confirm('操作确认', '确定要取消发布广告吗?', function(r) {
		if (r) {
			$.post("advertise/pubOrCanAdvertise", {
				ids : id,
				states : states
			}, function(data) {
				$('#ad-datagrid').datagrid('reload');
				$.messager.show({
					title : '提示',
					msg : '已取消发布',
					showType : 'slide'
				});
			});
		}
	});
}

// 清空搜索框
function ad_clear() {
	$("#searchForm").form('reset');
	$('#ad-datagrid').datagrid('load', {});
}

// 添加
function addAdvertise() {
	$('#ad-edit-dialog').dialog('open').dialog('setTitle', '添加广告');
	$('#ad-edit-form').form('clear');
	loadClassName();
	// 清空预览图片
	$("#preview").empty();
	url = 'advertise/add';
}
// 编辑
function editAdvertise() {
	$('#ad-edit-form').form('clear');
	loadClassName();
	var row = $('#ad-datagrid').datagrid('getSelected');
	if (row <= 0) {
		$.messager.alert('提示', '请选择要编辑的条目!');
	} else {
		$('#ad-edit-dialog').dialog('open').dialog('setTitle', '编辑广告');
		$('#ad-edit-form').form('load', row);
		$("#imghead").attr("src", row.imageurl);
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

	if (row.states == 1) {
		$.messager.alert('warning', '该广告已发布，无法删除，请先取消发布！', 'info');
		return;
	} else {
		$.messager.confirm('操作确认', '确定要删除此条广告吗？', function(r) {
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

// 广告查看
function showAdvertise() {
	var row = $('#ad-datagrid').datagrid('getSelected');
	if (row <= 0) {
		$.messager.alert('提示', '请选择查看的条目!');
	} else {
		$('#ad-show-dialog').dialog('open').dialog('setTitle', '广告查看');
		$('#ad-show-form').form('load', row);
		$("#showImg").attr("src", row.imageurl);
	}
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

//加载分类名称
function loadClassName() {
	$.ajax({
		url : '/goodsCheck/reqGoodsClassName',
		type : "GET",
		success : function(data) {
			data = eval("(" + data + ")");
			$('#_className').combobox({
				valueField : 'ids',
				textField : 'name',
				data : data.rows,
			})
		}
	});
}