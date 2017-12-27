<script type="text/javascript" src="js/goodsComment.js"></script>
<script type="text/javascript" src="js/myValidType.js"></script>
<div id="commentlist" class="easyui-layout" data-options="fit:true">
	<!-- Begin of toolbar -->
	<div id="spEvaluate-toolbar">
		<div class="spEvaluate-toolbar-search" style="border-bottom: 1px solid #DDDDDD">
			<form id="searchOnlineForm" style="margin: 0px">
				<label>商品名称</label> <input type="text" id="commente-title" name="title" class="easyui-textbox"/>
				<label>用户昵称</label> <input type="text" id="comment-nickname" name="nickname" class="easyui-textbox"/>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="spEvaluateDoSearch()">开始检索</a> 
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit-clear" onclick="spEvaluateDoClear()">清除</a>
			</form>
		</div>
		<div class="spEvaluate-toolbar-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="removeComment()" plain="true">删除</a>
			
		</div>
	</div>
	<!-- 数据显示datagrid -->
	<table id="spEvaluateinfo" class="easyui-datagrid"  style="height: 100%"
	 toolbar="#spEvaluate-toolbar"	data-options="rownumbers:true,
	 					 url:'/comments/findByPage',
						 fitColumns:false,
       					 pagination:true,
       					 sortName:'CREATE_TIME',
       					 sortOrder:'desc',
       					 title:'商品评论列表',
       				 	 iconCls:'icon-man',
		   				 striped:true,
		   				 singleSelect:false,
						 collapsible:true,
		   				 pageSize:20,
		   				 pageList: [20, 40, 60, 100],
		   				 onDblClickRow:showComments">
		   				 
	   <thead>
			<tr>
				<th field="ck" width="5%" align="center" data-options="checkbox:true"></th>
				<th field="title" width="13%" align="center" data-options="sortable:true">商品名称</th>
				<th field="count" width="15%" align="center" data-options="sortable:true">商品得分</th>
				<th field="content" width="40%" align="center" data-options="sortable:true">评论内容</th>
				<th field="imagepath" width="15%" align="center" data-options="formatter:imgFormatter ,sortable:true">评论图片</th>
				<th field="nickname" width="15%" align="center" data-options="sortable:true">评论者</th>
				<th field="useful" width="10%" align="center" data-options="sortable:true">点赞数量</th>
			</tr>
		</thead>
	</table>
</div>

	<!-- 商品评论表格 -->
	<div id="comments-show-dialog" class="easyui-dialog"
		data-options="closed:true,iconCls:'icon-add',inline:true"
		style="width: 100%; height: 100%; padding: 10px">
		<form id="comments-show-form"  enctype="multipart/form-data">
			<table>
				<tr>
					<td><input type="hidden"  id="ids" name="ids" /></td>
				</tr>
				<tr>
					<td align="right">商品名称</td>
					<td><input type="text" id="title" name="title" style=" width: 180px;"
				class="easyui-textbox"  disabled="true"/></td>
					<td align="right">商品得分</td>
					<td><input type="text" class="easyui-textbox" id="count" name="count" 
					style=" width: 180px;" disabled="true" /></td>
				</tr>
			
				<tr>
					<td align="right">评论者</td>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="nickname" name="nickname" disabled="true"/></td>
					<td align="right">评论时间</td>
					<td><input type="text" id="createTime" name="createTime" class="easyui-textbox"
						style=" width: 180px;" disabled="true" />
					</td>
				</tr>

					<tr>
					<td align="right">评论图片</td>
					<td><input type="text" style="width: 180px;"
						class="easyui-textbox" id="imagepath" name="imagepath" disabled="true"/>
					</td>
				</tr> 
				
				<tr>
				<td align="right">评论图片</td>
				<td><img style="height: 80px;width: 120px;" src="" id="imgUrl"/></td>
					
				</tr>
				
				<tr>
					<td></td>
					<td>
						<div id="showGoodsPic"></div>
					</td>
				</tr>
				
				<tr>
					<td align="right" style="padding-bottom: 0px">评论内容</td>
					<td colspan="3">
						<script id="containeComments" name="content" type="text/plain"></script>
					</td>
				</tr>
		
			</table>
		</form>
	</div>