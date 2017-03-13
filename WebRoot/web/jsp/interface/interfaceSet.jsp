<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/jquery.min.js"></script>
<!-- 树形结构 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/BootSideMenu.js"></script>
<link
	href="${pageContext.request.contextPath}/web/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/web/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/web/css/site.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/web/css/ll.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/web/css/style.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/web/css/color.css"
	rel="stylesheet" type="text/css">
<!-- 树形结构 -->
<link href="${pageContext.request.contextPath}/web/css/icon.css"
	rel="stylesheet" type="text/css">
<!-- 树形结构 -->
<link href="${pageContext.request.contextPath}/web/css/easyui.css"
	rel="stylesheet" type="text/css">


<link
	href="${pageContext.request.contextPath}/web/css/jquery.datetimepicker.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/jquery.datetimepicker.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MyTable.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/web/script/MyComponent/MySelect.js"></script>



    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/postman/css/custom-theme/jquery-ui-1.9.2.custom.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/postman/codemirror/lib/codemirror.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/postman/css/keyvalueeditor.css"/>
    
    <style>
    .keyvalueeditor-key{
    	width: 100px !important;
    }
    .keyvalueeditor-value{
    	width: 58% !important;
    }
    </style>
<div class="row wrapper" style="padding-left: 20px;width: 95%">
	<div class="set-row">
		模块： <select id="moduleSelect" class="easyui-combotree"
			data-options="url:'${pageContext.request.contextPath}/moduleAction_getModulesForComboTree?projectId=<%=request.getParameter("projectId") %>',method:'get'"
			multiple style="width:200px;"></select> &nbsp; 版本： <select
			id="versionSelect" class="form-control">
		</select> &nbsp; 开发者： <select id="devUserSelect" class="form-control">
		</select>
		<button onclick="initInterfaceTable()" class="btn btn-default">查询</button>
	</div>
</div>
<div class="row table-row" style="padding-left: 20px;width: 95%">
	<a class="btn-add" onclick="addItem(interfaceTable,interfaceEditPanel)"><span
		class="glyphicon glyphicon-plus" aria-hidden="true"></span> </a> <br>
	<br>
	<table id="interfaceTable" class="table table-striped"
		beforeInsert="beforeInsertInterface"
		beforeSubmit="beforeSubmitInterface" 
		beforeEdit="beforeEditInterface"
		beforeSelect="beforeSelectInterface"
		style="width: 1022px;">
		<thead>
			<tr>
				<th>序号</th>
				<th width="60px">版本</th>
				<th width="100px">模块</th>
				<th width="150px">接口名</th>
				<th>接口路径</th>
				<th>参数说明</th>
				<th width="60px">开发者</th>
				<th width="60px">状态</th>
				<th>查看</th>
				<th>操作</th>
			</tr>
			<tr id="selectTemplete" style="display:none">
				<input id="projectId" type="hidden"
					value="<%=request.getParameter("projectId")%>" />
				<input id="moduleIds" type="hidden" />
				<input id="versionId" type="hidden" />
				<input id="devUserId" type="hidden" />
				<td><span id="index"></span></td>
				<td><span id="versionCode"></span>
				</td>
				<td><span id="module"></span>
				</td>
				<td><span id="name"></span>
				</td>
				<td><span id="url"></span>
				</td>
				<td id="params" style="text-align: left;">
				</td>
				<td><span id="devUser"></span>
				</td>
				<td>
					<myspan id="status" params='{"0":"开发中 ","1":"已完成"}'></myspan>
				</td>
				<td>
					<a id="moc" target="_blank">模拟地址</a><br/>
					<a id="test" target="_blank">接口测试</a><br/>
					<a id="toVo" target="_blank">生成Javabean</a>
				</td>
				<td><a class="btn-operation" onclick="editItem(this,interfaceEditPanel)"><span
						class="glyphicon glyphicon-edit" aria-hidden="true"></span> </a> <a
					class="btn-operation" onclick="deleteItem(this)"><span
						class="glyphicon glyphicon-trash" aria-hidden="true"></span> </a>
				</td>
			</tr>
		</thead>
		<tbody id="dataTbody">
		</tbody>
	</table>
	<div class="table-page" paging-table="interfaceTable" page-size="10">
	</div>
</div>

<div class="modal fade" id="interfaceEditPanel" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	tableid="interfaceTable">
	<div class="modal-dialog modal-productSameName">
		<div class="modal-content">
			<div class="modal-header"></div>

			<div class="modal-body">
				<div class="header-nav" id="navs">
				</div>
				<div id="basic-edit" class="tab_content">
					<table class="table edit-table">
						<tr>
							<td class="w150"><span class="red">*</span>接口名：</td>
							<td class="w230"><input id="name" /></span>
							</td>
							<td class="w150"><span class="red">*</span>接口路径：</td>
							<td class="w230"><input id="url" /></span>
							</td>
						</tr>
						<tr>
							<td>模拟地址：</td>
							<td colspan="3" ><div id="path"><%=basePath%>test/</div><input type="hidden" id="mocUrl"/></td>
						</tr>
						<tr>
							<td  >参数示例：</td>
							<td colspan="3">
								<div id="paramsUl" id="url-keyvaleditor" style="border: solid 1px;padding-bottom: 10px;">
									<div id="paramsDiv" name="paramsDiv" class="keyvalueeditor-row">
										<input type="text" class="keyvalueeditor-key" placeholder="参数名称" name="keyvalueeditor-key" onclick="newParams(this)">
										<input type="text" class="keyvalueeditor-key" placeholder="必须" name="keyvalueeditor-must" onclick="newParams(this)">
										<input type="text" class="keyvalueeditor-key" placeholder="类型" name="keyvalueeditor-type" onclick="newParams(this)">
										<input type="text" class="keyvalueeditor-key keyvalueeditor-value-text" placeholder="参数说明" name="keyvalueeditor-value" onclick="newParams(this)">
										<a name="addButton" tabindex="-1" class="keyvalueeditor-delete" onclick="deleteParam(this)">
											<img class="deleteButton" src="../image/delete.png">
										</a>
									</div>
								</div>
							<input type="hidden" id="params"/> 
							<input type="hidden" id="itemId"/>  
							</td>
						</tr>
						<tr>
							<td >返回值示例：</td>
							<td colspan="3">
							<textarea id="result"
									class="textbox-text validatebox-text textbox-prompt"
									autocomplete="off" placeholder=""
									style="margin-left: 0px; margin-right: 0px; height: 95%; width:100%;border: solid 1px;"
									data-original-title="" title=""></textarea></td>
						</tr>
						<tr>
						   <td>返回参数说明：</td>
						   <td colspan="3"><div id="resultparams"   style="border: solid 1px;padding-bottom: 10px;">
						   <div id="resultparamss" name="resultparamss" class="keyvalueeditor-row">
										<input type="text" class="rps-key" placeholder="参数名称" name="rps-name" onclick="newRps(this)" >
										<input type="text" class="rps-key " placeholder="类型" name="rps-type"  >
										<input type="text" class="rps-key " placeholder="说明" name="rps-instruction"  >
										<a name="addButton" tabindex="-1" class="keyvalueeditor-delete" onclick="deleteRps(this)">
											<img class="deleteButton" src="../image/delete.png">
										</a>
									</div>
						   
						   </div>
						    <input type="hidden" id="rps"/>
						   </td>
						</tr>
						<tr>
							<td>备注：</td>
							<td colspan="3"><input id="rmk" /></td>
						</tr>
						<tr>
							<td><span class="red">*</span>开发者：</td>
							<td><select id="devUser"></select></td>
							<td><span class="red">*</span>状态：</td>
							<td><select id="status">
									<option value="0" selected="selected">开发中</option>
									<option value="1">已完成</option>
							</select></td>
						</tr>
						<tr>
							<td>项目：</td>
							<td><span id="project"></span></td>
							<td><span class="red">*</span>版本：</td>
							<td><select id="versionId"></select>
							</td>
						</tr>

						<tr>
							<td>模块：</td>
							<td><select id="editModuleSelect" class="easyui-combotree"
								data-options="method:'get'"  style="width:200px;"></select>
								<input id="module" type="hidden" /></td>
							<td colspan="2"><span id="moduleSpan"></span>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary"
					onclick="submitAdd(null, interfaceEditPanel);">保存</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
</div>

<script type="text/javascript">
	var aoColumns = [ {
		"mDataProp" : "project"
	}, {
		"mDataProp" : "versionId"
	},{
		"mDataProp" : "versionCode"
	}, {
		"mDataProp" : "module"
	}, {
		"mDataProp" : "name"
	}, {
		"mDataProp" : "url"
	}, {
		"mDataProp" : "params"
	},{
	    "mDataProp" : "rps"
	}, {
		"mDataProp" : "result"
	}, {
		"mDataProp" : "devUser"
	}, {
		"mDataProp" : "rmk"
	}, {
		"mDataProp" : "status"
	},{
	    "mDataProp": "itemId"
	},{
	    "mDataProp": "mocUrl"
	} ];
	var ajaxSource = {
		"get" : "${pageContext.request.contextPath}/interfaceAction_getInterface",
		"select" : "${pageContext.request.contextPath}/interfaceAction_getInterfaces",
		"add" : "${pageContext.request.contextPath}/interfaceAction_saveInterface",
		"delete" : "${pageContext.request.contextPath}/interfaceAction_deleteInterface"
	};
	$(function() {
		initVersionSelect();
		initDevUserSelect();
		initTable("interfaceTable", aoColumns, ajaxSource);
	});

	function initVersionSelect() {
		var postParams = {
			"projectId" :
<%=request.getParameter("projectId")%>
	};
		initSelect($("#versionSelect"),
				"${pageContext.request.contextPath}/versionAction_getVersionsForSelect",
				postParams, 1, null, true);
		var postParams = {
			"projectId" :
<%=request.getParameter("projectId")%>
	};
		initSelect($("#interfaceEditPanel #versionId"),
				"${pageContext.request.contextPath}/versionAction_getVersionsForSelect",
				postParams, 0, null, true);
	}

	function initDevUserSelect() {
		var postParams = {
			"roleId" : 1
		};
		initSelect($("#devUserSelect"),
				"${pageContext.request.contextPath}/userAction_getUsers",
				postParams, 1, null, true);
		initSelect($("#interfaceEditPanel #devUser"),
				"${pageContext.request.contextPath}/userAction_getUsers",
				postParams, 0, null, true);
	}

	function initInterfaceTable() {
		var t = $('#moduleSelect').combotree('tree'); // 得到树对象 
		var n = t.tree('getChecked');
		var modules = new Array();
		$.each(n, function(index, item) {
			modules[index] = item.id;
		});
		if (modules.length > 0) {
			$("#interfaceTable #selectTemplete #moduleIds").val(
					JSON.stringify(modules));
		} else {
			$("#interfaceTable #selectTemplete #moduleIds").val("");
		}
		$("#interfaceTable #selectTemplete #versionId").val(
				$("#versionSelect").val());
		$("#interfaceTable #selectTemplete #devUserId").val(
				$("#devUserSelect").val());
		initTable("interfaceTable", aoColumns, ajaxSource);
	}

	function beforeInsertInterface() {
		$('#editModuleSelect')
				.combotree(
						{
							url : "${pageContext.request.contextPath}/moduleAction_getModulesForComboTree",
							queryParams : {
								"projectId" :
<%=request.getParameter("projectId")%>
	}
						});
		if ($("#versionSelect").val() != null) {
			$("#interfaceEditPanel #version").val($("#versionSelect").val());
		}
		if ($("#devUserSelect").val() != null) {
			$("#interfaceEditPanel #devUser").val($("#devUserSelect").val());
		}
	}

	function beforeSubmitInterface() {
		var t = $('#editModuleSelect').combotree('tree'); // 得到树对象 
		var n = t.tree('getSelected');
		var modules = new Array();
//		$.each(n, function(index, item) {
//			modules[index] = item.id;
//			alert(item.id);
//		});
        modules[0]=n.id;
		if (modules.length > 0) {
			$("#interfaceEditPanel #module").val(JSON.stringify(modules));
//			$("#interfaceEditPanel #module").val(modules[modules.length-1]);
		} else {
		    
			$("#interfaceEditPanel #module").val("");
		}
		
//		var params=new Object();
		var paramsArray=new Array();
		var rpssArray=new Array();
		$.each($("div[name='paramsDiv']"), function(index, item) {
		    var params=new Object();
			var pKey=$(item).find("input[name='keyvalueeditor-key']").val();
			var pMust=$(item).find("input[name='keyvalueeditor-must']").val();
			var pType=$(item).find("input[name='keyvalueeditor-type']").val();
			var pValue=$(item).find("input[name='keyvalueeditor-value']").val();
			if(pKey!=null && pKey!=""){
				params["key"]=pKey;
				params["must"]=pMust;
				params["type"]=pType;
				params["value"]=pValue;
//				alert(index);
				paramsArray.push(JSON.stringify(params));
			}	
				
		});
		$.each($("div[name='resultparamss']"), function(index, item) {
		    var rps=new Object();
			var rName=$(item).find("input[name='rps-name']").val();
			var rType=$(item).find("input[name='rps-type']").val();
			var rInstruction=$(item).find("input[name='rps-instruction']").val();
			if(rName!=null && rName!=""){
				rps["name"]=rName;
				rps["type"]=rType;
				rps["instruction"]=rInstruction;
				rpssArray.push(JSON.stringify(rps));
			}	
		});
//		alert(rpssArray);
//		$("#interfaceEditPanel #params").val(JSON.stringify(params));
        $("#interfaceEditPanel #params").val("["+paramsArray+"]");
        $("#interfaceEditPanel #rps").val("["+rpssArray+"]");
//        $("#interfaceEditPanel #url").val($("#path").text()+$("#interfaceEditPanel #url").val());
        $("#interfaceEditPanel #mocUrl").val($("#path").text());
		console.log($("#interfaceEditPanel #params").val());
	}

	function beforeEditInterface(obj,dataItem) {
		$('#editModuleSelect')
				.combotree(
						{
							url : "${pageContext.request.contextPath}/moduleAction_getModulesForComboTree",
							queryParams : {
								"projectId" :
<%=request.getParameter("projectId")%>
	,
								"interfaceId" : $("#interfaceEditPanel #itemId").val()
							}
						});
		var paramsDivHtml=$("#interfaceEditPanel #paramsDiv").prop("outerHTML");
		$("#paramsUl").empty();
		if(dataItem["params"]!=null&&dataItem["params"]!=""){
			var params = $.parseJSON(dataItem["params"]);
			$.each(params, function(i, val) {
				var paramsDiv=jQuery(paramsDivHtml);
				$(paramsDiv).find("input[name='keyvalueeditor-key']").val(i);
				$(paramsDiv).find("input[name='keyvalueeditor-value']").val(val);
				$("#paramsUl").append(paramsDiv);
			});
		}
		var paramsDiv=jQuery(paramsDivHtml);
		$(paramsDiv).find("*[name='addButton']").attr('style',"display:none");
		$("#paramsUl").append(paramsDiv);
	}
	
	function beforeSelectInterface(obj,item){
		$(obj).find("#moc").attr("href","<%=basePath%>test/"+item.url);
		$(obj).find("#test").attr("href","../postman/index.jsp?testUrl="+item.projectUrl+item.url);
		$(obj).find("#toVo").attr("href","<%=basePath%>tojava/"+item.url);
//		if(item["params"]!=null && item["params"]!=""){
//			var params = $.parseJSON(item["params"]);
//			var props = "" ; 
//			$.each(params, function(i, val) {  
//			    props += i + " : " + val+"<br>";  
//			});  
//			item["params"]=props;
//		}
	}
	
	function newParams(obj){
		var paramDiv=$(obj).parents("#paramsDiv");
		var add=true;
		$.each($(paramDiv).nextAll(), function(index, item) {  
		    if(item.id=="paramsDiv"){
		    	add=false;
		    }
		}); 
		if(add){
			$(paramDiv).find("*[name='addButton']").attr('style',"display:inline");
			var newDiv=jQuery($(paramDiv).prop("outerHTML"));
			$(newDiv).find("*[name='addButton']").attr('style',"display:none");
			$("#paramsUl").append(newDiv);
		}
	}
	function newRps(obj){
		var paramDiv=$(obj).parents("#resultparamss");
		var add=true;
		$.each($(paramDiv).nextAll(), function(index, item) {  
		    if(item.id=="#resultparamss"){
		    	add=false;
		    }
		}); 
		if(add){
			$(paramDiv).find("*[name='addButton']").attr('style',"display:inline");
			var newDiv=jQuery($(paramDiv).prop("outerHTML"));
			$(newDiv).find("*[name='addButton']").attr('style',"display:none");
			$("#resultparams").append(newDiv);
		}
	}
	function deleteRps(obj){
	    $(obj).parents("#resultparamss").remove();
	}
	function deleteParam(obj){
		$(obj).parents("#paramsDiv").remove();
	}
</script>