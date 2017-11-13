/**
 * 主订单信息查看

function openMainorderCheck() {
	var row = $("#mainorderDataGrid").datagrid('getSelected');
	console.log(row);
	if (row) {
		$('#mainorderEditDialog').dialog('open').dialog({
			closed : false,
			modal : true,
			title : "主订单订单信息"
		});
		$('#mainorderEditForm').form('load', row);
	} else {
		$.messager.alert('信息提示', '请选中要查看的订单');
	}
} */

/**
 * 主订单条件查询
 */
function mainorderDoSearch() {
	$('#mainorderDataGrid').datagrid('load', {
		transactionid : $('#mainorder-transactionid').val(),
		bigorderId : $('#mainorder-bigorderId').val(),
		payStatus : $('#mainorder-payStatus').val(),
		minPayTime : $('#mainorder-minPayTime').val(),
		maxPayTime : $('#mainorder-maxPayTime').val(),
		contName : $('#mainorder-contName').val(),
		payway:$('#mainorder-payway').val()
	});

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
 * 主订单支付类型显示
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
		return '<span style="color:#E8343B">已删除</span>';
	} else if (value == "1") {
		return '<span style="color:#FF7E00">未发货</span>';
	} else if (value == "2") {
		return '<span>已发货</span>';
	} else {
		return '<span style="color:#0ADA85">已收货</span>';
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
 * 子订单信息查看

function openChildorderCheck() {
	var row = $("#childorderDataGrid").datagrid('getSelected');
	console.log(row);
	if (row) {
		$('#childorderEditDialog').dialog('open').dialog({
			closed : false,
			modal : true,
			title : "订单详细信息"
		});
		if(row.orderType == 1){
			row.orderType = "普通订单";
		} else if(row.orderType == 2){
			row.orderType = "优惠券订单";
		} else if(row.orderType == 3){
			row.orderType = "实物众筹订单";
		} else {
			
		}
		$('#childorderEditForm').form('load', row);
	} else {
		$.messager.alert('信息提示', '请选择要查看的订单');
	}
} */

/**
 * 前端排序
 
function childorderSort(a, b) {
	if (a >= b){
		return 1;
	}else {
		return -1;
	}
}*/

/**
 * 子操作按钮显示
 */
function btnFormatter(value, row, index) {
	var childorderLookBtn ='<button onclick="childorderLook('+ index +')">查看</button>' ;
	return childorderLookBtn;
}

function childorderLook(index){
	var row = $("#childorderDataGrid").datagrid('getData').rows[index];
	console.log(row);
	$('#childorderEditDialog').dialog('open').dialog({
		closed : false,
		modal : true,
		title : "订单详细信息"
	});
	/*if(row.orderType == 1){
		row.orderType = "普通订单";
	} else if(row.orderType == 2){
		row.orderType = "优惠券订单";
	} else if(row.orderType == 3){
		row.orderType = "实物众筹订单";
	} else {
		
	}*/
	$('#childorderEditForm').form('load', row);
}

/**
 * 主订单按钮
 */
function mianBtnFormatter(value, row, index) {
	var lookBtn ='<button onclick="mainorderLook('+ index +')">查看</button><br>';
	return lookBtn;
}

/**
 * 主订单详细信息
 */
function mainorderLook(index){
	var row = $("#mainorderDataGrid").datagrid('getData').rows[index];
	console.log(row);
	$('#mainorderEditDialog').dialog('open').dialog({
		closed : false,
		modal : true,
		title : "主订单订单信息"
	});
	$('#mainorderEditForm').form('load', row);
}




