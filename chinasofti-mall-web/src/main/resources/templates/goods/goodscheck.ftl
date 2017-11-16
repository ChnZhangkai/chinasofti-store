
<div id="auditlist" class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="wu-toolbar-3" style="height: 15%">
		<div class="wu-toolbar-search" style="border-bottom: 1px solid #DDDDDD">
			<form id="searchCheckForm" style="margin: 0px">
				<label>商品编号</label> <input type="text" id="goodsids" name="goodsids" class="easyui-textbox" style="width: 160px"/>
				<label>商品名称</label> <input type="text" id="goodstitle" name="title" class="easyui-textbox" style="width: 160px"/>
				<label>开始时间</label> <input type="text" id="goodsstarttime" name="startTime" class="easyui-datetimebox" style="width: 160px" data-options="prompt:'请选择日期',editable:'false'"/>
				<label>结束时间</label> <input type="text" id="goodsendtime" name="endTime" class="easyui-datetimebox" style="width: 160px" data-options="prompt:'请选择日期',editable:'false'"/><br>
				<label>商户名称</label> <input type="text" id="goodsvendorids" name="vendorSnm" class="easyui-textbox" style="width: 160px"/>
				<label>商品分类</label> <input type="text" id="goodsclassname" name=name class="easyui-textbox" style="width: 160px"/>
				<label>商品类型</label>
				<select autocomplete="off" class="easyui-combobox"
					data-options="panelHeight:'auto'" id="goodsType" name="type"
					style="width: 160px">
					<option selected="selected" value="">请选择</option>
					<option value="0">普通商品</option>
					<option value="1">活动商品</option>
				</select>
				<label>审核状态</label>
				<select autocomplete="off" class="easyui-combobox"
					data-options="panelHeight:'auto'" id="goodsReviewStates" name="reviewStatues"
					style="width: 160px">
					<option selected="selected" value="">请选择</option>
					<option value="0">待提交审核</option>
					<option value="3">已提交审核</option>
					<option value="1">审核通过</option>
					<option value="2">审核拒绝</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search"
					onclick="doGoodsCheckSearch()">开始检索</a> <a href="#" class="easyui-linkbutton"
					iconCls="icon-edit-clear" onclick="doGoodsCheckClear()">清除</a>
			</form>
		</div>
		<div class="wu-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openGoodsAdd()" plain="true">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="removeGoodsCheck()" plain="true">删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="print()" plain="true">导出</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-arrow-redo" id="pushCheck" onclick="handleCheck(this)" plain="true">申请审核</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-arrow-undo" id="repealCheck" onclick="handleCheck(this)" plain="true">撤销申请</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-chk-checked" id="doCheck" onclick="doCheck(this)" plain="true">商品审核</a>
		</div>
	</div>

	<!-- 数据显示datagrid -->
	<table id="goodscheck" class="easyui-datagrid" toolbar="#wu-toolbar-3"
		style="height: 95%">
		<thead>
			<tr>
				<th field="title" width="20%" align="center">商品名称</th>
				<th field="img" width="10%" align="center"
					data-options="formatter:imgFormatter">商品图片</th>
				<th field="price" width="15%" align="center">商品价格</th>
				<th field="vendorSnm" width="15%" align="center">商户名称</th>
				<th field="name" width="20%" align="center">商品分类</th>
				<th field="type" width="10%" align="center"
					data-options="formatter:typeFormatter">商品类型</th>
				<th field="reviewStatues" width="10%" align="center"
					data-options="formatter:statesFormatter">审核状态</th>
			</tr>
		</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="goodsCheckPagination"
		style="background: #efefef; border: 1px solid #ccc;"></div>

	<!-- 商品添加表格 -->
	<div id="addDl" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-add',inline:true"
		style="width: 100%; height: 100%; padding: 10px;background-image: url(images/goodsdiv.jpg)">
		<form id="addGoodsForm"  enctype="multipart/form-data">
			<table>
				<tr>
					<th align="right">商品名称</th>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox easyui-validatebox" id="title" name="title" data-options="required:true"/> <span><font
							style="color: #CCCCCC; font-size: 10px;">1-100位中文</font></span></td>
					<th align="right">商品分类</th>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto',panelMaxHeight:'200px'" id="goodsClassIds" name="goodsClassIds"></select></td>
				</tr>
				<tr>
					<th align="right">商品类型</th>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="type" name="type">
							<option value="0">普通商品</option>
							<option value="1">活动商品</option>
					</select></td>
					<th align="right">商户名称</th>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto',panelMaxHeight:'200px'" id="vendorids" name="vendorids"></select></td>
				</tr>
				<tr>
					<th align="right">开始日期</th>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="startTime" name="startTime"/></td>
					<th align="right">结束日期</th>
					<td><input type="text" class="easyui-datetimebox"
						style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" id="endTime" name="endTime"/></td>
				</tr>
				<tr>
					<th align="right">规格</th>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="standard" name="standard"/></td>
					<th align="right">重量</th>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="weight" name="weight"/> <span><font
							style="color: #CCCCCC; font-size: 10px;">重量单位:KG</font></span></td>
				</tr>
				<tr>
					<th align="right">前台是否显示商户名</th>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="isDisVerdorname" name="isDisVerdorname">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<th align="right">前台是否显示规格</th>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="isDisStandard" name="isDisStandard">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
				</tr>
				<tr>
					<th align="right">前台是否显示库存</th>
					<td><select style="width: 180px;" class="easyui-combobox" data-options="panelHeight:'auto'" id="isDisStore" name="isDisStore">
							<option value="1">是</option>
							<option value="0">否</option>
					</select></td>
					<th align="right">首次录入库存数量</th>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="collNum" name="collNum"/></td>
				</tr>
				<tr>
					<th align="right">每个用户限购数量</th>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="limitUserNum" name="limitUserNum"/> <span><font
							style="color: #CCCCCC; font-size: 10px;">空值时不限购</font></span></td>
					<th align="right">每笔订单限购数量</th>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="limitOrderNum" name="limitOrderNum"/></td>
				</tr>
				<tr>
					<th align="right">商品图片:</th>
					<td><input id="img" name="img" class="easyui-filebox"
						style="width: 180px;"
						data-options="onChange:function(){readGoodsPicture(this)},prompt:'请选择一张图片'" /></td>
					<th align="right">商品价格</th>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="price" name="price"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div id="showGoodsPic"></div>
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
	
		<!-- 商品添加表格 -->
	<div id="checkDialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-chk-checked',inline:true"
		style="width: 500px; height: 260px; padding: 10px;">
		<form id="checkForm">
			<table>
				<tr>
					<th align="right">审核状态</th>
					<td>
						<input type="radio" name="reviewStatues" value="1">审核通过</input>
                		<input type="radio" name="reviewStatues" value="2">审核拒绝</input>
					</td>
				</tr>
				<tr>
					<th align="right" style="padding-bottom: 0px">审核备注</th>
					<td><input type="text" style="width: 350px;height: 120px"
						class="easyui-textbox" id="reviewDesc" name="reviewDesc" data-options="multiline:true"/>
					</td>
				</tr>
			</table>
		</form>
	</div>

</div>


<script type="text/javascript">
	
	//初始化富文本编辑器
	var ue = UE.getEditor('container',{
		initialFrameWidth:1000,  //初始化编辑器宽度,默认1000  
        initialFrameHeight:140  //初始化编辑器高度,默认320
	});
	
	//打开商品添加页面
	function openGoodsAdd() {
		
		$('#addGoodsForm').form('clear');
		$('#addDl').dialog({
			draggable : false,			
			closed : false,
			modal : true,
			title : "添加商品",
			buttons : [ {
				text : '确定',
				iconCls : 'icon-ok',
				handler : addGoods
			}, {
				text : '取消',
				iconCls : 'icon-cancel',
				handler : function() {
					$('#addDl').dialog('close');
					$('#addGoodsForm').form('reset');
					ue.setContent('');
					document.getElementById("showGoodsPic").innerHTML = "";
				}
			} ]
		});
		
		$.ajax({
			url:'/goodsCheck/reqGoodsClassName',
			type:"GET",
			success: function(data){
				data = eval("("+data+")");
				$('#goodsClassIds').combobox({
					valueField:'ids',
					textField:'name',
					data:data.rows,
				})	
			}
		});
		
		$.ajax({
			url:'/goodsCheck/reqSpUserName',
			type:"GET",
			success: function(data){
				data = eval("("+data+")");
				$('#vendorids').combobox({
					valueField:'vendorId',
					textField:'vendorSnm',
					data:data.rows,
				})	
			}
		}); 
		
	}
	
	//商品添加
	function addGoods(){
		/* var ueditorData = UE.getEditor('container').getContent();*/
		
		var formData = new FormData($("#addGoodsForm")[0]); 
		   $.ajax({ 
		     url:'/goodsCheck/addGoods',
		     type: 'POST', 
		     data: formData, 
		     async: false, 
		     cache: false, 
		     contentType: false, 
		     processData: false, 
		     success: function(data) {
				$('#addDl').dialog('close');
				$('#addGoodsForm').form('reset');
				UE.getEditor('container').setContent("");
				$.messager.alert('信息提示','添加成功！','info');
				$('#goodsCheckPagination').pagination('select');
		     }, 
		     error: function(data) {   
		     } 
		   }); 
	}
	
	//条件查询
	function doGoodsCheckSearch(){
		var param = $.param({'pageNumber':1,'pageSize':10}) + '&' + $('#searchCheckForm').serialize();
		//console.info(param)
		$.ajax({ 
	          type: 'POST', 
	          url: '/goodsCheck/list', //用户请求数据的URL
	          data: param, 
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert("没有查询到数据"); 
	          }, 
	          success: function (data) { 
	        	  
	        	  data =eval("("+data+")");
	        	  
	        	  if(data.total == 0){
	        		  $.messager.alert('信息提示','</br>未检索到数据！请检查查询条件','info');
	        	  }
	        	  
	              $('#goodscheck').datagrid('loadData', data.rows);
	               $('#goodsCheckPagination').pagination({ 
			    	  total:data.total
			    	  });
	          }
	       });
	}
	
	/*
	 * 删除
	 */
	function removeGoodsCheck(){
		
		var items = $('#goodscheck').datagrid('getSelections');
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
					url:'/goodsCheck/delete/' + ids,
					type:'POST',
					success:function(data){
						if(data){
							$.messager.alert('信息提示','删除成功！','info');
							//$('#goodsinfo').datagrid('reload')
							$('#goodsCheckPagination').pagination('select');
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
	
	/*
	 * 提交审核申请/撤销申请流程
	 */
	function handleCheck(obj){
		
		var  reviewStatues;
		var ids ;
		
		var items = $('#goodscheck').datagrid('getSelections');
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中操作的数据');
			return ;
		}
		ids = items[0].ids;
		reviewStatues = items[0].reviewStatues;
		
		//提交审核
		if(obj.id == "pushCheck"){
			if(reviewStatues != 0){
				$.messager.alert('温馨提醒','您选中的不是一条待提交的数据，请重新选择其他待提交审核数据','question')
				return ;
			}
		}
		//撤销审核
		if(obj.id == "repealCheck"){
			if(reviewStatues != 3){
				$.messager.alert('温馨提醒','您选中的不是一条已提交审核的数据，请重新选择其他已提交审核数据','question')
				return ;
			}
		}
		
			$.ajax({
				url:'/goodsCheck/updateGoodsCheckStatus',
				type:'POST',
				data: {'ids':ids,'reviewStatues':reviewStatues},
				success:function(data){
					if(data){
						$.messager.alert('信息提示','操作成功！','info');
						$('#goodsCheckPagination').pagination('select');
					}
					else
					{
						$.messager.alert('信息提示','操作失败！','info');		
					}
				}	
			});
			
	}
	
	/*
	 * 执行审核
	 */
	function doCheck(obj){
			
		var reviewStatues;
		var ids ;
		
		var items = $('#goodscheck').datagrid('getSelections');
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中操作的数据');
			return ;
		}
		ids = items[0].ids;
		reviewStatues = items[0].reviewStatues;
		
		//审核通过或拒绝
		if(obj.id == "doCheck"){
			if(reviewStatues != 3){
				$.messager.alert('温馨提醒','您选中的不是一条已提交审核的数据，请重新选择其他已提交审核数据','question')
				return ;
			}
			
			$('#checkDialog').dialog({
				draggable : false,			
				closed : false,
				modal : true,
				title : "商品审核",
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
					var param = $.param({'ids':ids}) + '&' + $('#checkForm').serialize();
						$.ajax({
							url:'/goodsCheck/updateGoodsCheckStatus',
							type:'POST',
							data: param,
							success:function(data){
								if(data){
									$('#checkDialog').dialog('close');
									$('#checkForm').form('reset');
									$.messager.alert('信息提示','操作成功！','info');
									$('#goodsCheckPagination').pagination('select');
								}
								else
								{
									$.messager.alert('信息提示','操作失败！','info');		
								}
							}	
						});
					}
				}, {
					text : '取消',
					iconCls : 'icon-cancel',
					handler : function() {
						$('#checkDialog').dialog('close');
						$('#checkForm').form('reset');
					}
				} ]
			});
		}
	}
	
	/*
	 * 全局加载数据
	 */
	$(function() {

		//获取表格datagrid的ID属性,
		var tableID = "goodscheck";
		//获取分页工具条元素
		var pageId = $('#goodsCheckPagination');
		//此处设置自己的url地址
		var url = '/goodsCheck/list';
		//分页查询时传递查询条件
		seachId = '#searchCheckForm';
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
		var ids = row.ids
		var str = "";
		
		images = $.ajax({url:'/goodsCheck/reqGoodsGoodsImgPath/' + ids,type:'POST',async:false});
		str = "<img style=\"height: 75px;width: 110px;\" src=\""+ images.responseText +"\"/>";
		return str;
		
	}

	/*
	 * 分类状态
	 */
	function statesFormatter(value) {
		if (value == "0") {
			return '<span style="color:black">待申请审核</span>';
		} 
		if (value == "1"){
			return '<span style="color:green">审核通过</span>';
		} 
		if (value == '2'){
			return '<span style="color:red">审核拒绝</span>';
		}else{
			return '<span style="color:blue">已申请审核</span>';
		}
	}
	
	/*
	 * 商品类型
	 */
	function typeFormatter(value){
		if(value == "0"){
			return '<span>普通商品</span>';
		}else{
			return '<span style="color:#FF00FF">活动商品</span>';
		}
	}
	
	/*
	 *清除查询条件
	 */
	 function doGoodsCheckClear(){
		$('#searchCheckForm').form('reset');
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
			result.innerHTML = '<img id="readGoodsPic" style="height: 130px;width: 180px;" src ="' + src + '"/>';
		}
		//document.getElementById("showpic").style.display="";
	}
</script>
