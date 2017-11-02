<script type="text/javascript" src="js/common.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="user-toolbar-2">
        <div class="user-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="print()" plain="true">导出</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="print()" plain="true">打印</a>
        </div>
        <div class="user-toolbar-search">
            <label>用户名：</label> 
			<input type="text" id="name" name="name" />
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">开始检索</a>
        </div>
    </div>
    
    <!-- 显示数据,数据表格列对齐 -->
    <table class="easyui-datagrid" title="银行用户个人信息" url="/user/list"
			data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
    	<thead>
    		<tr>
    			<th data-options="field:'ids',width:150,align:'center'">用户ID</th>
				<th data-options="field:'username',width:200,align:'center'">登录名称</th>
				<th data-options="field:'name',width:200,align:'center'">用户姓名</th>
				<th data-options="field:'orgid',width:200,align:'center'">机构编号</th>
				<th data-options="field:'orgname',width:300,align:'center'">机构名称</th>
				<th data-options="field:'mobile',width:200,align:'center'">手机号</th>
    		</tr>
    	</thead>
    </table>
</div>   




