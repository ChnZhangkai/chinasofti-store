<div id="goodsClassMain" class="easyui-layout" data-options="fit:true">
	
	<div><font style="color: red;">左键双击快速修改分类名称,右键单击节点增删改</font></div>
	
	<!-- 菜单主体 -->
	<div>	
		<ul id="goodsClassTree"></ul>
	</div>
	
	<!-- 右键菜单 -->
	<div id="goodsClassMenu" class="easyui-menu" style="width:120px;">    
    	<div name="addGS" id="1" data-options="iconCls:'icon-add'" onclick="openGsAdd()" >添加</div>    
    	<div name="updateGS" id="2" data-options="iconCls:'icon-edit'" onclick="openGsEdit()">修改</div>    
    	<div name="deleteGS" id="3" data-options="iconCls:'icon-remove'" onclick="removeGs()" >删除</div>  
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
	
	
</div>
<script type="text/javascript">
	
	/* 初始化加载 */
	$(function() {
		
		loadGoodsClassTree();
		
	});
	
	/* 分类树 */
	function loadGoodsClassTree(){
		
		$('#goodsClassTree').tree({
			url:'/goods/findGoodsClass', //加载请求节点数据
			//checkbox:true, //复选框
			lines:true, //连接虚线
			animate:true, //展开折叠动画效果
			onDblClick:function(node){  //双击事件
               	var id = node.id;  
                var text = node.text;  
                $('#goodsClassTree').tree('beginEdit', node.target);//开启编辑
			},
            //右键点击打开菜单
			onContextMenu:function(e,node){
				e.preventDefault();
				// 查找节点
				$('#goodsClassTree').tree('select', node.target);
				// 显示快捷菜单
				$('#goodsClassMenu').menu('show', {
					left: e.pageX,
					top: e.pageY
				});

			},
			
			//编辑之后
			onAfterEdit : function(node) { 
				alert(node.id + '||' + node.text);
			}
		});
	}
	
		//打开添加窗口
		function openGsAdd(){
			
		}
		
		//打开修改窗口
		function openGsEdit(){
			$('#goodsClassDialog').dialog('open').dialog({
				closed: false,
				modal:true,
				closable:false,
	            title: "分类详情",
				buttons : [{
					text : '确认',
					iconCls : 'icon-ok',
					handler : function() {
						$('#goodsClassDialog').dialog('close');
					}
				},{
					text : '关闭',
					iconCls : 'icon-cancel',
					handler : function() {
						$('#goodsClassDialog').dialog('close');
					}
				}]
			});

		}
		
</script>