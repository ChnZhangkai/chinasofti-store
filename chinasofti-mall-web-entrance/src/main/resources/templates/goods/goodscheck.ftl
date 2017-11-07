<div id="auditlist" class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="wu-toolbar-3" style="height: 12%">
		<div class="wu-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add"
				onclick="openGoodsAdd()" plain="true">添加</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()"
				plain="true">修改</a> <a href="#" class="easyui-linkbutton"
				iconCls="icon-remove" onclick="remove()" plain="true">删除</a> <a
				href="#" class="easyui-linkbutton" iconCls="icon-excel"
				onclick="print()" plain="true">导出</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-print" onclick="print()"
				plain="true">打印</a>
		</div>
		<div class="wu-toolbar-search">
		<form id="searchCheckForm">
			<label>分类名称：</label> <input type="text" id="categoryname" name="name" />
			<label>分类描述：</label> <input type="text" id="categorycommons" name="commons" />
			<label>创建员工：</label> <input type="text" id="createbyname" name="createBy" />
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
	<table id="goodscheck" class="easyui-datagrid" toolbar="#wu-toolbar-3" style="height: 95%">
		<thead>
		<tr>
			<th field="name" width="10%" align="center">商品名称</th>
			<th field="img" width="10%" align="center" data-options="formatter:imgFormatter">商品图片</th>
			<th field="states" width="5%" align="center" data-options="formatter:statesFormatter">状态</th>
			<th field="commons" width="25%" align="center">分类描述</th>
			<th field="createBy" width="15%" align="center">创建员工</th>
			<th field="createTime" width="15%" align="center" >创建时间</th>
			<th field="price" width="15%" align="center" >商品价格</th>
		</tr>
		</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="goodsCheckPagination" style="background:#efefef;border:1px solid #ccc;"></div>
	
	<!-- 商品添加表格 -->
	<div id="wu-dialog-3" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save'"
		style="width: 800px;height: 600px; padding: 10px;">
		<form id="addGoodsForm" method="post" enctype="multipart/form-data">
			<table id="addGoods">
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
					<td><input type="file" id="img" name="img" onchange="readPicture()"/></td>
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
	
	<!-- 商品添加表格 -->
	<div id="addDl" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',inline:true"
													style="width: 100%;height: 100%;padding: 10px;">
	<form id="addGoodsForm">
		<table>
			<tr>
				<th align="right">商户名称</th>
				<td><input type="text" /> <span><font
						style="color: #CCCCCC; font-size: 10px;">1-100位中文</font></span></td>
				<th align="right">分类名称</th>
				<td><select style="width: 173px;" class="easyui-combobox">
						<option>1</option>
						<option>1</option>
						<option>1</option>
				</select></td>
			</tr>
			<tr>
				<th align="right">商品类型</th>
				<td><select style="width: 173px;" class="easyui-combobox">
						<option value="0">普通商品</option>
						<option value="1">活动商品</option>
				</select></td>
				<th align="right">商户名称</th>
				<td><select style="width: 173px;" class="easyui-combobox">
						<option>1</option>
						<option>1</option>
						<option>1</option>
				</select></td>
			</tr>
			<tr>
				<th align="right">开始日期</th>
				<td><input type="text" class="easyui-datebox"
					data-options="prompt:'请选择日期'" /></td>
				<th align="right">结束日期</th>
				<td><input type="text" class="easyui-datebox"
					data-options="prompt:'请选择日期'" /></td>
			</tr>
			<tr>
				<th align="right">规格</th>
				<td><input type="text" /></td>
				<th align="right">重量</th>
				<td><input type="text" /> <span><font
						style="color: #CCCCCC; font-size: 10px;">重量单位:KG</font></span></td>
			</tr>
			<tr>
				<th align="right">首次录入库存</th>
				<td><input type="text" /></td>
				<th align="right">运费模板</th>
				<td><select style="width: 173px;">
						<option>1</option>
						<option>1</option>
						<option>1</option>
				</select></td>
			</tr>
			<tr>
				<th align="right">每个用户限购数量</th>
				<td><input type="text" /> <span><font
						style="color: #CCCCCC; font-size: 10px;">空值时不限购</font></span></td>
				<th align="right">每笔订单限购数量</th>
				<td><select style="width: 173px;">
						<option>1</option>
						<option>1</option>
						<option>1</option>
				</select></td>
			</tr>
			<tr>
				<th align="right">商品图片:</th>
				<td><input type="file" id="img" name="img"
					onchange="readPicture()" /></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<div id="showpic"></div>
				</td>
			</tr>
			<tr>
				<th align="right">商品详情</th>
				<td>
					<div id="content" class="easyui-textbox"
						data-options="multiline:true" style="width: 300px; height: 200px"></div>
				</td>
			</tr>

		</table>
	</form>
	</div>
	
</div>


<script type="text/javascript">

	function openGoodsAdd(){
		$('#addGoodsForm').form('clear');
		$('#addDl').dialog({
			closed: false,
			modal:true,
            title: "添加分类",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: function(){
                	
                }
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    //$('#wu-dialog-2').dialog('close');
                    //$('#addForm').form('clear');
                    //document.getElementById("showpic").style.display="none";
                    //document.getElementById("showpic").innerHTML = "";
                }
            }]
        });
		
		
	}



	/*
	 * 全局加载数据
	 */
	$(function(){
		$.messager.show({
			title:'提示',
			msg:'该充值智商了!'
		});
		
		//获取表格datagrid的ID属性,
		var tableID = "goodscheck";
		//获取分页工具条元素
		var pageId = $('#goodsCheckPagination');
		//此处设置自己的url地址
		var url = '/goods/list';
		//分页查询时传递查询条件
		seachId = '#searchCheckForm';
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
	
	/*
	 * 上传图片回显
	 */
	function readPicture() {
		// 检查是否为图像类型
		var simpleFile = document.getElementById("img").files[0];
		//console.info(simpleFile)
		if (!/image\/\w+/.test(simpleFile.type)) {
			$.messager.alert('信息提示', '请确保文件类型为图像类型', 'info')
			return false;
		}
		var reader = new FileReader();
		// 将文件以二进制文件读入页面中
		reader.readAsBinaryString(simpleFile);
		reader.onload = function(f) {
			var result = document.getElementById("showpic");
			var src = "data:" + simpleFile.type + ";base64,"
					+ window.btoa(this.result);
			result.innerHTML = '<img id="readPic" style="height: 160px;width: 200px;" src ="' + src + '"/>';
		}
		//document.getElementById("showpic").style.display="";
	}
	
</script>
