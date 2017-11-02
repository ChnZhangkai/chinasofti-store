<script type="text/javascript" src="js/common.js"></script>
<div class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="wu-toolbar-2">
		<div class="wu-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"
				onclick="openAdd()" plain="true">添加</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()"
				plain="true">修改</a> <a href="#" class="easyui-linkbutton"
				iconCls="icon-remove" onclick="remove()" plain="true">删除</a> <a
				href="#" class="easyui-linkbutton" iconCls="icon-excel"
				onclick="print()" plain="true">导出</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-print" onclick="print()"
				plain="true">打印</a>
		</div>
		<div class="wu-toolbar-search">
			<label>商品类型：</label> <input type="text" id="goodsTypeSearch"
				name="goodstype" /> <a href="#" class="easyui-linkbutton"
				iconCls="icon-search" onclick="doSearch()">开始检索</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-edit-clear"
				onclick="doClear()">清除</a>
		</div>
	</div>
	
	<!-- 数据显示datagrid -->
	<table id="tt-advertise" class="easyui-datagrid" toolbar="#wu-toolbar-2">
		<thead>
		<tr>
			<th field="ids" width="10%" align="center">标题</th>
			<th field="goodsType" width="10%" align="center">链接URL</th>
			<th field="goodsCode" width="10%" align="center">广告类型</th>
			<th field="vendorids" width="10%" align="center">前台状态</th>
			<th field="title" width="10%" align="center">广告位名称</th>
			<th field="" width="10%" align="center">分类广告名称</th>
		</tr>
	</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="pagination" style="background:#efefef;border:1px solid #ccc;"></div>
</div>
<script type="text/javascript">
$(function(){
	//获取表格datagrid的ID属性
	var tableID = $("table.easyui-datagrid").attr("id");
	//alert(tableID);
	//获取分页工具条元素
	var pageId = $('#pagination');

	//此处设置自己的url地址
	var url = '/goods/list';
	
	tdload(tableID, pageId, url);
});
</script>