<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


 <div>
     <input type="text" name="queryName" id="queryName" value="${queryName}">
     <button type="button" class="btn btn-primary" onclick="query()">查询</button>
       <button type="button" class="btn btn-primary" onclick="delBatch()">批量删除</button>
     <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">添加</button>

 </div>


<!-- Modal -->
 <div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加品牌</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="addbrand">
        <input type="hidden" name="page">
        		 <div class="form-group">
    				<label for="brandName">品牌名称</label>
    				<input type="text" class="form-control" name="name"  aria-describedby="brandNamelHelp" placeholder="请输入您要添加的品牌名称">
    				<small id="brandNamelHelp" class="form-text text-muted"></small>
  				</div>
  				<div class="form-group">
    				<label for="inputAddress">品牌首字符</label>
    				<input type="text" name="firstChar" class="form-control" id="inputAddress" placeholder="请输入您要添加的品牌首字符">
  				</div>
  				
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="cancle">关闭</button>
        <button type="button" class="btn btn-primary" onclick="commitBrand()">提交</button>
      </div>
    </div>
  </div>
</div>
<!-- 修改Modal -->
 <div class="modal fade" id="staticBackdropUpdate" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">修改品牌</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="updateBrand">
        <input type="hidden" name="page">
        		 <div class="form-group">
    				<label for="brandName">品牌名称</label>
    				<input type="hidden" name="id" id="id">
    				<input type="text" class="form-control" name="name" id="name" aria-describedby="brandNamelHelp" placeholder="请输入您要修改的品牌名称">
    				<small id="brandNamelHelp" class="form-text text-muted"></small>
  				</div>
  				<div class="form-group">
    				<label for="inputAddress">品牌首字符</label>
    				<input type="text" name="firstChar"  id="firstChar" class="form-control" id="inputAddress" placeholder="请输入您要修改的品牌首字符">
  				</div>
  				
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="cancle">关闭</button>
        <button type="button" class="btn btn-primary" onclick="commitUpdateBrand()">提交</button>
      </div>
    </div>
  </div>
</div>
<table class="table">
       <tr>
           <th>id<input type="checkbox" id="allSel" onchange="selectedAll()"> 
        <button type="button" class="btn btn-info btn-sm" onclick="selAll(1)">全选</button>
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(2)">全不选</button>
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(3)">反选</button>
           </th>
           <th>品牌</th>
           <th>首字符</th>
       </tr>
       <c:forEach items="${pageInfo.list }" var="brand">
              <tr>
                  <td><input type="checkbox" name="ids" value="${brand.id}" onchange="selectedOne()"> ${brand.id }</td>
                  <td>${brand.name }</td>
                  <td>${brand.firstChar}
                  </td>
                  <td>
                  <button type="button" class="btn btn-danger" onclick="delBrand(${brand.id})">删除</button>
				  <button type="button" class="btn btn-warning" onclick="openUpdateBrand(${brand.id})">修改</button>
			      </td>
              </tr>
       </c:forEach>
       <tr>
          <td colspan="10">
              <jsp:include page="../common/page.jsp"></jsp:include>
          </td>
       </tr>
</table>
<script type="text/javascript">

//提交修改

function commitUpdateBrand(){
	
	//addspec
/* 	var data = $("form").serialize();
	alert(data);
	$.post("/brand/update",data,function(data){
									 if(data=="success"){
										 alert("数据提交成功")
										 $('#staticBackdropUpdate').modal('hide')
									 }else{
										 alert("数据保存失败");
									 }
								  
								  }) */
								  
		 var formData = new FormData($("#updateBrand")[0]);
	console.log(formData);
	$('#staticBackdropUpdate').modal('hide')
		$.ajax({url:"/brand/update",
			 // dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
				 if(data=="success"){
					 alert("数据提交成功");
					 refresh();
				 }else{
					 alert("数据保存失败")
				 }
				 
			  }
			  })
	
}
// 弹出修改的窗口
function openUpdateBrand(id){
	
	$.post("/brand/getBrand",{id:id},function(data){
		//规格的id
		console.log(data);
		$("#id").val(data.id)
		$("#name").val(data.name)
		$("#firstChar").val(data.firstChar)
	});
	
	$("#staticBackdropUpdate").modal('show')
}


      //提交数据
      function commitBrand(){
    	  //addbrand
    	 // var formData = new FormData($("#addbrand")[0]);
           var formData = $("#addbrand").serialize();
           $('#staticBackdrop').modal('hide')
    	  $.post("/brand/add",formData,function(data){
        	  alert(data);
        	  refresh();
          }
        	      
          )
      }
      //分页方法
      function gotoPage(currentPage){
    	  $("[name=page]").val(currentPage);
    	  var recUrl = "/brand/list";
    	  $("#main").load(recUrl+"?page="+currentPage+"&firstChar="+$("#queryName").val());
  }
      //全选、全不选、反选
      function selAll(flag){
    	  if(flag == 1){
    		  $("[name=ids]").each(function(){
    			  $(this).prop("checked",true);
    		  })
    		  
    	  }
    	  else if(flag ==2){
    		  $("[name=ids]").each(function(){
    			  $(this).prop("checked",false);
    		  })
    	  }
    	  else if(flag == 3){
    		  $("[name=ids]").each(function(){
    			  $(this).prop("checked", !$(this).prop("checked"));
    		  })
    	  }
    	  //判断是否所有的都选中了
    	  var allSelec = $("[name=ids]").length == $("[name=ids]:checked").length;
    		 $("#allSel").prop("checked",allSelec);
    	  }
      //点击id旁边的多选框，全部选中
      function selectedAll(){
		var checked = $("#allSel").prop("checked")
		// 让每个checkbox 都等于 总的checkbox
		$("[name=ids]").each(function(){
				$(this).prop("checked",checked)
			}
		)
	}
       //条件查询
       function query(){
    	  var currentPage = $("[name=page]").val();
     	  var recUrl = "/brand/list";
     	  $("#main").load(recUrl+"?firstChar="+$("#queryName").val());
       }
       
       //批量删除
       function delBatch(){
    	   
    	   if($("[name=ids]:checked").length<=0){
    		    alert("没有选中的数据，无法删除");
    		    return;
    	   }
    		   //选中删除的数据
    		  var delIds = new Array();
    		  $("[name=ids]:checked").each(function(){
    			  delIds.push($(this).val());
    		  })
    		  
    		  if(confirm("您确定要删除id="+delIds+"的数据吗？")){
    			  $.post("/brand/delBrandBatch",{ids:delIds},function(data){
    				  if(data=="success"){
    					  alert("批量删除成功");
    					  refresh();
    				  }
    				  else{
    					  alert("批量删除失败");
    				  }
    			  });
    		  }
    		  else{
    			  return;
    		  }
    	   }
       /**
   	    * 刷新 而且保持查询条件和页码
     	*/
   	function refresh(){
   		
   		var url="/brand/list?firstChar=${queryName}"+'&page=${pageInfo.pageNum}';
   		$("#main").load(url);
   	}
       //单删
       function delBrand(id){
    	   
    	   if(confirm("您确定删除id为"+id+"的数据吗？")){
    		   $.post("/brand/delBrand",{id:id},function(data){
    			   if(data="success"){
   					alert("删除成功")
   					refresh();
   				}else{
   					alert("删除失败")
   				}
    		   })
    	   }
       }
       
       
       
       
       /**
   	* 修改一个checkbox 当每条数据的多选框都被选中时，id旁边的多选框处于选中状态
   	*/
   	function selectedOne(){
   		// 判断是否所有的都被选中了
   		var allSelected = $("[name=ids]").length==$("[name=ids]:checked").length;
   		//设置全选的框
   		$("#allSel").prop("checked",allSelected)
   	}
</script>

