<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript" src="../script/MyComponent/MyTable.js"></script>
<script type="text/javascript" src="../script/MyComponent/MySelect.js"></script>


<div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<span class="panel-title">版本管理</span>
		</div>
		<div class="panel-body body-padding">
			<div class="row table-row">
				<a class="btn-add" onclick="addItem(versionTable)"><span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				</a> <br>
				<br>
				<table id="versionTable" class="table table-striped">
					<thead>
						<tr>
							<th width="60px;">序号</th>
							<th width="200px;">版本名</th>
							<th width="200px;">版本号</th>
							<th width="100px;">状态</th>
							<th width="100px;">操作</th>
						</tr>
						<tr id="selectTemplete" style="display:none">
							<td><span id="index"></span>
							</td>
							<td><span id="name"></span></td>
							<td><span id="code"></span></td>
							<td><myspan id="status" params='{"0":"有效","1":"无效"}'></myspan>
							</td>
							<td><a class="btn-operation" onclick="editItem(this)"><span
									class="glyphicon glyphicon-edit" aria-hidden="true"></span>
							</a> <a class="btn-operation" onclick="deleteItem(this)"><span
									class="glyphicon glyphicon-trash" aria-hidden="true"></span>
							</a></td>
						</tr>
						<tr id="insertTemplete" style="display:none">
							<td><span id="index"></span>
							</td>
							<td><input id="name" type="text" value=""
								class="form-control"></td>
							<td><input id="code" type="text" value=""
								class="form-control"></td>
							<td><select id="status" class="form-control">
									<option value="0">有效</option>
									<option value="1">无效</option>
							</select></td>
							<td><a class="btn-operation" onclick="submitAdd(this)"><span
									class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
							</a> <a class="btn-operation" onclick="cancleAdd(this)"><span
									class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
							</a></td>
						</tr>
						<tr id="editTemplete" style="display:none">
							<td><span id="index"></span>
							</td>
							<td><input id="name" type="text" value=""
								class="form-control"></td>
							<td><input id="code" type="text" value=""
								class="form-control"></td>
							<td><select id="status" class="form-control">
									<option value="0">有效</option>
									<option value="1">无效</option>
							</select></td>
							<td><a class="btn-operation" onclick="submitEdit(this)"><span
									class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
							</a> <a class="btn-operation" onclick="cancelEdit(this)"><span
									class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
							</a></td>
						</tr>
					</thead>
					<tbody id="dataTbody">
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>

<script type="text/javascript">
	var aoColumns =[
	            	{ "mDataProp":"name"}, 							
	            	{ "mDataProp":"code"},			
	            	{ "mDataProp":"status"}	
	    		 ];
	var ajaxSource = {
		"select" : '${pageContext.request.contextPath}/versionAction_getVersions?projectId=<%=request.getParameter("projectId") %>',
		"add" : "${pageContext.request.contextPath}/versionAction_addVersion?projectId=<%=request.getParameter("projectId") %>",
		"get" : "${pageContext.request.contextPath}/versionAction_getVersion",
		"delete" : "${pageContext.request.contextPath}/versionAction_deleteVersion",
		"edit" : "${pageContext.request.contextPath}/versionAction_editVersion"
	};
	$(function() {
		initTable("versionTable", aoColumns, ajaxSource);
	});
</script>