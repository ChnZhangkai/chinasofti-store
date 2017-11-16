<script type="text/javascript" src="js/common.js"></script>
<div class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="wu-toolbar-2" style="height: 10%">
		<div class="wu-toolbar-search" style="border-bottom: 1px solid #DDDDDD">
			<form id="searchForm" style="margin: 0px">
				<label>分类名称</label> <input type="text" id="categoryname" name="name" class="easyui-textbox"/>
				<label>分类描述</label> <input type="text" id="categorycommons" name="commons" class="easyui-textbox"/>
				<label>创建员工</label> <input type="text" id="createbyname" name="createBy" class="easyui-textbox"/>
				<label>状态</label> <select autocomplete="off" class="easyui-combobox" data-options="panelHeight:'auto'" id="classstates" name="states" style="width: 125px">
										<option selected="selected" value="">请选择</option>
										<option value="0">禁用</option>
										<option value="1">启用</option>
									</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">开始检索</a>
			    <a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="doClear()">清除</a>
			</form>	
		</div>
		<div class="wu-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="print()" plain="true">导出</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="print()" plain="true">打印</a>
		</div>
	</div>
	
	<!-- 数据显示datagrid -->
	<table id="goodsinfo" class="easyui-datagrid" toolbar="#wu-toolbar-2" style="height: 95%">
		<thead>
		<tr>
			<th field="ids" width="20%" align="center">分类编号</th>
			<th field="name" width="10%" align="center">分类名称</th>
			<th field="img" width="10%" align="center" data-options="formatter:imgFormatter">分类图片</th>
			<th field="commons" width="25%" align="center">分类描述</th>
			<th field="states" width="5%" align="center" data-options="formatter:statesFormatter">状态</th>
			<th field="createBy" width="15%" align="center">创建员工</th>
			<th field="createTime" width="15%" align="center" >创建时间</th>
		</tr>
		</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="goodsPagination" style="background:#efefef;border:1px solid #ccc;"></div>

</div>

<!-- 分类添加表格 -->
<div id="wu-dialog-2" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-save'"
	style="width: 400px; padding: 10px;">
	<form id="addForm" method="post" enctype="multipart/form-data">
		<table id="add">
			<tr>
				<td width="60" align="right">分类名称:</td>
				<td><input type="text" id="name" name="name"
					class="easyui-validatebox wu-text" required="true" missingMessage="请输入分类名称"/></td>
			</tr>
			<tr>
				<td align="right">分类描述:</td>
				<td><input type="text" id="commons" name="commons"
					class="wu-text" /></td>
			</tr>
			<tr>
				<td align="right">分类状态:</td>
				<td>
					<select class="easyui-combobox easyui-validatebox" required="true" missingMessage="请选择分类状态" data-options="editable:false,panelHeight:'auto'" id="states" name="states" style="width: 75px">
							<option value="0">禁用</option>
							<option value="1">启用</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">分类图片:</td>
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

<!-- 修改表格 -->
<div id="wu-dialog-3" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width: 400px; padding: 10px;">
	<form id="updateForm" method="post" enctype="multipart/form-data">
		<table id="update">
			<tr>
				<td width="60" align="right">分类编号:</td>
				<td><input type="text" id="ids" name="ids" 
				class="wu-text easyui-tooltip" title="分类ID不可修改" style="background-color: #F4F4F4" readonly="true"/></td>
			</tr>
			<tr>
				<td width="60" align="right">分类名称:</td>
				<td><input type="text" id="name" name="name"
					class="wu-text" /></td>
			</tr>
			<tr>
				<td align="right">分类描述:</td>
				<td><input type="text" id="commons" name="commons"
					class="wu-text" /></td>
			</tr>
			<tr>
				<td align="right">分类状态:</td>
				<td>
					<select class="easyui-combobox easyui-validatebox" required="true" missingMessage="请选择分类状态" data-options="editable:false,panelHeight:'auto'" id="states" name="states" style="width: 75px">
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


<script type="text/javascript">

/*
 * 全局加载数据
 */
$(function(){
	
	//获取表格datagrid的ID属性,
	var tableID = "goodsinfo";
	//获取分页工具条元素
	var pageId = $('#goodsPagination');
	//此处设置自己的url地址
	var url = '/goods/list';
	//分页查询时传递查询条件
	seachId = '#searchForm';
	//调用初始化方法	
	tdload(tableID, pageId, url);
	
	$.messager.progress({
		text:'数据正在加载中'
	});
	
});

	/*
	 * 读取路径显示图片
	 */
	function imgFormatter(value,row){
		var str = "";
		if(value != "" || value != null){
			str = "<img style=\"height: 80px;width: 117px;\" src=\""+value+"\"/>";
	        return str;
		}
	}

	/*
	 * 分类状态
	 */
	function statesFormatter(value){
		if(value == "0"){
			return '<span style="color:red">禁用</span>';
		}else{
			return '<span style="color:green">启用</span>';
		}
	}
	
	/**
	* Name 删除记录
	*/
	function remove(){
	
		var items = $('#goodsinfo').datagrid('getSelections');
		var ids = [];
		
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中要删的数据');
			return ;
		}
	
		$.messager.confirm('信息提示','确定要删除该记录？', function(result){
			if(result){
				$(items).each(function(){
					ids.push(this.ids);	
				});
				$.ajax({
					url:'/goods/delete/' + ids,
					type:'POST',
					success:function(data){
						if(data){
							$.messager.alert('信息提示','删除成功！','info');
							//$('#goodsinfo').datagrid('reload')
							$('#goodsPagination').pagination('select');
						}
						else
						{
							$.messager.alert('信息提示','删除失败！','info');		
						}
					}	
				});
			}	
		});
	}
	
	/**
	* Name 打开添加窗口
	*/
	function openAdd(){
		$('#addForm').form('clear');
		$('#wu-dialog-2').dialog({
			closed: false,
			closable:false,
			modal:true,
            title: "添加分类",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog-2').dialog('close');
                    $('#addForm').form('clear');
                    //document.getElementById("showpic").style.display="none";
                    document.getElementById("showpic").innerHTML = "";
                }
            }]
        });
	}
	
	/**
	* Name 添加记录
	*/
	function add(){
		
		$('#addForm').form('submit', {
			url:'/goods/save',
			type:'POST',
			success:function(data){
				if(data > 0){
					$('#goodsPagination').pagination('select');
					$('#wu-dialog-2').dialog('close');
					document.getElementById("showpic").innerHTML = "";
					$.messager.alert('信息提示','提交成功！','info');
				}
				else
				{
					$.messager.alert('信息提示','提交失败！','info');
				}
			}
		});
	}

	/**
	* Name 打开修改窗口
	*/
	function openEdit(){
		$('#updateForm').form('clear');
		var row = $("#goodsinfo").datagrid('getSelected');
		if (row) {
			$('#wu-dialog-3').dialog('open').dialog({
				closed: false,
				modal:true,
				closable:false,
	            title: "修改分类",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: edit
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#wu-dialog-3').dialog('close');
	                    document.getElementById("showupic").innerHTML = "";
	                }
	            }]
	        });
			$('#updateForm').form('load',row);
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/*
	*修改
	*/
	function edit(){
		$('#updateForm').form('submit', {
			url:'/goods/update',
    		type:'POST',
    		data:$('#updateForm').serialize(),
    		success:function(data){
    			if(data > 0){
    				$.messager.alert('信息提示','提交成功！','info');
    				$('#wu-dialog-3').dialog('close');
    				$('#goodsPagination').pagination('select');
    			}else{
    				$.messager.alert('信息提示','提交失败！','info');
    			}
    		}
    	});
	}
	
	/* 
	*查询
	*/
	function doSearch(){
		var param = $.param({'pageNumber':1,'pageSize':10}) + '&' + $('#searchForm').serialize();
		//console.info(param)
		$.ajax({ 
	          type: 'POST', 
	          url: '/goods/list', //用户请求数据的URL
	          data: param, 
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert("没有查询到数据"); 
	          }, 
	          success: function (data) { 
	        	  
	        	  data =eval("("+data+")");
	        	  
	        	  if(data.total == 0){
	        		  $.messager.alert('信息提示','</br>未检索到数据！请检查查询条件','info');
	        	  }
	        	  
	              $('#goodsinfo').datagrid('loadData', data.rows);
	               $('#goodsPagination').pagination({ 
			    	  total:data.total
			    	  });
	          }
	       });
	}
	
	/*
	*清除搜索框内容
	*/
	function doClear(){
		$("#searchForm").form("reset");
	} 	
	
	/*
	 * 上传图片回显
	 */
 	function readPicture() {
		
 		var a = document.getElementsByClassName("img");
 		console.info(a);
		
		// 检查是否为图像类型
		var simpleFile = document.getElementById("img").files[0];
		console.info(simpleFile)
		if (!/image\/\w+/.test(simpleFile.type)) {
			$.messager.alert('信息提示','请确保文件类型为图像类型','info')
			return false;
		}
		var reader = new FileReader();
		// 将文件以二进制文件读入页面中
		reader.readAsBinaryString(simpleFile);
		reader.onload = function(f) {
			var result = document.getElementById("showpic");
			var src = "data:" + simpleFile.type + ";base64," + window.btoa(this.result);
			result.innerHTML = '<img id="readPic" style="height: 80px;width: 117px;" src ="' + src + '"/>';
		}
		//document.getElementById("showpic").style.display="";
	}
	
 	function updatePicture() {
		// 检查是否为图像类型
		var simpleFile = document.getElementById("uimg").files[0];
		//console.info(simpleFile)
		if (!/image\/\w+/.test(simpleFile.type)) {
			$.messager.alert('信息提示','请确保文件类型为图像类型','info')
			return false;
		}
		var reader = new FileReader();
		// 将文件以二进制文件读入页面中
		reader.readAsBinaryString(simpleFile);
		reader.onload = function(f) {
			var result = document.getElementById("showupic");
			var src = "data:" + simpleFile.type + ";base64," + window.btoa(this.result);
			result.innerHTML = '<img id="readPic" style="height: 80px;width: 117px;" src ="' + src + '"/>';
		}
		//document.getElementById("showpic").style.display="";
	}
		
</script>