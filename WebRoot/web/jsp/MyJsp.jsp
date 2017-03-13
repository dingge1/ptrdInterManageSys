<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<div id="paramsUl" id="url-keyvaleditor">
	<div id="paramsDiv" name="paramsDiv" class="keyvalueeditor-row">
		<input type="text" class="keyvalueeditor-key" placeholder="参数名称" name="keyvalueeditor-key" onclick="newParams(this)">
		<input type="text" class="keyvalueeditor-value keyvalueeditor-value-text" placeholder="参数说明" name="keyvalueeditor-value" onclick="newParams(this)">
		<a tabindex="-1" class="keyvalueeditor-delete"><img name="addButton" class="deleteButton" src="../image/delete.png"></a>
	</div>
</div>