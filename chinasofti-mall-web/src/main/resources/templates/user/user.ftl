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
        	<@shiro.hasPermission name="user_add">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openUserAdd()" plain="true">添加</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="user_upd">
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="user_del">
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="user_role">
            <a href="#" class="easyui-linkbutton" iconCls="icon-users" onclick="openRole()" plain="true">修改用户角色</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="user_deful_pw">
            <a href="#" class="easyui-linkbutton" iconCls="icon-key-go" onclick="resetPw()" plain="true">重置密码</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="user_query_role">
            <a href="#" class="easyui-linkbutton" iconCls="icon-user-magnify" onclick="queryRole()" plain="true">查看角色</a>
            </@shiro.hasPermission>
        </div>
    </div>
    
    <!-- 显示数据,数据表格列对齐 -->
    <table id="ptUser" class="easyui-datagrid" title="用户列表" data-options="inline:true" toolbar="#user-toolbar-2" style="height: 95%">
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
	style="width: 520px; padding: 10px;">
	<form id="ptUserAddForm" method="post">
		<table id="ptUserAdd" style="margin-top: 12px">
			<tr>
				<td width="80" align="right">账号:</td>
				<td><input type="text" id="username" name="username" class="easyui-textbox" data-options="required:true"/></td>
				<td align="right">密码:</td>
				<td><input type="text" id="password" name="password" class="easyui-textbox" data-options="required:true"/></td>
			</tr>
			<tr>
				<td align="right">姓名:</td>
				<td><input type="text" id="usernames" name="usernames" class="easyui-textbox" data-options="required:true"/></td>
				<td align="right">角色:</td>
				<td><select class="easyui-combobox easyui-validatebox" missingMessage="请选择" data-options="panelHeight:'auto',panelMaxHeight:'150px',required:true" id="roleids" name="ids" style="width: 135px;"></select></td>
				
			</tr>
			<tr>
				<td align="right">部门编号:</td>
				<td><input type="text" id="departmentids" name="departmentids" class="easyui-textbox" /></td>
				<td align="right">状态:</td>
				<td><select class="easyui-combobox" missingMessage="请选择" data-options="editable:false,panelHeight:'auto',required:true" id="status" name="status" style="width: 135px">
							<option value="0" selected="selected">禁用</option>
							<option value="1">启用</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">部门名称:</td>
				<td><input type="text" id="departmentnames" name="departmentnames" class="easyui-textbox" /></td>
			</tr>
		</table>
	</form>
</div>


<!-- 修改表格 -->
<div id="ptUserUpdate" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-edit',inline:true"
	style="width: 520px; padding: 10px;">
	<form id="ptUserUpdateForm" method="post">
		<table id="update" style="margin-top: 15px">
			<tr>
				<td width="80" align="right">用户编号:</td>
				<td><input type="text" id="ids" name="ids" readonly="readonly"/></td>
				<td align="right">用户账号:</td>
				<td><input id="updateUsername" name="username" readonly="readonly"/>
				</td>		
			</tr>
			<tr>
				<td align="right">用户密码:</td>
				<td><input type="text" id="password" name="password" class="easyui-textbox" data-options="required:true"/>
				</td>		
				<td align="right">用户姓名:</td>
				<td><input type="text" id="usernames" name="usernames" class="easyui-textbox" data-options="required:true"/>
				</td>		
			</tr>
			<tr>
				<td align="right">部门编号:</td>				
				<td><input type="text" id="departmentids" name="departmentids" class="easyui-textbox" />					
				</td>				
				<td align="right">部门名字:</td>
				<td><input type="text" id="departmentnames" name="departmentnames" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">状态:</td>
				<td><select class="easyui-combobox" required="true" missingMessage="请选择" data-options="editable:false,panelHeight:'auto'" id="status" name="status" style="width: 75px">
							<option value="0">禁用</option>
							<option value="1">启用</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
</div>

<!-- 用户关联角色表格 -->
<div id="userRoleDialog" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-users',inline:true"
	style="width: 800px;height:340px; padding: 20px;">
	<form id="userRoleForm" method="post">
		<table id="userRoleDg" class="easyui-datagrid" singleSelect="true" style="width: 100%"
		data-options="url:'ptrole/all',fitColumns:true,pagination:true,pageSize:5,pageList:[5,10,15,20],
       				 toolbar:'#venderToolbar',striped:true">
		<thead>
			<div style="margin-bottom: 5px">
				当前角色<input id="nowName" class="easyui-textbox" readonly="readonly"/>
			</div>
			<tr>
				<th field="_ddd" data-options="checkbox:true">选择</th>
				<th field="ids" width="32%" align="center">角色编号</th>
				<th field="names" width="20%" align="center">角色名称</th>
				<th field="description" width="45%" align="center">角色描述</th>
			</tr>
		</thead>
	</table> 
	</form>
</div>

<div id="queryRoleDialog" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-users',inline:true,title:'用户角色',modal:true"
	style="width: 260px;height:100px; padding: 10px;">
	<form id="queryRoleForm" method="post">
		<table id="queryRoleDg">
			<tr>
				<td>当前角色</td>
				<td><input id="roleName" class="easyui-textbox" readonly="readonly"/></td>
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
	 * 单独查询角色名称
	 */
	function queryRole(){
		var row = $("#ptUser").datagrid('getSelected');
		if (row) {
			
			$.ajax({
				url:'/user/findRoleName/' + row.ids,
				type:'POST',
				success:function(data){
					$('#roleName').textbox('setValue',data)
				}
			})
			$('#queryRoleDialog').dialog('open');
		} else {
			$.messager.alert('信息提示','请选中要修改的用户');
			}
		}
	
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
	
	/**
	* Name 打开添加窗口
	*/
	function openUserAdd(){
		
		//动态加载角色
		$.ajax({
			url:'/user/find/role',
			type:"GET",
			success: function(data){
				data = eval("("+data+")");
				$('#roleids').combobox({
					valueField:'ids',
					textField:'names',
					data:data.rows,
				})	
			}
		});
		
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
					$('#ptUserAdd').dialog('close');
					successShow();
				}
				else
				{
					errorShow();
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
							$('#pagination').pagination('select');
							successShow();
						}
						else
						{
							errorShow()		
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
			$('#ptUserUpdate').dialog('open').dialog({
				closed: false,
				modal:true,
	            title: "修改用户信息",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: edit
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#ptUserUpdate').dialog('close');                    
	                }
	            }]
	        });
			$('#ptUserUpdateForm').form('load',row);
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/*
	*修改
	*/
	function edit(){
		$('#ptUserUpdateForm').form('submit', {
			url:'/user/update',
    		type:'POST',
    		data:$('#ptUserUpdateForm').serialize(),
    		success:function(data){
    			if(data > 0){
    				$('#ptUserUpdate').dialog('close');
    				$('#pagination').pagination('select');
    				successShow();
    			}else{
    				errorShow();
    			}
    		}
    	});
	}
	
	/**
	* 修改用户所属角色
	*/
	function openRole(){
		var row = $("#ptUser").datagrid('getSelected');
		if (row) {
			
			$.ajax({
				url:'/user/findRoleName/' + row.ids,
				type:'POST',
				success:function(data){
					$('#nowName').textbox('setValue',data)
				}
			})
			
			$('#userRoleDialog').dialog('open').dialog({
				closable:false,				
				closed: false,
				modal:true,
	            title: "修改用户角色",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: function(){
	                	var param = $("#userRoleDg").datagrid('getSelected');
	                	$.ajax({
	                		url:'user/updateRoleUser',
	                		data:{'moduleIds':row.ids,'roleIds':param.ids},
	                		type:'POST',
	                		success:function(data){
	                			if(data > 0){
	                				successShow();
	                				$('#userRoleDialog').dialog('close');
	                			}else{
	                				errorShow();
	                			}
	                		}
	                	});
	                	$('#userRoleDg').datagrid('clearSelections');
	                }
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#userRoleDialog').dialog('close');
	                    $('#userRoleDg').datagrid('clearSelections');
	                }
	            }]
	        });
		} else {
			$.messager.alert('信息提示','请选中要修改的用户');
		}
	}
	
	/**
	* 重置密码确认
	*/
	function resetPw(){
		var items = $('#ptUser').datagrid('getSelections');
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中要重置的用户');
			return ;
		}
		$.messager.confirm('信息提示','确定要将密码重置为000000吗？',function(data){
			if(data){
				$.ajax({ 
			          type: 'POST', 
			          url: '/user/update', //用户请求数据的URL
			          data: {'pageNumber':1,'pageSize':10,'ids':items[0].ids,'password':'000000'},
			          success: function (success) { 
			        	if(success){
			        		successShow();
			        	}
			          }
			       });
			}
		})
		
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
	
	$('#ids,#updateUsername').tooltip({    
		position: 'right',    
		content: '<span style="color:#fff">不可修改</span>',    
		onShow: function(){        
			$(this).tooltip('tip').css({            
				backgroundColor: '#666',            
				borderColor: '#666'        
				});    
			}
		});

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
	
</script>
