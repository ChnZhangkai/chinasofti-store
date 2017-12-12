<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/goodsClass.js"></script>
<script type="text/javascript" src="js/myValidType.js"></script>
<div id="goodsClassMain" class="easyui-layout" data-options="fit:true" style="overflow-y: auto"">
	<div><font style="color: red;">1.左键双击快速修改分类名称<br>2.右键单击节点增删改<br>3.父节点不可直接删除,只可重命名和添加子节点,子节点可删除 <br>4.禁用分类灰字体显示</font></div>
	
	<!-- 菜单主体 -->
	<div>	
		<ul id="goodsClassTree"></ul>
	</div>
	
	<!-- 右键菜单 -->
	<div id="goodsClassParentMenu" class="easyui-menu" style="width:120px;">    
    	<div name="addGS" id="1" data-options="iconCls:'icon-add'" onclick="openGsAdd()" >添加</div>    
  	</div>
	
	<!-- 右键菜单 -->
	<div id="goodsClassMenu" class="easyui-menu" style="width:120px;">    
    	<div name="addGS" id="4" data-options="iconCls:'icon-add'" onclick="openGsAdd()" >添加</div>    
    	<div name="updateGS" id="5" data-options="iconCls:'icon-edit'" onclick="openGsEdit()">修改</div>    
    	<div name="deleteGS" id="6" data-options="iconCls:'icon-remove'" onclick="removeGs()" >删除</div>  
  	</div> 
	
	<!-- 修改表格 -->
	<div id="goodsClassDialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',inline:true" style="width: 450px; padding: 10px;">
		<form id="goodsClassForm" method="post" enctype="multipart/form-data">
			<table id="goodsClassTable">
				<tr>
					<td width="60" align="right">分类编号:</td>
					<td><input type="text" id="ids" name="ids" 
					class="wu-text easyui-tooltip" title="分类ID不可修改" style="background-color: #F4F4F4" readonly="true"/></td>
				</tr>
				<tr>
					<td width="60" align="right">分类名称:</td>
					<td><input id="name" name="name" class="easyui-textbox validatebox" data-options="required:true,validType:['depName','betweenLength[2,10]']"/></td>
				</tr>
				<tr>
					<td align="right">分类描述:</td>
					<td><input id="commons" name="commons" class="easyui-textbox validatebox" data-options="required:true,validType:['depName','betweenLength[2,30]']"/></td>
				</tr>
				<tr>
					<td align="right">分类状态:</td>
					<td>
						<select class="easyui-combobox validatebox" missingMessage="请选择分类状态" data-options="required:true,editable:false,panelHeight:'auto'" id="states" name="states" style="width: 75px">
								<option value="0">禁用</option>
								<option value="1">启用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="center">原图地址:</td>
					<td><input type="text" id="img" name="img"
						class="wu-text easyui-tooltip" title="请选择新图片" style="background-color: #F4F4F4" readonly="true"/></td>
				</tr>
				<tr>
					<td align="center">分类图片:</td>
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
	
	
	<!-- 分类添加表格 -->
	<div id="goodsClassAddDialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save',inline:true"
		style="width: 600px; padding: 10px;">
		<form id="goodsClassAddForm" method="post" enctype="multipart/form-data">
			<table id="goodsClassAddTable">
				<tr>
					<td width="60" align="right">分类名称:</td>
					<td><input type="text" id="name" name="name" class="easyui-textbox validatebox" missingMessage="请输入分类名称" data-options="required:true,validType:['depName','betweenLength[2,10]']"/></td>
					<td align="right">当前节点:</td>
					<td><input type="text" id="node" name="node" class="easyui-textbox" disabled="true"/></td>
				</tr>
				<tr>
					<td align="right" style="line-height: 3">分类描述:</td>
					<td><input id="commons" name="commons" class="easyui-textbox validatebox" data-options="required:true,validType:['depName','betweenLength[2,30]']"/></td>
					<td align="right">分类状态:</td>
					<td>
						<select class="easyui-combobox validatebox" required="true" missingMessage="请选择分类状态" data-options="editable:false,panelHeight:'auto'" id="states" name="states" style="width: 137px">
								<option value="0">禁用</option>
								<option value="1">启用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="hidden" id="pid" name="pid"/></td>
				</tr>
				<tr>
					<td align="right">分类图片:</td>
					<td><input type="file" id="classimg" name="img" class="img" onchange="readPicture()"/></td>
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
	
</div>
<script type="text/javascript">
	
</script>