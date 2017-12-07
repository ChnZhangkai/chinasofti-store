<script type="text/javascript">
	
//状态转换
function statesFormatter(value) {
	if (value == "1") {
		return '<span style="color:green">请求成功</span>';
	} else {
		return '<span style="color:red">请求失败</span>';
	}
}
	
</script>
<div class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<!-- <div id="advertise-toolbar" >
		<div class="wu-toolbar-button">
			<@shiro.hasPermission name="adv_add">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="addAdvertise()" plain="true">添加</a> 
			</@shiro.hasPermission>
			<@shiro.hasPermission name="adv_update">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="editAdvertise()" plain="true">修改</a>
			</@shiro.hasPermission>
			<@shiro.hasPermission name="adv_delete">
			 <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteAdvertise()" plain="true">删除</a>
			 </@shiro.hasPermission> 
			 <@shiro.hasPermission name="adv_query">
			 <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="showAdvertise()" plain="true">查看</a>
			 </@shiro.hasPermission>
		</div>
		<form id="searchForm">
			<div class="wu-toolbar-search">
				<label>广告标题：</label> 
				<input id="ad_search_title" name="title" data-options="prompt:'请输入标题名称'" class="easyui-textbox" style="width: 120px" /> 
				<label>广告类型：</label>
				 <select id="ad_search_type" class="easyui-combobox" style="width: 100px" data-options="panelHeight:'auto'">
					<option value="">请选择</option>
					<option value="1">正常</option>
					<option value="0">备用</option>
				</select> 
				<label>广告位置：</label> 
				<input id="_positionId" class="easyui-combobox" style="width: 100px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="ad_search()">开始检索</a> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="ad_clear()" >清除</a>
			</div>
		</form>
	</div> -->

	<!-- 数据显示datagrid -->
	<table id="log-datagrid" style="height: 100%" class="easyui-datagrid"
		data-options="url:'/log/findAllOperator',
    				 fitColumns:false,
       				 pagination:true,
       				 sortName:'date',
       				 sortOrder:'desc',
        			 title:'系统操作',
       				 iconCls:'icon-man',
       				 striped:true,
       				 singleSelect:true,
       				 collapsible:true,
       				 pageSize:15,
       				 pageList: [15, 25, 50, 100]">
		<thead>
			<tr>
				<th field="url"   width="20%" align="center" data-options="sortable:true">请求路径</th>
				<th field="method"  width="15%" align="center" data-options="sortable:true">请求方法</th>
				<th field="ip"  width="10%" align="center" data-options="sortable:true">请求IP</th>
				<th field="type"  width="10%" align="center" data-options="sortable:true">请求类型</th>
				<th field="username"  width="10%" align="center" data-options="sortable:true">请求用户</th>
				<th field="date"  width="15%" align="center" data-options="sortable:true">请求时间</th>
				<th field="time" width="10%" align="center" data-options="sortable:true">请求耗时(ms)</th>
				<th field="state"  width="10%" align="center" data-options="formatter:statesFormatter,sortable:true">请求状态</th>  
			</tr>
		</thead>
	</table>
</div>
