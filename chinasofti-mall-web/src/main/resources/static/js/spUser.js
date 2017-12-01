	
	/**
	 * 全局加载数据
	 */
	$(function() {
		$.messager.show({
			title : '提示',
			msg : '该充值智商了!'
		});

		//获取表格datagrid的ID属性,
		var tableID = "spuserinfo";
		//获取分页工具条元素
		var pageId = $('#spUserPagination');
		//此处设置自己的url地址
		var url = '/spUser/list';
		//分页查询时传递查询条件
		seachId = '#spUserSearchForm';
		//调用初始化方法	
		tdload(tableID, pageId, url);

		$.messager.progress({
			text : '数据正在加载中'
		});

	});
	
	/**
	 * 编辑器
	 * */
	var ue = UE.getEditor('containeSpuser',{
		initialFrameWidth:800,  //初始化编辑器宽度,默认1000  
        initialFrameHeight:100  //初始化编辑器高度,默认320
	});
	
	/**
	 * 分类状态
	 */
	function statesFormatter(value){
		if(value == "0"){
			return '<span style="color:red">未开启</span>';
		}else{
			return '<span style="color:green">已启用</span>';
		}
	}
	
	/**
	* Name 删除记录
	*/
	function spUserRemove(){
	
		var items = $('#spuserinfo').datagrid('getSelections');
		var ids = [];
		
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中要删的数据');
			return ;
		}
	
		$.messager.confirm('信息提示','确定要删除该记录？', function(result){
			if(result){
				$(items).each(function(){
					ids.push(this.ids);	
				});
				$.ajax({
					url:'/spUser/delete/' + ids,
					type:'POST',
					success:function(data){
						if(data){
							$.messager.alert('信息提示','删除成功！','info');
							//$('#spuserinfo').datagrid('reload')
							$('#spUserPagination').pagination('select');
						}
						else
						{
							$.messager.alert('信息提示','删除失败！','info');		
						}
					}	
				});
			}	
		});
	}
	
	
	
	
	/**
	* Name 打开添加窗口
	*/
	function spUserOpenAdd(){
		$('#spUserAdd').form('clear');
		$('#spUserAddDialog').dialog({
			closed: false,
			closable:false,
			modal:true,
            title: "添加商户用户",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: add,
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#spUserAddDialog').dialog('close');
                    $('#spUserAdd').form('clear');
                    
                    //document.getElementById("showpic").style.display="none";
                    document.getElementById("showpic").innerHTML = "";
                }
           
            }],
            
        });
	
	}

	//扩展easyui表单的验证  
	$.extend($.fn.validatebox.defaults.rules, {  
	 
	    //商户编号验证  
		vendorIds: {//value值为文本框中的值  
	        validator: function (value) {  
	            var reg = /^[a-zA-Z0-9]{9}$/;   
	            return reg.test(value);  
	        },  
	        message: '输入商户编号格式不正确.'  
	    },
	   
	    //商户全称验证
		vendorFnm:{
			 validator: function (value) {  
				 var reg= /^[\u0391-\uFFE5a-zA-Z]{4,50}$/;
				 return reg.test(value);  
			 },
			  message: '只能输入汉字和字母，且字符长度在4-50位之间.' 
		},
	    
	    //商户简称验证
		vendorSnm:{
			 validator: function (value) {  
				 var reg= /^[\u0391-\uFFE5a-zA-Z]{4,20}$/;
				 return reg.test(value);  
			 },
			  message: '只能输入汉字和字母，且字符长度在4-20位之间.' 
		},
		
		//商户负责人
		chargeman:{
			 validator: function (value) {  
				 var reg= /^[\u0391-\uFFE5a-zA-Z]{2,15}$/;
				 return reg.test(value);  
			 },
			  message: '只能输入汉字和字母，且字符长度在2-15位之间.' 
		},
		
		//联系手机号
		 mobile: {//value值为文本框中的值  
		        validator: function (value) {  
		            var reg = /^1[3|4|5|8|9]\d{9}$/;  
		            return reg.test(value);  
		        },  
		        message: '输入手机号码格式不准确.'  
		    }
	})
	
	
	/**
	* Name 添加记录
	*/
	function add(){
	
		$('#spUserAdd').form('submit', {
			url:'/spUser/add',
			type:'POST',
			success:function(data){
				if(data > 0){
					$('#spUserPagination').pagination('select');
					$('#spUserAddDialog').dialog('close');
					$.messager.alert('信息提示','提交成功！','info');
				}
				else
				{
					$.messager.alert('信息提示','提交失败！','info');
				}
			}
		});
	}

		/**
	* Name 打开修改窗口
	*/
	function spUserOpenEdit(){
		$('#spUserUpdate').form('clear');
		var row = $("#spuserinfo").datagrid('getSelected');
		if (row) {
	
			$('#spUserUpdateDialog').dialog('open').dialog({
				closed: false,
				modal:true,
				closable:false,
	            title: "修改商户用户",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: edit
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#spUserUpdateDialog').dialog('close');
	                }
	            }]
	        });
			$('#spUserUpdate').form('load',row);//加载数据
			
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/*
	*修改
	*/
	function edit(){
		$('#spUserUpdate').form('submit', {
			url:'/spUser/update',
    		type:'POST',
    		data:$('#spUserUpdate').serialize(),
    		success:function(data){
    			if(data > 0){
    				$.messager.alert('信息提示','提交成功！','info');
    				$('#spUserUpdateDialog').dialog('close');
    				$('#spUserPagination').pagination('select');
    			}else{
    				$.messager.alert('信息提示','提交失败！','info');
    			}
    		}
    	});
	}
	
	// 导出
	function exportSpUser(){ 
 		window.location.href='spUser/export?model=jxls/vendorManage.xls';  
	}
	
	// 商户查看
	function showSpUser() {
		var row = $('#spuserinfo').datagrid('getSelected');
		if (row <= 0) {
			$.messager.alert('提示', '请选择查看的条目!');
		} else {
			$('#spuser-show-dialog').dialog('open').dialog('setTitle', '商户详情');
			$('#spuser-show-form').form('load', row);
		}
	}
	
	
	/* 
	*模糊查询
	*/
	function spUserDoSearch(){
		var param = $.param({'pageNumber':1,'pageSize':10}) + '&' + $('#spUserSearchForm').serialize();
		console.info(param)
		$.ajax({ 
	          type: 'POST', 
	          url: '/spUser/list', //用户请求数据的URL
	          data: param, 
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert("没有查询到数据"); 
	          }, 
	          success: function (data) { 
	        	  
	        	  data =eval("("+data+")");
	        	  
	        	  if(data.total == 0){
	        		  $.messager.alert('信息提示','</br>未检索到数据！请检查查询条件','info');
	        	  }
	        	  
	              $('#spuserinfo').datagrid('loadData', data.rows);
	               $('#spUserPagination').pagination({ 
			    	  total:data.total
			    	  });
	          }
	       });
	}
	
	/*
	*清除搜索框内容
	*/
	function spUserDoClear(){
		$("#spUserSearchForm").form("reset");
	} 	
	
	
		