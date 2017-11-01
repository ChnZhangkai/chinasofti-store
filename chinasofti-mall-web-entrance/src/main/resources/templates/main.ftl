<head>
<meta charset="UTF-8">
<title>后台界面</title>
<link rel="stylesheet" type="text/css" href="/css/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/css/zk.css" />
<link rel="stylesheet" type="text/css" href="/css/themes/icon.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
</head>

<body class="easyui-layout">

	<!--上-->
	<div class="zk-header"
		data-options="region:'north',border:false,split:true">
		<div class="zk-header-left">
			<h1 style="color: black;">华腾商城</h1>
		</div>
		<div class="zk-header-right">
			<button href="javascript:void(0)" id="mb" class="easyui-menubutton"
   	 			data-options="menu:'#mm',iconCls:'icon-personal'" style="background-color: white;">admin</button>
			<div id="mm" style="width:150px;">
			    <div data-options="iconCls:'icon-undo'">密码设置</div>
			    <div data-options="iconCls:'icon-redo'">退出系统</div>
			</div>
			<button href="javascript:void(0)" id="mb" class="easyui-menubutton"
   	 			data-options="menu:'#mm2',iconCls:'icon-settings32'" style="background-color: white;">系统切换</button>
			<div id="mm2" style="width:150px;">
			    <div data-options="iconCls:'icon-undo'">基础平台</div>
			    <div data-options="iconCls:'icon-redo'">运营中心</div>
			    <div data-options="iconCls:'icon-redo'">微信平台</div>
			</div>
		</div>
	</div>

	<!--左-->
	<div class="zk-sidebar"
		data-options="region:'west',split:true,title:'菜单'"
		style="width: 150px; padding: 10px;">

		<div class="easyui-accordion" data-options="border:false,fit:true">
			<!--选项卡1-->
			<div title="用户权限" data-options="iconCls:'icon-application-cascade'" style="padding: 5px;">
				<ul class="easyui-tree zk-side-tree">
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="/goods/index" iframe="0">内管用户管理</a></li>
                    <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html" iframe="0">分组管理</a></li>
                    <li iconCls="icon-user-group"><a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">角色管理</a></li>
                    <li iconCls="icon-book"><a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html" iframe="0">系统管理</a></li>
                    <li iconCls="icon-cog"><a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">功能管理</a></li>
                    <li iconCls="icon-application-osx-error"><a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="temp/layout-3.html" iframe="0">商户用户管理</a></li>
                </ul>
			</div>
			<!--选项卡1-->
			<div title="系统维护" data-options="iconCls:'icon-application-cascade'" style="padding: 5px;">
				<ul class="easyui-tree zk-side-tree">
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">清算文件</a></li>
                    <li iconCls="icon-users"><a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html" iframe="0">订单文件</a></li>
                    <li iconCls="icon-user-group"><a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">关注信息</a></li>
                    <li iconCls="icon-book"><a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html" iframe="0">系统日志</a></li>
                </ul>
			</div>
			<!--选项卡1-->
			<div title="部门管理" data-options="iconCls:'icon-application-cascade'" style="padding: 5px;">
				<ul class="easyui-tree zk-side-tree">
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">部门管理</a></li>
                </ul>
			</div>
			<!--选项卡1-->
			<div title="参数配置" data-options="iconCls:'icon-application-cascade'" style="padding: 5px;">
				<ul class="easyui-tree zk-side-tree">
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">参数管理</a></li>
                </ul>
			</div>
			<!--选项卡1-->
			<div title="外系统管理" data-options="iconCls:'icon-application-cascade'" style="padding: 5px;">
				<ul class="easyui-tree zk-side-tree">
                	<li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html" iframe="0">后台批量管理</a></li>
                </ul>
			</div>
		</div>
	</div>

	<!--主界面-->
	<div class="zk-main" data-options="region:'center'">

		<div id="zk-tabs" class="easyui-tabs"
			data-options="border:false,fit:true">
			<div title="首页" style="background-image: url(/images/shouye1.png)"
				data-options="closable:false,iconCls:'icon-tip',cls:'pd3'"></div>
		</div>


	</div>

	<!--下-->
	<div class="zk-footer"
		data-options="region:'south',border:true,split:true">© 2017
		后台测试界面, 粤ICP备14024044号-2, All Rights Reserved.</div>


	<script type="text/javascript">
		
	<!--获取标题，url,图标，内联标签-->
		$(function() {
			$('.zk-side-tree a').bind("click", function() {
				var title = $(this).text();
				var url = $(this).attr('data-link');
				var iconCls = $(this).attr('data-icon');
				var iframe = $(this).attr('iframe') == 1 ? true : false;
				addTab(title, url, iconCls, iframe);
			});
		})

		/**
		 * Name 添加菜单选项
		 * Param title 名称
		 * Param href 链接
		 * Param iconCls 图标样式
		 * Param iframe 链接跳转方式（true为iframe，false为href）
		 */
		function addTab(title, href, iconCls, iframe) {
			var tabPanel = $('#zk-tabs');
			if (!tabPanel.tabs('exists', title)) {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'
						+ href + '" style="width:100%;height:100%;"></iframe>';
				if (iframe) {
					tabPanel.tabs('add', {
						title : title,
						content : content,
						iconCls : iconCls,
						fit : true,
						cls : 'pd3',
						closable : true
					});
				} else {
					tabPanel.tabs('add', {
						title : title,
						href : href,
						iconCls : iconCls,
						fit : true,
						cls : 'pd3',
						closable : true
					});
				}
			} else {
				tabPanel.tabs('select', title);
			}
		}
		
		/**
		* Name 选项卡初始化
		*/
		$('#zk-tabs').tabs({
			tools:[{
				iconCls:'icon-reload',
				border:false,
				handler:function(){
					$('#wu-datagrid').datagrid('reload');
				}
			}]
		});
			
		/**
		* Name 移除菜单选项
		*/
		function removeTab(){
			var tabPanel = $('#zk-tabs');
			var tab = tabPanel.tabs('getSelected');
			if (tab){
				var index = tabPanel.tabs('getTabIndex', tab);
				tabPanel.tabs('close', index);
			}
		}
		
	</script>



</body>