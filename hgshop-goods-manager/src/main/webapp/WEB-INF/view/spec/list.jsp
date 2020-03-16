<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>



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
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
        <button type="button" onclick="addProp()"> 添加属性
         </button>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="addspec">
        <input type="hidden" name="page">
        		 <div class="form-group">
    				<label for="specName">规格名称</label>
    				<input type="text" class="form-control" name="specName" id="specName" aria-describedby="specNamelHelp" placeholder="请输入您要添加的规格">
    				<small id="specNamelHelp" class="form-text text-muted"></small>
  				</div>
  				<div class="form-group">
    				<label for="inputAddress">属性值</label>
    				<input type="text" name="options[0].optionName" class="form-control" id="inputAddress" placeholder="请输入您要添加的值">
    				<button onclick="$(this).parent().remove()">删除</buttonn>
  				</div>
  				
        	</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="cancle">关闭</button>
        <button type="button" class="btn btn-primary" onclick="commitSpec()">提交</button>
      </div>
    </div>
  </div>
</div>


<table class="table">
       <tr>
           <th>id <input type="checkbox" id="allSel" onchange="selectedAll()"> 
        <button type="button" class="btn btn-info btn-sm" onclick="selAll(1)">全选</button>
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(2)">全不选</button>
		<button type="button" class="btn btn-info btn-sm" onclick="selAll(3)">反选</button>
           </th>
           <th>名称</th>
           <th>详情</th>
       </tr>
       <c:forEach items="${pageInfo.list }" var="spec">
              <tr>
                  <td><input type="checkbox" name="ids" value="${spec.id}" onchange="selectedOne()"> ${spec.id }</td>
                  <td>${spec.specName }</td>
                  <td>
                   <c:forEach items="${spec.options }" var="op">
                    &nbsp;&nbsp;${op.optionName}
                   </c:forEach>
                  </td>
                  <td>
                  <button type="button" class="btn btn-danger" onclick="delSec(${spec.id})">删除</button>
				  <button type="button" class="btn btn-warning" onclick="openUpdateSpec(${spec.id})">修改</button>
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
      var addindex = 1;
      //添加规格
      function addProp(){
    	  $("#addspec").append('<div class="form-group">'+
  				'<label for="inputAddress">属性值</label>'+
				'<input type="text" name="options['+addindex+'].optionName" class="form-control" id="inputAddress" placeholder="请输入您要添加的值">'+
				'<button onclick="$(this).parent().remove()">删除</button>'+
				'</div>')
				addindex++;
      }

      //提交数据
      function commitSpec(){
    	  //addspec
    	 // var formData = new FormData($("#addspec")[0]);
           var formData = $("form").serialize();
    	  $.post("/spec/add",formData,function(data){
        	  alert(data);
        	  $("#cancle").click();
          }
        	      
          )
      }
      //分页方法
      function gotoPage(currentPage){
    	  $("[name=page]").val(currentPage);
    	  var recUrl = "/spec/list";
    	  $("#main").load(recUrl+"?page="+currentPage+"&name="+$("#queryName").val());
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
     	  var recUrl = "/spec/list";
     	  $("#main").load(recUrl+"?name="+$("#queryName").val());
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
    			  $.post("/spec/delSpecBatch",{ids:delIds},function(data){
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
   		
   		var url="/spec/list?name=${queryName}"+'&page=${pageInfo.pageNum}';
   		$("#main").load(url);
   	}
       //单删
       function delSec(id){
    	   
    	   if(confirm("您确定删除id为"+id+"的数据吗？")){
    		   $.post("/spec/delSpec",{id:id},function(data){
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
