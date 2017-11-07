<!-- 商品添加表格 -->
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

	<script type="text/javascript">
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
