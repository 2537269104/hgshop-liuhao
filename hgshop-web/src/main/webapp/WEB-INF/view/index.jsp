<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>豪哥商城系统</title>

    <!-- Bootstrap core CSS -->
    <script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
	<link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >
	<link href="/resource/css/bootstrap.css" rel="stylesheet" >    
	


    <!-- Favicons -->
<link rel="apple-touch-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="https://v4.bootcss.com/docs/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon.ico">
<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap4/js/bootstrap.js"></script>

<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >    
	<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>    
	


<meta name="msapplication-config" content="/docs/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="/resource/css/dashboard.css"  rel="stylesheet">
    
  <style type="text/css">/* Chart.js */
	@-webkit-keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}@keyframes chartjs-render-animation{from{opacity:0.99}to{opacity:1}}.chartjs-render-monitor{-webkit-animation:chartjs-render-animation 0.001s;animation:chartjs-render-animation 0.001s;}</style></head>
  <body>
    <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">请输入商品名称</a>
  	<div>
  		<form action="search">
  			<input class="form-control form-control-dark w-100" name="key" type="text" placeholder="商品关键字" aria-label="Search">
  			<button type="submit" class="btn btn-danger" >搜索</button>
  		</form>
	 </div>
	 
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link" href="#">Sign out</a>
    </li>
  </ul>
</nav>

<div class="container-fluid" style="margin-top:80px">
	<div class=row>
		<div class="col-md-3" id="addCategoryTree">
			
		</div>
		
		<!-- 放商品 -->
		<div class="col-md-9">
			<div class="row">
				<c:forEach items="${pageInfo.list}"  var="spu">
					<div class="col-md-3" style="border:1px ; margin-bottom:18px">
						<div>
							<a href="/detail?spuId=${spu.id}"><img width="200px" height="200px" alt="" src="/pic/${spu.smallPic}"></a>
						</div>
						<div>${spu.goodsName}</div>
						<div>${spu.caption}</div>
					</div>
				</c:forEach>
				
			</div>	
		</div>
	</div>
</div>
<script type="text/javascript">
function initTree() {
	//发送ajax获取树需要的数据
	
	$.post("/treeData", {},
			function(treeData) {
				//初始化添加的时候分类的树
				$("#addCategoryTree").treeview({
					data : treeData,
					levels : 2,
					onNodeSelected : function(event, node) {
						 if (node.nodes.length==0) {
							$("#category").val(node.text);
							$("#categoryId").val(node.id);
							$("#addCategoryTree").hide();
						}
						
					}
				});

			}, "json");
}
initTree();

</script>

</body></html>