<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/logMenu.js"></script>
	<div class="easyui-layout" data-options="fit:true" style="padding:4px;overflow:auto">
	    
	    <!-- 角色操作菜单树 -->
	    <div style="padding:4px;height: 300px">
			<ul id="menuTree" class="easyui-tree" style="height: 300px"></ul>
		</div>
		
		<!-- 父节点操作(包含添加) -->
		<div id="menuTreeToParent" class="easyui-menu" style="width:120px;" data-options="onClick:buttonHandler">
		    <div data-options="iconCls:'icon-add',name:'add'">添加</div>
		    <div class="menu-sep"></div>
		    <div data-options="iconCls:'icon-edit',name:'rename'">重命名</div>
		    <div class="menu-sep"></div>
		    <div data-options="iconCls:'icon-remove',name:'delete'">删除</div>
		</div>
		
		<!-- 底层节点操作 -->
		<div id="menuTreeToChild" class="easyui-menu" style="width:120px;" data-options="onClick:buttonHandler">
		    <div data-options="iconCls:'icon-edit',name:'rename'">重命名</div>
		    <div class="menu-sep"></div>
		    <div data-options="iconCls:'icon-remove',name:'delete'">删除</div>
		</div>
	</div>

