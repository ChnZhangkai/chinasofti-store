<script type="text/javascript" src="js/goodscheck.js"></script>
<script type="text/javascript" src="js/myValidType.js"></script>
<div id="auditlist" class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="wu-toolbar-3" >
		<div class="wu-toolbar-search" style="border-bottom: 1px solid #DDDDDD">
			<form id="searchCheckForm" style="margin: 0px">
				<label>商品名称</label> <input type="text" id="goodstitle" name="title" class="easyui-textbox" style="width: 160px"/>
				<label>商户名称</label> <input class="easyui-textbox" id="goodsCheck-vendorFnm" name="vendorFnm" readonly="true" />
							<a class="easyui-linkbutton" iconCls="icon-search" plain="false" id="like-choose" onclick="venderFnmChoose(this)">选择</a>
				<label>商品分类</label> 
					<input type="text" id="goodsclassname" name="name" class="easyui-textbox" style="width: 160px" data-options="editable:false"/>
					<a class="easyui-linkbutton" iconCls="icon-search" plain="false" id="goodscheck_like" onclick="ClassTree(this)">选择</a>
				<label>审核状态</label>
				<select autocomplete="off" class="easyui-combobox"
					data-options="panelHeight:'auto'" id="goodsReviewStates" name="reviewStatues"
					style="width: 160px">
					<option selected="selected" value="">请选择</option>
					<option value="0">待申请审核</option>
					<option value="3">待审核</option>
					<option value="1">审核通过</option>
					<option value="2">审核拒绝</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="doGoodsCheckSearch()">开始检索</a> <a href="#" class="easyui-linkbutton"
					iconCls="icon-edit-clear" onclick="doGoodsCheckClear()">清除</a>
			</form>
		</div>
		<div class="wu-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openGoodsAdd()" plain="true">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="removeGoodsCheck()" plain="true">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="goodsCheckExport()" plain="true">导出</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-arrow-redo" id="pushCheck" onclick="handleCheck(this)" plain="true">申请审核</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-arrow-undo" id="repealCheck" onclick="handleCheck(this)" plain="true">撤销申请</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-chk-checked" id="doCheck" onclick="doCheck(this)" plain="true">商品审核</a>
		</div>
	</div>

	<!-- 数据显示datagrid -->
	<table id="goodscheck" class="easyui-datagrid" title="商品审核列表" toolbar="#wu-toolbar-3" style="height: 95%"
		data-options="singleSelect:true,
						 collapsible:true,
						 url:'/goodsCheck/list',
						 fitColumns:false,
       					 sortName:'CREATE_TIME',
       					 sortOrder:'desc',
       					 iconCls:'icon-man',
       				 	 striped:true,
       				 	 onDblClickRow:showGoodsCheck">
		<thead>
			<tr>
				<th field="title" width="20%" align="center" data-options="sortable:true">商品名称</th>
				<th field="img" width="10%" align="center"
					data-options="formatter:imgFormatter,sortable:true">商品图片</th>
				<th field="price" width="15%" align="center" data-options="sortable:true">商品价格</th>
				<th field="vendorFnm" width="15%" align="center" data-options="sortable:true">商户名称</th>
				<th field="name" width="20%" align="center" data-options="sortable:true">商品分类</th>
				<th field="type" width="10%" align="center"
					data-options="formatter:typeFormatter,sortable:true">商品类型</th>
				<th field="reviewStatues" width="10%" align="center"
					data-options="formatter:statesFormatter,sortable:true">审核状态</th>
			</tr>
		</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="goodsCheckPagination" style="background: #efefef; border: 1px solid #ccc;"></div>
</div>

	<!-- 商品添加表格 -->
	<div id="addDl" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-add',inline:true,closable:false"
		style="width: 100%; height: 100%; padding: 10px;">
		<form id="addGoodsForm"  enctype="multipart/form-data">
			<table>
				<tr>
					<td align="right">商品名称</td>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="title" name="title"  
							data-options="required:true,validType:['depName','length[1,100]']" />
						 <span><font style="color: red; font-size: 10px;">*</font></span></td>
							
					<td align="right">商品分类</td>
					<td><input type="text" id="goodsClassIds" name="goodsClassIds" class="easyui-textbox" required="true" missingMessage="请选择" style="width: 160px" data-options="editable:false"/>
					<a class="easyui-linkbutton" iconCls="icon-search" plain="false" id="goodscheck_add"  onclick="ClassTree(this)">选择</a>
					</td>
				</tr>
				<tr>
					<td align="right">商品类型</td>
					<td><select style="width: 180px;" class="easyui-combobox easyui-validatebox" required="true" missingMessage="请选择" data-options="editable:false,panelHeight:'auto'" id="type" name="type">
							<option value="0">普通商品</option>
							<option value="1">活动商品</option>
					</select></td>
					<td align="right">商户编号</td>
					<td>
					<input class="easyui-textbox" id="add-vendorFnm" name="vendorids" readonly="true" />
							<a class="easyui-linkbutton" iconCls="icon-search" plain="false" id="add-choose" onclick="venderFnmChoose(this)">选择</a>
					</td>
				</tr>
				<tr>
					<td align="right">开始日期</td>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="startTime" name="startTime"/></td>
					<td align="right">结束日期</td>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="endTime" name="endTime"/></td>
				</tr>
				<tr>
					<td align="right">规格</td>
					<td><input type="text" style="width: 180px;" data-options="validType:['length[0,20]']"
						class="easyui-textbox" id="standard" name="standard"/></td>
					<td align="right">重量</td>
					<td><input type="text" style="width: 180px;" data-options="required:true,validType:['intOrFloat','length[1,9]']"
						class="easyui-textbox" id="weight" name="weight"/> <span><font
							style="color: #CCCCCC; font-size: 10px;">重量单位:KG</font></span></td>
				</tr>
				<tr>
					<td align="right">前台是否显示商户名</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="editable:false,panelHeight:'auto'" id="isDisVerdorname" name="isDisVerdorname">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<td align="right">前台是否显示规格</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="editable:false,panelHeight:'auto'" id="isDisStandard" name="isDisStandard">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">前台是否显示库存</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="editable:false,panelHeight:'auto'" id="isDisStore" name="isDisStore">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<td align="right">首次录入库存数量</td>
					<td><input type="text" style="width: 180px;"  data-options="required:true,validType:['isNumber','length[1,9]']"
						class="easyui-textbox" id="storeNum" name="storeNum"/></td>
				</tr>
				<tr>
					<td align="right">每个用户限购数量</td>
					<td><input type="text" style="width: 180px;" data-options="required:true,validType:['isNumber','length[1,5]']"
						class="easyui-textbox" id="limitUserNum" name="limitUserNum"/> <span><font
							style="color: #CCCCCC; font-size: 10px;">空值时不限购</font></span></td>
					<td align="right">每笔订单限购数量</td>
					<td><input type="text" style="width: 180px;"  data-options="validType:['isNumber','length[0,5]']"
						class="easyui-textbox" id="limitOrderNum" name="limitOrderNum"/></td>
				</tr>
				<tr>
					<td align="right">商品图片:</td>
					<td><input id="img" name="img" class="easyui-filebox"
						style="width: 180px;"
						data-options="onChange:function(){readGoodsPicture(this)},prompt:'请选择一张图片'" /></td>
					<td align="right">商品价格</td>
					<td><input type="text" style="width: 180px;"  data-options="required:true,validType:['intOrFloat','length[1,12]']"
						class="easyui-textbox" id="price" name="price"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div id="showGoodsPic"></div>
					</td>
				</tr>
				
				<tr>
					<td align="right" style="padding-bottom: 0px">商品详情</td>
					<td colspan="3">
						<script id="container" name="content" type="text/plain"
							 data-options="validType:['length[0,500]']">
						</script>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 商品修改表格 -->
	<div id="goodsCheckUpdateDl" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-add',inline:true"
		style="width: 100%; height: 100%; padding: 10px;">
		<form id="goodsCheckUpdateForm"  enctype="multipart/form-data">
			<table>
				<tr>
					<div><input type="hidden" name="ids" id="ids"><input type="hidden" name="goodsids" id="goodsids"></div>
					<td align="right">商品名称</td>
					<td><input type="text" style="width: 180px;" class="easyui-textbox" id="title" name="title"  
							data-options="required:true,validType:['depName','length[1,100]']" /></td>
					
					<td align="right">商品分类</td>
					<td><input type="text" id="goodsClassIds" name="goodsClassIds" class="easyui-textbox"  style="width: 160px" data-options="editable:false"/>
						<a class="easyui-linkbutton" iconCls="icon-search" plain="false" id="goodscheck_upd"  onclick="ClassTree(this)">选择</a>
					</td>
				</tr>
				<tr>
					<td align="right">商品类型</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="editable:false,panelHeight:'auto'" id="type" name="type">
							<option value="0">普通商品</option>
							<option value="1">活动商品</option>
					</select></td>
					<td align="right">商户编号</td>
					<td>
					<input class="easyui-textbox" id="update-vendorFnm" name="vendorids" readonly="true" />
							<a class="easyui-linkbutton" iconCls="icon-search" plain="false" id="upd-choose" onclick="venderFnmChoose(this)">选择</a>
					</td>
				</tr>
				<tr>
					<td align="right">开始日期</td>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="editable:false,prompt:'请选择日期'" id="startTime" name="startTime"/></td>
					<td align="right">结束日期</td>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="editable:false,prompt:'请选择日期'" id="endTime" name="endTime"/></td>
				</tr>
					<tr>
					<td align="right">每个用户限购数量</td>
					<td><input type="text" style="width: 180px;" data-options="required:true,validType:['isNumber','length[1,5]']"
						class="easyui-textbox" id="limitUserNum" name="limitUserNum"/> <span><font
							style="color: #CCCCCC; font-size: 10px;">空值时不限购</font></span></td>
					<td align="right">每笔订单限购数量</td>
					<td><input type="text" style="width: 180px;"  data-options="validType:['isNumber','length[0,5]']"
						class="easyui-textbox" id="limitOrderNum" name="limitOrderNum"/></td>
				</tr>
				<tr>
					<td align="right">前台是否显示商户名</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="editable:false,panelHeight:'auto'" id="isDisVerdorname" name="isDisVerdorname">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<td align="right">前台是否显示规格</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="editable:false,panelHeight:'auto'" id="isDisStandard" name="isDisStandard">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">前台是否显示库存</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="editable:false,panelHeight:'auto'" id="isDisStore" name="isDisStore">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<td align="right">首次录入库存数量</td>
					<td><input type="text" style="width: 180px;" readonly="true"
						class="easyui-textbox" id="storeNum" name="storeNum"/></td>
				</tr>
				<tr>
					<td align="right">每个用户限购数量</td>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="limitUserNum" name="limitUserNum"/> <span><font
							style="color: #CCCCCC; font-size: 10px;">空值时不限购</font></span></td>
					<td align="right">每笔订单限购数量</td>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="limitOrderNum" name="limitOrderNum"/></td>
				</tr>
				<tr>
					<td align="right">商品图片:</td>
					<td><input id="img" name="img" class="easyui-filebox"
						style="width: 180px;"
						data-options="onChange:function(){readUGoodsPicture(this)},prompt:'请选择一张图片'" /></td>
					<td align="right">商品价格</td>
					<td><input type="text" style="width: 180px;"  data-options="required:true,validType:['intOrFloat','length[1,12]']"
						class="easyui-textbox" id="price" name="price"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div id="showUGoodsPic"></div>
					</td>
				</tr>
				
				<tr>
					<td align="right" style="padding-bottom: 0px">商品详情</td>
					<td colspan="3">
						<script id="containerUpdate" name="content" type="text/plain"></script>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- 商品审核详情表格 -->
	<div id="goodsCheck-show" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-add',inline:true"
		style="width: 100%; height: 100%; padding: 10px;">
		<form id="goodsCheck-show-data"  enctype="multipart/form-data">
			<table>
				<tr>
					<td align="right">商品名称</td>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox easyui-validatebox" id="title" name="title" readonly="true"/> 
					<td align="right">商品分类</td>
					<td><select style="width: 180px;" class="easyui-combobox" readonly="true" data-options="panelHeight:'auto',panelMaxHeight:'200px'" id="name" name="name"></select></td>
				</tr>
				<tr>
					<td align="right">商品类型</td>
					<td><select style="width: 180px;" class="easyui-combobox" readonly="true" data-options="panelHeight:'auto'" id="type" name="type">
							<option value="0">普通商品</option>
							<option value="1">活动商品</option>
						</select>
					</td>
					
					<td align="right">商户名称</td>
					<td>
						<input class="easyui-textbox" id="update-vendorFnm" name="vendorFnm" readonly="true" />
							<a class="easyui-linkbutton" iconCls="icon-search" plain="false" onclick="venderFnmChoose()">选择</a>
					</td>
				</tr>
				<tr>
					<td align="right">开始日期</td>
					<td><input type="text" class="easyui-datetimebox" readonly="true"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="startTime" name="startTime"/></td>
					<td align="right">结束日期</td>
					<td><input type="text" class="easyui-datetimebox" readonly="true"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="endTime" name="endTime"/></td>
				</tr>
				<tr>
					<td align="right">规格</td>
					<td><input type="text" style="width: 180px;" readonly="true"
						class="easyui-textbox" id="standard" name="standard"/></td>
					<td align="right">重量</td>
					<td><input type="text" style="width: 180px;" readonly="true"
						class="easyui-textbox" id="weight" name="weight"/> <span><font
							style="color: #CCCCCC; font-size: 10px;">重量单位:KG</font></span></td>
				</tr>
				<tr>
					<td align="right">前台是否显示商户名</td>
					<td><select style="width: 180px;" class="easyui-combobox" readonly="true" data-options="panelHeight:'auto'" id="isDisVerdorname" name="isDisVerdorname">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<td align="right">前台是否显示规格</td>
					<td><select style="width: 180px;" class="easyui-combobox" readonly="true" data-options="panelHeight:'auto'" id="isDisStandard" name="isDisStandard">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">前台是否显示库存</td>
					<td><select style="width: 180px;" class="easyui-combobox" readonly="true" data-options="panelHeight:'auto'" id="isDisStore" name="isDisStore">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<td align="right">首次录入库存数量</td>
					<td><input type="text" style="width: 180px;" readonly="true"
						class="easyui-textbox" id="storeNum" name="storeNum"/></td>
				</tr>
				<tr>
					<td align="right">每个用户限购数量</td>
					<td><input type="text" style="width: 180px;" readonly="true"
						class="easyui-textbox" id="limitUserNum" name="limitUserNum"/> <span><font
							style="color: #CCCCCC; font-size: 10px;">空值时不限购</font></span></td>
					<td align="right">每笔订单限购数量</td>
					<td><input type="text" style="width: 180px;" readonly="true"
						class="easyui-textbox" id="limitOrderNum" name="limitOrderNum"/></td>
				</tr>
				<tr>
					<td align="right">商品图片:</td>
					<td><img style="height: 80px;width: 120px;" src="" id="checkImgUrl"/></td>
					<td align="right">商品价格</td>
					<td><input type="text" style="width: 180px;" readonly="true"
						class="easyui-textbox" id="price" name="price"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div id="showGoodsPic"></div>
					</td>
				</tr>
				
				<tr>
					<td align="right" style="padding-bottom: 0px">商品详情</td>
					<td colspan="3">
						<script id="containerQuery" name="content" type="text/plain"></script>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	
		<!-- 商品审核表格 -->
	<div id="checkDialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-chk-checked',inline:true"
		style="width: 500px; height: 260px; padding: 10px;">
		<form id="checkForm">
			<table>
				<tr>
					<td align="right">审核状态</td>
					<td>
						<input type="radio" name="reviewStatues" value="1">审核通过</input>
                		<input type="radio" name="reviewStatues" value="2">审核拒绝</input>
					</td>
				</tr>
				<tr>
					<td align="right" style="padding-bottom: 0px">审核备注</td>
					<td><input type="text" style="width: 350px;height: 120px" data-options="multiline:true,validType:['length[0,200]']"
						class="easyui-textbox" id="reviewDesc" name="reviewDesc" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 商品分类树弹框 -->
	<div id="goodsClassTreeDlg" data-options="closed:true,resizable:true,modal:true,buttons:'#classChooseBtns'">
		<div id="goodsClassTree" style="padding:4px;"></div>
	</div>

	<!-- 商品分类Id查询dialog按钮 -->
	<div id="classChooseBtns">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="classIdChoose(name)">选择</a>
	</div>
	
	

<!-- 商品审核商户id查询dialog -->
<div id="vendersChooseDialog" class="easyui-dialog" title="商户列表" style="width: 600px; height: 333px;padding:0 0 0 0;"
	 data-options="closed:true,resizable:true,modal:true,buttons:'#vendersChooseBtns'">
	<div id="venderToolbar" style="width: 100%">
		<!-- 商户条件搜索 -->
		<form id="venderSearchForm" method="post">
			<div align="left">
				<table class="" style="width: 95%">
					<tr>
						<td style="width:10%;padding:0 10px 0 0;" align="right">商户编号</td>
						<td style="width:15%" align="left">
							<input class="easyui-textbox" id="vender-vendorId" name="vendorId" style="width:80%"/>
						</td>
						<td style="width:10%;padding:0 10px 0 0;" align="right">商户名称</td>
						<td style="width:15%" align="left">
							<input class="easyui-textbox" id="vender-vendorSnm" name="vendorSnm" style="width:80%" />
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<a class="easyui-linkbutton" iconCls="icon-search" plain="false" onclick="venderDoSearch()">查询</a>&nbsp;&nbsp;
							<a class="easyui-linkbutton" iconCls="icon-edit-clear" plain="false" onclick="venderClearAll()">清空</a>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<!-- 商户数据表 -->
	<table id="venderDataTable" class="easyui-datagrid" singleSelect="true" style="width: 97%"
		data-options="url:'/spUser/findByPage',
					fitColumns:true,
					pagination:true,
					pageSize:5,
					pageList:[5,10,15,20],
       			 toolbar:'#venderToolbar',striped:true">
		<thead>
			<tr>
				<th field="_ddd" width="15%" data-options="checkbox:true">选择</th>
				<th field="vendorId" width="20%" align="center">商户编号</th>
				<th field="vendorFnm" width="50%" align="center">商户全称</th>
				<th field="vendorSnm" width="20%" align="center">商户简称</th>
			</tr>
		</thead>
	</table>    
</div>
<!-- 商户id查询dialog按钮 -->
<div id="vendersChooseBtns">
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="vendersChoose(name)">选择</a>
</div>