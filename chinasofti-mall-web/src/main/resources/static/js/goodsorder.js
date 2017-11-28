var pc; 
//不要放在$(function(){});中
$.parser.onComplete = function () {
    if (pc) clearTimeout(pc);
    pc = setTimeout(closes, 2000);
} 

function closes() {
    $('#loading').fadeOut('normal', function () {
        $(this).remove();
    });
}
/**
 * 主订单条件查询
 */
function mainorderDoSearch() {
	var minTime = $('#mainorder-minPayTime').val();
	var maxTime = $('#mainorder-maxPayTime').val();
	if (minTime > maxTime){
		$.messager.show({
			title:'提示信息',
			msg:'结束时间必须大于开始时间',
			timeout:5000,
			showType:'slide'
		});
	} else {
		$('#mainorderDataGrid').datagrid('load', {
			transactionid : $('#mainorder-transactionid').val(),
			bigorderId : $('#mainorder-bigorderId').val(),
			payStatus : $('#mainorder-payStatus').val(),
			minPayTime : $('#mainorder-minPayTime').val(),
			maxPayTime : $('#mainorder-maxPayTime').val(),
			contName : $('#mainorder-contName').val(),
			payway:$('#mainorder-payway').val(),
			orderStatus:$('#mainorder-status').val(),
			settleTimeFee:$('#mainorder-settleTimeFee').val(),
			vendorIds:$('#mainorder-vendorIds').val()
		});
	}
}

/**
 * 主订单搜索条件清空
 */
function mainorderClearAll() {
	$("#mainorderSearchForm").form("reset");
	$('#mainorderDataGrid').datagrid("load", {});
}

/**
 * 子订单条件查询
 */
function childorderDoSearch() {
	$('#childorderDataGrid').datagrid('load', {
		transactionid : $('#childorder-transactionid').val(),
		mainorderIds : $('#childorder-mainorderIds').val(),
		type:$('#childorder-type').val(),
		orderType : $('#childorder-orderType').val()
	});
}

/**
 * 子订单搜索条件清空
 */
function childorderClearAll() {
	$("#childorderSearchForm").form("reset");
	$('#childorderDataGrid').datagrid("load", {});
}

/**
 * 子操作按钮显示
 */
function btnFormatter(value, row, index) {
	var childorderLookBtn ='<button onclick="childorderLook('+ index +')">查看</button>' 
							+ '<button style="background:#772953" onclick="venderRemark('+ index +')">' 
							+ '<span style="color: #FFFFFF">商户备注</span></button>';
	return childorderLookBtn;
}
/**
 * 子订单详细信息
 */
function childorderLook(index){
	var row = $("#childorderDataGrid").datagrid('getData').rows[index];
	$('#childorderEditDialog').dialog('open').dialog({
		closed : false,
		modal : true,
		title : "订单详细信息"
	});
	$('#childorderEditForm').form('load', row);
}

/**
 * 商户备注
 */
function venderRemark(index){
	var row = $("#childorderDataGrid").datagrid('getData').rows[index];
	$('#venderRemarkEditDialog').dialog('open');
	$('#venderRemarkUpdateForm').form('load', row);
}

/**
 * 商户备注修改提交
 */
function updateVenderRemark(){
	$('#venderRemarkUpdateForm').form('submit',{
		url:'childorder/update',    
	    onSubmit: function(){
	    	
	    },    
	    success:function(){    
	    	$.messager.show({
				title: '系统消息',
				msg: '备注更改成功',
				timeout: 5000,
				showType:'slide'
			});
	    	$("#venderRemarkEditDialog").dialog("close");
			$("#childorderDataGrid").datagrid("load");
	    }
	});
}

/**
 * 打开商户列表
 */
function venderChoose(){
	$('#venderChooseDialog').dialog('open');
}

/**
 * 商户id选择
 */
function venderIdChoose(){
	var row = $("#venderDataGrid").datagrid("getSelected");
	if(row){
		$("#mainorder-vendorIds").textbox('setValue',row.vendorId);
		$("#venderChooseDialog").dialog("close");
	}else{
		$.messager.alert('系统消息','请选择一项进行操作!','info');
	}
}

/**
 * 主订单按钮
 */
function mainBtnFormatter(value, row, index) {
	var lookBtn ='<button style="background:#51A351" onclick="mainorderLook('+ index +')">' 
					+ '<span style="color: #FFFFFF">查看</span></button><br>'
					+ '<button style="background:#772953" onclick="checkChildorder('+ index +')">' 
					+ '<span style="color: #FFFFFF">订单明细</span></button>';
	return lookBtn;
}

/**
 * 主订单查看按钮
 */
function mainorderLook(index){
	var row = $("#mainorderDataGrid").datagrid('getData').rows[index];
	$('#mainorderEditDialog').dialog('open').dialog({
		closed : false,
		modal : true,
		title : "主订单订单信息"
	});
	if(row.afterType != null){
		row.afterType = '是';
	} else {
		row.afterType = '否';
	}
	$('#mainorderEditForm').form('load', row);
}

/**
 * 主订单订单明细按钮
 */
function checkChildorder(index){
	var row = $("#mainorderDataGrid").datagrid('getData').rows[index];
	var mainorderIds = row.transactionid;
	$("#childorder-mainorderIds").textbox('setValue',mainorderIds);
	$('#childorderDataGrid').datagrid('load', {
		mainorderIds : $('#childorder-mainorderIds').val()
	});
}

/**
 * 商户查询
 */
function venderDoSearch() {
	$('#venderDataGrid').datagrid('load', {
		vendorId : $('#vender-vendorId').val(),
		vendorSnm : $('#vender-vendorSnm').val()
	});
}

/**
 * 商户搜索条件清空
 */
function venderClearAll() {
	$("#venderSearchForm").form("reset");
	$('#venderDataGrid').datagrid("load", {});
}

/**
 * 主订单支付状态显示
 */
function payStatusFormatter(value, row, index) {
	if (value == "0") {
		return '<span style="color:red">未支付</span>';
	} else if (value == "1") {
		return '<span>已支付</span>';
	} else {
		return '<span>已取消</span>';
	}
}

/**
 * 主订单支付渠道显示
 */
function paywayFormatter(value, row, index) {
	if (value == "1") {
		return '<span style="color:#61C5FD">微信支付</span>';
	} else if (value == "2") {
		return '<span>支付宝支付</span>';
	} else {
		return '<span></span>';
	}
}

/**
 * 主订单状态显示
 */
function statusFormatter(value, row, index) {
	if (value == "0") {
		return '<span style="color:#E8343B">待付款</span>';
	} else if (value == "1") {
		return '<span style="color:#FF7E00">待发货</span>';
	} else if (value == "2") {
		return '<span>待收货</span>';
	} else if (value == "3") {
		return '<span>交易成功</span>';
	} else if (value == "4") {
		return '<span>交易关闭（已删除）</span>';
	} else if (value == "5") {
		return '<span>交易关闭（已取消）</span>';
	} else {
		return '<span style="color:#0ADA85">交易关闭（退款成功）</span>';
	}
}

/**
 * 主订单清算状态显示
 */
function settleStatuesFormatter(value, row, index) {
	if (value == "0") {
		return '<span style="color:#E8343B">未清算</span>';
	} else if (value == "1") {
		return '<span>清算成功</span>';
	} else if (value == "2") {
		return '<span style="color:#EB4E48">清算失败</span>';
	} else if (value == "3") {
		return '<span style="color:#B984E1">清算中</span>';
	} else if (value == "4") {
		return '<span style="color:#B984E1">手续到中间户进行中</span>';
	} else if (value == "5") {
		return '<span style="color:#B984E1">手续到中间户完成</span>';
	} else if (value == "6") {
		return '<span style="color:#EB4E48">手续到中间户失败</span>';
	} else {
		return '<span style="color:#A5C4EA">无需清算</span>';
	}
}

/**
 * 订单类型显示
 */
function orderTypeFormatter(value, row, index) {
	if (value == "1") {
		return '<span>普通订单</span>';
	} else if (value == "2") {
		return '<span>优惠券订单</span>';
	} else if (value == "3") {
		return '<span>实物众筹</span>';
	} else {
		return '<span></span>';
	}
}

/**
 * 退换货类型显示
 */
function afterTypeFormatter(value, row, index) {
	if (value == "1") {
		return '<span>退货退款</span>';
	} else if (value == "2") {
		return '<span>仅退款</span>';
	} else if (value == "3") {
		return '<span>换货</span>';
	} else {
		return '<span>订单正常</span>';
	}
}

/**
 * 售后状态显示
 */
function approveStatusFormatter(value, row, index) {
	if (value == "0") {
		return '<span>待审核</span>';
	} else if (value == "1") {
		return '<span>审批通过</span>';
	} else if (value == "2") {
		return '<span>审批未通过</span>';
	} else if (value == "3") {
		return '<span>售后成功</span>';
	}else {
		return '<span>未申请售后</span>';
	}
}

/**
 * 主订单导出Excel
 * */
function mainOrderExport(){
	var minTime = $('#mainorder-minPayTime').val();
	var maxTime = $('#mainorder-maxPayTime').val();
	minTime = minTime.replace(new RegExp("-","gm"),"/");
	var startTimeHaoMiao = (new Date(minTime)).getTime(); //得到毫秒数
	maxTime = maxTime.replace(new RegExp("-","gm"),"/");
	var endTimeHaoMiao =(new Date(maxTime)).getTime(); //得到毫秒数
	if (minTime > maxTime){
		$.messager.alert('系统消息','结束时间必须大于开始时间!','info');
	} else if(minTime == ''){
		$.messager.alert('系统消息','请选择订单开始时间!','info');
	}else if((endTimeHaoMiao-startTimeHaoMiao) > 7948827000){
		$.messager.alert('系统消息','查询时间段不能超过3月,请重新选择开始和结束时间!','info');
	}else{
		window.location.href='mainorder/export?model=jxls/mainOrderManage.xls'; 
	}
}

/**
 * 大订单导出Excel
 * */
function bigOrderExport(){
	var minTime = $('#mainorder-minPayTime').val();
	var maxTime = $('#mainorder-maxPayTime').val();
	minTime = minTime.replace(new RegExp("-","gm"),"/");
	var startTimeHaoMiao = (new Date(minTime)).getTime(); //得到毫秒数
	maxTime = maxTime.replace(new RegExp("-","gm"),"/");
	var endTimeHaoMiao =(new Date(maxTime)).getTime(); //得到毫秒数
	if (minTime > maxTime){
		$.messager.alert('系统消息','结束时间必须大于开始时间!','info');
	} else if(minTime == ''){
		$.messager.alert('系统消息','请选择订单开始时间!','info');
	}else if((endTimeHaoMiao-startTimeHaoMiao) > 7948827000){
		$.messager.alert('系统消息','查询时间段不能超过3月,请重新选择开始和结束时间!','info');
	}else{
		window.location.href='mainorder/export?model=jxls/mainOrderManage.xls'; 
	}
}

/**
 * 子订单导出Excel
 * */
function childOrderExport(){
	
	window.location.href='childorder/export?model=jxls/childOrderManage.xls';
}