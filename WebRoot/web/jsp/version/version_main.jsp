<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="main-left" id="main-left">
    <div class="panel panel-default panel-sub-tabs">
        <div class="panel-heading">
            <span class="panel-title">系统</span>
        </div>
        <div class="panel-body">
            <ul id="projects" class="sub-tabs">
            </ul>
        </div>
    </div>
</div>
        

<div class="main-right" id="main-right">
    
</div>

<script type="text/javascript">
	$(function() {
		$.ajax({
			type: "post",
			dataType:"json", //收受数据格式
			url:"${pageContext.request.contextPath}/projectAction_getProjects",
			cache:false,
			success: function(data){
				if(data.retcode=="0000"){
					var addHtml="";
					$.each(data.obj, function(index, item) {
						addHtml+="<li><a onclick='commonLoadPage(\"${pageContext.request.contextPath}/web/jsp/version/versionSet.jsp?projectId="+item.id+"\",\"main-right\")'>"+item.name+"</a></li>";
					});
					$("#projects").html(addHtml);
				}else{
					alert(data.errorMsg);
				}
			}
		});
		//commonLoadPage("${pageContext.request.contextPath}/web/jsp/interface/interfaceSet.jsp","main-right");
	});
</script>