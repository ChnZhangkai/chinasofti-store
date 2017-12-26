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
			{field:'operator',title:'操作',width:'20%',align:'center',formatter:function(value){
				
			}}
		]],
		onBeforeExpand:function(row){
			$(this).treegrid("options").url = '/param/list/' + row.id;
			return true;
		},
		onExpand:function(row){ 
            console.info(row.id);
         },
		onLoadSuccess:function(){
			 $(this).treegrid("options").url = '/param/list/' + 0;
        },
	})
});