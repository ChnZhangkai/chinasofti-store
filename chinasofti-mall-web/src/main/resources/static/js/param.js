//初始化页面
$(document).ready(function(){
	
	$('#ParamTable').treegrid({
		url:'/param/list/' + 0,
		idField: 'id',
		method:'POST',
	    treeField: 'text',
		rownumbers: true,
		animate: true,
		columns:[[
			{field:'',width:'5%',checkbox:true}, 
			{field:'text',title:'名称',width:'25%',align:'center'},
			{field: 'description',title:'描述',width:'20%',align: 'center'},
			{field: 'cearttime',title:'创建时间',width:'20%',align: 'center'},
			{field:'status',title:'状态',width:'10%',align:'center',formatter:function(value){
				if(value == "0"){
					return '<span style="color:red">禁用</span>';
				}else{
					return '<span style="color:green">启用</span>';
				}
			}},
			{field:'operator',title:'操作',width:'20%',align:'center',formatter:function(value,row,index){
				if (row.status == 0) {
					return '<button id="allow" style="background-color: #3DADD3" class="easyui-linkbutton" iconCls="icon-tick" onclick="changeStatus(this,'+index+')" plain="true">启用</button>';
				} else {
					return '<button id="forbid" class="easyui-linkbutton" iconCls="icon-stop" onclick="changeStatus(this,'+index+')" plain="true">禁用</button>';
				}
//				if(row.id > 1000000){
//					return '<button id="edit" style="background-color: #3DADD3" class="easyui-linkbutton" iconCls="icon-edit" onclick="changeStatus(this,'+index+')" plain="true">修改</button>'+
//						   '<button id="rm" style="background-color: #3DADD3" class="easyui-linkbutton" iconCls="icon-remove" onclick="changeStatus(this,'+index+')" plain="true">删除</button>';
//				}else{
//					return '<button id="edit" style="background-color: #3DADD3" class="easyui-linkbutton" iconCls="icon-edit" onclick="changeStatus(this,'+index+')" plain="true">修改</button>'
//						   '<button id="add" style="background-color: #3DADD3" class="easyui-linkbutton" iconCls="icon-add" onclick="changeStatus(this,'+index+')" plain="true">添加</button>';
//				}
			}}
		]],
		onBeforeExpand:function(row){
			$(this).treegrid("options").url = '/param/list/' + row.id;
			return true;
		},
		onExpand:function(row){ 
            
         },
		onLoadSuccess:function(){
			 $(this).treegrid("options").url = '/param/list/' + 0;
			 $('#ParamTable').treegrid('expandAll');
        },
	});
});

//树查询
function doParamSearch(){
	var parentNode = $('#ParamTable').treegrid('getRoots');//得到顶级Node
	var paramTextSearch = $('#text').val();
	var childrenNode;
	
	childrenNode = $('#ParamTable').treegrid('getChildren',parentNode[0].target);
	
	for(var i=0;i<childrenNode.length;i++){
		if(childrenNode[i].text.indexOf(paramTextSearch) >= 0){
			$('#ParamTable').treegrid('select',childrenNode[i].id);
		}
	}
	
	//$('#ParamTable').treegrid('expandAll');
}









