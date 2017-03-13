<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

	<script type="text/javascript" src="../script/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-v1.4.4/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-v1.4.4/themes/icon.css">
	<script type="text/javascript" src="../jquery-easyui-v1.4.4/jquery.easyui.min.js"></script>
	
	<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="../css/site.css" rel="stylesheet" type="text/css">
	<link href="../css/style.css" rel="stylesheet" type="text/css">
	<link href="../css/color.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="../script/MyComponent/MySelect.js"></script>
<div class="main-right" style="width: 80%">
	<div>
		<div class="panel panel-default" style="height:auto">
			<div class="panel-heading">
				<span class="panel-title">模块管理</span>
			</div>
			<div class="panel-body body-padding">
					<label for="">项目：</label>
				    <select id="projectSelect" style="width:200px;" onchange="initModuleTable()"> 
				    </select>
					<div style="margin:20px 0;">
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="edit()">编辑</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="save()">保存</a>
						<a href="javascript:void(0)" class="easyui-linkbutton" onclick="cancel()">取消</a>
					</div>
					<table id="tg" class="easyui-treegrid" title="系统模块表" style="width:700px;height:500px"
							data-options="
								iconCls: 'icon-ok',
								lines: true,
								rownumbers: true,
								animate: true,
								collapsible: true,
								fitColumns: true,
								method: 'get',
								idField: 'id',
								treeField: 'name',
								onContextMenu: onContextMenu
							">
						<thead>
							<tr>
								<th data-options="field:'name',width:180,editor:'text'">模块名称</th>
							</tr>
						</thead>
					</table>
					<div id="mm" class="easyui-menu" style="width:120px;">
						<div onclick="append()" data-options="iconCls:'icon-add'">Append</div>
						<div onclick="removeIt()" data-options="iconCls:'icon-remove'">Remove</div>
					</div>
				
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	$(function() {
		initProjectSelect();
		
		initModuleTable();
	});
	
	function initProjectSelect(){
		initSelect($("#projectSelect"),"${pageContext.request.contextPath}/projectAction_getProjects",null,1,null,true);
	}
	
	function initModuleTable(){
		var selectProjectId=$("#projectSelect").val(); 
		$('#tg').treegrid({url:"${pageContext.request.contextPath}/moduleAction_getModules",    
		queryParams:{"selectProjectId":selectProjectId}
		});
		$('#tg').treegrid('reload');
	}
</script>

<script type="text/javascript">	
	var editingId;
	function edit(){
		if (editingId != undefined){
			$('#tg').treegrid('select', editingId);
			return;
		}
		var row = $('#tg').treegrid('getSelected');
		if (row){
			editingId = row.id
			$('#tg').treegrid('beginEdit', editingId);
		}
	}
	function save(){
		if (editingId != undefined){
			var t = $('#tg');
			var row = $('#tg').treegrid('getSelected');
			t.treegrid('endEdit', editingId);
			var id=row.id;
			var name=row.name;
			var parent=row._parentId;
			$.ajax({
				type: "post",
				data:{"id":id,"name":name,"parent":parent},
				dataType:"json", //收受数据格式
				url:"${pageContext.request.contextPath}/moduleAction_editModule",
				cache:false,
				success: function(data){
					if(data.retcode=="0000"){
					}else{
						alert(data.errorMsg);
					}
				}
			});
			editingId = undefined;
		}
	}
	function cancel(){
		if (editingId != undefined){
			$('#tg').treegrid('cancelEdit', editingId);
			editingId = undefined;
		}
	}
	
	
	function onContextMenu(e,row){
		if (row){
			e.preventDefault();
			$(this).treegrid('select', row.id);
			$('#mm').menu('show',{
				left: e.pageX,
				top: e.pageY
			});				
		}
	}

	function append(){
		$.messager.prompt('SetValue','请输入模块名称：',function(v){
			if (v){
				var node = $('#tg').treegrid('getSelected');
				$.ajax({
					type: "post",
					data:{"name":v,"parent":node.id},
					dataType:"json", //收受数据格式
					url:"${pageContext.request.contextPath}/moduleAction_addModule",
					cache:false,
					success: function(data){
						if(data.retcode=="0000"){
							$('#tg').treegrid('append',{
								parent: node.id,
								data: [{
									id: data.obj.id,
									name: data.obj.name
								}]
							});
						}else{
							alert(data.errorMsg);
						}
					}
				});
			}
		});
	}
	function removeIt(){
		var node = $('#tg').treegrid('getSelected');
		$.ajax({
			type: "post",
			data:{"id":node.id},
			dataType:"json", //收受数据格式
			url:"${pageContext.request.contextPath}/moduleAction_deleteModule",
			cache:false,
			success: function(data){
				if(data.retcode=="0000"){
					$('#tg').treegrid('remove', node.id);
				}else{
					alert(data.errorMsg);
				}
			}
		});
	}
	function collapse(){
		var node = $('#tg').treegrid('getSelected');
		if (node){
			$('#tg').treegrid('collapse', node.id);
		}
	}
	function expand(){
		var node = $('#tg').treegrid('getSelected');
		if (node){
			$('#tg').treegrid('expand', node.id);
		}
	}
</script>