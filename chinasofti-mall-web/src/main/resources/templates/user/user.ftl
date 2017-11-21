<script type="text/javascript" src="js/common.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="user-toolbar-2">
        <div class="user-toolbar-search">
        	<form id="searchPtUserForm" style="margin: 0px">
	            <label>账号:</label> 
				<input type="text" id="username" name="username" class="easyui-textbox"/>
				<label>姓名:</label>
				<input type="text" id="usernames" name="usernames" class="easyui-textbox"/>
				<label>状态</label> <select id="status" name="status" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 125px">
										<option value=""  selected="selected">请选择</option>
										<option value="0" >禁用</option>
										<option value="1">启用</option>
									</select>
	          	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">开始检索</a>
			    <a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="doClear()">清除</a>
		    </form>
        </div>
        <div class="user-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-key-go" onclick="resetPw()" plain="true">重置密码</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="print()" plain="true">导出</a>
        </div>
    </div>
    
    <!-- 显示数据,数据表格列对齐 -->
    <table id="ptUser" class="easyui-datagrid" title="用户列表" toolbar="#user-toolbar-2" style="height: 95%">
    	<thead>
    		<tr>
    			<th field="ids" width="20%" align="center">用户编号</th>
				<th field="username" width="15%" align="center" >账号</th>
				<th field="usernames" width="15%" align="center" >姓名</th>
				<th field="departmentids" width="20%" align="center">部门编号</th>
				<th field="departmentnames" width="15%" align="center">部门名字</th>
				<th field="status" width="15%" align="center" data-options="formatter:statesFormatter">状态</th>			
    		</tr>
    	</thead>
    </table>
    <!-- 分页工具条 -->
	<div id="pagination" style="background:#efefef;border:1px solid #ccc;"></div>
</div>

<!-- 内管用户添加表格 -->
<div id="ptUserAdd" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-add',inline:true"
	style="width: 300px; padding: 10px;">
	<form id="ptUserAddForm" method="post" enctype="multipart/form-data">
		<table id="add">
			<tr>
				<td width="80" align="right">账号:</td>
				<td><input type="text" id="username" name="username" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">密码:</td>
				<td><input type="text" id="password" name="password" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">姓名:</td>
				<td><input type="text" id="usernames" name="errorcounts" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">部门编号:</td>
				<td><input type="text" id="departmentids" name="departmentids" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">部门名称:</td>
				<td><input type="text" id="departmentnames" name="departmentnames" class="easyui-textbox" /></td>
			</tr>
			<tr>
			<td align="right">状态:</td>
				<td><select class="easyui-combobox" missingMessage="请选择" data-options="editable:false,panelHeight:'auto'" id="status" name="status" style="width: 75px">
							<option value="0" selected="selected">禁用</option>
							<option value="1">启用</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
</div>

<!-- 修改表格 -->
<div id="user-dialog-3" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-save',inline:true"
	style="width: 300px; padding: 10px;">
	<form id="user-form-3" method="post">
		<table id="update">
			<tr>
				<td width="80" align="right">用户编号:</td>
				<td><input type="text" id="ids" name="ids" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">用户账号:</td>
				<td><input type="text" id="username" name="username" class="easyui-textbox" />
				</td>		
			</tr>
			<tr>
				<td align="right">用户姓名:</td>
				<td><input type="text" id="usernames" name="usernames" class="easyui-textbox" />
				</td>		
			</tr>
			<tr>
				<td align="right">部门编号:</td>				
				<td><input type="text" id="departmentids" name="departmentids" class="easyui-textbox" />					
				</td>				
			</tr>
			<tr>
				<td align="right">部门名字:</td>
				<td><input type="text" id="departmentnames" name="departmentnames" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">状态:</td>
				<td><select class="easyui-combobox" required="true" missingMessage="请选择" data-options="editable:false,panelHeight:'auto'" id="status" name="status" style="width: 75px">
							<option value="0">未开启</option>
							<option value="1">已启用</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
	$(function(){
		//获取表格datagrid的ID属性,
		var tableID = "ptUser";
		//获取分页工具条元素
		var pageId = $('#pagination');
		//此处设置自己的url地址
		var url = '/user/list';
		//分页查询时传递查询条件
		seachId = '#searchPtUserForm';
		//调用初始化方法	
		tdload(tableID, pageId, url);
		
		$.messager.progress({
			text:'数据正在加载中'
		});
		
	});
	
	/*
	 * 分类状态
	 */
	function statesFormatter(value){
		if(value == "0"){
			return '<span style="color:red">禁用</span>';
		}else{
			return '<span style="color:green">启用</span>';
		}
	}
	
	function imgFormatter(value,row){
		//alert(123)
		var str = "";
		if(value != "" || value != null){
			str = "<img style=\"height: 80px;width: 150px;\" src=\""+value+"\"/>";
	        return str;
		}
	}
	
	function choose1(){
		var str="";
		
	}
	
	/**
	* Name 打开添加窗口
	*/
	function openAdd(){
		$('#ptUserAddForm').form('clear');
		$('#ptUserAdd').dialog({
			closed: false,
			modal:true,
	        title: "新增用户",
	        buttons: [{
	            text: '确定',
	            iconCls: 'icon-ok',
	            handler: add
	        }, {
	            text: '取消',
	            iconCls: 'icon-cancel',
	            handler: function () {
	                $('#ptUserAdd').dialog('close');                    
	            }
	        }]
	    });
	}

	/**
	* Name 添加记录
	*/
	function add(){
		
		$('#ptUserAddForm').form('submit', {
			url:'/user/add',
			type:'POST',
			success:function(data){
				if(data > 0){
					$('#pagination').pagination('select');
					$('#user-dialog-2').dialog('close');
					$.messager.alert('信息提示','提交成功！','info');
				}
				else
				{
					$.messager.alert('信息提示','提交失败！','info');
				}
			}
		});
	
		
	}
	
	
	/**
	* Name 删除记录
	*/
	function remove(){
	
		var items = $('#ptUser').datagrid('getSelections');
		var ids = [];
		
		/*alert(JSON.stringify(items));*/
		
		
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中要删的数据');
			return ;
		}
	
		$.messager.confirm('信息提示','确定要删除该记录？', function(result){
			if(result){
				$(items).each(function(){
					ids.push(this.ids);	
				});
				/*alert(ids);*/
				$.ajax({
					url:'/user/delete/' + ids,
					type:'POST',
					success:function(data){
						if(data){
							$.messager.alert('信息提示','删除成功！','info');
							//$('#tt-userinfo').datagrid('reload')
							$('#pagination').pagination('select');
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
	* Name 打开修改窗口
	*/
	function openEdit(){
		var row = $("#ptUser").datagrid('getSelected');
		if (row) {
			//alert(JSON.stringify(row));
			$('#user-dialog-3').dialog('open').dialog({
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
	                    $('#user-dialog-3').dialog('close');                    
	                }
	            }]
	        });
			$('#user-form-3').form('load',row);
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/*
	*修改
	*/
	function edit(){
		$('#user-form-3').form('submit', {
			url:'/user/update',
    		type:'POST',
    		data:$('#user-form-3').serialize(),
    		success:function(data){
    			if(data > 0){
    				$.messager.alert('信息提示','提交成功！','info');
    				$('#user-dialog-3').dialog('close');
    				$('#pagination').pagination('select');
    			}else{
    				$.messager.alert('信息提示','提交失败！','info');
    			}
    		}
    	});
	}
	
	/* 
	*查询
	*/
	function doSearch(){
		var param = $.param({'pageNumber':1,'pageSize':10}) + '&' + $('#searchPtUserForm').serialize();
		$.ajax({ 
	          type: 'POST', 
	          url: '/user/list', //用户请求数据的URL
	          data: param,
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert(textStatus); 
	          }, 
	          success: function (data) { 
				data =eval("("+data+")");
	        	if(data.total == 0){
	        		$.messager.alert('信息提示','</br>未检索到数据！请检查查询条件','info');
	        	}
	              $('#ptUser').datagrid('loadData', data.rows);
	               $('#pagination').pagination({ 
			    	  total:data.total
			    	  });
	          }
	       });
	}
	
	/*
	*清除搜索框内容
	*/
	function doClear(){
		$('#searchPtUserForm').form('reset');
	}
		
</script>
