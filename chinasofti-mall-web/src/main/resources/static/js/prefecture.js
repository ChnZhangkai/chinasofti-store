/*
 * 全局加载数据
 */
$(function() {
	//商品分类选择窗口
	$('#ClassTreeDlg').dialog({
		title: '菜单树',//窗口标题
		width: 400,//窗口宽度
		height: 300,//窗口高度
		closed: true,//窗口是是否为关闭状态, true：表示关闭
		modal: true,//模式窗口
		resizable:true,
	});
	$('#prefecture-datagrid').datagrid({
		onLoadSuccess:function(){
			$('#prefecture-datagrid').datagrid('selectRow',0)
			row = $('#prefecture-datagrid').datagrid('getSelected');
			$('#goodsList').datagrid('load', {
				ids : row.ids,
			});
		}
	});
});
var states;
var name;
//专区商品添加
function menuView2(value, row, index) {
	var lookBtn ='<button style="background:#51A351" onclick="menuView(\''+ row.ids + '\')">' 
	+ '<span style="color: #FFFFFF">商品添加</span></button>';
	states = row.states;
	name = row.name;
	return lookBtn;
}	
//删除商品
function mainBtnFormatter(value, row, index) {
	var lookBtn1 ='<button style="background:#51A351" onclick="goodsDelete(\''+ row.ids + '\')">' 
	+ '<span style="color: #FFFFFF">商品删除</span></button>';
	return lookBtn1;
}	
/*
 * 读取路径显示图片
 */
function imgFormatter(value, row) {
	var str1 = row.img;
	str = "<img style=\"height: 75px;width: 110px;\" src=\""+ str1 +"\"/>";
	return str;
}
/*
 * 商品状态
 */
function statesFormatter(value) {
	if (value == "0") {
		return '<span style="color:black">已删除</span>';
	} 
	if (value == "1"){
		return '<span style="color:green">已上架</span>';
	} 
	if (value == "2"){
		return '<span style="color:red">已下架</span>';
	}
}
/**
 * 删除专区
 */
function remove(){
	var items = $('#prefecture-datagrid').datagrid('getSelections');
	var ids = [];
	
	if(items.length < 1){
		$.messager.alert('温馨提示','请选中要删的数据');
		return ;
	}
	$.messager.confirm('信息提示','确定要删除该纪录?',function(result){
		if(result){
			$(items).each(function(){
				ids.push(this.ids);
			});
			$.ajax({
				url:'/prefecture/delete/' + ids,
				type:'POST',
				success:function(data){
					if(data){
						$.messager.alert('信息提示','删除成功!','info');
						$('#prefecture-datagrid').datagrid('reload');
						showGoods();
					}else{
						$.messager.alert('信息提示','删除失败','info');
					}
				}
			});
		}
	});
}
/**
 * 打开添加窗口
 */
function openAdd(){
	$('#addForm').form('clear');
	$('#prefectureAddDialog').dialog({
		closed:false,
		closable:false,
		modal:true,
		title:"添加专区",
		buttons:[{
			text:'确定',
			iconCls:'icon-ok',
			handler:add
		},{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				$('#prefectureAddDialog').dialog('close');
				$('#addForm').form('clear');
				document.getElementById("showpic").innerHTML = "";
			}
		}]
	});
}
/**
 * 添加纪录
 */
function add(){
	$('#addForm').form('submit',{
		url:'/prefecture/save',
		type:'POST',
		success:function(data){
			if(data > 0){
				$('#prefecture-datagrid').datagrid('reload');
				$('#prefectureAddDialog').dialog('close');
				document.getElementById("showpic").innerHTML = "";
				$.messager.alert('信息提示','提交成功！','info');
			}else{
				$.messager.alert('信息提示','提交失败！','info');
			}
		}
	});
}
/**
 * 打开修改窗口
 */
function openEdit(){
	$('#updateForm').form('clear');
	var row = $('#prefecture-datagrid').datagrid('getSelected');
	if(row){
		$('#prefectureDialog').dialog('open').dialog({
			closed:false,
			modal:true,
			closable:false,
			title: "修改专区",
			buttons:[{
				text:'确定',
				iconCls:'icon-ok',
				handler:edit
			},{
				text:'取消',
				iconCls:'icon-cancel',
				handler:function(){
					$('#prefectureDialog').dialog('close');
					document.getElementById("showpic").innerHTML = "";
				}
			}]
		});
		$('#updateForm').form('load',row);
	}else{
		$.messager.alert('信息提示','请选中要修改的数据');
	}
}
/**
 *修改
 */
function edit(){
	$('#updateForm').form('submit',{
		url:'/prefecture/update',
		type:'POST',
		data:$('#updateForm').serialize(),
		success:function(data){
			if(data > 0){
				$.messager.alert('信息提示','提交成功！','info');
				$('#prefecture-datagrid').datagrid('reload');
				$('#prefectureDialog').dialog('close');
			}else{
				$.messager.alert('信息提示','提交失败！','info');
			}
		}
	});
}
/**
 *上传图片回显
 */
function readPicture() {
	// 检查是否为图像类型
	var simpleFile = document.getElementById("img").files[0];
	if (!/image\/\w+/.test(simpleFile.type)) {
		$.messager.alert('信息提示','请确保文件类型为图像类型','info')
		return false;
	}
	var reader = new FileReader();
	// 将文件以二进制文件读入页面中
	reader.readAsBinaryString(simpleFile);
	reader.onload = function(f) {
		var result = document.getElementById("showpic");
		var src = "data:" + simpleFile.type + ";base64," + window.btoa(this.result);
		result.innerHTML = '<img id="readPic" style="height: 80px;width: 117px;" src ="' + src + '"/>';
	}
}

	function updatePicture() {
	// 检查是否为图像类型
	var simpleFile = document.getElementById("uimg").files[0];
	if (!/image\/\w+/.test(simpleFile.type)) {
		$.messager.alert('信息提示','请确保文件类型为图像类型','info')
		return false;
	}
	var reader = new FileReader();
	// 将文件以二进制文件读入页面中
	reader.readAsBinaryString(simpleFile);
	reader.onload = function(f) {
		var result = document.getElementById("showupic");
		var src = "data:" + simpleFile.type + ";base64," + window.btoa(this.result);
		result.innerHTML = '<img id="readPic" style="height: 80px;width: 117px;" src ="' + src + '"/>';
	}
}
//专区商品
/*function menuView(ids){
	$('#goodsList').datagrid({
		url:'/prefecture/findGoods/' +ids,
		rownumbers:true,
		singleSelect:true,
		pageSize:20,           
		pagination:true,
		multiSort:true,
		fitColumns:true,
		fit:true,
		columns:[[
		          { field:'goodsids',title:'商品编号',width:100,sortable:true},  
		          { field:'title',title:'商品名称',width:100,sortable:true},  
		          { field:'price',title:'商品加个',width:100,sortable:true},  
		          { field:'vendorids',title:'商户名称',width:100,sortable:true},  
		          { field:'vendorids',title:'分类名称',width:100,sortable:true},  
		          { field:'status',title:'上下架状态',width:100,sortable:true},  
		          ]],
	});
	$('#prefectureGoodsDialog').dialog("open");
}*/
var prefectureIds;
function menuView(ids){
	prefectureIds = ids;
	$('#GoodsDialog').dialog("open");
}
function goodsDelete(goodsids){
	$.ajax({
		url : '/prefecture/deleteGoods/' + goodsids,
		type : 'POST',
		success : function(data) {
			if (data == 1) {
				$('#goodsList').datagrid('reload');
				$.messager.alert('信息提示', '删除成功！', 'info');
			} else {
				$.messager.alert('信息提示', '删除失败！', 'info');
			}
		}
});
}
/**
 * 通过专区ids查询商品列表
 */
function showGoods(){
	var row = $('#prefecture-datagrid').datagrid('getSelected');
	$('#goodsList').datagrid('load', {
		ids : row.ids,
	});
} 
/*
 * 商品类型
 */
function typesFormatter(value){
	if(value == "0"){
		return '<span>普通商品</span>';
	}else{
		return '<span style="color:#FF00FF">活动商品</span>';
	}
}

/*
 * 商品状态
 */
function statusFormatter(value) {
	if (value == "0") {
		return '<span style="color:black">已删除</span>';
	} 
	if (value == "1"){
		return '<span style="color:green">已上架</span>';
	} 
	if (value == "2"){
		return '<span style="color:red">已下架</span>';
	}
}
//条件查询
function prefectureGoodOnlineDoSearch(){
	$("#prefectureGoodsOnlineinfo").datagrid("load", {
		'title' : $('#prefectureGoodsOnline-title').val(),
		'name' : $('#prefectureGoodsOnline-name').val(),
		'type':$('#prfectureGoodsOnline-goodsType').val(),
		'status':$('#prefectureGoodsOnline-status').val()
		
	});
}

/*
 *清除查询条件
 */
 function prefectureGoodOnlineDoClear(){
	$('#searchPrefectureGoodsOnlineForm').form('reset');
}

/**
 * 打开商品分类窗口
 */
function goodsClassChoose(){
	//异步请求数据
    $('#ClassTreeDlg').dialog('open');
	$('#classTree').tree({
		url:'/goods/findGoodsClass'
	});
}

/**
 * 商品分类选择
 */
function Choose(){
	var row = $("#classTree").tree('getSelected');
	if(row){ 
		$("#prefectureGoodsOnline-name").textbox('setValue',row.text);	
		$("#ClassTreeDlg").dialog("close");
		$('#classTree').tree('clearSelections');
	}else{
		$.messager.alert('系统消息','请选择一项进行操作!','info');
	}
}
/*
 * 读取路径显示图片
 */
function img1Formatter(value, row) {
	var ids = row.ids;
	var str = "";
	images = $.ajax({url:'/goodsOnline/reqGoodsImgPath/' + ids,type:'POST',async:false});
	str = "<img style=\"height: 75px;width: 110px;\" src=\""+ images.responseText +"\"/>";
	return str;
}
/*
 * 添加商品至专区
 */
function addToPrefecture(){
	var  row= $("#prefectureGoodsOnlineinfo").datagrid("getSelected");
	if(row ==null){
		alert("请选择所需添加的数据！");
		return;
	}
	goodsids = row.ids;
	$.post("/prefecture/addPrefectureGoods", {
		goodsids : goodsids,
		ids : prefectureIds,
		states : states,
		name : name
	}, function(data) {
		showGoods();
		$('#GoodsDialog').dialog('close');
		$.messager.alert('信息提示','添加成功！','info');
	},"json");
}