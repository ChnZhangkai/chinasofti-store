<div id="goodsClassMain" class="easyui-layout" data-options="fit:true">
	
	<div><font style="color: red;">左键双击快速修改分类名称,右键单击节点增删改,父节点不可直接删除,子节点可删除</font></div>
	
	<!-- 菜单主体 -->
	<div>	
		<ul id="goodsClassTree"></ul>
	</div>
	
	<!-- 右键菜单 -->
	<div id="goodsClassParentMenu" class="easyui-menu" style="width:120px;">    
    	<div name="addGS" id="1" data-options="iconCls:'icon-add'" onclick="openGsAdd()" >添加</div>    
    	<div name="updateGS" id="2" data-options="iconCls:'icon-edit'" onclick="openGsEdit()">修改</div>    
  	</div>
	
	<!-- 右键菜单 -->
	<div id="goodsClassMenu" class="easyui-menu" style="width:120px;">    
    	<div name="addGS" id="4" data-options="iconCls:'icon-add'" onclick="openGsAdd()" >添加</div>    
    	<div name="updateGS" id="5" data-options="iconCls:'icon-edit'" onclick="openGsEdit()">修改</div>    
    	<div name="deleteGS" id="6" data-options="iconCls:'icon-remove'" onclick="removeGs()" >删除</div>  
  	</div> 
	
	<!-- 修改表格 -->
	<div id="goodsClassDialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',inline:true" style="width: 400px; padding: 10px;">
		<form id="goodsClassForm" method="post" enctype="multipart/form-data">
			<table id="goodsClassTable">
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
	
	
	<!-- 分类添加表格 -->
	<div id="goodsClassAddDialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-save',inline:true"
		style="width: 400px; padding: 10px;">
		<form id="goodsClassAddForm" method="post" enctype="multipart/form-data">
			<table id="goodsClassAddTable">
				<tr>
					<td width="60" align="right">分类名称:</td>
					<td><input type="text" id="name" name="name"
						class="easyui-validatebox wu-text easyui-textbox" required="true" missingMessage="请输入分类名称"/></td>
				</tr>
				<tr>
					<td align="right">分类描述:</td>
					<td><input type="text" id="commons" name="commons"
						class="wu-text easyui-textbox" /></td>
				</tr>
				<tr>
					<td align="right">当前节点:</td>
					<td><input type="text" id="node" name="node"
						class="wu-text easyui-textbox" disabled="true"/></td>
				</tr>
				<tr>
					<td><input type="hidden" id="pid" name="pid"/></td>
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
					<td><input type="file" id="classimg" name="img" class="img" onchange="readPicture()"/></td>
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
	
</div>
<script type="text/javascript">
	
	/* 初始化加载 */
	$(function() {
		
		loadGoodsClassTree();
		
	});
	
	/* 分类树 */
	function loadGoodsClassTree(){
		
		var isChange ;
		
		$('#goodsClassTree').tree({
			url:'/goods/findGoodsClass', //加载请求节点数据
			//checkbox:true, //复选框
			lines:true, //连接虚线
			animate:true, //展开折叠动画效果
			onDblClick:function(node){  //双击事件
               	var id = node.id;  
                var text = node.text;  
                isChange = node.text;
                $('#goodsClassTree').tree('beginEdit', node.target);//开启编辑
			},
            //右键点击打开菜单
			onContextMenu:function(e,node){
				
				e.preventDefault();
				// 查找节点
				$('#goodsClassTree').tree('select', node.target);
				
				if(($(this).tree('getChildren',node.target)).length>0){
					// 若为父节点，则可删除
					$('#goodsClassParentMenu').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				}else{
					// 若为子节点，则可删除
					$('#goodsClassMenu').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				}
			},
			
			//编辑之后
			onAfterEdit : function(node) { 
				if(node.text != isChange){
					$.ajax({
						url:'/goods/updateGoodsClassName',
						type:'POST',
						data:{'ids':node.id,'name':node.text},
						success:function(data){
							//$('#goodsClassTree').tree('reload')
						}
					});
				}
			}
		});
	}
		
		//打开新增窗口
		function openGsAdd(){
			$('#goodsClassAddForm').form('clear');
			var node = $('#goodsClassTree').tree('getSelected');
			$('#node').textbox('setValue',node.text)
			$('#pid').val(node.id)
			$('#goodsClassAddDialog').dialog({
				closed: false,
				closable:false,
				modal:true,
	            title: "添加分类",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: addGoodsClass
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#goodsClassAddDialog').dialog('close');
	                    //$('#addForm').form('clear');
	                    //document.getElementById("showpic").style.display="none";
	                    document.getElementById("showpic").innerHTML = "";
	                }
	            }]
	        });
		}
		
		//执行新增方法
		function addGoodsClass(){
			$('#goodsClassAddForm').form('submit', {
				url:'/goods/save',
				type:'POST',
				success:function(data){
					if(data > 0){
						$('#goodsClassTree').tree('reload'); 
						$('#goodsClassAddDialog').dialog('close');
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
		
		//打开修改窗口
		function openGsEdit(){
			$('#goodsClassForm').form('clear');
			var node = $('#goodsClassTree').tree('getSelected');
			var ids = node.id;
			$.ajax({
				url:'/goods/select/' + ids,
				type:'POST',
				success:function(data){
					$('#goodsClassDialog').dialog('open').dialog({
						closed: false,
						modal:true,
						closable:false,
			            title: "分类详情",
						buttons : [{
							text : '确认',
							iconCls : 'icon-ok',
							handler : function() {
								$('#goodsClassForm').form('submit', {
									url:'/goods/update',
						    		type:'POST',
						    		data:$('#goodsClassForm').serialize(),
						    		success:function(data){
						    			if(data > 0){
						    				$.messager.alert('信息提示','提交成功！','info');
						    				$('#goodsClassDialog').dialog('close');
						    			}else{
						    				$.messager.alert('信息提示','提交失败！','info');
						    			}
						    		}
						    	});
								//$('#goodsClassDialog').dialog('close');
							}
						},{
							text : '关闭',
							iconCls : 'icon-cancel',
							handler : function() {
								$('#goodsClassDialog').dialog('close');
								document.getElementById("showupic").innerHTML = "";
							}
						}]
					});
					$('#goodsClassForm').form('load',data);
				}
			})
			

		}
		
		//移除节点
		function removeGs(){
			var node = $('#goodsClassTree').tree('getSelected');
			var ids = node.id;
			$.ajax({
				url:'/goods//delete/' + ids,
				type:'POST',
				success:function(data){
					loadTree();
				}
			});
		}
		
		/*
		 * 新增分类上传图片回显
		 */
	 	function readPicture() {
			
	 		//var a = document.getElementsByClassName("img");
	 		//console.info(a);
			
			// 检查是否为图像类型
			var simpleFile = document.getElementById("classimg").files[0];
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
		
		//修改图片时回显
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