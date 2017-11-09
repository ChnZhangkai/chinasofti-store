<script type="text/javascript" src="js/goodsorder.js"></script>

<div class="easyui-layout" data-options="" >
	<!-- 主订单模块开始 -->
	<!-- 主订单工具栏 -->
	<div id="mainorderToolbar">
		<div class="mainorderoolbarButton"  style="padding:0 0 0 10px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search"
				onclick="openMainorderCheck()" plain="false">查看主订单详细信息</a>
		</div>

		<!-- 主订单条件搜索 -->
		<form id="mainorderSearchForm" method="post">
			<div align="left">
				<table class="" style="width: 95%">
					<tr>
						<th style="width:10%;padding:0 10px 0 0;" align="right">主订单号</th>
						<td style="width:15%" align="left">
							<input class="easyui-textbox" id="mainorder-transactionid" name="transactionid" data-options="" />
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">主订单号</th>
						<td style="width:15%" align="left">
							<input class="easyui-textbox" id="mainorder-bigorderId" name="bigorderId" data-options="" />
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">订单开始时间</th>
						<td style="width:15%" align="left"> 
							<input class="easyui-datetimebox" id="mainorder-minPayTime" name="minPayTime" data-options="editable:false" />
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">订单结束时间</th>
						<td style="width:15%" align="left">
							<input class="easyui-datetimebox" id="mainorder-maxPayTime" name="maxPayTime" data-options="editable:false" />
						</td>
					</tr>
					<tr>
						<th style="width:10%;padding:0 10px 0 0;" align="right">支付状态</th>
						<td style="width:15%" align="left">
							<select id="mainorder-payStatus" class="easyui-combobox" name="payStatus"
									data-options="width:135,panelMaxHeight:82">
								<option value="">请选择</option>
								<option value="0">未支付</option>
								<option value="1">已支付</option>
								<option value="2">已取消</option>
							</select>
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">支付渠道</th>
						<td style="width:15%" align="left">
							<select id="mainorder-payway" class="easyui-combobox" name="payway"
									data-options="width:135,panelMaxHeight:82">
								<option value="">请选择</option>
								<option value="1">微信</option>
								<option value="2">支付宝</option>
							</select>
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">订单状态</th>
						<td style="width:15%" align="left">
							<select id="mainorder-orderStatus" class="easyui-combobox" name="orderStatus"
									data-options="width:135,panelMaxHeight:82">
								<option value="">请选择</option>
								<option value="0">待付款</option>
								<option value="1">待发货</option>
								<option value="2">待收货</option>
								<option value="3">交易成功</option>
								<option value="4">交易关闭（已删除）</option>
								<option value="5">交易关闭（已取消）</option>
								<option value="6">交易关闭（退款成功）</option>
							</select>
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">联系人</th>
						<td style="width:15%" align="left">
							<input class="easyui-textbox"id="mainorder-contName" name="contName" data-options="" />
						</td>
					</tr>
					<tr>
						<th style="width:10%;padding:0 10px 0 0;" align="right">销售渠道</th>
						<td style="width:15%" align="left">
							<select id="mainorder-" class="easyui-combobox" name=""
									data-options="width:135,panelMaxHeight:82">
								<option value="">请选择</option>
								<option value="0">线上</option>
								<option value="1">线下</option>
							</select>
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">核销状态</th>
						<td style="width:15%" align="left">
							<select id="mainorder-" class="easyui-combobox" name=""
									data-options="width:135,panelMaxHeight:82">
								<option value="">请选择</option>
								<option value="0">已核销</option>
								<option value="1">未核销</option>
							</select>
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">清算日期</th>
						<td style="width:15%" align="left">
							<input class="easyui-datetimebox" id="mainorder-settleTimeFee" name="settleTimeFee" data-options="" />
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<a class="easyui-linkbutton" iconCls="icon-search" plain="false" onclick="mainorderDoSearch()">查询</a>&nbsp;&nbsp;
							<a class="easyui-linkbutton" iconCls="icon-edit-clear" plain="false" onclick="mainorderClearAll()">清空</a>
						</td>
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
				<th field="transactionid" width="20%" align="center" data-options="sortable:true">主订单号</th>
				<th field="bigorderId" width="20%" align="center">大订单号</th>
				<th field="ac" width="8%" align="center" data-options="formatter:paywayFormatter">订单类型-</th>
				<th field="vendorIds" width="10%" align="center">商户名称-</th>
				<th field="orderTotalAmt" width="8%" align="center" data-options="sortable:true">订单总额</th>
				<th field="payStatus" width="5%" align="center" data-options="formatter:payStatusFormatter">支付状态</th>
				<th field="status" width="5%" align="center" data-options="formatter:statusFormatter">订单状态-</th>
				<th field="ac" width="5%" align="center">物流状态</th>
				<th field="settleStatues" width="8%" align="center" data-options="formatter:settleStatuesFormatter">清算状态</th>
				<th field="ac" width="5%" align="center" data-options="formatter:statusFormatter">核销状态-</th>
			</tr>
		</thead>
	</table>

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
							<input name="transactionid" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">大订单号</td>
						<td style="width:40%" align="left">
							<input name="bigorderId" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">商户名称</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">订单类型</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">订单销售渠道</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">运费</td>
						<td style="width:40%" align="left">
							<input name="freight" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">商品总积分</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">实付金额</td>
						<td style="width:40%" align="left">
							<input name="orderAmt" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">积分总价值</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">订单总额</td>
						<td style="width:40%" align="left">
							<input name="orderTotalAmt" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">是否已申请退换货</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">抽奖码</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
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
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">用户OpenId</td>
						<td style="width:40%" align="left">
							<input name="userIds" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">订货人手机号</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">下单时间</td>
						<td style="width:40%" align="left">
							<input name="orderTime" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">是否行内人员</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">客户IP</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
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
							<input name="deliveryWay" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">收货人</td>
						<td style="width:40%" align="left">
							<input name="contName" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">收货人手机号</td>
						<td style="width:40%" align="left">
							<input name="contPhone" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">收货人地址</td>
						<td style="width:40%" align="left">
							<input name="contAddress" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">客户订单备注</td>
						<td style="width:40%" align="left">
							<input name="buyersMessage" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">推荐人</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
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
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">现金支付时间</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">支付渠道</td>
						<td style="width:40%" align="left">
							<input name="payway" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">支付方式</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
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
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">物流公司名称</td>
						<td style="width:40%" align="left">
							<input name="expressName" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">快递单号</td>
						<td style="width:40%" align="left">
							<input name="expressId" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">发货说明</td>
						<td style="width:40%" align="left">
							<input name="senddesc" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
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
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">发货时间</td>
						<td style="width:40%" align="left">
							<input name="sendouttime" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">签收类型</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">签收人</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">签收时间</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
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
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">优惠券代码</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">券编号</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">券名称</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">券面额</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">券实际抵扣金额</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
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
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
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
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">对账时间</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">清算状态</td>
						<td style="width:40%" align="left">
							<input name="settleStatues" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
						<td style="width:10%;padding:0 15px 0 0;" align="right">清算时间</td>
						<td style="width:40%" align="left">
							<input name="settleTime" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td style="width:10%;padding:0 15px 0 0;" align="right">清算检查状态</td>
						<td style="width:40%" align="left">
							<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<!-- 主订单详细信息显示结束 -->
	<!-- 主订单模块结束 -->
	
	<!-- 子订单模块开始 -->
	<!-- 子订单模块工具栏 -->
	<div id="childorderToolbar">
		<div class="childorderoolbarButton" style="padding:0 0 0 10px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="openChildorderCheck()">查看订单详细信息</a>
		</div>

		<!-- 子订单条件搜索 -->
		<form id="childorderSearchForm" method="post">
			<div align="left">
				<table class="" style="width: 95%">
					<tr>
						<th style="width:10%;padding:0 10px 0 0;" align="right">子订单号</th>
						<td style="width:15%" align="left">
							<input class="easyui-textbox" id="childorder-transactionid" name="transactionid" />
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">主订单号</th>
						<td style="width:15%" align="left">
							<input class="easyui-textbox" id="childorder-mainorderIds" name="mainorderIds" />
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">商品类型</th>
						<td style="width:15%" align="left">
							<select id="childorder-goodsClass" data-options="panelMaxHeight:82" class="easyui-combobox" name="goodsClass">
								<option value="">请选择</option>
								<option value="1">普通商品</option>
								<option value="2">活动商品</option>
								<option value="3">实物众筹商品</option>
							</select>
						</td>
						<th style="width:10%;padding:0 10px 0 0;" align="right">订单类型</th>
						<td style="width:15%" align="left">
							<select id="childorder-orderType" data-options="panelMaxHeight:82" class="easyui-combobox" name="orderType">
								<option value="">请选择</option>
								<option value="1">普通订单</option>
								<option value="2">优惠券订单</option>
								<option value="3">实物众筹订单</option>
						</select>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<a class="easyui-linkbutton" iconCls="icon-search" plain="false" onclick="childorderDoSearch()">查询</a>&nbsp;&nbsp;
							<a class="easyui-linkbutton" iconCls="icon-edit-clear" plain="false" onclick="childorderClearAll()">清空</a>
						</td>
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
       				 sortName:'mainorderIds',
       				 sortOrder:'asc',
       				 remoteSort:false,
       				 sorter:childorderSort,
       				 toolbar:'#childorderToolbar',
       				 title:'子订单列表',
       				 iconCls:'icon-man',
       				 striped:true,
       				 collapsible:true">
		<thead>
			<tr>
				<th field="transactionid" width="20%" align="center" 
					data-options="sortable:true">子订单号</th>
				<th field="mainorderIds" width="20%" align="center" 
					data-options="sortable:true">主订单号</th>
				<th field="orderType" width="8%" align="center"
					data-options="formatter:orderTypeFormatter">订单类型</th>
				<th field="goodsids" width="15%" align="center">商品名称-</th>
				<th field="aa" width="8%" align="center">商品规格</th>
				<th field="goodsNum" width="5%" align="center">购买数量</th>
				<th field="orderAmt" width="5%" align="center">商品总价</th>
				<th field="ab" width="8%" align="center">退换货类型</th>
				<th field="ac" width="8%" align="center">售后状态</th>
				<th field="ad" width="8%" align="center" 
					data-options="formatter:btnFormatter">操作</th>
			</tr>
		</thead>
	</table>
	
	<!-- 子订单详细信息显示开始 -->
	<div id="childorderEditDialog" class="easyui-dialog" data-options="closed:true,draggable:false,inline:true"
		style="width: 100%; height: 100%">
		<form id="childorderEditForm" action="">
			<table style="width:100%">
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">子订单号</td>
					<td style="width:40%" align="left">
						<input name="transactionid" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">主订单号</td>
					<td style="width:40%" align="left">
						<input name="mainorderIds" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">商品分类</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">商品类型</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">商品名称</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">商品编号</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">商品规格</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">购买数量</td>
					<td style="width:40%" align="left">
						<input name="goodsNum" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">商品单价</td>
					<td style="width:40%" align="left">
						<input name="goodsPrice" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">商品总价</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">支付金额(不含运费)</td>
					<td style="width:40%" align="left">
						<input name="orderRealAmt" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">运费</td>
					<td style="width:40%" align="left">
						<input name="freight" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">支付渠道</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">支付方式</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">积分数量</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">积分总价值</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">商户备注</td>
					<td style="width:40%" align="left">
						<input name="venderRemark" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">订单类型</td>
					<td style="width:40%" align="left">
						<input name="orderType" class="easyui-textbox" 
							style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">优惠券代码</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">券编号</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">券名称</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">券面额</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">券实际抵扣金额</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">是否已申请退换货</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td style="width:10%;padding:0 15px 0 0;" align="right">退换货类型</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly" />
					</td>
					<td style="width:10%;padding:0 15px 0 0;" align="right">售后状态</td>
					<td style="width:40%" align="left">
						<input name="" class="easyui-textbox" style="width:80%;height:30px;" readonly="readonly"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 子订单详细信息显示开始 -->
	<!-- 子订单模块结束 -->
</div> 
<!-- End of easyui-dialog -->
