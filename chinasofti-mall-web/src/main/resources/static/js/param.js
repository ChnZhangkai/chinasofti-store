//初始化页面
$(document).ready(function(){
	
	var firstID = "1";
	
	$('#ParamTable').treegrid({
		url:'/param/list/1',
		idField: 'id',
	    treeField: 'text',
//	    queryParams:{firstId:"1"},
		rownumbers: true,
		pagination:true,
		pageSize:10,
		pageList: [10, 20, 50, 100],
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
			$('#ParamTable').treegrid('options').url = "/param/list/" + row.id;
			alert(row.id);
		},
		onLoadSuccess:function(){
            //每次数据加载完成以后，还原查询URL
            $("#ParamTable").treegrid('options').url = "/param/list/1";
        },
	})
});