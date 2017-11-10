<script type="text/javascript" src="js/common.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="user-toolbar-2">
        <div class="user-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="spUserOpenAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="spUserOpenEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-spUserRemove" onclick="spUserRemove()" plain="true">删除</a>
        </div>
       	<div class="spUser-toolbar-search">
		<form id="spUserSearchForm">
			<label>商户编号：</label> <input type="text" id="vendorId" name="vendorId" class="easyui-textbox"/>
			<label>商户名称：</label> <input type="text" id="vendorSnm" name="vendorSnm" class="easyui-textbox"/>
			<label>拓展网站：</label> <input type="text" id="belongSiteName" name="belongSiteName" class="easyui-textbox"/>
			<label>状态</label> <select autocomplete="off" class="easyui-combobox" data-options="panelHeight:'auto'" id="classstates" name="status" style="width: 125px">
									<option value=""  selected="selected">请选择</option>
									<option value="0" >未开启</option>
									<option value="1">已启用</option>
								</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="spUserDoSearch()">开始检索</a>
		    <a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="spUserDoClear()">清除</a>
		</form>	
		</div>
	</div>
    
	<!-- 数据显示datagrid -->
	<table id="spuserinfo" class="easyui-datagrid" title="商户用户列表" 
			data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'" style="height: 80%">
		<thead>
		<tr>
			<th field="vendorId" width="15%" align="center">商户编号</th>
			<th field="vendorFnm" width="20%" align="center">商户全称</th>
			<th field="vendorSnm" width="15%" align="center">商户简称</th>
			<th field="status" width="5%" align="center" data-options="formatter:statesFormatter">状态</th>
			<th field="chargeman" width="10%" align="center">商户负责人</th>	
			<th field="linkman" width="15%" align="center">商户方联系人</th>	
			<th field="mobile" width="10%" align="center">联系手机号</th>
			<th field="address" width="20%" align="center">通讯地址</th>
		</tr>
		</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="spUserPagination" style="background:#efefef;border:1px solid #ccc;"></div>
</div>

<!-- 添加表格 -->
<div id="spUserAddDialog" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-save'"
	style="width: 800px; padding: 10px;">
	<form id="spUserAdd" method="post" enctype="multipart/form-data">
		<table id="spUserAdd">
			<tr>
                <td align="right">商户编号:</td>
                <td>
                	<input  id="vendorId" name="vendorId" class="easyui-textbox" 
               		style="width: 180px" type="text" required="required" />
                	<span style="color:gray"><font size="1">由6-10位字母和数字组成</font></span>
                </td>
                	
                <td align="right">商户全称:</td>
                <td>
                  <input id="vendorFnm" name="vendorFnm" class="easyui-textbox" 
                  	style="width: 180px" type="text" required="required"/>
                	<span style="color:gray"><font size="1">长度不超过50字</font></span>
                </td>
            </tr>
            <tr>
                <td align="right">商户简称:</td>
                <td><input id="vendorSnm" name="vendorSnm" class="easyui-textbox" 
                	 style="width: 180px" type="text" required="required"/>
                	 <span style="color:gray"><font size="1">长度不超过20字</font></span>
                </td>
                
                <td align="right">状态:</td>
				<td>
					<select class="easyui-combobox easyui-validatebox" required="true" missingMessage="请选择" data-options="editable:false,panelHeight:'auto'" id="classstates" name="status" style="width: 75px">
							<option value="0" selected="selected">未开启</option>
							<option value="1">已启用</option>
					</select>
					<span style="color:gray"><font size="1">必选</font></span>
				</td>
            </tr>
          
			<tr>
                <td align="right">商户负责人:</td>
                <td><input id="chargeman" name="chargeman" class="easyui-textbox" 
                	 style="width: 180px" type="text" required="required"/>
            	 <span style="color:gray"><font size="1">长度不超过15字</font></span>
            	</td>
           
           		<td align="right">联系手机号:</td>
                <td><input id="mobile" name="mobile" class="easyui-textbox" 
                	 style="width: 180px" type="text" required="required"/>
            	 <span style="color:gray"><font size="1">长度不超过11字</font></span>
            	</td>
            </tr>
            <tr>
                <td align="right">邮箱:</td>
                <td><input id="email" name="email" class="easyui-textbox" 
                	 style="width: 180px" type="text" required="required"/>
            	 <span style="color:gray"><font size="1">长度不超过30字</font></span>
            	</td>
                
                <td align="right">通讯地址:</td>
                <td><input id="address" name="address" class="easyui-textbox" 
                	 style="width: 180px" type="text" required="required"/>
            	 <span style="color:gray"><font size="1">必填</font></span>
            	</td>
            </tr>
            
            <tr>
                <td align="right">售后服务电话:</td>
                <td><input id="servicePhone" name="servicePhone"class="easyui-textbox" 
                	 style="width: 180px" type="text" required="required"/>
            	 <span style="color:gray"><font size="1">必填</font></span>
            	</td>
                <td align="right">拓展网点名称:</td>
                <td><input id="belongSiteName" name="belongSiteName" class="easyui-textbox"
                 style="width: 180px" type="text"/>
                </td>
                
            </tr>
            <tr>
               
                <td align="right">商户介绍:</td>
                <td><textarea id="venderIntro" name="venderIntro" class="wu-textarea" /></textarea></td>
                 <td align="right">售后说明:</td>
                <td><textarea id="venderExplain" name="venderExplain" class="wu-textarea" /></textarea></td>
                
            </tr>
			
		</table>
	</form>
</div>


<!-- 修改表格 -->
<div id="spUserUpdateDialog" class="easyui-dialog"
	data-options="closed:true,iconCls:'icon-save'"
	style="width: 800px; padding: 10px;">
	<form id="spUserUpdate" method="post" enctype="multipart/form-data">
		<table id="update">
			<tr>
				<td  align="right">商户编号:</td>
				<td><input class="wu-text easyui-tooltip" id="vendorId" name="vendorId"
				 title="商户编号不可修改" style="background-color: #F4F4F4" readonly="true"/></td>
				
				<td align="right">商户全称:</td>
                <td><input id="vendorFnm" name="vendorFnm" class="wu-text" /></td>
			</tr>
			<tr>
				<td align="right">商户简称:</td>
                <td><input id="vendorSnm" name="vendorSnm" class="wu-text" /></td>
                
                <td align="right">状态:</td>
				<td>
					<select class="easyui-combobox easyui-validatebox" required="true" missingMessage="请选择" data-options="editable:false,panelHeight:'auto'" id="status" name="status" style="width: 75px">
							<option value="0">未开启</option>
							<option value="1">已启用</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">商户负责人:</td>
                <td><input id="chargeman" name="chargeman" class="wu-text" /></td>
           		<td align="right">联系手机号:</td>
                <td><input id="mobile" name="mobile" class="wu-text" /></td>
                
			</tr>
			
			
			 <tr>
                <td align="right">通讯地址:</td>
                <td><input id="address" name="address" class="wu-text" /></td>
                <td align="right">邮箱:</td>
                <td><input id="email" name="email" class="wu-text" /></td>
                
            </tr>
            <tr>
                <td align="right">拓展网点名称:</td>
                <td><input id="belongSiteName" name="belongSiteName" class="wu-text" /></td>
                
                <td align="right">创建日期:</td>
                <td>
                	<input id="createDate" name="createDate" class="wu-text easyui-tooltip" 
               		 title="不可修改" style="background-color: #F4F4F4" readonly="true"/>
                </td>
            </tr>
             <tr>
                <td align="right">创建时间:</td>
                <td><input id="createTime" name="createTime" class="wu-text easyui-tooltip" 
               		 title="不可修改" style="background-color: #F4F4F4" readonly="true"/>
                </td>
                
                <td align="right">更新时间:</td>
                <td><input id="updatetime" name="updatetime" class="wu-text easyui-tooltip" 
               		 title="不可修改" style="background-color: #F4F4F4" readonly="true"/>
                </td>
            </tr>
               <tr>
                <td align="right">更新人:</td>
                <td><input id="updateby" name="updateby" class="wu-text easyui-tooltip" 
               		 title="不可修改" style="background-color: #F4F4F4" readonly="true"/>
                </td>
                
                <td align="right">售后服务电话:</td>
                <td><input id="servicePhone" name="servicePhone" class="wu-text" /></td>
            </tr>
            
            <tr>
                <td align="right">售后说明:</td>
                <td><textarea id="venderExplain" name="venderExplain" class="wu-textarea" /></textarea></td>
                
                <td align="right">商户介绍:</td>
                <td><textarea id="venderIntro" name="venderIntro" class="wu-textarea" /></textarea></td>
                
            </tr>
			
		</table>
	</form>
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
	var tableID = "spuserinfo";
	//获取分页工具条元素
	var pageId = $('#spUserPagination');
	//此处设置自己的url地址
	var url = '/spUser/list';
	//分页查询时传递查询条件
	seachId = '#spUserSearchForm';
	//调用初始化方法	
	tdload(tableID, pageId, url);
	
	$.messager.progress({
		text:'数据正在加载中'
	});
	
});



	/*
	 * 分类状态
	 */
	function statesFormatter(value){
		if(value == "0"){
			return '<span style="color:red">未开启</span>';
		}else{
			return '<span style="color:green">已启用</span>';
		}
	}
	
	/**
	* Name 删除记录
	*/
	function spUserRemove(){
	
		var items = $('#spuserinfo').datagrid('getSelections');
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
					url:'/spUser/delete/' + ids,
					type:'POST',
					success:function(data){
						if(data){
							$.messager.alert('信息提示','删除成功！','info');
							//$('#spuserinfo').datagrid('reload')
							$('#spUserPagination').pagination('select');
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
	function spUserOpenAdd(){
		$('#spUserAdd').form('clear');
		$('#spUserAddDialog').dialog({
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
                    $('#spUserAddDialog').dialog('close');
                    $('#spUserAdd').form('clear');
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
		
		$('#spUserAdd').form('submit', {
			url:'/spUser/add',
			type:'POST',
			success:function(data){
				if(data > 0){
					$('#spUserPagination').pagination('select');
					$('#spUserAddDialog').dialog('close');
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
	function spUserOpenEdit(){
		$('#spUserUpdate').form('clear');
		var row = $("#spuserinfo").datagrid('getSelected');
		if (row) {
	
			$('#spUserUpdateDialog').dialog('open').dialog({
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
	                    $('#spUserUpdateDialog').dialog('close');
	                }
	            }]
	        });
			$('#spUserUpdate').form('load',row);
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/*
	*修改
	*/
	function edit(){
		$('#spUserUpdate').form('submit', {
			url:'/spUser/update',
    		type:'POST',
    		data:$('#spUserUpdate').serialize(),
    		success:function(data){
    			if(data > 0){
    				$.messager.alert('信息提示','提交成功！','info');
    				$('#spUserUpdateDialog').dialog('close');
    				$('#spUserPagination').pagination('select');
    			}else{
    				$.messager.alert('信息提示','提交失败！','info');
    			}
    		}
    	});
	}
	
	/* 
	*查询
	*/
	function spUserDoSearch(){
		var param = $.param({'pageNumber':1,'pageSize':10}) + '&' + $('#spUserSearchForm').serialize();
		console.info(param)
		$.ajax({ 
	          type: 'POST', 
	          url: '/spUser/list', //用户请求数据的URL
	          data: param, 
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert("没有查询到数据"); 
	          }, 
	          success: function (data) { 
	        	  
	        	  data =eval("("+data+")");
	        	  
	        	  if(data.total == 0){
	        		  $.messager.alert('信息提示','</br>未检索到数据！请检查查询条件','info');
	        	  }
	        	  
	              $('#spuserinfo').datagrid('loadData', data.rows);
	               $('#spUserPagination').pagination({ 
			    	  total:data.total
			    	  });
	          }
	       });
	}
	
	/*
	*清除搜索框内容
	*/
	function spUserDoClear(){
		$("#spUserSearchForm").form("reset");
	} 	
	
	
		
</script>



