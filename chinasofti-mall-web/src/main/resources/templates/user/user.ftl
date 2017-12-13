<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/user.js"></script>
<script type="text/javascript" src="js/myValidType.js"></script>
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
            <@shiro.hasPermission name="user_deful_pw">
            <a href="#" class="easyui-linkbutton" iconCls="icon-key-go" onclick="resetPw()" plain="true">重置密码</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="user_query_role">
            <a href="#" class="easyui-linkbutton" iconCls="icon-user-magnify" onclick="queryRole()" plain="true">查看角色</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="user_role">
            <a href="#" class="easyui-linkbutton" iconCls="icon-users" onclick="openRole()" plain="true">修改用户角色</a>
            </@shiro.hasPermission>
        </div>
    </div>
    
    <!-- 显示数据,数据表格列对齐 -->
    <table id="ptUser" class="easyui-datagrid" title="用户列表" toolbar="#user-toolbar-2" style="height: 100%"
    				   data-options="url:'/user/list',
    				   				 inline:true,
    				   				 fitColumns:false,
    				   				 singleSelect:true,
    				   				 collapsible:true,
    				   				 sortName:'createtime',
       				 				 sortOrder:'desc',
       				 				 striped:true,
       				 				 pagination:true,
       				 				 pageSize:15,
       					 			 pageList: [15, 25, 50, 100],">
    	<thead>
    		<tr>
    			<th field="ids" hidden="true">用户编号</th>
				<th field="username" width="15%" align="center" >账号</th>
				<th field="usernames" width="15%" align="center" >姓名</th>
				<th field="departmentids" width="15%" align="center">部门编号</th>
				<th field="departmentnames" width="15%" align="center">部门名字</th>
				<th field="status" width="10%" align="center" data-options="formatter:statesFormatter,sortable:true">状态</th>
				<th field="createtime" width="20%" align="center" data-options="sortable:true">创建日期</th>
				<th field="userOperator" width="10%" align="center" data-options="formatter:userOperatorFormatter">操作</th>			
    		</tr>
    	</thead>
    </table>
    <!-- 分页工具条 -->
	<!-- <div id="pagination" style="background:#efefef;border:1px solid #ccc;"></div> -->
</div>

<!-- 内管用户添加表格 -->
<div id="ptUserAdd" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-add',inline:true"
	style="width: 700px; padding: 10px;">
	<form id="ptUserAddForm" method="post">
		<table id="ptUserAdd" style="margin-top: 12px">
			<tr>
				<td width="120px" align="right">账号:</td>
				<td>
					<input type="text" id="username" name="username" class="easyui-textbox" data-options="required:true" validType="account[6,30]" /><br>
					<span style="color:gray"><font size="1">请输入6-30位数,可包含_,数字,字母</font></span>
				</td>
				<td align="right">姓名:</td>
				<td>
					<input type="text" id="usernames" name="usernames" class="easyui-textbox" data-options="required:true,validType:['betweenLength[2,30]','checkUserNames[usernames]']" /><br>
					<span style="color:gray"><font size="1">请输入2-30位数,可包含汉字,字母</font></span>
				</td>
			</tr>
			<tr>
				<td align="right" style="line-height: 3">密码:</td>
				<td>
					<input type="text" id="password" name="password" class="easyui-passwordbox" data-options="required:true" validType="betweenLength[6,12]"/><br>
					<span style="color:gray"><font size="1">请输入6-12位数</font></span>
				</td>
				<td align="right">确认密码:</td>
				<td>
					<input type="text" id="repassword" name="repassword" class="easyui-passwordbox validatebox" data-options="required:true" validType="checkPwd['#password']"/><br>
					<span style="color:gray"><font size="1">请再次输入密码</font></span>
				</td>
				
			</tr>
			<tr>
				<td align="right">角色:</td>
				<td><select class="easyui-combobox validatebox" data-options="editable:false,panelHeight:'auto',panelMaxHeight:'150px',required:true" id="roleids" name="ids" style="width: 135px;"></select></td>
				<td align="right">状态:</td>
				<td><select class="easyui-combobox validatebox" data-options="editable:false,panelHeight:'auto',required:true" id="status" name="status" style="width: 135px">
							<option value="0" selected="selected">禁用</option>
							<option value="1">启用</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" style="line-height: 3">部门编号:</td>
				<td>
					<input type="text" id="departmentids" name="departmentids" class="easyui-textbox validatebox" data-options="required:true,validType:['isNumOrLet','betweenLength[6,32]']"/><br>
					<span style="color:gray"><font size="1">请输入6-32位数字或字母</font></span>
				</td>
				<td align="right">部门名称:</td>
				<td>
					<input type="text" id="departmentnames" name="departmentnames" class="easyui-textbox validatebox" data-options="required:true,validType:['depName','betweenLength[2,30]']"/><br>
					<span style="color:gray"><font size="1">请输入2-30位数</font></span>
				</td>
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
				<td><input type="text" id="ids" name="ids" style="background-color: #FAFAFA;" readonly="readonly"/></td>
				<td align="right">用户账号:</td>
				<td><input id="updateUsername" name="username" style="background-color: #FAFAFA;" readonly="readonly"/>
				</td>		
			</tr>
			<tr>
				<td align="right" style="line-height: 3">用户密码:</td>
				<td><input id="password" name="password" class="easyui-passwordbox validatebox" data-options="required:true,validType:['betweenLength[6,12]']"/>
				</td>		
				<td align="right">用户姓名:</td>
				<td><input id="usernames" name="usernames" class="easyui-textbox validatebox" data-options="required:true,validType:['betweenLength[2,30]','checkUserNames[usernames]']"/>
				</td>		
			</tr>
			<tr>
				<td align="right">部门编号:</td>				
				<td><input id="departmentids" name="departmentids" class="easyui-textbox validatebox" data-options="required:true,validType:['isNumber','betweenLength[6,32]']"/>					
				</td>				
				<td align="right">部门名字:</td>
				<td><input id="departmentnames" name="departmentnames" class="easyui-textbox validatebox" data-options="required:true,validType:['depName','betweenLength[2,30]']"/></td>
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

</script>
