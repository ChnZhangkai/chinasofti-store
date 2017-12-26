<script type="text/javascript" src="js/prefecture.js"></script>
<!-- 显示专区表格 -->
<div class="easyui-layout" id="prefecture_easyui-layout" data-options="fit:true" style="overflow:auto">
	<!--专区的toolbar -->
	<div id="prefecture-toolbar-main">
		<div class="prefecture-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"onclick="openAdd()" plain="true">添加</a>
			<a href="#"class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()"plain="true">修改</a>
			<a href="#" class="easyui-linkbutton"iconCls="icon-remove" onclick="remove()" plain="true">删除</a> 
		</div>
	</div>
	<!-- 显示数据,数据表格列对齐 -->
	<table id="prefecture-datagrid" class="easyui-datagrid" toolbar="#prefecture-toolbar-main" style="min-height:495px"
		data-options="url:'prefecture/findAll',
					 singleSelect:true,
    				 fitColumns:true,
       				 sortOrder:'asc',
       				 pagination:true,
        			 title:'专区列表',
       				 iconCls:'icon-man',
       				 striped:true,
       				 collapsible:true,
       				 pageSize:10,
       				 pageList: [10, 20, 30],
       				 onDblClickRow:showGoods">
		<thead>
			<tr>
				<th field="ids" width="20%" align="center">专区编号</th>
				<th field="name" width="15%" align="center">专区名称</th>
				<th field="img" width="15%" align="center"
					data-options="formatter:imgFormatter" >专区图片</th>
				<th field="commons" width="25%" align="center">专区描述</th>
				<th field="states" width="10%" align="center"
					data-options="formatter:statesFormatter,sortable:true">专区状态</th>
				<th align="center" width="15%" data-options="field:'level',formatter:menuView2">商品操作</th>
			</tr>
		</thead>
	</table>
	<!-- 商品表格 显示专区下面商品列表 -->
	<table id="goodsList" class="easyui-datagrid" style="min-height:400px" singleSelect="true"
		data-options="url:'/prefecture/findGoods/',
					 fitColumns:true,
					 pagination:true,
       				 sortOrder:'asc',title:'专区商品列表',iconCls:'icon-man',striped:true,
       				 collapsible:true,checkOnSelect: false,selectOnCheck: true">
		<thead>
			<tr>
				<th field="ids" width="20%" align="center" data-options="sortable:true">商品编号</th>
				<th field="title" width="10%" align="center">商品名称</th>
				<th field="price" width="10%" align="center" data-options="sortable:true">商品价格</th>
				<th field="vendorFnm" width="20%" align="center" data-options="sortable:true">商户名称</th>
				<th field="name" width="20%" align="center" data-options="sortable:true">分类名称</th>
				<th field="status" width="10%" align="center"
					data-options="formatter:statusFormatter,sortable:true">商品状态</th>
				<th field="delete" width="10%" align="center" 
					data-options="formatter:mainBtnFormatter">商品删除</th>
			</tr>
		</thead>
	</table>

</div>
<!-- 显示商品页面 -->
<div id="GoodsDialog" title="商品页面" class="easyui-dialog"
	data-options="closed:true,draggable:false,inline:true"
	style="width: 800px; height: 400px">
	<div class="goodonline-toolbar-search"
		style="border-bottom: 1px solid #DDDDDD">
		<form id="searchPrefectureGoodsOnlineForm" style="margin: 0px">
			<label>商品名称</label> <input type="text"
				id="prefectureGoodsOnline-title" name="title" class="easyui-textbox" />
			<label>商品分类</label> <input class="easyui-textbox"
				id="prefectureGoodsOnline-name" name="name"
				data-options="editable:false" /> <a class="easyui-linkbutton"
				iconCls="icon-search" plain="false" onclick="goodsClassChoose()">选择</a></br> <label>商品类型</label>
			<select autocomplete="off" class="easyui-combobox"
				data-options="editable:false,panelHeight:'auto'"
				id="prfectureGoodsOnline-goodsType" name="type" style="width: 135px">
				<option selected="selected" value="">请选择</option>
				<option value="0">普通商品</option>
				<option value="1">活动商品</option>
			</select> <label>商品状态</label> <select autocomplete="off"
				class="easyui-combobox"
				data-options="editable:false,panelHeight:'auto'"
				id="prefectureGoodsOnline-status" name="status" style="width: 135px">
				<option selected="selected" value="">请选择</option>
				<option value="1">已上架</option>
				<option value="2">已下架</option>
			</select> <a href="#" class="easyui-linkbutton" iconCls="icon-search"
				onclick="prefectureGoodOnlineDoSearch()">开始搜索</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-edit-clear"
				onclick="prefectureGoodOnlineDoClear()">清除</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-add"
				onclick="addToPrefecture()">添加至专区</a>
		</form>
	</div>
	<table id="prefectureGoodsOnlineinfo" class="easyui-datagrid"
		style="height: 100%" toolbar="#goodonline-toolbar-3"
		data-options="url:'/goodsOnline/findByPage',
						 fitColumns:false,
       					 pagination:true,
       					 sortName:'CREATE_TIME',
       					 sortOrder:'desc',
       					 title:'商品在线列表',
       				 	 iconCls:'icon-man',
		   				 striped:true,
		   				 singleSelect:true,
						 collapsible:true,
		   				 pageSize:20,
		   				 pageList: [20, 40, 60, 100]">
		<thead>
			<tr>
				<th field="title" width="13%" align="center"
					data-options="sortable:true">商品名称</th>
				<th field="img" width="10%" align="center"
					data-options="formatter:img1Formatter ,sortable:true" >商品图片</th>
				<th field="price" width="15%" align="center"
					data-options="sortable:true">商品价格</th>
				<th field="vendorFnm" width="15%" align="center"
					data-options="sortable:true">商户名称</th>
				<th field="name" width="15%" align="center"
					data-options="sortable:true">分类名称</th>
				<th field="type" width="10%" align="center"
					data-options="formatter:typesFormatter ,sortable:true">商品类型</th>
				<th field="storeNum" width="10%" align="center"
					data-options="sortable:true">当前库存</th>
				<th field="status" width="10%" align="center"
					data-options="formatter:statusFormatter,sortable:true">商品状态</th>
			</tr>
		</thead>
	</table>
</div>
<div id="ClassTreeDlg" data-options="closed:true,resizable:true,modal:true,buttons:'#ChooseBtns'">
	<div id="classTree" style="padding:4px;"></div>
</div>

<!-- 商品分类Id查询dialog按钮 -->
<div id="ChooseBtns">
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="Choose()">选择</a>
</div>
<!-- 专区添加表格 -->
<div id="prefectureAddDialog" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-save'"
	style="width: 500px; padding: 10px;">
	<form id="addForm" method="post" enctype="multipart/form-data">
		<table id="add">
			<tr>
				<td width="60" align="right">专区名称:</td>
				<td><input type="text" id="name" name="name"
					class="easyui-validatebox easyui-textbox" required="true" missingMessage="请输入专区名称"/></td>
			</tr>
			<tr>
				<td align="right">专区描述:</td>
				<td><input type="text" id="commons" name="commons"
					class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">专区状态:</td>
				<td>
					<select class="easyui-combobox easyui-validatebox" required="true" missingMessage="请选择专区状态" data-options="editable:false,panelHeight:'auto'" id="states" name="states" style="width: 75px">
							<option value="0">删除</option>
							<option value="1">上线</option>
							<option value="2">下线</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">专区图片:</td>
				<td><input type="file" id="img" name="img"  class="img" onchange="readPicture()"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="showpic"></div>
				</td>
			</tr>
		</table>
	</form>
</div>

<!-- 修改专区表格 -->
<div id="prefectureDialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width: 500px; padding: 10px;">
	<form id="updateForm" method="post" enctype="multipart/form-data">
		<table id="update">
			<tr>
				<td width="60" align="right">专区编号:</td>
				<td><input type="text" id="ids" name="ids" 
				class="wu-tex easyui-tooltip" title="专区ID不可修改" style="background-color: #F4F4F4" readonly="true"/></td>
			</tr>
			<tr>
				<td width="60" align="right">专区名称:</td>
				<td><input type="text" id="name" name="name"
					class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">专区描述:</td>
				<td><input type="text" id="commons" name="commons"
					class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">专区状态:</td>
				<td>
					<select class="easyui-combobox easyui-validatebox" required="true" missingMessage="请选择专区状态" data-options="editable:false,panelHeight:'auto'" id="states" name="states" style="width: 75px">
							<option value="0">删除</option>
							<option value="1">上线</option>
							<option value="2">下线</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">原图地址:</td>
				<td><input type="text" id="img" name="img"
					class="easyui-textbox easyui-tooltip" title="请选择新图片" style="background-color: #F4F4F4" readonly="true"/></td>
			</tr>
			<tr>
				<td align="center">专区图片:</td>
				<td><input type="file" id="uimg" name="uimg" onchange="updatePicture()"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="showupic"></div>
					<!-- <img alt="" src="" id="showImg" style="height: 80px;width: 117px"> -->
				</td>
			</tr>
		</table>
	</form>
</div>
