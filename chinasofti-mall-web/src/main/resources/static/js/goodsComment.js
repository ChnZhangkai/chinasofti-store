
	$(function() {
		var nodes = $('#spEvaluateinfo').tree('getChecked');
		console.info(nodes);
	});

/*
	 * 读取路径显示图片
	 */
	function imgFormatter(value, row) {
		var ids = row.ids;
		var str = "";
		images = $.ajax({url:'/comments/reqCommentsImgPath/' + ids,type:'POST',async:false});
		str = "<img style=\"height: 75px;width: 110px;\" src=\""+ images.responseText +"\"/>";
		return str;
		
	}

	/*
	 * 删除
	 */
	/*function removeComment(){
		
		var items = $('#spEvaluateinfo').datagrid('getSelections');
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
					url:'/comments/delete/' + ids,
					type:'POST',
					success:function(data){
						if(data){
							successShow();
							$('#spEvaluateinfo').datagrid('reload');
						}
						else
						{
							errorShow();		
						}
					}	
				});
			}	
		});
	}*/
	

	/*
	 * 批量删除
	 */
	function removeComment(){
		//返回选中多行  
        var selRow = $('#spEvaluateinfo').datagrid('getSelections');
        //判断是否选中行  
        if (selRow.length==0) {  
            $.messager.alert("提示", "请选择要删除的行！", "info");  
            return;  
        }else{      
            var temID="";  
            //批量获取选中行的评估模板ID  
            for (i = 0; i < selRow.length;i++) {  
                if (temID =="") {  
                    temID = selRow[i].ids;  
                  console.info("true"+temID);
                } else {  
                    temID = selRow[i].ids + "," + temID; 
                    console.info("false"+temID);
                }                 
            }  
                        
            $.messager.confirm('提示', '是否删除选中数据?', function (r) {  
  
                if (!r) {  
                    return;  
                }   //提交  
                $.ajax({  
                    type: "POST",  
                    async: false,  
                    url:'/comments/batchDeletes/' + temID,
                    success: function (result) {  
                        if (result) {  
                            $('#spEvaluateinfo').datagrid('clearSelections');  
                            $.messager.alert("提示", "恭喜您，信息删除成功！", "info");  
                            $('#spEvaluateinfo').datagrid('reload');  
                        } else {  
                            $.messager.alert("提示", "删除失败，请重新操作！", "info");  
                            return;  
                        }  
                    }  
                });  
            });  
  
        }  
	}
		

	//条件查询
	function spEvaluateDoSearch(){
		$("#spEvaluateinfo").datagrid("load", {
			'title' : $('#commente-title').val(),
			'nickname' : $('#comment-nickname').val()		
		});
	}
	
	/*
	 *清除查询条件
	 */
	 function spEvaluateDoClear(){
		$('#searchOnlineForm').form('reset');
	}
	
	// 商品评论详情
	function showComments() {
		var row = $('#spEvaluateinfo').datagrid('getSelected');
		var ids = row.ids;
		$(document).ready(function(){  
			var ue = UE.getEditor('containeComments',{
				initialFrameWidth:1000,  //初始化编辑器宽度,默认1000  
		        initialFrameHeight:140  //初始化编辑器高度,默认320
			});
        
        ue.ready(function() {//编辑器初始化完成再赋值  
        ue.setContent(row.content);  //赋值给UEditor 
        ue.setDisabled('fullscreen');
        
        images = $.ajax({url:'/comments/reqCommentsImgPath/' + ids,type:'POST',async:false});
        var tp=$("#imgUrl").attr("src",images.responseText); 
        });  
    });
	
	if (row <= 0) {
		$.messager.alert('提示', '请选择查看的条目!');
	} else {
		$('#comments-show-dialog').dialog('open').dialog('setTitle', '商品在线详情');
		$('#comments-show-form').form('load', row);
	}
}

	

	