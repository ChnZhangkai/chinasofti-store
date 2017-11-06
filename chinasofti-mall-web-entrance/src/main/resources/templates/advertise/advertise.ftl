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
