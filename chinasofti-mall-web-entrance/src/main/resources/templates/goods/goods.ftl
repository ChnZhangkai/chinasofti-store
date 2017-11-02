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
			<label>分类名称：</label> <input type="text" id="categoryname" name="categoryname" />
			<label>分类详情：</label> <input type="text" id="categorytitle" name="categorytitle" />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">开始检索</a>
		    <a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="doClear()">清除</a>
		</div>
	</div>
	
	<!-- 数据显示datagrid -->
	<table id="tt-goodsinfo" class="easyui-datagrid" toolbar="#wu-toolbar-2" style="height: 95%">
		<thead>
		<tr>
			<th field="ids" width="25%" align="center">分类ID</th>
			<th field="name" width="25%" align="center">分类名称</th>
			<th field="url" width="25%" align="center" data-options="formatter:imgFormatter">分类图片</th>
			<th field="title" width="25%" align="center">分类详情</th>
		</tr>
		</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="pagination" style="background:#efefef;border:1px solid #ccc;"></div>

</div>

<!-- 分类添加表格 -->
<div id="wu-dialog-2" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-save'"
	style="width: 400px; padding: 10px;">
	<form id="wu-form-2" method="post" action="/goods/add">
		<table id="add">
			<tr>
				<td width="60" align="right">分类ID:</td>
				<td><input type="text" id="ids" name="ids" class="wu-text" /></td>
			</tr>
			<tr>
				<td width="60" align="right">分类名称:</td>
				<td><input type="text" id="name" name="name"
					class="wu-text" /></td>
			</tr>
			<tr>
				<td align="right">分类图片:</td>
				<td><input type="file" id="url" name="url"/></td>
			</tr>
			<tr>
				<td align="right">分类详情:</td>
				<td><input type="text" id="title" name="title"
					class="wu-text" /></td>
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
				<td><input type="text" id="cgids" name="cgids" class="wu-text" /></td>
			</tr>
			<tr>
				<td width="60" align="right">分类名称:</td>
				<td><input type="text" id="cgname" name="cgname"
					class="wu-text" /></td>
			</tr>
			<tr>
				<td align="right">分类图片:</td>
				<td><input type="text" id="cgurl" name="cgurl"
					class="wu-text" />
				</td>
			</tr>
			<tr>
				<td align="right">分类详情:</td>
				<td><input type="text" id="cgtitle" name="cgtitle"
					class="wu-text" /></td>
			</tr>
		</table>
	</form>
</div>


<!-- End of easyui-dialog -->
<script type="text/javascript">
$(function(){
	//获取表格datagrid的ID属性
	var tableID = $("table.easyui-datagrid").attr("id");
	//alert(tableID);
	//获取分页工具条元素
	var pageId = $('#pagination');

	//此处设置自己的url地址
	var url = '/goods/list';
	
	tdload(tableID, pageId, url);
});

function imgFormatter(value,row){
	//alert(123)
	var str = "";
	if(value != "" || value != null){
		str = "<img style=\"height: 80px;width: 150px;\" src=\""+value+"\"/>";
        return str;
	}
}

function imgUpdateFormatter(){
	alert(123)
	//var str = "";
	//if(value != "" || value != null){
		//str = "<img style=\"height: 10px;width: 20px;\" src=\""+value+"\"/>";
        //return str;
	//}
}


	/**
	* Name 添加记录
	*/
	function add(){
		
		$('#wu-form-2').form('submit', {
			url:'/goods/add',
			type:'POST',
			success:function(data){
				if(data){
					$.messager.alert('信息提示','提交成功！','info');
					$('#wu-dialog-2').dialog('close');
					$('#tt-goodsinfo').datagrid('reload')
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
	
		var items = $('#tt-goodsinfo').datagrid('getSelections');
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
							//$('#tt-goodsinfo').datagrid('reload')
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
	* Name 查询数据并打开修改窗口
	*/
	function openEdit(){

		var items = $('#tt-goodsinfo').datagrid('getSelections');
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
					$('#cgids').val(obj.ids);
					$('#cgname').val(obj.name);
					$('#cgurl').val(obj.url);
					$('#cgtitle').val(obj.title);
					
					/*id只读*/
					$('#cgids').attr('readonly','readonly');
					
					/*打开界面*/
					$('#wu-dialog-3').dialog({
							closable:false,
							closed: false,
							modal:true,
				            title: "修改信息",
				            buttons: [{
				                text: '确定',
				                iconCls: 'icon-ok',
				                handler: function(){
				                	$('#wu-form-3').form('submit', {
				            			url:'/goods/update',
				                		type:'POST',
				                		success:function(data){
				                			if(data){
				                				$.messager.alert('信息提示','提交成功！','info');
				                				$('#wu-dialog-3').dialog('close');
				                				$('#ids').attr('readonly',false);
				                				$('#tt-goodsinfo').datagrid('reload')
				                			}
				                		}
				                	});
				                }
				            }, {
				                text: '取消',
				                iconCls: 'icon-cancel',
				                handler: function () {
				                    $('#wu-dialog-3').dialog('close');
				                    /* $('#ids').attr('readonly',false); */
				                }
							          }]
				        });
						
					}
				
			}	
		});
		
	}
	/**
	* Name 打开修改窗口
	*/
	/*function openEdit(){
		var row = $("#tt-goodsinfo").datagrid('getSelected');
		if (row) {
			alert(JSON.stringify(row));
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
	}*/
	
	/* 
	*查询
	*/
	function doSearch(){
		$.ajax({ 
	          type: 'POST', 
	          url: '/goods/list', //用户请求数据的URL
	          data: {'title':$('#categorytitle').val(),'name':$('#categoryname').val(),'pageNumber':1,'pageSize':10}, 
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert(textStatus); 
	          }, 
	          success: function (data) { 
	        	  data =eval("("+data+")");
	              $('#tt-goodsinfo').datagrid('loadData', data.rows);
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
		document.getElementById("categorytitle").value="";
		document.getElementById("categoryname").value="";
	}
 
		
</script>