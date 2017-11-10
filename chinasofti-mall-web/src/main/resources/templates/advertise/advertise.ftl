<script type="text/javascript" src="js/advertise.js">
</script>
<div class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="advertise-toolbar" >
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
				<input id="ad_search_title" name="title" class="easyui-textbox" style="width: 120px" /> 
				<label>广告类型：</label>
				 <select id="ad_search_type" class="easyui-combobox" style="width: 100px">
					<option value="">请选择</option>
					<option value="1">正常</option>
					<option value="0">备用</option>
				</select> 
				<label>广告位置：</label> 
				<select id="ad_search_position" class="easyui-combobox" style="width: 100px">
					<option value="">请选择</option>
					<option value="1">专区广告</option>
					<option value="2">分类广告</option>
					<option value="3">首页轮播位</option>
			</select> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="ad_search()">开始检索</a> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="ad_clear()" >清除</a>
			</div>
		</form>
	</div>

	<!-- 数据显示datagrid -->
	<table id="ad-datagrid" class="easyui-datagrid" toolbar="#advertise-toolbar"
		data-options="url:'/advertise/findByPage',
    				 	 fitColumns:false,
       				 pagination:true,
       				 sortName:'ids',
       				 sortOrder:'asc',
        				 title:'广告列表',
       				 iconCls:'icon-man',
       				 striped:true,
       				 singleSelect:true,
       				 collapsible:true,
       				 pageSize:15,
       				  pageList: [15, 25, 50, 100]">
		<thead>
			<tr>
				<th field="title"  width="15%" align="center" data-options="sortable:true">标题</th>
				<th field="url"   width="15%" align="center" data-options="sortable:true">链接URL</th>
				<th field="type"  width="15%" align="center" data-options="formatter:typeFormatter,sortable:true">广告类型</th>
				<th field="states"  width="15%" align="center" data-options="formatter:statesFormatter,sortable:true">前台状态</th>
				<th field="positionName"  width="15%" align="center" data-options="sortable:true">广告位名称</th>
				<th field="categoryName"  width="15%" align="center" data-options="sortable:true">分类广告名称</th>
				<th field="beginTime"  width="15%" align="center" data-options="sortable:true">有效开始日期</th>
				<th field="endTime" width="15%" align="center" data-options="sortable:true">有效结束日期</th>
				<th field="_operator"  width="15%" align="center" data-options="formatter:OperatorFormatter">操作</th>  
			</tr>
		</thead>
	</table>
	<!-- 编辑框 -->
	<div id="ad-edit-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',inline:true" style="width: 100%;height: 100%;padding:10px" buttons="#ad-edit-dialog-button">
		<form id="ad-edit-form" method="post" enctype="multipart/form-data" >
			<input name="ids" type="hidden">
			<table >
				<tr>
					<th nowrap="nowrap" >标题*:</th>
					<td >
						<input style="width: 180px" type="text" required="required"  name="title" class="easyui-textbox" />
						<span style="color:gray"><font size="1">1-100位任意字符</font></span>
					</td>
					<th nowrap="nowrap">链接URL*:</th>
					<td>
					<input style="width: 180px" data-options="required:true,validType:'url'" name="url" class="easyui-textbox easyui-validatebox" />
						<span style="color:gray"><font size="1">请填完整链接</font></span>
					</td>
				</tr>
				<tr>
					<th nowrap="nowrap" style="padding:10px">广告类型*:</th>
					<td>
						<select id="" name="type" style="width: 180px" class="easyui-combobox" required="required"  >
							<option value="" selected="selected">请选择</option>
							<option value="1">正常</option>
							<option value="0">备用</option>
						</select>
						<span style="color:gray"><font size="1">必选</font></span>
					</td>
					<th nowrap="nowrap">广告位名称*:</th>
					<td>
						<select id="positionId" name="title" style="width: 180px" class="easyui-combobox" required="required">
							<option value="" data-options="selected:true">请选择</option>
							<option value="1">专区广告</option>
							<option value="2">分类广告</option>
							<option value="3">首页轮播位</option>
						</select>
						<span style="color:gray"><font size="1">必选</font></span>
					</td>
				</tr>
				<tr>
					<th  style="padding:10px">分类名称*:</td>
					<td>
						<select id="_className" name="categoryName" style="width: 180px" required="required" class="easyui-combobox"></select>
					</td>
					
					<th nowrap="nowrap">有效开始日期*:</th>
					<td>
						<input type="text" data-options="prompt:'请输入日期',required:'true'" name="beginTime" class="easyui-datetimebox"  style="width: 180px" />
					</td>
				</tr>
				<tr>
					<th nowrap="nowrap" style="padding:10px">有效结束日期*:</th>
					<td>
						<input type="text" data-options="prompt:'请输入日期'" name="endTime" class="easyui-datetimebox" data-options="required:true" style="width: 180px" />
						<span style="color:gray"><font size="1">必选</font></span>
					</td>
					<th nowrap="nowrap">排序*:</th>
					<td>
						<input type="text" name="descs" class="easyui-textbox" data-options="required:true" style="width: 180px" />
						<span style="color:gray"><font size="1">1-10位任意字符</font></span>
					</td>
				</tr>
				<tr>
					<th nowrap="nowrap">图片:</th>
					<td>
						<input name="file" type="file" onchange="previewImage(this)"/>
						<div id="preview">  
			    				<img id="imghead"  style="max-width:235px;max-height:175px;width:135;height:75;" src=''>  
						</div>
						<span style="color:gray" ><font size="1">请务必上传比例为宽750*高180的图片，
						以避免前端图片展现失真或形变;图片格式必须为jpg,png,gif,jpeg中的一种
						</font></span>
						<span style="color:gray"><font size="1">必选</font></span>
					</td>
				</tr>	
				
			</table>
		</form>
	</div>
	<div id="ad-edit-dialog-button">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveAdvertise()">保存</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#ad-edit-dialog').dialog('close')">取消</a>
	</div>

	<!-- 广告查看框  -->
	<div id="ad-show-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',inline:true" style="width: 100%;height:100%; padding: 50px;">
		<form id="ad-show-form" method="post" enctype="multipart/form-data">
			<table>
			<tr>
				<th style="width:180px" align="right">标题</th>
				<td style="width:180px" align="left" align="left">
					<input type="text" id="" name="title" class="easyui-textbox" readonly="readonly" style="width:180px"/>
				</td>
				<th style="width:10%;padding:0 15px 0 0;" align="right">链接URL</th>
				<td style="width:40%" align="left" align="left">
				<input type="text" id="" name="url" class="easyui-textbox" readonly="readonly" style="width:180px"/>
				</th>
			</tr>
			<tr>
				<th style="width:10%;padding:0 15px 0 0;" align="right" >有效开始日期</th>
				<td style="width:40%" align="left" align="left">
				<input type="text" id="" name="beginTime" readonly="readonly"  class="easyui-textbox" style="width:180px"/>
				</td>
				<th align="right">有效结束日期</th>
				<td><input type="text" id="" name="endTime" readonly="readonly"  class="easyui-textbox" style="width:180px"/></td>
			</tr>
			<tr>
				<th align="right">图片</th>
				<td align="left"><img id="showImg" style="width:180px"/></td>
				<th align="right">广告类型</th>
				<td align="left">
				<select id="" name="type" disabled="disabled" class="easyui-combobox" style="width:180px">
						<option value="">请选择</option>
						<option value="1">正常</option>
						<option value="0">备用</option>
				</select>
				</td>
			</tr>
			<tr>
				<th align="right" >广告位名称</th>
				<td>
					<select id="positionName" name="title" disabled="disabled" class="easyui-combobox" style="width:180px">
						<option value="">请选择</option>
						<option value="1">专区广告</option>
						<option value="2">分类广告</option>
						<option value="3">首页轮播位</option>
					</select>
				</td>
				<th align="right">分类名称</th>
				<td>
					<input id="" name="categoryName" readonly="readonly" class="easyui-textbox" style="width:180px">
				</td>
			</tr>
			<tr>
				<th align="right">广告尺寸提示</th>
				<td><textarea rows="5px" cols="50px" placeholder="上传图片 请务必上传比例为宽750*高180的图片，以避免前端图片展现失真或形变;图片格式必须为jpg,png,gif,jpeg中的一种" disabled="disabled"></textarea></td>
				<th align="right" >广告排序</th>
				<td><input name="descs" readonly="readonly" style="width:180px" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<th align="right" >前台展示状态</th>
				<td>
					<select name="states" disabled="disabled" class="easyui-combobox" style="width:180px">
						<option value="0">备用</option>
						<option value="1">正常</option>
					</select>
				</td>
				<th align="right" >创建者</th>
				<td><input name="createBy" readonly="readonly" class="easyui-textbox" style="width:180px"/>
				</td>
			</tr>
			
			<tr>
				<th align="right">创建时间</th>
				<td><input name="createTime" readonly="readonly" class="easyui-textbox"  style="width:180px"/>
				</td>
				<th align="right">更新者</th>
				<td><input name="updateBy" readonly="readonly" class="easyui-textbox" style="width:180px"/></td>
				
			</tr>
			<tr>
				<th align="right">更新时间</th>
				<td><input name="updateTime" readonly="readonly" class="easyui-textbox" style="width:180px" />
				</td>
			</tr>
			</table>
		</form>
</div>
</div>
