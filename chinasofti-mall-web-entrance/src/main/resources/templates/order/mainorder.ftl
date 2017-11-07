<script type="text/javascript">

	/**
	*  添加订单记录
	*/
	function add(){
		$('#mainorderAddForm').form('submit', {
			url:'/mainorder/add',
			type:'POST',
			success:function(data){
				if(data){
					$('#mainorderAddDialog').dialog('close');
					$.messager.alert('信息提示','提交成功！','info');
					$('#mainorderDataGrid').datagrid('reload');
				}
				else
				{
					$.messager.alert('信息提示','提交失败！','info');
				}
			}
		});
	}
	
	/**
	*  修改订单记录
	*/
	function edit(){
		$('#mainorderEditForm').form('submit', {
			url:'/mainorder/update',
			type:'POST',
			success:function(data){
				if(data){
					$('#mainorderEditDialog').dialog('close');
					$.messager.alert('信息提示','提交成功！','info');
					$('#mainorderDataGrid').datagrid('reload');
				}
				else
				{
					$.messager.alert('信息提示','提交失败！','info');
				}
			}
		});
	}
	
	/**
	*  删除订单
	*/
	function remove(){
		var items = $('#mainorderDataGrid').datagrid('getSelections');
		var ids = [];
		if(items.length < 1){
			$.messager.alert('信息提示','请选中要删的数据');
			return ;
		}
		$.messager.confirm('信息提示','确定要删除该记录？', function(result){
			if(result){
				$(items).each(function(){
					ids.push(this.ids);	
				});
				$.ajax({
					url:'/mainorder/delete/' + ids,
					type:'GET',
					success:function(data){
						if(data){
							$.messager.alert('信息提示','删除成功！','info');
							$('#mainorderDataGrid').datagrid('reload')
						}
						else
						{
							$.messager.alert('信息提示','删除失败！','info');		
						}
					}	
				});
			}	
		});
	}
	
	/**
	*  打开添加窗口
	*/
	function openAdd(){
		$('#mainorderAddForm').form('clear');
		$('#mainorderAddDialog').dialog({
			closed: false,
			modal:true,
            title: "添加订单信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#mainorderAddDialog').dialog('close');                    
                }
            }]
        });
	}
	
	/**
	* Name 打开修改窗口
	*/
	function openEdit(){
		var row = $("#mainorderDataGrid").datagrid('getSelected');
		if (row) {
			$('#mainorderEditDialog').dialog('open').dialog({
				closed: false,
				modal:true,
	            title: "修改订单信息",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: edit
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#mainorderEditDialog').dialog('close');                    
	                }
	            }]
	        });
			$('#mainorderEditForm').form('load',row);
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}	
	
	
	/* 
	*条件查询
	*/
	function doSearch(){
		$('#mainorderDataGrid').datagrid('load',{
			transactionid:$('#mainorder-transactionid').val(),
			bigorderId:$('#mainorder-bigorderId').val(),
			payStatus:$('#mainorder-payStatus').val(),
			minPayTime:$('#mainorder-minPayTime').val(),
			maxPayTime:$('#mainorder-maxPayTime').val(),
			contName:$('#mainorder-contName').val()
		});
		
	}
	
	/**
	* 清空搜索条件
	*/
	function clearAll(){
		//$("#mainorder-transactionid").textbox('setValue','');
		//$("#mainorder-payStatus").textbox('setValue','请选择');
		$("#mainorderSearchForm").form("reset");
		$('#mainorderDataGrid').datagrid("load", {});
	}
	
	/**
	* 支付状态
	*/
	function payStatusFormatter(value,row,index){
		if(value == "0"){
			return '<span style="color:red">未支付</span>';
		}else if(value == "1"){
			return '<span>已支付</span>';
		}else {
			return '<span>已取消</span>';
		}
	}
	
	/**
	* 订单类型
	*/
	function paywayFormatter(value,row,index){
		if(value == "1"){
			return '<span style="color:#61C5FD">微信订单</span>';
		}else if(value == "2"){
			return '<span>支付宝订单</span>';
		}else {
			return '<span style="color:#E0ECFF">银联订单</span>';
		}
	}
	
	/**
	* 订单状态
	*/
	function statusFormatter(value,row,index){
		if(value == "0"){
			return '<span style="color:#E8343B">已删除</span>';
		}else if(value == "1"){
			return '<span style="color:#FF7E00">未发货</span>';
		}else if(value == "2"){
			return '<span>已发货</span>';
		}else {
			return '<span style="color:#0ADA85">已收货</span>';
		}
	}
	
	/**
	* 清算状态
	*/
	function settleStatuesFormatter(value,row,index){
		if(value == "0"){
			return '<span style="color:#E8343B">未清算</span>';
		}else if(value == "1"){
			return '<span>清算成功</span>';
		}else if(value == "2"){
			return '<span style="color:#EB4E48">清算失败</span>';
		}else if(value == "3"){
			return '<span style="color:#B984E1">清算中</span>';
		}else if(value == "4"){
			return '<span style="color:#B984E1">手续到中间户进行中</span>';
		}else if(value == "5"){
			return '<span style="color:#B984E1">手续到中间户完成</span>';
		}else if(value == "6"){
			return '<span style="color:#EB4E48">手续到中间户失败</span>';
		}else {
			return '<span style="color:#A5C4EA">无需清算</span>';
		}
	}
	
</script>

<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="mainorderToolbar">
        <div class="mainorderoolbarButton">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">主订单添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">主订单修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">主订单删除</a>
        </div>
        
		<form id="mainorderSearchForm" method="post">
			<div align="left">
			<table class="" style="width:95%">
				<tr>
					<td>主订单号：<input class="easyui-textbox" id="mainorder-transactionid" name="transactionid" data-options="height:20,width:160"/></td>
					<td>大订单号：<input class="easyui-textbox" id="mainorder-bigorderId" name="bigorderId" data-options="height:20,width:160"/></td>
					<td>支付开始时间：<input class="easyui-datetimebox" id="mainorder-minPayTime" name="minPayTime" data-options="height:20,width:160,editable:false"/></td>
					<td>支付结束时间：<input class="easyui-datetimebox" id="mainorder-maxPayTime" name="maxPayTime" data-options="height:20,width:160,editable:false"/></td>
				</tr>
				<tr>
					<td>
					支付状态：<select id="mainorder-payStatus" class="easyui-combobox" data-options="height:20,width:160"  name="payStatus">
						    <option value="">请选择</option>
						    <option value="0">未支付</option>   
						    <option value="1">已支付</option>
						    <option value="2">已取消</option>  
						</select>
					</td>
					<td>联系人：<input class="easyui-textbox" id="mainorder-contName" name="contName" data-options="height:20,width:160"/></td>
				</tr>
				<tr>
					<td align="center">
						<a class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="doSearch()">查询</a>&nbsp;&nbsp;
						<a class="easyui-linkbutton" iconCls="icon-edit-clear" plain="true" onclick="clearAll()">清空</a> 
					</td>
				</tr>
			</table>
			</div>
		</form>
    </div>

    <table id="mainorderDataGrid" class="easyui-datagrid" singleSelect="true"
    	data-options="url:'mainorder/list',
    				 fitColumns:true,
       				 pagination:true,
       				 sortName:'ids',
       				 sortOrder:'asc',
       				 toolbar:'#mainorderToolbar',
       				 title:'主订单列表',
       				 iconCls:'icon-man',
       				 striped:true,
       				 collapsible:true,
       				 height:400">
		<thead>
			<tr>
				<th field="transactionid" width="20%" align="center">主订单号</th>
				<th field="bigorderId" width="20%" align="center">大订单号</th>
				<th field="payway" width="8%" align="center" data-options="formatter:paywayFormatter">订单类型</th>
				<th field="vendorIds" width="10%" align="center">商户ID</th>
				<th field="orderTotalAmt" width="8%" align="center">订单总额</th>
				<th field="payStatus" width="5%" align="center" data-options="formatter:payStatusFormatter">支付状态</th>
				<th field="status" width="5%" align="center" data-options="formatter:statusFormatter">订单状态</th>
				<th field="settleStatues" width="8%" align="center" data-options="formatter:settleStatuesFormatter">清算状态</th>
			</tr>
		</thead>
	</table>
	
</div>

<!-- 添加表格 -->
<div id="mainorderAddDialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
	<form id="mainorderAddForm" method="post">
        <table>
        	<tr>
                <td>ID:</td>
                <td><input name="ids" class="easyui-textbox" /></td>
            </tr>
        	<tr>
                <td>大订单编号:</td>
                <td><input name="bigorderId" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>商户编号:</td>
                <td><input name="vendorIds" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>用户编号:</td>
                <td><input name="userIds" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>收件人证件号:</td>
                <td><input name="contIdentityno" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>邮编:</td>
                <td><input name="contPostcode"class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>详细地址:</td>
                <td><input name="contAddress"class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>支付状态:</td>
                <td><input name="payStatus"class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>订单状态:</td>
                <td><input name="status"class="easyui-textbox" /></td>
            </tr>
        </table>
    </form>
</div>
<!-- 修改dialog -->
<div id="mainorderEditDialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
	<form id="mainorderEditForm" method="post">
        <table>
        	<tr>
                <td>ID:</td>
                <td><input name="ids" class="easyui-textbox" readonly="readonly"/></td>
            </tr>
        	<tr>
                <td>大订单编号:</td>
                <td><input name="bigorderId" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>商户编号:</td>
                <td><input name="vendorIds" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>用户编号:</td>
                <td><input name="userIds" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>收件人证件号:</td>
                <td><input name="contIdentityno" class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>邮编:</td>
                <td><input name="contPostcode"class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>详细地址:</td>
                <td><input name="contAddress"class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>支付状态:</td>
                <td><input name="payStatus"class="easyui-textbox" /></td>
            </tr>
            <tr>
                <td>订单状态:</td>
                <td><input name="status"class="easyui-textbox" /></td>
            </tr>
        </table>
    </form>
</div>
<!-- End of easyui-dialog -->
