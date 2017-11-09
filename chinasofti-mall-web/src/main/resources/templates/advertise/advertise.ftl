<script type="text/javascript" src="js/advertise.js">
</script>
<div class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="advertise-toolbar" >
		<div class="wu-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="addAdvertise()" plain="true">添加</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="editAdvertise()" plain="true">修改</a>
			 <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteAdvertise()" plain="true">删除</a> 
			 <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="showAdvertise()" plain="true">查看</a>
		</div>
		<form id="searchForm">
		<div class="wu-toolbar-search">
			<label>广告标题：</label> <input type="text" id="ad_search_title" name="title" /> <label>广告类型：</label>
			 <select id="ad_search_type">
				<option value="">请选择</option>
				<option value="1">正常</option>
				<option value="0">备用</option>
			</select> 
			<label>广告位置：</label> 
			<select id="ad_search_position" name="title">
				<option value="">请选择</option>
				<option value="1">专区广告</option>
				<option value="2">分类广告</option>
				<option value="3">首页轮播位</option>
			</select> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"
				onclick="ad_search()">开始检索</a> <a href="#" class="easyui-linkbutton"
				iconCls="icon-edit-clear" onclick="ad_clear()">清除</a>
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
       				  pageList: [15, 25, 50, 100]"
       				 >
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
	<div id="ad-edit-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width: 500px; padding: 50px;" buttons="#ad-edit-dialog-button">
		<form id="ad-edit-form" method="post" enctype="multipart/form-data">
			<input name="ids" type="hidden">
			<table>
				<tr>
					<td width="60" align="right">标题*:</td>
					<td><input type="text" id="" name="title"
						class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td width="60" align="right">链接URL*:</td>
					<td><input type="text" id="" name="url" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<td align="right">广告类型*:</td>
					<td>
						<select id="" name="type" >
							<option value="" selected="selected" >请选择</option>
							<option value="1">正常</option>
							<option value="0">备用</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">广告位名称*:</td>
					<td>
						<select id="positionId" name="title">
							<option value="" selected="selected">请选择</option>
							<option value="1">专区广告</option>
							<option value="2">分类广告</option>
							<option value="3">首页轮播位</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">分类名称*:</td>
					<td>
						<select id="" name="categoryName">
							<option>休闲零食</option>
							<option>生鲜水果</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">有效开始日期*:</td>
					<td>
						<input type="text" id="" name="beginTime" class="easyui-datetimebox" required="required" />
					</td>
				</tr>
				<tr>
					<td align="right">有效结束日期*:</td>
					<td>
						<input type="text" id="" name="endTime" class="easyui-datetimebox" data-options="required:true" />
					</td>
				</tr>
				<tr>
				<td align="right">图片:</td>
				<td><input name="file" type="file" onchange="previewImage(this)"/>
					<div id="preview">  
			    			<img id="imghead"  style="max-width:235px;max-height:175px;width:135;height:75;" src=''>  
					</div>
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
	<div id="ad-show-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',inline:true" style="width: 80%; padding: 50px;">
		<form id="ad-show-form" method="post" enctype="multipart/form-data">
			<table>
			<tr>
				<td style="width:10%;padding:0 15px 0 0;" align="right">标题</td>
				<td style="width:40%" align="left" align="left">
					<input type="text" id="" name="title" class="easyui-textbox" readonly="readonly"/>
				</td>
				<td style="width:10%;padding:0 15px 0 0;" align="right">链接URL</td>
				<td style="width:40%" align="left" align="left">
				<input type="text" id="" name="url" class="easyui-textbox" readonly="readonly" />
				</td>
			</tr>
			<tr>
				<td style="width:10%;padding:0 15px 0 0;" align="right" >有效开始日期</td>
				<td style="width:40%" align="left" align="left">
				<input type="text" id="" name="beginTime" readonly="readonly"  class="easyui-textbox"/>
				</td>
				<td align="right">有效结束日期</td>
				<td><input type="text" id="" name="endTime" readonly="readonly"  class="easyui-textbox"/></td>
			</tr>
			<tr>
				<td align="right">图片</td>
				<td align="left"><img id="showImg" style="width:200px;height: 100px"/></td>
				<td align="right">广告类型</td>
				<td align="left">
				<select id="" name="type" disabled="disabled">
						<option value="">请选择</option>
						<option value="1">正常</option>
						<option value="0">备用</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align="right" >广告位名称</td>
				<td>
					<select id="positionName" name="title" disabled="disabled" >
						<option value="">请选择</option>
						<option value="1">专区广告</option>
						<option value="2">分类广告</option>
						<option value="3">首页轮播位</option>
					</select>
				</td>
					<td align="right">分类名称</td>
				<td><select id="" name="categoryName" disabled="disabled">
						<option>休闲零食</option>
						<option>生鲜水果</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">广告尺寸提示</td>
				<td><textarea rows="5px" cols="50px" placeholder="上传图片 请务必上传比例为宽750*高180的图片，以避免前端图片展现失真或形变;图片格式必须为jpg,png,gif,jpeg中的一种" disabled="disabled"></textarea></td>
				<td align="right" >广告排序</td>
				<td><input name="descs" readonly="readonly" /></td>
			</tr>
			<tr>
				<td align="right" >创建者</td>
				<td><input name="createBy" readonly="readonly" />
				</td>
				<td align="right">创建时间</td>
				<td><input name="createTime" readonly="readonly" />
				</td>
			</tr>
			
			<tr>
				<td align="right">更新者</td>
				<td><input name="updateBy" disabled="disabled" /></td>
				<td align="right">更新时间</td>
				<td><input name="updateTime" disabled="disabled" />
				</td>
			</tr>
			</table>
		</form>
</div>
</div>
