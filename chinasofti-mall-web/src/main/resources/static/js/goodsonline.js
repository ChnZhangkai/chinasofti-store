
	var ue = UE.getEditor('containeGoods',{
		initialFrameWidth:1000,  //初始化编辑器宽度,默认1000  
        initialFrameHeight:140  //初始化编辑器高度,默认320
	});

	/*
	 * 全局加载数据
	 */
	$(function() {
		//商品分类选择窗口
		$('#ClassTreeDlg').dialog({
			title: '菜单树',//窗口标题
			width: 400,//窗口宽度
			height: 300,//窗口高度
			closed: true,//窗口是是否为关闭状态, true：表示关闭
			modal: true,//模式窗口
			resizable:true
		});
	});


	/*
	 * 读取路径显示图片
	 */
	function imgFormatter(value, row) {
		var ids = row.ids;
		var str = "";
		images = $.ajax({url:'/goodsOnline/reqGoodsImgPath/' + ids,type:'POST',async:false});
		str = "<img style=\"height: 75px;width: 110px;\" src=\""+ images.responseText +"\"/>";
		return str;
		
	}
	
	
	/*
	 * 商品类型
	 */
	function typesFormatter(value){
		if(value == "0"){
			return '<span>普通商品</span>';
		}else{
			return '<span style="color:#FF00FF">活动商品</span>';
		}
	}
	
	/*
	 * 商品状态
	 */
	function statusFormatter(value) {
		if (value == "0") {
			return '<span style="color:black">已删除</span>';
		} 
		if (value == "1"){
			return '<span style="color:green">已上架</span>';
		} 
		if (value == "2"){
			return '<span style="color:red">已下架</span>';
		}
	}
	

	//扩展easyui表单的验证  
	$.extend($.fn.validatebox.defaults.rules, {  
		//库存验证  
		storeNum: {//value值为文本框中的值  
	        validator: function (value) {  
	            var reg = /^[0-9]{0,10}$/;   
	            return reg.test(value);  
	        },  
	        message: '只能输入数字,不能为负数和小数，不能超长输入.'  
	    }
	})
	
	

	
/**
	* Name 打开修改窗口
	*/
	function onlineEdits(){
		$('#updateGoodsForm').form('clear');
		var row = $("#goodsOnlineinfo").datagrid('getSelected');
		
		if (row) {
			$('#goodsOnline_updateDl').dialog('open').dialog({
				closed: false,
				modal:true,
				closable:false,
	            title: "修改库存",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: edit
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#goodsOnline_updateDl').dialog('close');
	                    document.getElementById("showGoodsPic").innerHTML = "";
	                }
	            }]
	        });
	 
				$('#updateGoodsForm').form('load',row);//加载数据
				var ids = row.ids;
				$(document).ready(function(){  
		        var ue = UE.getEditor('containeGoods');  
		        
		        ue.ready(function() {//编辑器初始化完成再赋值  
		        ue.setContent(row.content);  //赋值给UEditor 
		      	ue.setDisabled('fullscreen');
		          
		        images = $.ajax({url:'/goodsOnline/reqGoodsImgPath/' + ids,type:'POST',async:false});
		        var tp=$("#imgUrl").attr("src",images.responseText); 
		    
		        });  
		        
		    });
			
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/*
	*修改
	*/
	function edit(){
		$('#updateGoodsForm').form('submit', {
			url:'/goodsOnline/update',
    		type:'POST',
    		data:$('#updateGoodsForm').serialize(),
    		success:function(data){
    			if(data > 0){
    				$.messager.alert('信息提示','提交成功！','info');
    				$('#goodsOnlineinfo').datagrid('reload');
    				$('#goodsOnline_updateDl').dialog('close');
    			}else{
    				$.messager.alert('信息提示','提交失败！','info');
    			}
    		}
    	});
	}
	

	
	// 导出
	function exportExcel(){
	  
 		window.location.href='goodsOnline/export?model=jxls/goodsOnline.xls';  
	}
	
		
	/*
	*商品上下架
	*/
	function putaway(obj){
	 var goodsids;
	 var status;
	 var onlineTime;
	 var leaveTime;
	 
	 var items = $('#goodsOnlineinfo').datagrid('getSelections');
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中操作的数据');
			return ;
		}
		goodsids = items[0].ids;
		status = items[0].status;
		onlineTime1 = items[0].onlineTime;
		leaveTime = items[0].leaveTime;
		
		//提交
		if(obj.id == "putaway"){
			if(status != 2){
				$.messager.alert('温馨提醒','您选中的是一条已上架的数据，请重新选择其他要上架的商品数据','question')
				return ;
			}
			$.ajax({
				url:'/goodsOnline/updateGoodsStatus',
				type:'POST',
				data: {'ids':goodsids,'status':status,'leaveTime':leaveTime,'onlineTime':onlineTime1},
				success:function(data){
					if(data){
						$.messager.alert('信息提示','提交成功！','info');
						$('#goodsOnlineinfo').datagrid('reload');
					}
					else
					{
						$.messager.alert('信息提示','提交失败！','info');		
					}
				}	
			});
		}if(obj.id == "soldOut"){
			if(status != 1){
				$.messager.alert('温馨提醒','您选中的是一条已下架的数据，请重新选择其他要下架的商品数据','question')
				return ;
			}
			$.ajax({
				url:'/goodsOnline/updateGoodsStatus',
				type:'POST',
				data: {'ids':goodsids,'status':status,'leaveTime':leaveTime,'onlineTime':onlineTime1},
				success:function(data){
					if(data){
						$.messager.alert('信息提示','提交成功！','info');
						$('#goodsOnlineinfo').datagrid('reload');
					}
					else
					{
						$.messager.alert('信息提示','提交失败！','info');		
					}
				}	
			});
		}
	}
	

	//条件查询
	function goodOnlineDoSearch(){
		$("#goodsOnlineinfo").datagrid("load", {
			'title' : $('#goodsOnline-title').val(),
			'vendorFnm' : $('#goodsOnline-vendorFnm').val(),
			'name' : $('#goodsOnline-name').val(),
			'type':$('#goodsOnline-goodsType').val(),
			'status':$('#goodsOnline-status').val()
			
		});
	}
	
	/*
	 *清除查询条件
	 */
	 function goodOnlineDoClear(){
		$('#searchOnlineForm').form('reset');
	}
	
	// 商品在线查看
		function showGoodsOnline() {
			var row = $('#goodsOnlineinfo').datagrid('getSelected');
			var ids = row.ids;
			$(document).ready(function(){  
	        var ue = UE.getEditor('containeGoods');  
	        
	        ue.ready(function() {//编辑器初始化完成再赋值  
	        ue.setContent(row.content);  //赋值给UEditor 
	      	ue.setDisabled('fullscreen');
	          
	      	images = $.ajax({url:'/goodsOnline/reqGoodsImgPath/' + ids,type:'POST',async:false});
	        var tp=$("#imgUrl").attr("src",images.responseText); 
	        });  
	        
	    });
			if (row <= 0) {
				$.messager.alert('提示', '请选择查看的条目!');
			} else {
				$('#goodsOnline-show-dialog').dialog('open').dialog('setTitle', '商品在线详情');
				$('#goodsOnline-show-form').form('load', row);
			}
		}
	
	
	/*
	 * 上传图片回显
	 */
	function readGoodsPicture(_obj) {
		//easyui-filebox封装input标签
		var fileId = $("input[type='file']").attr('id');
		//console.info(fileId);
		// 检查是否为图像类型
		var simpleFile = document.getElementById(fileId).files[0];
		//console.info(simpleFile);
		if (!/image\/\w+/.test(simpleFile.type)) {
			$.messager.alert('信息提示', '请确保文件类型为图像类型', 'info')
			return false;
		}
		var reader = new FileReader();
		// 将文件以二进制文件读入页面中
		reader.readAsBinaryString(simpleFile);
		reader.onload = function(f) {
			var result = document.getElementById("showGoodsPic");
			var src = "data:" + simpleFile.type + ";base64,"
					+ window.btoa(this.result);
			result.innerHTML = '<img id="readGoodsPic" style="height: 130px;width: 200px;" src ="' + src + '"/>';
		}
		//document.getElementById("showpic").style.display="";
	}
	
	
	/**
	 * 打开商品分类窗口
	 */
	function classChoose(){
		//异步请求数据
        $('#ClassTreeDlg').dialog('open');
		$('#classTree').tree({
			url:'/goods/findGoodsClass'
		});
	}
	
	/**
	 * 商品分类选择
	 */
	function Choose(){
		var row = $("#classTree").tree('getSelected');
		if(row){ 
			$("#goodsOnline-name").textbox('setValue',row.text);	
			$("#ClassTreeDlg").dialog("close");
			$('#classTree').tree('clearSelections');
		}else{
			$.messager.alert('系统消息','请选择一项进行操作!','info');
		}
	}
	
	/**
	 * 打开商户列表
	 */
	function vendersFnmChoose(){
		$('#FnmChooseDialog').dialog('open');
	}
	
	/**
	 * 商户查询
	 */
	function venderDoSearch() {
		$('#venderDataTable').datagrid('load', {
			vendorId : $('#vender-vendorId').val(),
			vendorSnm : $('#vender-vendorSnm').val()
		});
	}

	/**
	 * 商户搜索条件清空
	 */
	function venderClearAll() {
		$("#venderSearchForm").form("reset");
		$('#venderDataTable').datagrid("load", {});
	}

	/**
	 * 商户名称选择
	 */
	function FnmChoose(){
		var row = $("#venderDatas").datagrid("getSelected");
		if(row){
			$("#goodsOnline-vendorFnm").textbox('setValue',row.vendorFnm);
			$("#FnmChooseDialog").dialog("close");
			$('#venderDatas').datagrid('clearSelections');
		}else{
			$.messager.alert('系统消息','请选择一项进行操作!','info');
		}
	}
	