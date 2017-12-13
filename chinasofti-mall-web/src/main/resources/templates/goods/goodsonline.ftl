<script type="text/javascript" src="js/goodsonline.js"></script>
<script type="text/javascript" src="js/myValidType.js"></script>
<div id="auditlist" class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="goodonline-toolbar-3">
		<div class="goodonline-toolbar-search" style="border-bottom: 1px solid #DDDDDD">
			<form id="searchOnlineForm" style="margin: 0px">
				<label>商品名称</label> <input type="text" id="title" name="title" class="easyui-textbox"/>
				<label>商户名称</label><input class="easyui-textbox" id="goodsOnline-vendorFnm" name="vendorFnm" readonly="true" />
							<a class="easyui-linkbutton" iconCls="icon-search" plain="false" onclick="vendersFnmChoose()">选择</a>
				<label>商品分类</label> 
					<input class="easyui-textbox" id="goodsOnline-name" name="name" readonly="true" />
					<a class="easyui-linkbutton" iconCls="icon-search" plain="false" onclick="classChoose()">选择</a></br>
				<label>商品类型</label>
				<select autocomplete="off" class="easyui-combobox"
					data-options="panelHeight:'auto'" id="goodsType" name="type"
					style="width: 135px">
					<option selected="selected" value="">请选择</option>
					<option value="0">普通商品</option>
					<option value="1">活动商品</option>
				</select>
				<label>商品状态</label>
				<select autocomplete="off" class="easyui-combobox"
					data-options="panelHeight:'auto'" id="status" name="status"
					style="width: 135px">
					<option selected="selected" value="">请选择</option>
					<option value="1">已上架</option>
					<option value="2">已下架</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="goodOnlineDoSearch()">开始检索</a> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="goodOnlineDoClear()">清除</a>
			</form>
		</div>
		<div class="goodonline-toolbar-button">
			 <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="onlineEdits()"plain="true">修改</a> 
			 <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="exportExcel()" plain="true">导出</a> 
			 <a href="#" class="easyui-linkbutton" iconCls="icon-arrow-redo" id="putaway" onclick="putaway(this)" plain="true">上架</a>
			 <a href="#" class="easyui-linkbutton" iconCls="icon-arrow-undo" id="soldOut" onclick="putaway(this)" plain="true">下架</a>
		
		</div>
	</div>
	<!-- 数据显示datagrid -->
	<table id="goodsOnlineinfo" class="easyui-datagrid"  style="height: 80%"
	 toolbar="goodonline-toolbar-3"	data-options="url:'/goodsOnline/findByPage',
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
		   				 pageList: [20, 40, 60, 100],
		   				 onDblClickRow:showGoodsOnline">
		   				 
	   <thead>
			<tr>
				<th field="title" width="13%" align="center" data-options="sortable:true">商品名称</th>
				<th field="img" width="10%" align="center"
					data-options="formatter:imgFormatter ,sortable:true" >商品图片</th>
				<th field="price" width="15%" align="center" data-options="sortable:true">商品价格</th>
				<th field="vendorFnm" width="15%" align="center" data-options="sortable:true">商户名称</th>
				<th field="name" width="15%" align="center" data-options="sortable:true">分类名称</th>
				<th field="type" width="10%" align="center"
					data-options="formatter:typesFormatter ,sortable:true">商品类型</th>
				<th field="storeNum" width="10%" align="center" data-options="sortable:true">当前库存</th>
				<th field="status" width="10%" align="center"
					data-options="formatter:statusFormatter,sortable:true">商品状态</th>
			</tr>
		</thead>
	</table>
	
	<!-- 分页工具条 -->
	<div id="goodsOnlinePagination" style="background:#efefef;border:1px solid #ccc;"></div>
</div>

	<!-- 商品修改表格表格 -->
	<div id="goodsOnline_updateDl" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-add',inline:true"
		style="width: 40%; height: 40%; padding: 10px">
		<form id="updateGoodsForm"  enctype="multipart/form-data">
			<table>
				<tr>
					<td><input type="hidden"  id="ids" name="ids" /></td>
				</tr>
				
				<tr>
					<td align="right">当前库存数量</td>
					<td>
						<input type="text" style="width: 180px;"
						class="easyui-textbox" id="storeNum" name="storeNum" required="required" validtype="storeNum" missingMessage="请输入修改的库存数量"/>
					</td>
				</tr>
				
			
			</table>
		</form>
	</div>
	
	<!-- 商品在线查看表格 -->
	<div id="goodsOnline-show-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-add',inline:true"
		style="width: 100%; height: 100%; padding: 10px">
		<form id="goodsOnline-show-form"  enctype="multipart/form-data">
			<table>
				<tr>
					<td><input type="hidden"  id="ids" name="ids" /></td>
				</tr>
				<tr>
					<td align="right">商品名称</td>
					<td><input type="text" id="title" name="title" style=" width: 180px;background-color:#F4F4F4"
				class="easyui-textbox"  readonly="true"/></td>
					<td align="right">分类名称</td>
					<td><input type="text" class="easyui-textbox" id="name" name="name" 
					style=" width: 180px;background-color:#F4F4F4" title="不可修改" readonly="true" /></td>
				</tr>
				<tr>
					<td align="right">商品类型</td>
					<td><select style="width: 180px;" class="easyui-combobox " data-options="panelHeight:'auto'" id="type" name="type"
					style=" width: 180px;background-color:#F4F4F4" readonly="true">
							<option value="0">普通商品</option>
							<option value="1">活动商品</option>
					</select></td>
					<td align="right">商户名称</td>
					<td>
						<input type="text" id="vendorFnm" name="vendorFnm" class="easyui-textbox"
						 title="不可修改" style=" width: 180px;background-color: #F4F4F4" readonly="true"/>
					</td>
				</tr>
				<tr>
					<td align="right">开始日期</td>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="startTime" name="startTime" readonly="true"/></td>
					<td align="right">结束日期</td>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="endTime" name="endTime" readonly="true"/></td>
				</tr>
				
				
				<tr>
					<td align="right">规格</td>
					<td><input type="text" id="standard" name="standard" class="easyui-textbox"
						 title="不可修改" style=" width: 180px;background-color: #F4F4F4" readonly="true" /></td>
					<td align="right">重量</td>
					<td><input type="text" id="weight" name="weight" class="easyui-textbox"
						 title="不可修改" style="width: 180px;background-color: #F4F4F4" readonly="true"  /> <span><font
							style="color: #CCCCCC; font-size: 10px;">重量单位:KG</font></span></td>
				</tr>
				
				<tr>
					<td align="right">审核状态</td>
					<td><select style="width: 180px;" class="easyui-combobox " data-options="panelHeight:'auto'" id="reviewStatues" name="reviewStatues"
					style=" width: 180px;background-color:#F4F4F4" readonly="true">
							<option value="0">待提交审核</option>
							<option value="3">已提交审核</option>
							<option value="1">审核通过</option>
							<option value="2">审核拒绝</option>
				
					<td align="right">商品状态</td>
					<td><select style="width: 180px;" class="easyui-combobox " data-options="panelHeight:'auto'" id="status" name="status"
					style=" width: 180px;background-color:#F4F4F4" readonly="true">
						<option value="1">已上架</option>
						<option value="2">已下架</option>
					</select></td>
						
				</tr>
				<tr>
					<td align="right">前台是否显示商户名</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="isDisVerdorname" name="isDisVerdorname" readonly="true">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<td align="right">前台是否显示规格</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="isDisStandard" name="isDisStandard" readonly="true">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">前台是否显示库存</td>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="isDisStore" name="isDisStore" readonly="true">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<td align="right">每个用户限购数量</td>
				<td><input type="text" style="width: 180px;"
					class="easyui-textbox" id="limitUserNum" name="limitUserNum" readonly="true"/> <span><font
						style="color: #CCCCCC; font-size: 10px;">空值时不限购</font></span></td>
				</tr>
				<tr>
					<td align="right">每笔订单限购数量</td>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="limitOrderNum" name="limitOrderNum" readonly="true"/></td>
					<td align="right">商品价格</td>
					<td><input type="text" id="price" name="price" class="easyui-textbox"
						 title="不可修改" style=" width: 180px;background-color: #F4F4F4" readonly="true" />
					</td>
				</tr>
				<tr>
				<td align="right">商品图片</td>
				<td><img style="height: 80px;width: 120px;" src="" id="imgUrl"/></td>
					
				</tr>
				
				<tr>
					<td></td>
					<td>
						<div id="showGoodsPic"></div>
					</td>
				</tr>
				
					<tr>
					<td align="right">售后电话</td>
					<td><input type="text" id="servicePhone" name="servicePhone" class="easyui-textbox"
						 title="不可修改" style=" width: 180px;background-color: #F4F4F4" readonly="true" />
					</td>
				
					<td align="right">当前库存数量</td>
					<td>
						<input type="text" style="width: 180px;"
						class="easyui-textbox" id="storeNum" name="storeNum"  readonly="readonly"/>
					</td>
				</tr>
				
				<tr>
					<td align="right" style="padding-bottom: 0px">商品详情</td>
					<td colspan="3">
						<script id="containeGoods" name="common" type="text/plain"></script>
					</td>
				</tr>
			
			
			
			</table>
		</form>
	</div>
	
	<div id="ClassTreeDlg" data-options="closed:true,resizable:true,modal:true,buttons:'#ChooseBtns'">
		<div id="classTree" style="padding:4px;"></div>
	</div>

	<!-- 商品分类Id查询dialog按钮 -->
	<div id="ChooseBtns">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="Choose()">选择</a>
	</div>
	

<!-- 商品审核商户id查询dialog -->
<div id="FnmChooseDialog" class="easyui-dialog" title="商户列表" style="width: 600px; height: 333px;padding:0 0 0 0;"
	 data-options="closed:true,resizable:true,modal:true,buttons:'#FnmChooseBtns'">
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
	<table id="venderDatas" class="easyui-datagrid" singleSelect="true" style="width: 97%"
		data-options="url:'/spUser/list',
				fitColumns:true,pagination:true,pageSize:5,pageList:[5,10,15,20],
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
<div id="FnmChooseBtns">
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="FnmChoose()">选择</a>
</div>