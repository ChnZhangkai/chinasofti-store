<script type="text/javascript" src="js/param.js"></script>
<script type="text/javascript" src="js/user.js"></script>
<script type="text/javascript" src="js/myValidType.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div id="param-toolbar">
        <div class="user-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openUserAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
			<label style="margin-left: 20px">名称 </label><input id="text" name="text" class="easyui-searchbox" prompt="请输入参数名称" searcher="doParamSearch" style="width: 130px"/>
        </div>
    </div>
    
    <!-- 显示数据,数据表格列对齐 -->
    <table id="ParamTable" class="easyui-treegrid" title="用户列表" toolbar="#param-toolbar" style="height: 100%"></table>
</div>