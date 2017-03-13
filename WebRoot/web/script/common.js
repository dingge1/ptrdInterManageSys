var isChrome = navigator.userAgent.toLowerCase().indexOf('chrome');
var isIE = navigator.userAgent.toLowerCase().indexOf('msie');

var vur_index=0;
var main_pages=new Array();
/**
 * 公用加载页面的方法
 * @param url 请求页面的url
 * @param workPanl 用来加载页面元素的面板id
 */
function commonLoadPage(url,workPanl,index){
	lockScreen();
	/*if(index!=null){
		if(vur_index!=0){
			main_pages[vur_index]=$("#"+workPanl).html();
		}
		vur_index=index;
		if(main_pages[index]!=null && main_pages[index]!=""){
			$("#"+workPanl).html(main_pages[index]);
			unLockScreen();
			return;
		}
	}*/
	var cb = arguments;
	$.ajax({
		url :  url,
		dataType : "html",
		cache : false,
		success : function(html) {
			//unLockScreen();
			$("#"+workPanl).empty();
			$("#systemLoadingDialog").nextAll().remove();
			$("#"+workPanl).html(html);
			/*try{
				var j=$.parseJSON(html);
				
				if("SESSION_INVALIDATE"==j.retcode){
					$("#systemInvalidUser").dialog('open');
				}else{
					systemAlert(j.errorMsg);
				}
				
			}catch(e){
				$("#"+workPanl).html(html);
				for(var i = 2; i < cb.length; i++){
					cb[i].call();
				}
			}*/
		},
		error : function(XMLHttpRequest,textStatus,errorThrown){
			unLockScreen();
			/*systemAlert("网络不是很给力，请重试");*/
		},
		complete:function(){
			unLockScreen();
		}
	});
}


/**
 * 显示数据处理中浮层，或禁用组件(按钮)
 * disableId 禁用组件ID
 */
function lockScreen(){
	$('#systemLoadingDialog').removeAttr("style");
}

/**
 * 取消显示数据处理中浮层，或启用组件(按钮)
 * enableId 启用组件ID
 */
function unLockScreen(){
	$('#systemLoadingDialog').attr('style',"display:none");//启用组件(按钮)
}

