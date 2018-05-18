<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>聊天室</title>

<script src="${pageContext.request.contextPath}/Js/jquery-1.8.2.min.js"></script>
<%--     <script src="${pageContext.request.contextPath}/Js/chat.js"></script>    
 --%>
<script type="text/javascript">
		 //获取当前用户
	$(document).ready(function(){
	    $("#clickMe").on("click",function(){
	    	alert(111);
	    	 $.ajax({  
                 type:"GET",  //提交方式  
                 url:"http://localhost:9090/intermediary/api/rtuWater/getRtuWaterData?startTime=2017-07-30%2008:08:00&endTime=2017-07-30%2008:08:00",//路径  
                 success:function(result) {//返回数据根据结果进行相应的处理  
                     if ( result.success ) {  
                         $("#tipMsg").text("删除数据成功");  
                         tree.deleteItem("${org.id}", true);  
                     } else {  
                         $("#tipMsg").text("删除数据失败");  
                     }  
                 }  
             });  
  });
	});
	</script>
</head>
<body>
	<button id="clickMe" type="button">Click Me!</button>

</body>
</html>
