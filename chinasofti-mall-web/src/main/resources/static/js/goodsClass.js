/* 初始化加载 */
	$(function() {
		loadGoodsClassTree();
	});
	
	/* 分类树 */
	function loadGoodsClassTree(){
		//debugger;
		var isChange ;
		$('#goodsClassTree').tree({
			url:'/goods/findGoodsClass', //加载请求节点数据
			//checkbox:true, //复选框
			lines:true, //连接虚线
			animate:true, //展开折叠动画效果
			formatter:function(node){//渲染节点文本
				console.info(node.text+"|"+node.states);
				if(node.states == "0"){
					return '<font color="gray" >'+node.text+'</font>';
				}
				return '<font style="font-weight:bold">'+node.text+'</font>';;
			},
			onDblClick:function(node){  //双击事件
               	var id = node.id;  
                var text = node.text;  
                isChange = node.text;
                $('#goodsClassTree').tree('beginEdit', node.target);//开启编辑
			},
            //右键点击打开菜单
			onContextMenu:function(e,node){
				e.preventDefault();
				// 查找节点
				$('#goodsClassTree').tree('select', node.target);
				if(($(this).tree('getChildren',node.target)).length>0){
					// 若为父节点，则可删除
					$('#goodsClassParentMenu').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				}else{
					// 若为子节点，则可删除
					$('#goodsClassMenu').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				}
			},
			
			//编辑之后
			onAfterEdit : function(node) { 
				if((node.text).length > 30){
					$.messager.alert('温馨提醒','分类名称长度请保持在0-30内','warning');
					$('#goodsClassTree').tree('reload');
					return ;
				}
				if(node.text != isChange){
					$.ajax({
						url:'/goods/updateGoodsClassName',
						type:'POST',
						data:{'ids':node.id,'name':node.text},
						success:function(data){
							//$('#goodsClassTree').tree('reload')
						}
					});
				}
			}
		});
	}
		
		//打开新增窗口
		function openGsAdd(){
			$('#goodsClassAddForm').form('clear');
			var node = $('#goodsClassTree').tree('getSelected');
			$('#node').textbox('setValue',node.text)
			$('#pid').val(node.id)
			$('#goodsClassAddDialog').dialog({
				closed: false,
				closable:false,
				modal:true,
	            title: "添加分类",
	            buttons: [{
	                text: '确定',
	                iconCls: 'icon-ok',
	                handler: addGoodsClass
	            }, {
	                text: '取消',
	                iconCls: 'icon-cancel',
	                handler: function () {
	                    $('#goodsClassAddDialog').dialog('close');
	                    //$('#addForm').form('clear');
	                    //document.getElementById("showpic").style.display="none";
	                    document.getElementById("showpic").innerHTML = "";
	                }
	            }]
	        });
		}
		
		//执行新增方法
		function addGoodsClass(){
			$('#goodsClassAddForm').form('submit', {
				url:'/goods/save',
				type:'POST',
				success:function(data){
					if(data > 0){
						$('#goodsClassTree').tree('reload');
						$('#goodsClassAddDialog').dialog('close');
						document.getElementById("showpic").innerHTML = "";
						successShow();
					}
					else
					{
						errorShow();
					}
				}
			});
		}
		
		//打开修改窗口
		function openGsEdit(){
			$('#goodsClassForm').form('clear');
			var node = $('#goodsClassTree').tree('getSelected');
			var ids = node.id;
			$.ajax({
				url:'/goods/select/' + ids,
				type:'POST',
				success:function(data){
					$('#goodsClassDialog').dialog('open').dialog({
						closed: false,
						modal:true,
						closable:false,
			            title: "分类详情",
						buttons : [{
							text : '确认',
							iconCls : 'icon-ok',
							handler : function() {
								$('#goodsClassForm').form('submit', {
									url:'/goods/update',
						    		type:'POST',
						    		data:$('#goodsClassForm').serialize(),
						    		success:function(data){
						    			if(data > 0){
						    				$('#goodsClassTree').tree('reload');
						    				$('#goodsClassDialog').dialog('close');
						    				successShow();
						    			}else{
						    				errorShow();
						    			}
						    		}
						    	});
								//$('#goodsClassDialog').dialog('close');
							}
						},{
							text : '关闭',
							iconCls : 'icon-cancel',
							handler : function() {
								$('#goodsClassDialog').dialog('close');
								document.getElementById("showupic").innerHTML = "";
							}
						}]
					});
					$('#goodsClassForm').form('load',data);
				}
			})
			

		}
		
		//移除节点
		function removeGs(){
			var node = $('#goodsClassTree').tree('getSelected');
			var ids = node.id;
			
			$.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){
				if(r){
					$.ajax({
	     			   type: "POST",
	     			   url: "/goods/delete/" + ids,
	     			   //向后台传输的数据，
	     			   success: function(msg){
	     				  successShow();
	     				 $('#goodsClassTree').tree("remove",node.target);
	     			   },
	     			   error: function(){
	     				  errorShow();
	     			   }
	     			});
				}
			});
		}
		
		/*
		 * 新增分类上传图片回显
		 */
	 	function readPicture() {
			
	 		//var a = document.getElementsByClassName("img");
	 		//console.info(a);
			
			// 检查是否为图像类型
			var simpleFile = document.getElementById("classimg").files[0];
			console.info(simpleFile)
			if (!/image\/\w+/.test(simpleFile.type)) {
				$.messager.alert('信息提示','请确保文件类型为图像类型','info')
				return false;
			}
			var reader = new FileReader();
			// 将文件以二进制文件读入页面中
			reader.readAsBinaryString(simpleFile);
			reader.onload = function(f) {
				var result = document.getElementById("showpic");
				var src = "data:" + simpleFile.type + ";base64," + window.btoa(this.result);
				result.innerHTML = '<img id="readPic" style="height: 80px;width: 117px;" src ="' + src + '"/>';
			}
			//document.getElementById("showpic").style.display="";
		}
		
		//修改图片时回显
		function updatePicture() {
			// 检查是否为图像类型
			var simpleFile = document.getElementById("uimg").files[0];
			//console.info(simpleFile)
			if (!/image\/\w+/.test(simpleFile.type)) {
				$.messager.alert('信息提示','请确保文件类型为图像类型','info')
				return false;
			}
			var reader = new FileReader();
			// 将文件以二进制文件读入页面中
			reader.readAsBinaryString(simpleFile);
			reader.onload = function(f) {
				var result = document.getElementById("showupic");
				var src = "data:" + simpleFile.type + ";base64," + window.btoa(this.result);
				result.innerHTML = '<img id="readPic" style="height: 80px;width: 117px;" src ="' + src + '"/>';
			}
			//document.getElementById("showpic").style.display="";
		}