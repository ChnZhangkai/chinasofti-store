
<div id="auditlist" class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="goodonline-toolbar-3" style="height: 15%">
		<div class="goodonline-toolbar-button">
			 <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()"plain="true">修改</a> 
			 <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="print()" plain="true">导出</a> 
			 <a href="#" class="easyui-linkbutton" iconCls="icon-print" onclick="print()" plain="true">打印</a>
		</div>
		<div class="goodonline-toolbar-search">
			<form id="searchOnlineForm">
				<label>商品编号</label> <input type="text" id="goodsids" name="ids" class="easyui-textbox"/>
				<label>商品名称</label> <input type="text" id="goodstitle" name="title" class="easyui-textbox"/>
				<label>开始时间</label> <input type="text" id="goodsstarttime" name="starttime" class="easyui-datebox"/>
				<label>结束时间</label> <input type="text" id="goodsendtime" name="endtime" class="easyui-datebox"/><br>
				<label>商户编号</label> <input type="text" id="goodsvendorids" name="vendorids" class="easyui-textbox"/>
				<label>商品分类</label> <input type="text" id="goodsclassname" name="goodsclass" class="easyui-textbox"/>
				<label>商品类型</label>
				<select autocomplete="off" class="easyui-combobox"
					data-options="panelHeight:'auto'" id="goodsType" name="type"
					style="width: 135px">
					<option selected="selected" value="">请选择</option>
					<option value="0">普通商品</option>
					<option value="1">活动商品</option>
				</select>
				<label>审核状态</label>
				<select autocomplete="off" class="easyui-combobox"
					data-options="panelHeight:'auto'" id="goodsReviewStates" name="reviewstates"
					style="width: 135px">
					<option selected="selected" value="">请选择</option>
					<option value="0">待提交审核</option>
					<option value="1">审核通过</option>
					<option value="2">审核拒绝</option>
					<option value="3">已提交申请</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="goodOnlineDoSearch()">开始检索</a> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="goodOnlineDoClear()">清除</a>
			</form>
		</div>
	</div>

	<!-- 数据显示datagrid -->
	<table id="goodsOnlineinfo" class="easyui-datagrid" toolbar="#goodonline-toolbar-3"
		style="height: 95%">
		<thead>
			<tr>
				<th field="name" width="10%" align="center">商品名称</th>
				<th field="img" width="10%" align="center"
					data-options="formatter:imgFormatter">商品图片</th>
				<th field="price" width="15%" align="center">商品价格</th>
				<th field="createBy" width="15%" align="center">商户名称</th>
				<th field="commons" width="25%" align="center">分类名称</th>
				<th field="createTime" width="15%" align="center">商品类型</th>
				<th field="storeNum" width="15%" align="center">当前库存</th>
				<th field="status" width="15%" align="center">商品状态</th>
			</tr>
		</thead>
	</table>

	<!-- 分页工具条 -->
	<div id="goodsOnlinePagination" style="background:#efefef;border:1px solid #ccc;"></div>

	

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
		var url = '/goods/list';
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
		var str = "";
		if (value != "" || value != null) {
			str = "<img style=\"height: 75px;width: 110px;\" src=\""+value+"\"/>";
			return str;
		}
	}

	/*
	 * 分类状态
	 */
	function statesFormatter(value) {
		if (value == "0") {
			return '<span style="color:black">待提交审核</span>';
		} 
		if (value == "1"){
			return '<span style="color:green">审核通过</span>';
		} 
		if (value == '2'){
			return '<span style="color:red">审核拒绝</span>';
		}else{
			return '<span style="color:yellow">已提交审核</span>';
		}
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