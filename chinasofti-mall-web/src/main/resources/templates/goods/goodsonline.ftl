
<div id="auditlist" class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="goodonline-toolbar-3" style="height: 15%">
		<div class="goodonline-toolbar-search" style="border-bottom: 1px solid #DDDDDD">
			<form id="searchOnlineForm" style="margin: 0px">
				<label>商品编号</label> <input type="text" id="ids" name="ids" class="easyui-textbox"/>
				<label>商品名称</label> <input type="text" id="title" name="title" class="easyui-textbox"/>
				<label>开始时间</label> <input type="text" id="goodsstarttime" name="startTime" class="easyui-datetimebox" style="width: 160px" data-options="prompt:'请选择日期',editable:'false'"/>
				<label>结束时间</label> <input type="text" id="goodsendtime" name="endTime" class="easyui-datetimebox" style="width: 160px" data-options="prompt:'请选择日期',editable:'false'"/><br>
				<label>商户编号</label> <input type="text" id="vendorId" name="vendorId" class="easyui-textbox"/>
				<label>商品分类</label> <input type="text" id="classId" name="classId" class="easyui-textbox"/>
				<label>商品类型</label>
				<select autocomplete="off" class="easyui-combobox"
					data-options="panelHeight:'auto'" id="goodsType" name="type"
					style="width: 135px">
					<option selected="selected" value="">请选择</option>
					<option value="0">普通商品</option>
					<option value="1">活动商品</option>
				</select>
				<label>商品状态</label>
				<select autocomplete="off" class="easyui-combobox"
					data-options="panelHeight:'auto'" id="status" name="status"
					style="width: 135px">
					<option selected="selected" value="">请选择</option>
					<option value="1">已上架</option>
					<option value="2">已下架</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="goodOnlineDoSearch()">开始检索</a> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="goodOnlineDoClear()">清除</a>
			</form>
		</div>
		<div class="goodonline-toolbar-button">
			 <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="onlineEdits()"plain="true">修改</a> 
			 <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="prints()" plain="true">导出</a> 
			 <a href="#" class="easyui-linkbutton" iconCls="icon-arrow-redo" id="putaway" onclick="putaway(this)" plain="true">上架</a>
			 <a href="#" class="easyui-linkbutton" iconCls="icon-arrow-undo" id="soldOut" onclick="putaway(this)" plain="true">下架</a>
		</div>
	</div>
	<!-- 数据显示datagrid -->
	<table id="goodsOnlineinfo" class="easyui-datagrid" toolbar="#goodonline-toolbar-3"
		style="height: 95%">
		<thead> 
			<tr>
				<th field="title" width="13%" align="center">商品名称</th>
				<th field="img" width="10%" align="center"
					data-options="formatter:imgFormatter">商品图片</th>
				<th field="price" width="15%" align="center">商品价格</th>
				<th field="vendorSnm" width="15%" align="center">商户名称</th>
				<th field="name" width="15%" align="center">分类名称</th>
				<th field="type" width="10%" align="center"
					data-options="formatter:typesFormatter">商品类型</th>
				<th field="storeNum" width="10%" align="center">当前库存</th>
				<th field="status" width="10%" align="center"
					data-options="formatter:statusFormatter">商品状态</th>
			</tr>
		</thead>
	</table>

	<!-- 分页工具条 -->
	<div id="goodsOnlinePagination" style="background:#efefef;border:1px solid #ccc;"></div>

	<!-- 商品修改表格表格 -->
	<div id="updateDl" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-add',inline:true"
		style="width: 100%; height: 100%; padding: 10px;background-image: url(images/goodsdiv.jpg)">
		<form id="updateGoodsForm"  enctype="multipart/form-data">
			<table>
				<tr>
					<td><input type="hidden"  id="ids" name="ids" /></td>
				</tr>
				<tr>
					<th align="right">商品名称</th>
					<td><input type="text" id="title" name="title" style=" width: 180px;background-color:#F4F4F4"
				class="easyui-textbox" title="不可修改" readonly="true"/></td>
					<th align="right">分类名称</th>
					<td><input type="text" class="easyui-textbox" id="name" name="name" 
					style=" width: 180px;background-color:#F4F4F4" title="不可修改" readonly="true" /></td>
				</tr>
				<tr>
					<th align="right">商品类型</th>
					<td><select style="width: 180px;" class="easyui-combobox " data-options="panelHeight:'auto'" id="type" name="type"
					style=" width: 180px;background-color:#F4F4F4" readonly="true">
							<option value="0">普通商品</option>
							<option value="1">活动商品</option>
					</select></td>
					<th align="right">商户名称</th>
					<td>
						<input type="text" id="vendorSnm" name="vendorSnm" class="easyui-textbox"
						 title="不可修改" style=" width: 180px;background-color: #F4F4F4" readonly="true"/>
					</td>
				</tr>
				<tr>
					<th align="right">开始日期</th>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="startTime" name="startTime" readonly="true"/></td>
					<th align="right">结束日期</th>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="endTime" name="endTime" readonly="true"/></td>
				</tr>
				
				
				<tr>
					<th align="right">规格</th>
					<td><input type="text" id="standard" name="standard" class="easyui-textbox"
						 title="不可修改" style=" width: 180px;background-color: #F4F4F4" readonly="true" /></td>
					<th align="right">重量</th>
					<td><input type="text" id="weight" name="weight" class="easyui-textbox"
						 title="不可修改" style="width: 180px;background-color: #F4F4F4" readonly="true"  /> <span><font
							style="color: #CCCCCC; font-size: 10px;">重量单位:KG</font></span></td>
				</tr>
				
				<tr>
					<th align="right">审核状态</th>
					<td><select style="width: 180px;" class="easyui-combobox " data-options="panelHeight:'auto'" id="reviewStatues" name="reviewStatues"
					style=" width: 180px;background-color:#F4F4F4" readonly="true">
							<option value="0">待提交审核</option>
							<option value="3">已提交审核</option>
							<option value="1">审核通过</option>
							<option value="2">审核拒绝</option>
				
					<th align="right">商品状态</th>
					<td><select style="width: 180px;" class="easyui-combobox " data-options="panelHeight:'auto'" id="status" name="status"
					style=" width: 180px;background-color:#F4F4F4" readonly="true">
						<option value="1">已上架</option>
						<option value="2">已下架</option>
					</select></td>
						
				</tr>
				<tr>
					<th align="right">前台是否显示商户名</th>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="isDisVerdorname" name="isDisVerdorname" readonly="true">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<th align="right">前台是否显示规格</th>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="isDisStandard" name="isDisStandard" readonly="true">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
				</tr>
				<tr>
					<th align="right">前台是否显示库存</th>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="isDisStore" name="isDisStore" readonly="true">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<th align="right">每个用户限购数量</th>
				<td><input type="text" style="width: 180px;"
					class="easyui-textbox" id="limitUserNum" name="limitUserNum" readonly="true"/> <span><font
						style="color: #CCCCCC; font-size: 10px;">空值时不限购</font></span></td>
				</tr>
				<tr>
					<th align="right">每笔订单限购数量</th>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="limitOrderNum" name="limitOrderNum" readonly="true"/></td>
					<th align="right">商品价格</th>
					<td><input type="text" id="price" name="price" class="easyui-textbox"
						 title="不可修改" style=" width: 180px;background-color: #F4F4F4" readonly="true" />
					</td>
				</tr>
				<tr>
					<th align="right">商品图片:</th>
					<td><img style="height: 75px;width: 110px;" src=""/></td>
						
					
				</tr>
				
				<tr>
					<td></td>
					<td>
						<div id="showGoodsPic"></div>
					</td>
				</tr>
				
					<tr>
					<th align="right">售后电话</th>
					<td><input type="text" id="servicePhone" name="servicePhone" class="easyui-textbox"
						 title="不可修改" style=" width: 180px;background-color: #F4F4F4" readonly="true" />
					</td>
				
					<th align="right">当前库存数量</th>
					<td>
						<input type="text" style="width: 180px;"
						class="easyui-textbox" id="storeNum" name="storeNum"/>
					</td>
				</tr>
				
				<tr>
					<th align="right" style="padding-bottom: 0px">商品详情</th>
					<td colspan="3">
						<script id="container" name="content" type="text/plain"></script>
					</td>
				</tr>
			
			
			
			</table>
		</form>
	</div>
	
</div>




<script type="text/javascript">
	
	var ue = UE.getEditor('container',{
		initialFrameWidth:1000,  //初始化编辑器宽度,默认1000  
        initialFrameHeight:140  //初始化编辑器高度,默认320
	});

	
	
	/*
	 * 全局加载数据
	 */
	$(function() {
		$.messager.show({
			title : '提示',
			msg : '该充值智商了!'
		});

		//获取表格datagrid的ID属性,
		var tableID = "goodsOnlineinfo";
		//获取分页工具条元素
		var pageId = $('#goodsOnlinePagination');
		//此处设置自己的url地址
		var url = '/goodsOnline/list';
		//分页查询时传递查询条件
		seachId = '#searchOnlineForm';
		//调用初始化方法	
		tdload(tableID, pageId, url);

		$.messager.progress({
			text : '数据正在加载中'
		});

	});


	/*
	 * 读取路径显示图片
	 */
	function imgFormatter(value, row) {
		var ids = row.ids;
		var str = "";
		images = $.ajax({url:'/goodsOnline/reqGoodsImgPath/' + ids,type:'POST',async:false});
		str = "images = $.ajax({url:'/goodsOnline/reqGoodsImgPath/' + ids,type:'POST',async:false});
		str = "<img style=\"height: 75px;width: 110px;\" src=\""+ images.responseText +"\"/>";
		return str;";
		return str;
		
	}
	

	
	
	/*
	 * 商品类型
	 */
	function typesFormatter(value){
		if(value == "0"){
			return '<span>普通商品</span>';
		}else{
			return '<span style="color:#FF00FF">活动商品</span>';
		}
	}
	
	/*
	 * 商品状态
	 */
	function statusFormatter(value) {
		if (value == "0") {
			return '<span style="color:black">已删除</span>';
		} 
		if (value == "1"){
			return '<span style="color:green">已上架</span>';
		} 
		if (value == "2"){
			return '<span style="color:red">已下架</span>';
		}
	}
	
	/**
	* Name 打开修改窗口
	*/
	function onlineEdits(){
		$('#updateGoodsForm').form('clear');
		var row = $("#goodsOnlineinfo").datagrid('getSelected');
		if (row) {
			$('#updateDl').dialog('open').dialog({
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
	                    $('#updateDl').dialog('close');
	                    document.getElementById("showGoodsPic").innerHTML = "";
	                }
	            }]
	        });
			$('#updateGoodsForm').form('load',row);
			alert($('#updateGoodsForm').serialize());
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/*
	*修改
	*/
	function edit(){
		var imgURl;
		$('#updateGoodsForm').form('submit', {
			url:'/goodsOnline/update',
    		type:'POST',
    		data:$('#updateGoodsForm').serialize(),
    		success:function(data){
    			if(data > 0){
    				$.messager.alert('信息提示','提交成功！','info');
    				$('#updateDl').dialog('close');
    				UE.getEditor('container').setContent("");
    				$('#goodsOnlinePagination').pagination('select');
    			}else{
    				$.messager.alert('信息提示','提交失败！','info');
    			}
    		}
    	});
	}
	
	
		
	/*
	*商品上下架
	*/
	function putaway(obj){
	 var goodsids;
	 var status;
	 var onlineTime;
	 var leaveTime;
	 
	 var items = $('#goodsOnlineinfo').datagrid('getSelections');
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中操作的数据');
			return ;
		}
		goodsids = items[0].ids;
		status = items[0].status;
		onlineTime1 = items[0].onlineTime;
		leaveTime = items[0].leaveTime;
		
		//提交
		if(obj.id == "putaway"){
			if(status != 2){
				$.messager.alert('温馨提醒','您选中的是一条已上架的数据，请重新选择其他要上架的商品数据','question')
				return ;
			}
			$.ajax({
				url:'/goodsOnline/updateGoodsStatus',
				type:'POST',
				data: {'ids':goodsids,'status':status,'leaveTime':leaveTime,'onlineTime':onlineTime1},
				success:function(data){
					if(data){
						$.messager.alert('信息提示','提交成功！','info');
						$('#goodsOnlinePagination').pagination('select');
					}
					else
					{
						$.messager.alert('信息提示','提交失败！','info');		
					}
				}	
			});
		}if(obj.id == "soldOut"){
			if(status != 1){
				$.messager.alert('温馨提醒','您选中的是一条已下架的数据，请重新选择其他要下架的商品数据','question')
				return ;
			}
			$.ajax({
				url:'/goodsOnline/updateGoodsStatus',
				type:'POST',
				data: {'ids':goodsids,'status':status,'leaveTime':leaveTime,'onlineTime':onlineTime1},
				success:function(data){
					if(data){
						$.messager.alert('信息提示','提交成功！','info');
						$('#goodsOnlinePagination').pagination('select');
					}
					else
					{
						$.messager.alert('信息提示','提交失败！','info');		
					}
				}	
			});
		}
	}
	

	//条件查询
	function goodOnlineDoSearch(){
		var param = $.param({'pageNumber':1,'pageSize':10}) + '&' + $('#searchOnlineForm').serialize();
		//console.info(param)
		$.ajax({ 
	          type: 'POST', 
	          url: '/goodsOnline/list', //用户请求数据的URL
	          data: param, 
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert("没有查询到数据"); 
	          }, 
	          success: function (data) { 
	        	  
	        	  data =eval("("+data+")");
	        	  
	        	  if(data.total == 0){
	        		  $.messager.alert('信息提示','</br>未检索到数据！请检查查询条件','info');
	        	  }
	        	  
	              $('#goodsOnlineinfo').datagrid('loadData', data.rows);
	               $('#goodsOnlinePagination').pagination({ 
			    	  total:data.total
			    	  });
	          }
	       });
	}
	
	/*
	 *清除查询条件
	 */
	 function goodOnlineDoClear(){
		$('#searchOnlineForm').form('reset');
	}
	
	
	
	
	/*
	 * 上传图片回显
	 */
	function readGoodsPicture(_obj) {
		//easyui-filebox封装input标签
		var fileId = $("input[type='file']").attr('id');
		//console.info(fileId);
		// 检查是否为图像类型
		var simpleFile = document.getElementById(fileId).files[0];
		//console.info(simpleFile);
		if (!/image\/\w+/.test(simpleFile.type)) {
			$.messager.alert('信息提示', '请确保文件类型为图像类型', 'info')
			return false;
		}
		var reader = new FileReader();
		// 将文件以二进制文件读入页面中
		reader.readAsBinaryString(simpleFile);
		reader.onload = function(f) {
			var result = document.getElementById("showGoodsPic");
			var src = "data:" + simpleFile.type + ";base64,"
					+ window.btoa(this.result);
			result.innerHTML = '<img id="readGoodsPic" style="height: 130px;width: 200px;" src ="' + src + '"/>';
		}
		//document.getElementById("showpic").style.display="";
	}
</script>
