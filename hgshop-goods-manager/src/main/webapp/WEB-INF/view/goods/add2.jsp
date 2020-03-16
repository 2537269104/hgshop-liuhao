<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link href="/resource/css/bootstrap.css" rel="stylesheet" > 
 
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js"></script>

  
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >    
<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script> 
 
    
<div class="modal-body">
        	<form id="addspec">
			  <div class="form-row">
			    <div class="col">
			      <label >商品名称</label>
			      <input type="text" class="form-control" placeholder="商品名称">
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="col">
			      <label >分类</label>
			      <input type="text" class="form-control" placeholder="商品分类" onclick="$('#addCategoryTree').show()" />
			      <div id="addCategoryTree"
					style="display: none; position: absolute; z-index: 1010; background-color: white; width: 96%"></div>
									
			    </div>
			  </div>
          	</form>
      </div>    
      
      
<script>
      function initTree() {
			//发送ajax获取树需要的数据
			$.post("/cat/treeData", {},
					function(tree) {

						//初始化添加的时候分类的树
						$("#addCategoryTree").treeview({
							data : tree,
							levels : 2,
							onNodeSelected : function(event, node) {
								if (node.nodes.length==0) {
									$("#add_spu_category").val(node.text);
									$("#add_spu_category_id").val(node.id);
									$("#addCategoryTree").hide();
								}
							}
						});

					}, "json");
		}
      
      initTree();
      </script>      
		