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
			'bigorderId':$('#bigorderId').val(),
			'vendorIds':$('#vendorIds').val()
		});
		
	}
	
	/**
	* 清空搜索条件
	*/
	function clearAll(){
		$("#bigorderId").textbox('setValue');
		$("#vendorIds").textbox('setValue');
		$('#mainorderDataGrid').datagrid("load", {});
	}
	
</script>

<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="mainorderToolbar">
        <div class="mainorderoolbarButton">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
        </div>
        
		<form id="mainorderEditForm" method="post">
			<div align="center">
			<table class="dialog-table" style="width:95%">
				<tr>
					<th>主订单号</th>
					<td><input class="easyui-textbox" name="name" data-options="height:24,width:160"/></td>
					<th>大订单号</th>
					<td><input class="easyui-textbox" name="name" data-options="height:24,width:160"/></td>
				</tr>
				<tr>
					<th>支付开始时间</th>
					<td>
						<input class="easyui-datetimebox" name="minCreateDateTime" data-options="height:24,width:160,editable:false"/>
					</td>
					<th>支付结束时间</th>
					<td>
						<input class="easyui-datetimebox" name="maxCreateDateTime" data-options="height:24,width:160,editable:false"/>
					</td>
				</tr>
				<tr>
					<th>支付状态</th>
					<td>
						<select class="easyui-combobox" data-options="height:24,width:160"  name="gender">
						    <option value="">请选择</option>
						    <option value="0">未支付</option>   
						    <option value="1">已支付</option>
						    <option value="2">已取消</option>  
						</select>
					</td>
					<th>最后修改间</th>
					<td><input class="easyui-textbox" name="name" data-options="height:24,width:160"/></td>
				</tr>
				<tr>
					<td colspan="4" align="left">
						<a class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="doSearch()">查询</a>&nbsp;
						<a class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="clearAll()">清空</a> 
					</td>
				</tr>
			</table>
			</div>
		</form>
    </div>

    <table id="mainorderDataGrid" class="easyui-datagrid" url="/mainorder/list"
		rownumbers="true" pagination="true" singleSelect="false">
		<thead>
			<tr>
				<th field="transactionid" width="20%" align="center">主订单号</th>
				<th field="bigorderId" width="20%" align="center">大订单号</th>
				<th field="orderType" width="8%" align="center">订单类型</th>
				<th field="vendorIds" width="10%" align="center">商户ID</th>
				<th field="orderTotalAmt" width="8%" align="center">订单总额</th>
				<th field="payStatus" width="5%" align="center">支付状态</th>
				<th field="status" width="5%" align="center">物流状态</th>
				<th field="settleStatues" width="8%" align="center">核销状态</th>
				<th field="orderStatues" width="8%" align="center">订单状态</th>
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
