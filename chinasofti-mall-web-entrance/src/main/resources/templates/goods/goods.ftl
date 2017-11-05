<script type="text/javascript" src="js/common.js"></script>
<div class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="wu-toolbar-2" style="height: 12%">
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
		<form id="searchForm">
			<label>分类名称：</label> <input type="text" id="categoryname" name="name" />
			<label>分类描述：</label> <input type="text" id="categorycommons" name="commons" />
			<label>修改员工：</label> <input type="text" id="updatebyname" name="updateBy" />
			<label>状态：</label> <select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'" id="classstates" name="states" style="width: 75px">
									<option value="">请选择</option>
									<option value="0">禁用</option>
									<option value="1">启用</option>
								</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">开始检索</a>
		    <a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="doClear()">清除</a>
		</form>	
		</div>
	</div>
	
	<!-- 数据显示datagrid -->
	<table id="goodsinfo" class="easyui-datagrid" toolbar="#wu-toolbar-2" style="height: 95%">
		<thead>
		<tr>
			<th field="ids" width="20%" align="center">分类ID</th>
			<th field="name" width="10%" align="center">分类名称</th>
			<th field="states" width="5%" align="center" data-options="formatter:statesFormatter">状态</th>
			<th field="commons" width="25%" align="center">分类描述</th>
			<th field="img" width="10%" align="center" data-options="formatter:imgFormatter">分类图片</th>
			<th field="updateBy" width="15%" align="center">修改员工</th>
			<th field="updateTime" width="15%" align="center" >修改时间</th>
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
	<form id="wu-form-2" method="post" enctype="multipart/form-data">
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
				<td><input type="file" id="url" name="url"/></td>
			</tr>
		</table>
	</form>
</div>

<!-- 修改表格 -->
<div id="wu-dialog-3" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-save'"
	style="width: 400px; padding: 10px;">
	<form id="wu-form-3" method="post">
		<table id="update">
			<tr>
				<td width="60" align="right">分类ID:</td>
				<td><input type="text" id="ids" name="ids" class="wu-text" readonly="true"/></td>
			</tr>
			<tr>
				<td width="60" align="right">分类名称:</td>
				<td><input type="text" id="name" name="name"
					class="wu-text" /></td>
			</tr>
			<tr>
				<td align="right">分类图片:</td>
				<td><input type="text" id="url" name="url"
					class="wu-text" readonly="true"/>
				</td>
			</tr>
			<tr>
				<td align="right">分类详情:</td>
				<td><input type="text" id="title" name="title"
					class="wu-text" /></td>
			</tr>
		</table>
	</form>
</div>


<!-- End of easyui-dialog -->
<script type="text/javascript">
$(function(){
	$.messager.show({
		title:'提示',
		msg:'该充值智商了!'
	});
	//获取表格datagrid的ID属性
	var tableID = "goodsinfo";
	//alert(tableID);
	//获取分页工具条元素
	var pageId = $('#goodsPagination');

	//此处设置自己的url地址
	var url = '/goods/list';
	
	var pstates = $('#classstates').val();
	tdload(tableID, pageId, url);
	$.messager.progress({
		text:'数据正在加载中'
	});
	
});

function imgFormatter(value,row){
	var str = "";
	if(value != "" || value != null){
		str = "<img style=\"height: 80px;width: 150px;\" src=\""+value+"\"/>";
        return str;
	}
}

function statesFormatter(value){
	if(value == "0"){
		return '<span style="color:red">禁用</span>';
	}else{
		return '<span style="color:green">启用</span>';
	}
}


	/**
	* Name 添加记录
	*/
	function add(){
		
		$('#wu-form-2').form('submit', {
			url:'/goods/save',
			type:'POST',
			success:function(data){
				if(data > 0){
					$('#pagination').pagination('select');
					$('#wu-dialog-2').dialog('close');
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
	* Name 删除记录
	*/
	function remove(){
	
		var items = $('#goodsinfo').datagrid('getSelections');
		var ids = [];
		
		/*alert(JSON.stringify(items));*/
		
		
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中要删的数据');
			return ;
		}
	
		$.messager.confirm('信息提示','确定要删除该记录？', function(result){
			if(result){
				$(items).each(function(){
					ids.push(this.ids);	
				});
				/*alert(ids);*/
				$.ajax({
					url:'/goods/delete/' + ids,
					type:'POST',
					success:function(data){
						if(data){
							$.messager.alert('信息提示','删除成功！','info');
							//$('#goodsinfo').datagrid('reload')
							$('#pagination').pagination('select');
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
		$('#wu-form-2').form('clear');
		$('#wu-dialog-2').dialog({
			closed: false,
			modal:true,
            title: "添加信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#wu-dialog-2').dialog('close');                    
                }
            }]
        });
	}
	

	/**
	* Name 打开修改窗口
	*/
	function openEdit(){
		var row = $("#goodsinfo").datagrid('getSelected');
		if (row) {
			//alert(JSON.stringify(row));
			$('#wu-dialog-3').dialog('open').dialog({
				closed: false,
				modal:true,
	            title: "修改订单信息",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: edit
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#wu-dialog-3').dialog('close');                    
	                }
	            }]
	        });
			$('#wu-form-3').form('load',row);
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/*
	*修改
	*/
	function edit(){
		$('#wu-form-3').form('submit', {
			url:'/goods/update',
    		type:'POST',
    		data:$('#wu-form-3').serialize(),
    		success:function(data){
    			if(data > 0){
    				$.messager.alert('信息提示','提交成功！','info');
    				$('#wu-dialog-3').dialog('close');
    				$('#pagination').pagination('select');
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
		$.ajax({ 
	          type: 'POST', 
	          url: '/goods/list', //用户请求数据的URL
	          data: $('#searchForm').serialize(), 
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert(textStatus); 
	          }, 
	          success: function (data) { 
	        	  data =eval("("+data+")");
	              $('#goodsinfo').datagrid('loadData', data.rows);
	               $('#pagination').pagination({ 
			    	  total:data.total
			    	  });
	          }
	       });
	}
	
	/*
	*清除搜索框内容
	*/
	function doClear(){
		document.getElementById("categorycommons").value="";
		document.getElementById("categoryname").value="";
		document.getElementById("updatebyname").value="";
	} 	
	/**
	* Name 查询数据并打开修改窗口
	*/
	/*function openEdit(){

		var items = $('#goodsinfo').datagrid('getSelections');
		var ids = [];
		
		$(items).each(function(){
			ids.push(this.ids);
		});
		if(ids.length < 1){
			$.messager.alert('温馨提醒','请选择一条数据');
		}
		$.ajax({
			url:'/goods/select/' + ids,
			type:'POST',
			success:function(data){
				//alert(JSON.stringify(data));
				if(data){
					var obj = data;
					$('#ids').val(obj.ids);
					$('#name').val(obj.name);
					$('#url').val(obj.url);
					$('#title').val(obj.title);
					
					$('#ids').attr('readonly','readonly');
					
					$('#wu-dialog-2').dialog({
							closable:false,
							closed: false,
							modal:true,
				            title: "修改信息",
				            buttons: [{
				                text: '确定',
				                iconCls: 'icon-ok',
				                handler: function(){
				                	$('#wu-form-2').form('submit', {
				            			url:'/goods/update',
				                		type:'POST',
				                		data:$('#wu-form-2').serialize(),
				                		success:function(data){
				                			alert(data)
				                			if(data > 0){
				                				$.messager.alert('信息提示','提交成功！','info');
				                				$('#wu-dialog-2').dialog('close');
				                				$('#ids').attr('readonly',false);
				                				$('#goodsinfo').datagrid('reload')
				                			}else{
				                				$.messager.alert('信息提示','提交失败！','info');
				                			}
				                		}
				                	});
				                }
				            }, {
				                text: '取消',
				                iconCls: 'icon-cancel',
				                handler: function () {
				                    $('#wu-dialog-2').dialog('close');
				                    $('#ids').attr('readonly',false);
				                }
							          }]
				        });
						
					}
				
			}	
		});
	}*/
		
</script>