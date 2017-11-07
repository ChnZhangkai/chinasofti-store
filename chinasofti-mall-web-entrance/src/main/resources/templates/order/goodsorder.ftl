<script type="text/javascript" src="js/goodsorder.js"></script>

<div class="easyui-layout" data-options="">
	<!-- 主订单模块开始 -->
	<!-- 主订单工具栏 -->
	<div id="mainorderToolbar">
		<div class="mainorderoolbarButton">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"
				onclick="openMainorderCheck()" plain="true">主订单查看</a>
			<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">主订单添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">主订单删除</a> -->
		</div>

		<!-- 主订单条件搜索 -->
		<form id="mainorderSearchForm" method="post">
			<div align="left">
				<table class="" style="width: 95%">
					<tr>
						<td>主订单号： <input class="easyui-textbox"
							id="mainorder-transactionid" name="transactionid" data-options="" />
						</td>
						<td>大订单号： <input class="easyui-textbox"
							id="mainorder-bigorderId" name="bigorderId" data-options="" />
						</td>
						<td>支付开始时间： <input class="easyui-datetimebox"
							id="mainorder-minPayTime" name="minPayTime"
							data-options="editable:false" />
						</td>
						<td>支付结束时间：<input class="easyui-datetimebox"
							id="mainorder-maxPayTime" name="maxPayTime"
							data-options="editable:false" /></td>
					</tr>
					<tr>
						<td>支付状态：<select id="mainorder-payStatus"
							class="easyui-combobox" name="payStatus"
							data-options="width:80,panelMaxHeight:82">
								<option value="">请选择</option>
								<option value="0">未支付</option>
								<option value="1">已支付</option>
								<option value="2">已取消</option>
						</select>
						</td>
						<td>联&nbsp;&nbsp;系&nbsp;人：<input class="easyui-textbox"
							id="mainorder-contName" name="contName" data-options="" /></td>
					</tr>
					<tr>
						<td align="center"><a class="easyui-linkbutton"
							iconCls="icon-search" plain="true" onclick="mainorderDoSearch()">查询</a>&nbsp;&nbsp;
							<a class="easyui-linkbutton" iconCls="icon-edit-clear"
							plain="true" onclick="mainorderClearAll()">清空</a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>

	<!-- 主订单数据表格 -->
	<table id="mainorderDataGrid" class="easyui-datagrid"
		singleSelect="true"
		data-options="url:'mainorder/list',
    				 fitColumns:true,
       				 pagination:true,
       				 sortName:'ids',
       				 sortOrder:'asc',
       				 toolbar:'#mainorderToolbar',
       				 title:'主订单列表',
       				 iconCls:'icon-man',
       				 striped:true,
       				 collapsible:true">
		<thead>
			<tr>
				<th field="transactionid" width="20%" align="center">主订单号</th>
				<th field="bigorderId" width="20%" align="center">大订单号</th>
				<th field="payway" width="8%" align="center"
					data-options="formatter:paywayFormatter">支付路径-</th>
				<th field="vendorIds" width="10%" align="center">商户名称-</th>
				<th field="orderTotalAmt" width="8%" align="center">订单总额</th>
				<th field="payStatus" width="5%" align="center"
					data-options="formatter:payStatusFormatter">支付状态</th>
				<th field="status" width="5%" align="center"
					data-options="formatter:statusFormatter">订单状态</th>
				<th field="settleStatues" width="8%" align="center"
					data-options="formatter:settleStatuesFormatter">清算状态</th>
			</tr>
		</thead>
	</table>
	<!-- 主订单模块结束 -->

	<!-- 子订单模块开始 -->
	<!-- 子订单模块工具栏 -->
	<div id="childorderToolbar">
		<div class="childorderoolbarButton">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit"
				onclick="openEdit()" plain="true">子订单查看</a>
			<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="openAdd()" plain="true">主订单添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="remove()" plain="true">主订单删除</a> -->
		</div>

		<!-- 子订单条件搜索 -->
		<form id="childorderSearchForm" method="post">
			<div align="left">
				<table class="" style="width: 95%">
					<tr>
						<td>子订单号：<input class="easyui-textbox"
							id="childorder-transactionid" name="transactionid" /></td>
						<td>主订单号：<input class="easyui-textbox"
							id="childorder-mainorderIds" name="mainorderIds" /></td>
						<td>商品类型：<select id="childorder-goodsClass"
							data-options="panelMaxHeight:82" class="easyui-combobox"
							name="goodsClass">
								<option value="">请选择</option>
								<option value="1">普通商品</option>
								<option value="2">活动商品</option>
								<option value="3">实物众筹商品</option>
						</select>
						</td>
						<td>订单类型：<select id="childorder-orderType"
							data-options="panelMaxHeight:82" class="easyui-combobox"
							name="orderType">
								<option value="">请选择</option>
								<option value="1">普通订单</option>
								<option value="2">优惠券订单</option>
								<option value="3">实物众筹订单</option>
						</select>
						</td>
					</tr>
					<tr>
						<td align="center"><a class="easyui-linkbutton"
							iconCls="icon-search" plain="true" onclick="childorderDoSearch()">查询</a>&nbsp;&nbsp;
							<a class="easyui-linkbutton" iconCls="icon-edit-clear"
							plain="true" onclick="childorderClearAll()">清空</a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>

	<!-- 子订单模块数据表 -->
	<table id="childorderDataGrid" class="easyui-datagrid"
		singleSelect="true"
		data-options="url:'childorder/list',
    				 fitColumns:true,
       				 pagination:true,
       				 sortName:'ids',
       				 sortOrder:'asc',
       				 toolbar:'#childorderToolbar',
       				 title:'子订单列表',
       				 iconCls:'icon-man',
       				 striped:true,
       				 collapsible:true">
		<thead>
			<tr>
				<th field="transactionid" width="20%" align="center">子订单号</th>
				<th field="mainorderIds" width="20%" align="center">主订单号</th>
				<th field="orderType" width="8%" align="center"
					data-options="formatter:orderTypeFormatter">订单类型</th>
				<th field="goodsids" width="15%" align="center">商品名称-</th>
				<th field="aa" width="8%" align="center">商品规格</th>
				<th field="goodsNum" width="5%" align="center">购买数量</th>
				<th field="orderAmt" width="5%" align="center">商品总价</th>
				<th field="ab" width="8%" align="center">退换货类型</th>
				<th field="ac" width="8%" align="center">售后状态</th>
			</tr>
		</thead>
	</table>
	<!-- 子订单模块结束 -->

	<!-- 主订单详细信息显示开始 -->
	<div id="mainorderEditDialog" class="easyui-dialog"
		data-options="closed:true,draggable:false,inline:true"
		style="width: 100%; height: 100%">
		<form id="mainorderEditForm" action="">
			<div id="" class="easyui-panel" title="基本信息"
				data-options="collapsible:true,iconCls:'icon-edit'" style="width: 100%">
				<table style="width:100%">
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">主订单号</td>
						<td style="width:40%" align="left">
							<input name="transactionid" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">大订单号</td>
						<td style="width:40%" align="left">
							<input name="bigorderId" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">商户名称</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">订单类型</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">订单销售渠道</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">运费</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">商品总积分</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">实付金额</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">积分总价值</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">订单总额</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">是否已申请退换货</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">抽奖码</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
				</table>
			</div>
			<div id="" class="easyui-panel" title="订货信息"
				data-options="collapsible:true,iconCls:'icon-edit'" style="width: 100%">
				<table style="width:100%">
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">订货人</td>
						<td style="width:40%" align="left">
							<input name="transactionid" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">用户OpenId</td>
						<td style="width:40%" align="left">
							<input name="bigorderId" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">订货人手机号</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">下单时间</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">是否行内人员</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">客户IP</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
				</table>
			</div>
			<div id="" class="easyui-panel" title="收货人信息"
				data-options="collapsible:true,iconCls:'icon-edit'" style="width: 100%">
				<table style="width:100%">
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">配送方式</td>
						<td style="width:40%" align="left">
							<input name="transactionid" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">收货人</td>
						<td style="width:40%" align="left">
							<input name="bigorderId" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">收货人手机号</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">收货人地址</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">客户订单备注</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">推荐人</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
				</table>
			</div>
			<div id="" class="easyui-panel" title="支付信息"
				data-options="collapsible:true,iconCls:'icon-edit'" style="width: 100%">
				<table style="width:100%">
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">现金支付状态</td>
						<td style="width:40%" align="left">
							<input name="transactionid" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">现金支付时间</td>
						<td style="width:40%" align="left">
							<input name="bigorderId" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">支付渠道</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">支付方式</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
				</table>
			</div>
			<div id="" class="easyui-panel" title="发货信息"
				data-options="collapsible:true,iconCls:'icon-edit'" style="width: 100%">
				<table style="width:100%">
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">物流状态</td>
						<td style="width:40%" align="left">
							<input name="transactionid" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">物流公司名称</td>
						<td style="width:40%" align="left">
							<input name="bigorderId" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">快递单号</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">发货说明</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
				</table>
			</div>
			<div id="" class="easyui-panel" title="物流信息"
				data-options="collapsible:true,iconCls:'icon-edit'" style="width: 100%">
				<table style="width:100%">
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">发货人</td>
						<td style="width:40%" align="left">
							<input name="transactionid" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">发货时间</td>
						<td style="width:40%" align="left">
							<input name="bigorderId" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">签收类型</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">签收人</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">签收时间</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
					</tr>
				</table>
			</div>
			<div id="" class="easyui-panel" title="优惠券信息"
				data-options="collapsible:true,iconCls:'icon-edit'" style="width: 100%">
				<table style="width:100%">
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">优惠券类型</td>
						<td style="width:40%" align="left">
							<input name="transactionid" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">优惠券代码</td>
						<td style="width:40%" align="left">
							<input name="bigorderId" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">券编号</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">券名称</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">券面额</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">券实际抵扣金额</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
					</tr>
				</table>
			</div>
			<div id="" class="easyui-panel" title="发票信息"
				data-options="collapsible:true,iconCls:'icon-edit'" style="width: 100%">
				<table style="width:100%">
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">发票类型</td>
						<td style="width:40%" align="left">
							<input name="transactionid" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right"></td>
						<td style="width:40%" align="left"></td>
					</tr>
				</table>
			</div>
			<div id="" class="easyui-panel" title="对账清算信息"
				data-options="collapsible:true,iconCls:'icon-edit'" style="width: 100%">
				<table style="width:100%">
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">对账状态</td>
						<td style="width:40%" align="left">
							<input name="transactionid" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">对账时间</td>
						<td style="width:40%" align="left">
							<input name="bigorderId" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">清算状态</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">清算时间</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">清算检查状态</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:260px;height:30px;" readonly="readonly" />
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<!-- 主订单详细信息显示结束 -->
</div>
<!-- End of easyui-dialog -->
