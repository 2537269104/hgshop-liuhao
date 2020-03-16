<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
  <script src="/resource/js/jquery-3.2.1.js"></script>    

<!-- <script type="text/javascript" src="/resource/bootstrap4/js/bootstrap.js"></script> -->

<link href="/resource/css/bootstrap.css" rel="stylesheet" > 
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.min.js"></script>

  
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >    
<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script> 


<button class="btn btn-primary btn-lg" onclick="toadd()">添加/button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
            </div>
            <div class="modal-body">点击关闭按钮检查事件功能。</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

 <!-- Modal -->
<!-- 
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        	
      </div>
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
			      <input type="text" class="form-control" placeholder="商品分类">
			    </div>
			  </div>
          	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="commitSpec()">提交</button>
      </div>
    </div>
  </div>
</div> -->

<script>
	function toadd(){
		$('#main').load("/goods/add")
	}
</script>


<table class="table">
	<tr><td>1</td></tr>
	<tr><td>2</td></tr>
	<tr><td>3</td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
</table>