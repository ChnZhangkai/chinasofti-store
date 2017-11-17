
	<div class="wu-toolbar-button" style="border-bottom: 1px solid #DDDDDD">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="openEdit()" plain="true">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
	</div>
	
	<div>	
		<ul id="goodsClassTree"></ul>
	</div>
	
	
	<div id="goodsClassDialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-chk-checked',inline:true"
		style="width: 500px; height: 260px; padding: 10px;">
		<form id="goodsClassForm">
			<table>
				<!-- <tr>
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
				</tr> -->
			</table>
		</form>
	</div>
	
<script type="text/javascript">

	$(function() {
		
		loadGoodsClassTree();
		
	});
	
	function loadGoodsClassTree(){
		
		$('#goodsClassTree').tree({
			url:'/goods/findGoodsClass', //加载请求节点数据
			//checkbox:true, //复选框
			lines:true, //连接虚线
			animate:true, //展开折叠动画效果
			onDblClick:function(node){  //双击事件
                /* var id = node.id;  
                var text = node.text;  
                $('#goodsClassTree').tree('beginEdit', node.target); */
                
                $('#goodsClassDialog').dialog('open').dialog({
    				closed: false,
    				modal:true,
    				closable:false,
    	            title: "分类详情",
					buttons : [{
						text : '关闭',
						iconCls : 'icon-cancel',
						handler : function() {
							$('#goodsClassDialog').dialog('close');
						}
					}]
				})

			},

			onAfterEdit : function(node) { //编辑之后
				alert(node.id + '||' + node.text);
			}
		});

	}
</script>