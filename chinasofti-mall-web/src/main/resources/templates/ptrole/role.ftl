<script type="text/javascript" src="js/common.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="user-toolbar-2">
        <div class="role-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="operatorChange()" plain="true">权限设置</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="print()" plain="true">打印</a>
        </div>
       	<div class="ptrole-toolbar-search">
		<form id="searchForm">
			<label>商户编号：</label> <input type="text" id="vendorId" name="vendorId"/></br>
			<label>商户名称：</label> <input type="text" id="vendorSnm" name="vendorSnm"/>
			<label>拓展网站：</label> <input type="text" id="belongSiteName" name="belongSiteName"/>
			<label>状态：</label> <select autocomplete="off" class="easyui-combobox" data-options="panelHeight:'auto'" id="classstates" name="states" style="width: 75px">
									<option selected="selected" value="">请选择</option>
									<option value="0">禁用</option>
									<option value="1">启用</option>
								</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch()">开始检索</a>
		    <a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="doClear()">清除</a>
		</form>	
		</div>
	</div>
    
	<!-- 数据显示datagrid -->
	<table id="ptroleinfo" class="easyui-datagrid" title="商户用户列表" 
			data-options="singleSelect:true,collapsible:true" style="height: 80%">
		<thead>
		<tr>
			<th field="ids" width="10%" align="center">编号</th>
			<th field="names" width="15%" align="center">角色全称</th>
			<th field="numbers" width="10%" align="center">角色数量</th>
			<th field="updateby" width="10%" align="center">更新人员</th>
			<th field="updatetime" width="10%" align="center">更新时间</th>	
			<th field="createby" width="15%" align="center">创建人员</th>	
			<th field="createtime" width="10%" align="center">创建时间</th>
			<th field="description" width="20%" align="center">角色描述</th>
		</tr>
		</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="ptrolePagination" style="background:#efefef;border:1px solid #ccc;"></div>
</div>

<!-- 添加表格 -->
<div id="ptroleAddDialog" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-save'"
	style="width: 800px; padding: 10px;">
	<form id="ptroleAdd" method="post" enctype="multipart/form-data">
		<table id="add">
			<tr>
                <td align="right">角色全称:</td>
                <td><input  id="names" name="names" class="wu-text" /></td>
                	
                <td align="right">角色数量:</td>
                <td><input id="numbers" name="numbers" class="wu-text" /></td>
            </tr>
			<tr>
				<td align="right">创建人员:</td>
                <td><input id="createby" name="createby" class="wu-text" /></td>
                
                <td align="right">更新人员:</td>
                <td><input id="updateby" name="updateby" class="wu-text" /></td>
            </tr>
            <tr>
             <td align="right">角色描述:</td>
                <td><input id="description" name="description" class="wu-text" /></td>
            </tr>
		</table>
	</form>
</div>


<!-- 修改表格 -->
<div id="ptroleUpdateDialog" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-save'"
	style="width: 800px; padding: 10px;">
	<form id="ptroleUpdate" method="post" enctype="multipart/form-data">
		<table id="update">
			<tr>
                <td align="right">角色全称:</td>
              
                <td><input  id="names" name="names" class="wu-text" /></td>
                	
                <td align="right">角色数量:</td>
                <td><input id="numbers" name="numbers" class="wu-text" /></td>
            </tr>
			<tr>
				<td align="right">创建人员:</td>
                <td><input id="createby" name="createby" class="wu-text" /></td>
                
                <td align="right">更新人员:</td>
                <td><input id="updateby" name="updateby" class="wu-text" /></td>
            </tr>
            <tr>
             <td align="right">角色描述:</td>
                <td><input id="description" name="description" class="wu-text" /></td>
                  <td><input  id="ids" name="ids" /></td>
            </tr>
		</table>
	</form>
</div>
	<div id="treeDlg">
		<div id="tree" style="padding:4px;"></div>
	</div>
<script type="text/javascript">

/*
 * 全局加载数据
 */
$(function(){
	$.messager.show({
		title:'提示',
		msg:'飘过'
	});
	
	//获取表格datagrid的ID属性,
	var tableID = "ptroleinfo";
	//获取分页工具条元素
	var pageId = $('#ptrolePagination');
	//此处设置自己的url地址
	var url = '/ptrole/all';
	//分页查询时传递查询条件
	seachId = '#searchForm';
	//调用初始化方法	
	tdload(tableID, pageId, url);
	
	$.messager.progress({
		text:'数据正在加载中'
	});
	
	$('#treeDlg').dialog({
		title: '菜单树',//窗口标题
		width: 400,//窗口宽度
		height: 300,//窗口高度
		closed: true,//窗口是是否为关闭状态, true：表示关闭
		modal: true,//模式窗口
		resizable:true
	});
	
	$('#tree').tree({
		animate:true,
		checkbox:true
	});
	
});

	
	/**
	* Name 删除记录
	*/
	function remove(){
		var items = $('#ptroleinfo').datagrid('getSelections');
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
					url:'/ptrole/delete/' + ids,
					type:'POST',
					success:function(data){
						if(data){
							$.messager.alert('信息提示','删除成功！','info');
							//$('#ptroleinfo').datagrid('reload')
							$('#ptrolePagination').pagination('select');
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
		$('#ptroleAdd').form('clear');
		$('#ptroleAddDialog').dialog({
			closed: false,
			closable:false,
			modal:true,
            title: "添加商户用户",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#ptroleAddDialog').dialog('close');
                    $('#ptroleAdd').form('clear');
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
		$('#ptroleAdd').form('submit', {
			url:'/ptrole/add',
			type:'POST',
			success:function(data){
				if(data > 0){
					$('#ptrolePagination').pagination('select');
					$('#ptroleAddDialog').dialog('close');
					$.messager.alert('信息提示','提交成功！','info');
				}else{
					$.messager.alert('信息提示','提交失败！','info');
				}
			}
		});
	}

		/**
	* Name 打开修改窗口
	*/
	function openEdit(){
		$('#ptroleUpdate').form('clear');
		var row = $("#ptroleinfo").datagrid('getSelected');
		if (row) {
			$('#ptroleUpdateDialog').dialog('open').dialog({
				closed: false,
				modal:true,
				closable:false,
	            title: "修改商户用户",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: edit
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#ptroleUpdateDialog').dialog('close');
	                }
	            }]
	        });
			$('#ptroleUpdate').form('load',row);
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/**
	 * 角色权限设置
	 *
	 */
	function operatorChange(){
		$('#treeDlg').dialog('open');
		var row = $("#ptroleinfo").datagrid('getSelected');
		var id = row.ids;
		$('#tree').tree({
			url:'/ptrole/' + id
		});
		if (row) {
			$('#treeDlg').dialog('open').dialog({
				closed: false,
				modal:true,
				closable:false,
	            title: "修改角色操作",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: changeSave
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#treeDlg').dialog('close');
	                }
	            }]
	        });
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/* 
	* 修改权限
	*/
	function changeSave(){
		var nodes = $('#tree').tree('getChecked');
		var idsArr = new Array();
		$.each(nodes,function(i, node){
			idsArr.push(node.id);
		});
		//选中的菜单编号以逗号分割的字符串 
		var checkedIds = idsArr.toString();
		var row = $("#ptroleinfo").datagrid('getSelected');
		
		//构建提交参数
		var submitData = {};
		submitData.id = row.ids;
		submitData.ids = checkedIds;
		
		//提交保存请求
		$.ajax({
			url:'/ptrole/save',
			data:submitData,
			dataType:'json',
			type:'post',
			success:function(data){
				if(data > 0){
	    				$.messager.alert('信息提示','提交成功！','info');
	    				$('#treeDlg').dialog('close');
    				}else{
    					$.messager.alert('信息提示','提交失败！','info');
    				}
			}
		});
	}
	
	
	
	/*
	*修改
	*/
	function edit(){
		$('#ptroleUpdate').form('submit', {
			url:'/ptrole/update',
    		type:'POST',
    		data:$('#ptroleUpdate').serialize(),
    		success:function(data){
    			if(data > 0){
    				$.messager.alert('信息提示','提交成功！','info');
    				$('#ptroleUpdateDialog').dialog('close');
    				$('#ptrolePagination').pagination('select');
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
	          url: '/ptrole/list', //用户请求数据的URL
	          data: param, 
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert("没有查询到数据"); 
	          }, 
	          success: function (data) { 
	        	  
	        	  data =eval("("+data+")");
	        	  
	        	  if(data.total == 0){
	        		  $.messager.alert('信息提示','</br>未检索到数据！请检查查询条件','info');
	        	  }
	        	  
	              $('#ptroleinfo').datagrid('loadData', data.rows);
	               $('#ptrolePagination').pagination({ 
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
		
</script>



