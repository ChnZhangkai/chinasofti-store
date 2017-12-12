	$(function(){
		//文档对象加载完毕之后，找到id=menuOperator的标签，然后在它上面创建树
		$("#menuOperator").tree({
			//树节点内容远程调用地址
			url : '/menu/tree',
			animate: true,
			//提交方式为get
			method : "GET",
			//鼠标右击事件,e为当前事件对象，node为当前点击事件所在的tree节点
			onContextMenu: function(e,node){
					//屏蔽系统默认的菜单右键事件
		            e.preventDefault();
					//让当前点击的树节点选中---select选中方法
		            $(this).tree('select',node.target);
					
				if($(this).tree('getParent',node.target)!=null && $(this).tree('getChildren',node.target).length>0){
				
					//让id=menuOperatorMenu的标签显示对应的EasyUI菜单界面,固定当前弹出的菜单坐标
		            $('#menuOperatorMenu').menu('show',{
		                left: e.pageX,
		                top: e.pageY
		            });
				}else{
					$('#menuOperatorMenu2').menu('show',{
		                left: e.pageX,
		                top: e.pageY
		            });
				}
	        },
	        //编辑完成之后执行如下操作
	        onAfterEdit : function(node){
		        	//当前节点对象
		        	var _tree = $(this);
		        	var nodeTextLength = (node.text).length;
		        	if(nodeTextLength<2 || nodeTextLength>10){
		        		$.messager.alert('提示','操作失败!名称长度必须在2-10之间!');
		        		$('#menuOperator').tree('reload');
		        		return ;
		        	}
		        	//如果说当前节点的id=0，执行如下代码
		        	if(node.id == 0){
		        		// 新增节点
		        		$.ajax({
			        		type: "POST",
			        		url: "/operator/add",
			        		//传到后台的参数，父节点：可以修改父节点状态，如是否是叶子节点,父节点还要为当前新增的节点填充父id
			        		data: {menuids:node.parentId,names:node.text},
			        		success: function(msg){
					     	//刷新_tree(当前节点)节点
					     	//alert(msg);
					        	_tree.tree("update",{
							    //新增节点说明需要返回当前节点存储到数据库的id
							    target : node.target,
							    //将返回的节点id更新到当前节点
							    id : msg
					        	})
						},
						error: function(){
			        			$.messager.alert('提示','新增失败!');
			        			$('#menuOperator').tree('reload');
						}
					});
		        	}else{
		        		//如果node.id != 0则执行如下更新代码
		        		$.ajax({
		        			type: "POST",
		        			url: "/operator/update",
		        			//这儿只更新自己数据，不需要更新父类信息
		        			data: {ids:node.id,names:node.text},
		        			error: function(){
		        				  $.messager.alert('提示','重命名失败!');
		        				  $('#menuOperator').tree('reload');
		        			}
		        		});
		        	}
			}
		});
	});

	//菜单点击事件，item是当前点击的菜单对象
	function menuHandler(item){
		//获得树节点对象
		var tree = $("#menuOperator");
		//获取树节点被选中的对象
		var node = tree.tree("getSelected");
		//当前点击的获取菜单的name属性，如果属性值=add，则执行如下代码
		if(item.name === "add"){
			//在树节点下增加一个树节点
			tree.tree('append', {
				//指定父类为当前选中对象
	            parent: (node?node.target:null),
	            data: [{
	                text: '新建操作',
	                id : 0,
	                parentId : node.id
	            }]
	        }); 
			//找到树节点的id=0的节点，即刚才新增的树节点
			var _node = tree.tree('find',0);
			//首先让上面新增的树节点选中,beginEdit:即开启它的编辑状态
			tree.tree("select",_node.target).tree('beginEdit',_node.target);
		}else if(item.name === "rename"){
			//如果当前菜单的name属性=rename，则开启当前树节点的编辑状态
			tree.tree('beginEdit',node.target);
			//如果当前菜单的name属性=delete，则执行如下删除流程操作
		}else if(item.name === "delete"){
			$.messager.confirm('确认','确定删除名为 '+node.text+' 的操作吗？',function(r){
				if(r){
					$.ajax({
	     			   type: "POST",
	     			   url: "/operator/delete",
	     			   //向后台传输的数据，
	     			   data : {ids:node.id},
	     			   success: function(msg){
	     				  tree.tree("remove",node.target);
	     			   },
	     			   error: function(){
	     				   $.messager.alert('提示','删除失败!');
	     			   }
	     			});
				}
			});
		}
	}