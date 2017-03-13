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
<script type="text/javascript" src="../script/bootstrap.min.js"></script>
<link href="../css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="../css/site.css" rel="stylesheet" type="text/css">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/color.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="../css/BootSideMenu.css">
<script type="text/javascript" src="../script/BootSideMenu.js"></script>

<title>编码设置</title>
<script type="text/javascript" src="../script/jquery.js"></script>
		<script type="text/javascript" src="../script/MyComponent/MyTable.js"></script>
</head>

<body>
	<div class="main">
		<div class="main-right">
			<div class="code-set">
				<div class="panel panel-default">
					<div class="panel-heading">
						<span class="panel-title">用户管理</span>
					</div>
					<div class="panel-body body-padding">
						<div class="row table-row">
							<a class="btn-add" onclick="addItem(userTable)"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
							<br><br>
							<table id="userTable" class="table table-striped">
								<thead>
									<tr>
										<th width="60px;">序号</th>
										<th width="100px;">用户名</th>
										<th width="100px;">密码</th>
										<th width="100px;">姓名</th>
										<th width="100px;">角色</th>
                                    	<th width="100px;">操作</th>
									</tr>
									<tr id="selectTemplete" style="display:none">
										<td><span id="index"></span></td>
										<td>
											<span id="username"></span>
										</td>
										<td>
											<span>******</span>
										</td>
										<td>
											<span id="name"></span>
										</td>
										<td>
											<span id="roleId"></span>
										</td>
										<td>
	                                        <a class="btn-operation" onclick="editItem(this)"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
	                                        <a class="btn-operation" onclick="deleteItem(this)"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
	                                    </td>
									</tr>
									<tr id="insertTemplete" style="display:none">
										<td><span id="index"></span></td>
										<td>
											<input id="username" type="text" value="" class="form-control">
										</td>
										<td>
											<input id="password" type="text" value="" class="form-control">
										</td>
										<td>
											<input id="name" type="text" value="" class="form-control">
										</td>
										<td>
											<select id="roleId" class="form-control">
											</select>
											<script type="text/javascript">
												$(function() {
													initRoleSelect("#insertTemplete #roleId");
												});
											</script>
										</td>
										<td>
	                                        <a class="btn-operation" onclick="submitAdd(this)"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span></a>
											<a class="btn-operation" onclick="cancleAdd(this)"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true" ></span></a>
										</td>
                                   	</tr>
									<tr id="editTemplete" style="display:none">
										<td><span id="index"></span></td>
										<td>
											<input id="username" type="text" value="" class="form-control">
										</td>
										<td>
											<input id="password" type="text" value="" class="form-control">
										</td>
										<td>
											<input id="name" type="text" value="" class="form-control">
										</td>
										<td>
											<select id="roleId" class="form-control">
											</select>
											<script type="text/javascript">
												$(function() {
													initRoleSelect("#editTemplete #roleId");
												});
											</script>
										</td>
										<td>
	                                        <a class="btn-operation" onclick="submitEdit(this)"><span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span></a>
											<a class="btn-operation" onclick="cancelEdit(this)"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true" ></span></a>
										</td>
									</tr>	
								</thead>
								<tbody id="dataTbody">
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	var aoColumns =[
	            	{ "mDataProp":"username","bSortable":false,"type":"input"},	
	            	{ "mDataProp":"password","bSortable":false,"type":"input"},	
	            	{ "mDataProp":"name","bSortable":false,"type":"input"},		
	            	{ "mDataProp":"roleId","bSortable":false,"sClass":"center","type":"select"}			
	    		 ];
	var ajaxSource = {
		"select" : "${pageContext.request.contextPath}/userAction_getUsers",
		"get" : "${pageContext.request.contextPath}/userAction_getUser",
		"add" : "${pageContext.request.contextPath}/userAction_addUser",
		"delete" : "${pageContext.request.contextPath}/userAction_deleteUser",
		"edit" : "${pageContext.request.contextPath}/userAction_editUser"
	};
	
	function initRoleSelect(id){
		$.ajax({
			type: "post",
			dataType:"json", //收受数据格式
			url:"${pageContext.request.contextPath}/roleAction_getRoles",
			cache:false,
			success: function(data){
				if(data.retcode=="0000"){
					var addHtml = "";
					//显示层绑定控件
					$.each(data.obj, function(index, item) {
						addHtml+="<option value='"+item.id+"'>"+item.name+"</option>";
					});
					$(id).html(addHtml);
				}
			}
		});
	}
		
	$(function() {
		initTable("userTable",aoColumns,ajaxSource);
	});
</script>