<script type="text/javascript" src="js/spUser.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <!-- Begin of toolbar -->
    <div id="user-toolbar-2">
        <div class="user-toolbar-button">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="spUserOpenAdd()" plain="true">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="spUserOpenEdit()" plain="true">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="spUserRemove()" plain="true">删除</a>
            			 <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="exportSpUser()" plain="true">导出</a>
        </div>
       	<div class="spUser-toolbar-search">
		<form id="spUserSearchForm">
			<label>商户编号：</label> <input type="text" id="vendorId" name="vendorId" class="easyui-textbox"/>
			<label>商户名称：</label> <input type="text" id="vendorSnm" name="vendorSnm" class="easyui-textbox"/>
			<label>拓展网站：</label> <input type="text" id="belongSiteName" name="belongSiteName" class="easyui-textbox"/>
			<label>状态：</label> <select autocomplete="off" class="easyui-combobox" data-options="panelHeight:'auto'" id="classstates" name="status" style="width: 125px">
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
	<table id="spuserinfo" class="easyui-datagrid" title="商户用户列表"  style="height: 80%"
			data-options="singleSelect:true,
						 collapsible:true,
						 url:'/spUser/list',
						 fitColumns:false,
       					 sortName:'CREATE_TIME',
       					 sortOrder:'desc',
       					onDblClickRow:showSpUser">
		<thead>
		<tr>
			<th field="vendorId" width="10%" align="center" data-options="sortable:true">商户编号</th>
			<th field="vendorFnm" width="20%" align="center" data-options="sortable:true">商户全称</th>
			<th field="vendorSnm" width="15%" align="center" data-options="sortable:true">商户简称</th>
			<th field="status" width="7%" align="center" data-options="formatter:statesFormatter,sortable:true">状态</th>
			<th field="chargeman" width="10%" align="center" data-options="sortable:true">商户负责人</th>	
			<th field="linkman" width="10%" align="center" data-options="sortable:true">商户方联系人</th>	
			<th field="mobile" width="10%" align="center" data-options="sortable:true">联系手机号</th>
			<th field="address" width="20%" align="center" data-options="sortable:true">通讯地址</th>
		</tr>
		</thead>
	</table>
	<!-- 分页工具条 -->
	<div id="spUserPagination" style="background:#efefef;border:1px solid #ccc;"></div>
</div>

<!-- 添加表格 -->
<div id="spUserAddDialog" class="easyui-dialog"
 data-options="closed:true,iconCls:'icon-save',inline:true" style="width: 80%;height:80%; padding: 10px;">
	<form id="spUserAdd" method="post" enctype="multipart/form-data">
		<table id="spUserAdd">
			<tr>
                <td align="right">商户编号:</td>
                <td>
                	<input  id="sp-vendorId" name="vendorId" class="easyui-textbox" 
               		style="width: 180px" type="text" required="required"  validtype="vendorIds" missingMessage="商户编号由字母和数字组成，长度不能超过9位"/>
               		<span style="color:gray"><font size="1">必填项</font></span>
                </td>
                	
                <td align="right">商户全称:</td>
                <td>
                  <input id="vendorFnm" name="vendorFnm" class="easyui-textbox" 
                  	style="width: 180px" type="text" required="required" validtype="vendorFnm" missingMessage="请输入商户全称，长度不超过50位"/>
                	<span style="color:gray"><font size="1">必填项</font></span>
                </td>
            </tr>
            <tr>
                <td align="right">商户简称:</td>
                <td><input id="vendorSnm" name="vendorSnm" class="easyui-textbox" 
                	 style="width: 180px" type="text" required="required" validtype="vendorSnm" missingMessage="请输入商户简称，长度不超过20位"/>
                	 <span style="color:gray"><font size="1">必填项</font></span>
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
                	 style="width: 180px" type="text" required="required" validtype="chargeman" missingMessage="请输入商户负责人"/>
            	  <span style="color:gray"><font size="1">必填项</font></span>
            	</td>
           
           		<td align="right">联系手机号:</td>
                <td><input id="mobile" name="mobile" class="easyui-textbox" 
                	 style="width: 180px" type="text" required="required" validtype="mobile" missingMessage="请输入联系手机号"/>
            	 <span style="color:gray"><font size="1">必填项</font></span>
            	</td>
            </tr>
            <tr>
           		 <td align="right">邮箱:</td>
                <td><input id="email" name="email" class="easyui-textbox" 
                	 style="width: 180px" type="text"  data-options="required:true,validType:['email','length[1,30]']" />
            	</td>
            	
                <td align="right">售后服务电话:</td>
                <td><input id="servicePhone" name="servicePhone"class="easyui-textbox" 
                	 style="width: 180px" type="text" data-options="required:true,validType:['length[1,18]']" />
            	 <span style="color:gray"><font size="1">必填项</font></span>
            	</td>  
            </tr>
            
            <tr>
                
            	<td align="right">通讯地址:</td>
                <td><input id="address" name="address" class="easyui-textbox" 
                	 style="width: 180px" type="text" />
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
 data-options="closed:true,iconCls:'icon-save',inline:true" style="width: 80%;height:80%; padding: 10px;">
	<form id="spUserUpdate" method="post" enctype="multipart/form-data">
		<table id="update">
			<tr>
				<td align="right">商户编号:</td>
				<td><input id="vendorId" name="vendorId"
				 class="easyui-textbox" readonly="true" style="width:180px"/></td>
				
				<td align="right">商户全称:</td>
                <td><input id="vendorFnm" name="vendorFnm"  class="easyui-textbox" style="width:180px"
                required="required" validtype="vendorFnm" missingMessage="请输入商户全称，长度不超过50位"/></td>
			</tr>
			<tr>
				<td align="right">商户简称:</td>
                <td><input id="vendorSnm" name="vendorSnm" class="easyui-textbox" style="width:180px"
                required="required" validtype="vendorSnm" missingMessage="请输入商户简称，长度不超过20位"/></td>
                
                <td align="right">状态:</td>
				<td>
					<select class="easyui-combobox" data-options="panelHeight:'auto'" required="true" missingMessage="请选择" data-options="editable:false,panelHeight:'auto'" id="status" name="status" style="width: 75px">
							<option value="0">未开启</option>
							<option value="1">已启用</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">商户负责人:</td>
                <td><input id="chargeman" name="chargeman" class="easyui-textbox" style="width:180px"
                 required="required" validtype="chargeman" missingMessage="请输入商户负责人"/></td>
                
           		<td align="right">联系手机号:</td>
                <td><input id="mobile" name="mobile" class="easyui-textbox" style="width:180px" 
               validtype="mobile" missingMessage="请输入联系手机号"/></td>
                
			</tr>
			
			
			 <tr>
                <td align="right">通讯地址:</td>
                <td><input id="address" name="address" class="easyui-textbox" style="width:180px" /></td>
                <td align="right">邮箱:</td>
                <td><input id="email" name="email" class="easyui-textbox" style="width:180px" 
                 data-options="validType:['email','length[1,30]']" /></td>
                
            </tr>
            <tr>
                <td align="right">拓展网点名称:</td>
                <td><input id="belongSiteName" name="belongSiteName" class="easyui-textbox" style="width:180px" /></td>
                
                  <td align="right">创建日期:</td>
                <td>
                	<input id="createDate" name="createDate"
                	class="easyui-datebox" style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" readonly="readonly"/>
                </td>
            </tr>
             <tr>
                <td align="right">创建时间:</td>
                <td><input id="createTime" name="createTime" 
               class="easyui-textbox" style="width: 180px;" readonly="readonly"/>
                </td>
                
                <td align="right">更新时间:</td>
                <td><input id="updatetime" name="updatetime" 
				class="easyui-datetimebox" style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" readonly="readonly"/>
                </td>
            </tr>
            <tr>
            	
                <td align="right">更新人:</td>
                <td><input id="updateby" name="updateby" class="easyui-textbox" style="width:180px" readonly="true"/>
                </td>
                
                <td align="right">售后服务电话:</td>
                <td><input id="servicePhone" name="servicePhone" class="easyui-textbox" style="width:180px"/></td>
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
	<!-- 商户查看框  -->
	<div id="spuser-show-dialog" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save',inline:true" style="width: 80%;height:80%; padding: 10px;">
		<form id="spuser-show-form" method="post" enctype="multipart/form-data">
			<table id="query">
			<tr>
				<td  align="right">商户编号:</td>
				<td><input id="vendorId" name="vendorId"
				 class="easyui-textbox" readonly="true" style="width:180px"/></td>
				
				<td align="right">商户全称:</td>
                <td><input id="vendorFnm" name="vendorFnm" 
                class="easyui-textbox" readonly="readonly" style="width:180px" /></td>
			</tr>
			<tr>
				<td align="right">商户简称:</td>
                <td><input id="vendorSnm" name="vendorSnm" 
                class="easyui-textbox" readonly="readonly" style="width:180px" /></td>
                
                <td align="right">状态:</td>
				<td>
					<select id="status" name="status"
					 style="width: 75px;" class="easyui-combobox" data-options="panelHeight:'auto'" readonly="true" >
							<option value="0">未开启</option>
							<option value="1">已启用</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">商户负责人:</td>
                <td><input id="chargeman" name="chargeman" 
                 class="easyui-textbox" readonly="readonly" style="width:180px"class="wu-text" /></td>
                 
           		<td align="right">联系手机号:</td>
                <td><input id="mobile" name="mobile" 
                 class="easyui-textbox" readonly="readonly" style="width:180px" /></td>
                
			</tr>
			
			
			 <tr>
                <td align="right">通讯地址:</td>
                <td><input id="address" name="address" 
                 class="easyui-textbox" readonly="readonly" style="width:180px" /></td>
                 
                <td align="right">邮箱:</td>
                <td><input id="email" name="email"
               class="easyui-textbox" readonly="readonly" style="width:180px" /></td>
                
            </tr>
            <tr>
                <td align="right">拓展网点名称:</td>
                <td><input id="belongSiteName" name="belongSiteName"
                  class="easyui-textbox" readonly="readonly" style="width:180px" /></td>
                
                <td align="right">创建日期:</td>
                <td>
                	<input id="createDate" name="createDate"
                	class="easyui-datebox" style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" readonly="readonly"/>
                </td>
            </tr>
             <tr>
                <td align="right">创建时间:</td>
                <td><input id="createTime" name="createTime" 
               class="easyui-textbox" style="width: 180px;" readonly="readonly"/>
                </td>
                
                <td align="right">更新时间:</td>
                <td><input id="updatetime" name="updatetime" 
				class="easyui-datetimebox" style="width: 180px;" data-options="prompt:'请选择日期',editable:'false'" readonly="readonly"/>
                </td>
            </tr>
               <tr>
                <td align="right">更新人:</td>
                <td><input id="updateby" name="updateby"
 					class="easyui-textbox" readonly="readonly" style="width:180px"/>
                </td>
                
                <td align="right">售后服务电话:</td>
                <td><input id="servicePhone" name="servicePhone" 
                class="easyui-textbox" readonly="readonly" style="width:180px" /></td>
            </tr>
            
            <tr>
                <td align="right">商户介绍:</td>
                <td><textarea id="venderIntro" name="venderIntro" class="wu-textarea" readonly="readonly"/></textarea></td>
                
                <td align="right">售后说明:</td>
                <td><textarea id="venderExplain" name="venderExplain" class="wu-textarea"  readonly="readonly"/></textarea></td>

            </tr>
			
		</table>
		</form>
</div>



