
//缓冲分类数据
var categoryData ='';
//缓冲广告位名称数据
var adPositonData ='';


// 搜索
function ad_search() {
	$("#ad-datagrid").datagrid("load", {
		'title' : $('#ad_search_title').val(),
		'positionId' : $('#_positionId').val(),
		'type' : $('#ad_search_type').val()
	});
}

// 状态转换
function statesFormatter(value) {
	if (value == "0") {
		return '<span style="color:gray">未展示</span>';
	} else {
		return '<span style="color:blue">已展示</span>';
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
	$('#ad-datagrid').datagrid('load', {sort:''});
	loadAdPosition();
}

function addAdvertise(){
$('#ad-datagrid').datagrid('reload'); 
addAdvertise_();
}

// 添加
function addAdvertise_() {
	$('#ad-edit-dialog').dialog('open').dialog('setTitle', '添加广告');
	$('#ad-edit-form').form('clear');
	$('#ad-edit-form').form('reset');
	loadClassName();
	loadAdPostion();
	// 清空预览图片
	$("#preview").empty();
	url = 'advertise/add';
}
// 编辑
function editAdvertise() {
	$('#ad-edit-form').form('clear');
	var row = $('#ad-datagrid').datagrid('getSelected');
	if (row <= 0) {
		$.messager.alert('提示', '请选择要编辑的条目!');
	}
	if (row.states == 1) {
		$.messager.alert('warning', '该广告已发布，无法修改，请先取消发布！', 'info');
		return;
	}
	$('#ad-edit-dialog').dialog('open').dialog('setTitle', '编辑广告');
	$('#ad-edit-form').form('load', row);
	loadClassName2();
	loadAdPostion2();
	$("#imghead").attr("src", row.imageurl);
	url = 'advertise/update';
}
// 保存
function saveAdvertise() {
	var file = $("#file").val();
	var imgUrl =$("#imgUrl").val();
	if(file == "" && imgUrl ==''){
		console.info($('#imghead')[0]);
		//console.info($('#imghead')[0].src);
		$.messager.alert('温馨提醒','请选择一张图片！','question');
		return false;
	}
	$('#ad-edit-form').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.errorMsg) {
				/*$.messager.show({
					title : 'Error',
					msg : result.errorMsg
				});*/
				errorShow();
			} else {
				$('#ad-edit-dialog').dialog('close'); // close the dialog
				$('#ad-datagrid').datagrid('reload'); // reload the user data
				successShow();
			}
		}
	});
}


// 删除
function deleteAdvertise() {
	var row = $('#ad-datagrid').datagrid('getSelected');

	if (row <= 0) {
		$.messager.alert('提示', '请选择要删除的广告', 'info');
		return;
	}
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
						successShow();
					} else {
						/*$.messager.show({ // show error message
							title : '错误提示',
							msg : result.errorMsg
						});*/
						errorShow();
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
		//alert(JSON.stringify(row));
		$("#showImg").attr("src", row.imageurl);
	}
}

// 图片预览
function previewImage(file) {
	var MAXWIDTH = 235;
	var MAXHEIGHT = 125;
	var div = document.getElementById('preview');
	if (file.files && file.files[0]) {
		if (!/image\/\w+/.test((file.files[0]).type)) {
			var imgfile = document.getElementById('file');
			imgfile.value = null;
			$.messager.alert('信息提示', '请确保文件类型为图像类型', 'info');
			return false;
		}
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

// 加载分类名称
function loadClassName() {
			$('#_className').combobox({
				data : categoryData.rows,
				valueField : 'name',
				textField : 'name'
			})
}
	// 加载分类名称
	function loadClassName2() {
		
//		$.ajax({
//			url : '/goodsCheck/reqGoodsClassName',
//			type : "GET",
//			success : function(data) {
//				data = eval("(" + data + ")");
				$('#_className').combobox({
					valueField : 'name',
					textField : 'name',
					data : categoryData.rows,
					onLoadSuccess : function() { // 加载完成后,设置选中第一项
						var row = $('#ad-datagrid').datagrid('getSelected');
						$('#_className').combobox('select',row.categoryName);
					}
				})
//			}
//		});
	}

//加载添加页面广告位名称
function loadAdPostion(){	
			$('#positionId_').combobox({
				data : adPositonData,
				valueField : 'ids',
				textField : 'name',
			});
}

//加载修改页面广告位名称
function loadAdPostion2(){	
//	$.ajax({
//		url : '/advertise/findAdPostionAll',
//		dataType : 'json',
//		success : function(jsonstr) {
			$('#positionId_').combobox({
				data : adPositonData,
				valueField : 'ids',
				textField : 'name',
				onLoadSuccess : function() { // 加载完成后,设置默认选中
					var row = $('#ad-datagrid').datagrid('getSelected');
					$('#positionId_').combobox('select',row.positionId);
				}
			});
//		}
//	});
	
}

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



$(function() {
	// 加载搜索框广告位名称
	$.ajax({
		url : '/advertise/findAdPostionAll',
		dataType : 'json',
		success : function(jsonstr) {
			jsonstr.unshift({
				'ids' : '',
				'name' : '请选择'
			});// 向json数组开头添加自定义数据
			adPositonData = jsonstr;
			$('#_positionId').combobox({
				data : jsonstr,
				valueField : 'ids',
				textField : 'name',
				onLoadSuccess : function() { // 加载完成后,设置选中第一项
					var val = $(this).combobox('getData');
					for ( var item in val[0]) {
						if (item == 'ids') {
							$(this).combobox('select', val[0][item]);
						}
					}
				}
			});
		}
	});
	
	// 加载分类名称
		$.ajax({
			url : '/goodsCheck/reqGoodsClassName',
			type : "GET",
			success : function(data) {
				data = eval("(" + data + ")");
//				data.rows.unshift({
//					'name' : '',
//					'name' : '请选择'
//				});// 向json数组开头添加自定义数据
				categoryData = data;
			}
		});

	
	
	// 日期验证
	$.extend($.fn.validatebox.defaults.rules, {
		equaldDate : {
			validator : function(value, param) {
				var start = $(param[0]).datetimebox('getValue'); // 获取开始时间
				return value > start; // 有效范围为当前时间大于开始时间
			},
			message : '结束日期应大于开始日期!' // 匹配失败消息
		}
	});
	
	//输入框长度验证
	$.extend($.fn.validatebox.defaults.rules, {    
	    maxLength: {    
	        validator: function(value, param){    
	            return value.length <= param[0];    
	        },    
	        message: '最大只能输入30位！'   
	    }    
	});

});