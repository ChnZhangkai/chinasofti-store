	
	//全局初始化
	$(function(){
		//获取表格datagrid的ID属性,
		var tableID = "ptUser";
		//获取分页工具条元素
		var pageId = $('#pagination');
		//此处设置自己的url地址
		var url = '/user/list';
		//分页查询时传递查询条件
		seachId = '#searchPtUserForm';
		//调用初始化方法	
		tdload(tableID, pageId, url);
		
		$.messager.progress({
			text:'数据正在加载中'
		});
		
	});
	
	/*
	 * 单独查询角色名称
	 */
	function queryRole(){
		var row = $("#ptUser").datagrid('getSelected');
		if (row) {
			
			$.ajax({
				url:'/user/findRoleName/' + row.ids,
				type:'POST',
				success:function(data){
					$('#roleName').textbox('setValue',data)
				}
			})
			$('#queryRoleDialog').dialog('open');
		} else {
			$.messager.alert('信息提示','请选中要修改的用户');
			}
		}
	
	/*
	 * 分类状态
	 */
	function statesFormatter(value){
		if(value == "0"){
			return '<span style="color:red">禁用</span>';
		}else{
			return '<span style="color:green">启用</span>';
		}
	}
	
	/**
	* Name 打开添加窗口
	*/
	function openUserAdd(){
		//动态加载角色
		$.ajax({
			url:'/user/find/role',
			type:"GET",
			success: function(data){
				data = eval("("+data+")");
				$('#roleids').combobox({
					valueField:'ids',
					textField:'names',
					data:data.rows,
				})	
			}
		});
		
		$('#ptUserAddForm').form('clear');
		$('#ptUserAdd').dialog({
			closed: false,
			modal:true,
	        title: "新增用户",
	        buttons: [{
	            text: '确定',
	            iconCls: 'icon-ok',
	            handler: add
	        }, {
	            text: '取消',
	            iconCls: 'icon-cancel',
	            handler: function () {
	                $('#ptUserAdd').dialog('close');                    
	            }
	        }]
	    });
	}

	/**
	* Name 添加记录
	*/
	function add(){
		
		$('#ptUserAddForm').form('submit', {
			url:'/user/add',
			type:'POST',
			success:function(data){
				if(data > 0){
					$('#pagination').pagination('select');
					$('#ptUserAdd').dialog('close');
					successShow();
				}
				else
				{
					errorShow();
				}
			}
		});
	}
	
	
	/**
	* Name 删除记录
	*/
	function remove(){
	
		var items = $('#ptUser').datagrid('getSelections');
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
				/*alert(ids);*/
				$.ajax({
					url:'/user/delete/' + ids,
					type:'POST',
					success:function(data){
						if(data){
							$('#pagination').pagination('select');
							successShow();
						}
						else
						{
							errorShow()		
						}
					}	
				});
			}	
		});
	}
	
	/**
	* Name 打开修改窗口
	*/
	function openEdit(){
		var row = $("#ptUser").datagrid('getSelected');
		if (row) {
			//alert(JSON.stringify(row));
			$('#ptUserUpdate').dialog('open').dialog({
				closed: false,
				modal:true,
	            title: "修改用户信息",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: edit
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#ptUserUpdate').dialog('close');                    
	                }
	            }]
	        });
			$('#ptUserUpdateForm').form('load',row);
		} else {
			$.messager.alert('信息提示','请选中要修改的数据');
		}
	}
	
	/*
	*修改
	*/
	function edit(){
		$('#ptUserUpdateForm').form('submit', {
			url:'/user/update',
    		type:'POST',
    		data:$('#ptUserUpdateForm').serialize(),
    		success:function(data){
    			if(data > 0){
    				$('#ptUserUpdate').dialog('close');
    				$('#pagination').pagination('select');
    				successShow();
    			}else{
    				errorShow();
    			}
    		}
    	});
	}
	
	/**
	* 修改用户所属角色
	*/
	function openRole(){
		var row = $("#ptUser").datagrid('getSelected');
		if (row) {
			
			$.ajax({
				url:'/user/findRoleName/' + row.ids,
				type:'POST',
				success:function(data){
					$('#nowName').textbox('setValue',data)
				}
			})
			
			$('#userRoleDialog').dialog('open').dialog({
				closable:false,				
				closed: false,
				modal:true,
	            title: "修改用户角色",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: function(){
	                	var param = $("#userRoleDg").datagrid('getSelected');
	                	$.ajax({
	                		url:'user/updateRoleUser',
	                		data:{'moduleIds':row.ids,'roleIds':param.ids},
	                		type:'POST',
	                		success:function(data){
	                			if(data > 0){
	                				successShow();
	                				$('#userRoleDialog').dialog('close');
	                			}else{
	                				errorShow();
	                			}
	                		}
	                	});
	                	$('#userRoleDg').datagrid('clearSelections');
	                }
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#userRoleDialog').dialog('close');
	                    $('#userRoleDg').datagrid('clearSelections');
	                }
	            }]
	        });
		} else {
			$.messager.alert('信息提示','请选中要修改的用户');
		}
	}
	
	/**
	* 重置密码确认
	*/
	function resetPw(){
		var items = $('#ptUser').datagrid('getSelections');
		if(items.length < 1){
			$.messager.alert('温馨提醒','请选中要重置的用户');
			return ;
		}
		$.messager.confirm('信息提示','确定要将密码重置为000000吗？',function(data){
			if(data){
				$.ajax({ 
			          type: 'POST', 
			          url: '/user/update', //用户请求数据的URL
			          data: {'pageNumber':1,'pageSize':10,'ids':items[0].ids,'password':'000000'},
			          success: function (success) { 
			        	if(success){
			        		successShow();
			        	}
			          }
			       });
			}
		})
		
	}
	
	/* 
	*查询
	*/
	function doSearch(){
		var param = $.param({'pageNumber':1,'pageSize':10}) + '&' + $('#searchPtUserForm').serialize();
		$.ajax({ 
	          type: 'POST', 
	          url: '/user/list', //用户请求数据的URL
	          data: param,
	          error: function (XMLHttpRequest, textStatus, errorThrown) { 
	              alert(textStatus); 
	          }, 
	          success: function (data) { 
				data =eval("("+data+")");
	        	if(data.total == 0){
	        		$.messager.alert('信息提示','</br>未检索到数据！请检查查询条件','info');
	        	}
	              $('#ptUser').datagrid('loadData', data.rows);
	               $('#pagination').pagination({ 
			    	  total:data.total
			    	  });
	          }
	       });
	}
	
	/*
	*清除搜索框内容
	*/
	function doClear(){
		$('#searchPtUserForm').form('reset');
	}
	
	$('#ids,#updateUsername').tooltip({    
		position: 'right',    
		content: '<span style="color:#fff">不可修改</span>',    
		onShow: function(){        
			$(this).tooltip('tip').css({            
				backgroundColor: '#666',            
				borderColor: '#666'        
				});    
			}
		});

	function successShow(){
		$.messager.show({
			title:'提示',
			msg:'<font style="color:green">操作成功</font>',
			showType:'slide',
			timeout:3000,
		});
	}
	
	function errorShow(){
		$.messager.show({
			title:'提示',
			msg:'<font style="color:red">操作失败</font>',
			showType:'slide',
			timeout:3000,
		});
	}
	
	//异步查询添加用户时输入的用户名
	function checkUserName_Exist(valueName){
		var status = "0";
		$.ajax({
			url:'/user/findByUserName',
			type:'POST',
			data:{'username':valueName},
			dataType:'text',
			async:false,
			success:function(msg){
				b = msg;
			},
			error:function(errorMsg){
				b = false;
			}
		});
		return b;
	}
	
	//输入框长度验证
	$.extend($.fn.validatebox.defaults.rules, {    
	    maxLength: {    
	        validator: function(value, param){    
	            return value.length <= param[0];    
	        },    
	        message: '最大只能输入30位！'   
	    },
	    checkPwd: {    
	        validator: function(value,param){    
	            return value == $(param[0]).val();    
	        },    
	        message: '两次输入密码不一致！'   
	    },
	    pwdLength: {    
	        validator: function(value){
	        	var len = $.trim(value).length;
	            return len >= 6 && len <= 12;    
	        },    
	        message: '输入长度必须为6-12之间！'   
	    },
	    account: {//param的值为[]中值  
	        validator: function (value,param) {  
	            if (value.length < param[0] || value.length > param[1]) {  
	                $.fn.validatebox.defaults.rules.account.message = "用户名长度必须在" + param[0] + "至" + param[1] + "之间!";  
	                return false;  
	            } else {  
	                if (!/^[\w]+$/.test(value)) {  
	                    $.fn.validatebox.defaults.rules.account.message = "用户名只能数字、字母、下划线构成!";  
	                    return false;  
	                } else {  
	                	var v = checkUserName_Exist(value);
	                    if (v=="1") {                    
	                    	$.fn.validatebox.defaults.rules.account.message = '用户名已存在!';                        
	                        return false;
	                    }
	                    else {
	                    	return true;
	                    }  
	                }  
	            }  
	        },
	        message: ""  
	    },
	    checkUserNames: {    
	        validator: function(value,param){    
	            return value == $(param[0]).val();    
	        },    
	        message: '两次输入密码不一致！';   
	    }
	});