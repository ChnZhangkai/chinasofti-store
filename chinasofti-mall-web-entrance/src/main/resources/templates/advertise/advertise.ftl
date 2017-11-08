<<<<<<< HEAD
<script type="text/javascript" src="js/advertise.js">
<!--
	
//-->
</script>
<div class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="advertise-toolbar">
		<div class="wu-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="addAdvertise()" plain="true">添加</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="editAdvertise()" plain="true">修改</a>
			 <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteAdvertise()" plain="true">删除</a> 
			 <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="showAdvertise()" plain="true">查看</a>
			 <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="publicAdvertise()" plain="true">广告发布</a>
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
    				 fitColumns:true,
       				 pagination:true,
       				 sortName:'ids',
       				 sortOrder:'asc',
       				 toolbar:'#mainorderToolbar',
       				 title:'主订单列表',
       				 iconCls:'icon-man',
       				 striped:true,
       				 collapsible:true">
		<thead>
			<tr>
				<th field="title" width="15%" align="center" data-options="sortable:true">标题</th>
				<th field="url" width="15%" align="center" data-options="sortable:true">链接URL</th>
				<th field="type" width="15%" align="center" data-options="formatter:typeFormatter,sortable:true">广告类型</th>
				<th field="states" width="15%" align="center" data-options="formatter:statesFormatter,sortable:true">前台状态</th>
				<th field="positionName" width="15%" align="center" data-options="sortable:true">广告位名称</th>
				<th field="categoryName" width="15%" align="center" data-options="sortable:true">分类广告名称</th>
				<th field="beginTime" width="15%" align="center" data-options="sortable:true">有效开始日期</th>
				<th field="endTime" width="15%" align="center" data-options="sortable:true">有效结束日期</th>
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
	
	<div id="ad-show-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',inline:true" style="width: 80%; padding: 50px;"
	buttons="#ad-show-dialog-button">
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
	<!-- 分页工具条 -->
	<div id="pagination" style="background: #efefef; border: 1px solid #ccc;"></div>
</div>

=======
<script type="text/javascript" src="js/common.js"></script>
<div class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="advertise-toolbar">
		<div class="wu-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="addAdvertise()" plain="true">添加</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="" plain="true">修改</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="" plain="true">删除</a> 
			<a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="" plain="true">导出</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="" plain="true">打印</a>
		</div>
		<div class="wu-toolbar-search">
			<label>广告标题：</label> <input type="text" id="ad_search_title" name="title" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="ad_search()">开始检索</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="ad_clear()">清除</a>
		</div>
	</div>

	<!-- 数据显示datagrid -->
	<table id="advertise-datagrid" class="easyui-datagrid"
		toolbar="#advertise-toolbar">
		<thead>
			<tr>
				<th field="title" width="15%" align="center">标题</th>
				<th field="url" width="15%" align="center">链接URL</th>
				<th field="states" width="15%" align="center">前台状态</th>
				<th field="positionName" width="15%" align="center">广告位名称</th>
				<th field="categoryName" width="15%" align="center">分类广告名称</th>
				<th field="beginTime" width="15%" align="center">有效开始日期</th>
				<th field="endTime" width="15%" align="center">有效结束日期</th>
			</tr>
		</thead>
	</table>
	<div id="ad-edit-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width: 500px; padding: 50px;">
	<form id="ad-edit-form" method="post" enctype="multipart/form-data">
		<input name="ids" type="hidden">
		<table id="add">
			<tr>
				<td width="60" align="right">标题*:</td>
				<td><input type="text" id="" name="title" class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td width="60" align="right">链接URL*:</td>
				<td><input type="text" id="" name="url"
					class="easyui-textbox" /></td>
			</tr>
			<tr>
				<td align="right">广告位名称*:</td>
				<td><input type="text" id="" name="positionName" class="easyui-textbox"/></td>
			</tr>
			<tr>
				<td align="right" >有效开始日期*:</td>
				<td><input type="text" id="" name=""
					 class="easyui-datetimebox" required="required"/></td>
			</tr>
			<tr>
				<td align="right">有效结束日期*:</td>
				<td><input type="text" id="" name=""
					 class="easyui-datetimebox"  data-options="required:true" /></td>
			</tr>
			<tr>
				<td align="right">图片:</td>
				<td><input id="" name="" class="easyui-filebox"/></td>
			</tr>
		</table>
	</form>
</div>
	<!-- 分页工具条 -->
	<div id="pagination" style="background: #efefef; border: 1px solid #ccc;"></div>
</div>
 <div><img alt="" src="/static/images/goods/phone.jpg"></div>
 <script type="text/javascript">
	$(function() {
		//获取表格datagrid的ID属性
		var tableID = $("table.easyui-datagrid").attr("id");
		//alert(tableID);
		//获取分页工具条元素
		var pageId = $('#pagination');

		//此处设置自己的url地址
		var url = '/advertise/findByPage';

		tdload(tableID, pageId, url);
	});

	//格式转换
	$('#advertise-datagrid').datagrid({
		loadFilter : function(data) {
			for (var i = 0; i < data.length; i++) {
				if (data[i].states == "1") {
					data[i].states = '已显示';
				}else{
					data[i].states = '未显示';
				}
			}
			return data;
		}
	});
	//图片转换
	/* function imgFormatter(value,row){
		//alert(123)
		var str = "";
		if(value != "" || value != null){
			str = "<img style=\"height: 80px;width: 150px;\" src=\""+value+"\"/>";
	        return str;
		}
	} */
	//搜索
	function ad_search(){
		$.ajax({ 
	          type: 'POST', 
	          url: '/advertise/findByPage', //用户请求数据的URL
	          data: {'title':$('#ad_search_title').val(),'pageNumber':1,'pageSize':10}, 
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert(textStatus); 
	          }, 
	          success: function (data) { 
	        	  data =eval("("+data+")");
	              $('#advertise-datagrid').datagrid('loadData', data.rows);
	               $('#pagination').pagination({ 
			    	  total:data.total
			    	  });
	          }
	       });
	}
	
	//清空搜索框
	function ad_clear(){
		$("#ad_search_title").val("");
	}
	
	//添加
	function addAdvertise() {
		$('#ad-edit-dialog').dialog('open').dialog('setTitle', '添加广告');
		$('#ad-edit-form').form('clear');
		//url = 'add';
	}
	
	//保存
	function saveAdvertise(){
		$('#ad-edit-form').form('submit',{
			url: 'addOrUpdate',
			onSubmit: function(){
				return $(this).form('validate');
			},
			success: function(result){
				var result = eval('('+result+')');
				if (result.errorMsg){
					$.messager.show({
						title: 'Error',
						msg: result.errorMsg
					});
				} else {
					$('#ad-edit-dialog').dialog('close');		// close the dialog
					$('#advertise-datagrid').datagrid('reload');	// reload the user data
				}
			}
		});
	}
	
</script>
>>>>>>> branch 'master' of https://github.com/ChnZhangkai/chinasofti-store.git
