<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="../script/jquery.min.js"></script>
        <script type="text/javascript" src="../script/bootstrap.min.js"></script>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="../css/site.css" rel="stylesheet" type="text/css">
        <link href="../css/style.css" rel="stylesheet" type="text/css">
        <link href="../css/color.css" rel="stylesheet" type="text/css">
    	<script type="text/javascript" src="../script/common.js"></script>
        <title>接口管理系统</title>
    </head>
    <body>

        <div class="header" id="header">
            <div class="header-info text-right">
                <a href=""><span class="glyphicon glyphicon-user" aria-hidden="true"></span>管理员</a>
                <a href=""><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>信息</a>
                <a href=""><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>帮助</a>
                <a href=""><span class="glyphicon glyphicon-off" aria-hidden="true"></span>退出</a>
            </div>
            <div class="header-title">
                <h2 style="margin-left: 44px;">接口开发管理系统</h2>
            </div>
            <div class="header-nav">
                <ul class="nav nav-tabs">
                    <li><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/project/projectSet.jsp","main")'>项目管理</a></li>
                    <li><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/version/version_main.jsp","main")'>版本管理</a></li>
                    <li><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/module/moduleSet.jsp","main")'>模块管理</a></li>
                    <li><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/role/roleSet.jsp","main")'>角色管理</a></li>
                    <li><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/user/userSet.jsp","main")'>用户管理</a></li>
                    <li><a onclick='commonLoadPage("${pageContext.request.contextPath}/web/jsp/interface/interface_main.jsp","main")'>接口管理</a></li>
                </ul>
            </div>
        </div>

        <div class="main" id="main" style="width: 100%;">
        </div>
        <!-- 页面切换浮层 -->
		<div class="layer" id="systemLoadingDialog" style="display:none">
	  		<img src="../image/load.gif" class="layer-img">
	  	</div>	
    </body>
</html>