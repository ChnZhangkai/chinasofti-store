<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/myValidType.js"></script>
<script type="text/javascript" src="js/role.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="role-toolbar-2">
       	<div class="wu-toolbar-search">
			<form id="searchForm" style="margin: 0px">
				<label>角色编号：</label> <input class="easyui-textbox" id="vendorId" name="vendorId"/>
				<label>角色名称：</label> <input class="easyui-textbox" id="vendorSnm" name="vendorSnm"/>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">开始检索</a>
			    <a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="doClear()">清除</a>
			</form>	
		</div>
		<div class="role-toolbar-button">
			<@shiro.hasPermission name="role_add">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openRoleAdd()" plain="true">添加</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="role_upd">
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="role_del">
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
            </@shiro.hasPermission>
            <@shiro.hasPermission name="role_operator">
            <a href="#" class="easyui-linkbutton" iconCls="icon-group-key" onclick="menuTree()" plain="true">角色操作</a>
            </@shiro.hasPermission>
        </div>
	</div>
    
	<!-- 数据显示datagrid -->
	<table id="ptroleinfo" class="easyui-datagrid" title="角色列表"
			data-options="singleSelect:true,collapsible:true,inline:true" toolbar="#role-toolbar-2" style="height: 95%">
		<thead>
			<tr>
				<th field="ids" hidden="true">编号</th>
				<th field="names" width="20%" align="center">角色全称</th>
				<th field="numbers" width="10%" align="center">角色数量</th>
				<th field="createby" width="15%" align="center">创建人员</th>	
				<th field="createtime" width="25%" align="center">创建时间</th>
				<th field="description" width="30%" align="center">角色描述</th>
			</tr>
		</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="ptrolePagination" style="background:#efefef;border:1px solid #ccc;"></div>
</div>

<!-- 添加表格 -->
<div id="ptroleAddDialog" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-add',inline:true"
	style="width: 300px; padding: 10px;">
	<form id="ptroleAdd" method="post" enctype="multipart/form-data">
		<table id="roleAdd">
			<tr>
                <td width="80" align="right">角色名称:</td>
                <td><input  id="roleNames" name="names" class="easyui-textbox validatebox" data-options="required:true,validType:['betweenLength[2,30]','checkUserNames[roleNames]']"/></td>
            </tr>
            <tr>
             	<td align="right" style="line-height: 3">角色描述:</td>
                <td><input id="description" name="description" class="easyui-textbox validatebox" data-options="required:true,validType:['betweenLength[2,50]']"/></td>
            </tr>
            <tr>
                <td align="right">角色数量:</td>
                <td><input id="numbers" name="numbers" class="easyui-textbox validatebox" data-options="required:true,validType:['maxLength[10]','isNumber']"/></td>
            </tr>
		</table>
	</form>
</div>


<!-- 修改表格 -->
<div id="ptroleUpdateDialog" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-edit',inline:true"
	style="width: 500px;height: 200px;padding: 10px;">
	<form id="ptroleUpdate" method="post" >
		<table id="update">
			<tr>
				<td><input type="hidden" id="ids" name="ids" /></td>
			</tr>
			<tr>
                <td align="right" style="line-height: 3">角色名称:</td>
                <td><input  id="names" name="names" class="easyui-textbox" readonly="readonly"/></td>
                <td align="right">创建人员:</td>
                <td><input id="createby" name="createby" class="easyui-textbox" readonly="readonly"/></td>
            </tr>
			<tr>
               	<td align="right">角色数量:</td>
                <td><input id="numbers" name="numbers" class="easyui-textbox" data-options="required:true"/></td> 
                <td align="right">角色描述:</td>
                <td><input id="description" name="description" class="easyui-textbox" data-options="required:true"/></td>
            </tr>
		</table>
	</form>
</div>
	<div id="treeDlg">
		<div id="tree" style="padding:4px;"></div>
	</div>
	
	<div id="menuTreeDlg">
		<div id="menuTree" style="padding:4px;"></div>
	</div>
<script type="text/javascript">

</script>