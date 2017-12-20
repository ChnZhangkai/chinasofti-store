<script type="text/javascript" src="js/param.js"></script>
<script type="text/javascript" src="js/user.js"></script>
<script type="text/javascript" src="js/myValidType.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div id="param-toolbar">
        <div class="param-toolbar-search">
        	<form id="searchParamForm" style="margin: 0px">
				<label>名称</label>
				<input type="text" id="usernames" name="usernames" class="easyui-textbox"/>
				<label>状态</label> <select id="status" name="status" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 125px">
										<option value=""  selected="selected">请选择</option>
										<option value="0" >禁用</option>
										<option value="1">启用</option>
									</select>
	          	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">检索</a>
			    <a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="doClear()">清除</a>
		    </form>
        </div>
        <div class="user-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openUserAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
        </div>
    </div>
    
    <!-- 显示数据,数据表格列对齐 -->
    <table id="ParamTable" class="easyui-treegrid" title="用户列表" toolbar="#param-toolbar" style="height: 100%"></table>
</div>