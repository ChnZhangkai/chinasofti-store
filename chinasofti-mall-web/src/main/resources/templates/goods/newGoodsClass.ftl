

<ul id="goodsClassTree"></ul>

<script type="text/javascript">

	$(function() {
		
		loadGoodsClassTree();
		
	});
	
	function loadGoodsClassTree(){
		
		$('#goodsClassTree').tree({
			url:'/goods/findGoodsClass', //加载请求节点数据
			checkbox:true, //复选框
			lines:true, //连接虚线
			animate:true, //展开折叠动画效果
			onClick:function(node){  
                var id = node.id;  
                var text = node.text;  
                alert(id+'ll'+text);  
            }
		});
		
	}
	
	
	
	
	
	
	
	
	
	/*var convertTreeData = function(rows) {  
    var nodes = [];  
    for(var i=0; i<rows.length; i++){  
        var row = rows[i];  
        nodes.push({  
                    id:row.ids,
                    text:row.name,
	         });  
    	}  
    	return nodes;  
	}
	$.fn.tree.defaults.loadFilter = convertTreeData;*/
	
	
</script>