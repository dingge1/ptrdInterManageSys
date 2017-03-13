<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Postman</title>
    <link rel="stylesheet" type="text/css" href="css/custom-theme/jquery-ui-1.9.2.custom.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-modal.css"/>
    <link rel="stylesheet" type="text/css" href="css/jquery.jscrollpane.css"/>
    <link rel="stylesheet" type="text/css" href="codemirror/lib/codemirror.css"/>
    <link rel="stylesheet" type="text/css" href="codemirror/theme/eclipse.css"/>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <link rel="stylesheet" type="text/css" href="css/keyvalueeditor.css"/>
</head>
<body>
<div id="container" class="clearfix">
<div id="sidebar-footer">
    <div id="donate-form">
        <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
            <input type="hidden" name="cmd" value="_s-xclick">
            <input type="hidden" name="hosted_button_id" value="UZTSEWB887WDJ">
            <input type="image" src="https://www.paypalobjects.com/en_GB/i/btn/btn_paynowCC_LG.gif" border="0" name="submit" alt="PayPal — The safer, easier way to pay online.">
            <img alt="" border="0" src="https://www.paypalobjects.com/en_GB/i/scr/pixel.gif" width="1" height="1">
        </form>
    </div>
    <a id="make-postman-better">Make Postman better!</a>
    <a id="donate">Donate</a>
</div>
<div id="sidebar-toggle">
    <img src="img/tri_arrow_left.png"/>
</div>
<div id="sidebar">
    <div id="header" class="clearfix">
        <div id="logo">
            <a target="_blank">
                <img src="img/logo-grey.png" alt="Postman" height="15px"
                     width="100px"/>
            </a>
        </div>
        <div id="external-links">
            <ul>
                <li>
                    <a href="http://www.twitter.com/postmanclient"
                        target="_blank"><img src="img/twitter.png"/>
                    </a>
                </li>
                <li>
                    <a href="http://www.github.com/a85/POSTMan-Chrome-Extension/wiki"
                       target="_blank"><img src="img/question_mark.png"/>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div id="sidebar-sections" class="clearfix">
        <div id="history-options" class="section-options">
            <a
                    class="history-actions-delete" rel="tooltip"
                    data-placement="bottom"
                    data-original-title="Clear history">
                <img src="img/trash-empty.png" style="width:24px; height:24px; vertical-align: middle;"/>
            </a>
        </div>
        <div id="collections-options" class="section-options">
            <a href="#modal-new-collection" rel="tooltip" data-original-title="Add new collection"
               data-toggle="modal"
               data-backdrop="static"
               data-placement="bottom"
               data-keyboard="true"><img src="img/folder_plus.png"
                                         style="width:20px; height:20px; vertical-align: middle;"/></a>
            <a href="#modal-import-collection" rel="tooltip" data-original-title="Import collection"
               data-toggle="modal"
               data-backdrop="static"
               data-placement="bottom"
               data-keyboard="true"><img src="img/inbox_in.png"
                                         style="width:20px; height:20px; vertical-align: middle;"/></a>
        </div>
        <ul id="sidebar-selectors" class="nav nav-pills">
            <li class="active"><a href="#sidebar-section-history" data-id="history" data-toggle="tab">History</a></li>
            <li><a href="#sidebar-section-collections" data-id="collections" data-toggle="tab">Collections</a></li>
        </ul>
        <div id="sidebar-section-data">
            <div class="tab-pane active" id="sidebar-section-history">
                <ul id="history-items" class="clearfix">
                </ul>
            </div>
            <div class="tab-pane active" id="sidebar-section-collections">
                <ul id="collection-items" class="clearfix">
                </ul>
            </div>
        </div>
    </div>
    <div id="sidebar-filler"></div>
</div>
<div id="main" class="content">
<section id="request">
    <div id="request-builder">
        <div id="request-types" class="clearfix">
            <ul class="request-helper-tabs">
                <li class="active" data-id="normal">Normal</li>
                <li data-id="basicAuth">Basic Auth</li>
                <li data-id="digestAuth">Digest Auth</li>
                <li data-id="oAuth1">OAuth 1.0</li>
            </ul>
            <div id="environment-selector-wrapper">
                <div id="environment-quicklook-wrapper">
                    <a id="environment-quicklook">
                        <img src="img/eye.png"/>
                    </a>
                </div>
                <div id="environment-quicklook-content" class="clearfix">
                    <div id="environment-quicklook-environments">
                        <h6>No environment</h6>
                        <ul></ul>
                    </div>
                    <div id="environment-quicklook-globals">
                        <h6>Globals</h6>
                        <ul></ul>
                    </div>
                </div>
                <div id="environment-selector">
                    <div class="btn-group">
                        <a data-toggle="dropdown">
                            <span class="environment-list-item-selected">No environment</span>
                            <span class="caret" style="margin-top: 8px;"></span></a>
                        <ul class="dropdown-menu">
                        </ul>
                    </div>
                </div>
            </div>
            <div id="broadcasts" class="btn-group">
                <a data-toggle="dropdown" rel="tooltip" id="broadcasts-count">0</a>
                <ul class="dropdown-menu">
                </ul>
            </div>
            <div class="preferences">
                <a data-toggle="modal" href="#modal-shortcuts"
                   rel="tooltip" data-placement="bottom" data-original-title="Shortcuts">
                    <img src="img/keyboard_wireless.png" style="vertical-align: middle;"/></a>
                <a href="#modal-settings" data-toggle="modal"
                   rel="tooltip"
                   data-placement="bottom" data-original-title="Settings">
                    <img src="img/settings.png" style="vertical-align: middle;"/></a>
            </div>
        </div>
        <div id="request-helpers" class="clearfix">
            <div id="request-helper-normal" class="request-helpers"></div>
            <div id="request-helper-basicAuth" class="request-helpers">
                <div class="request-helper-form-container">
                    <form class="form form-horizontal">
                        <div class="control-group">
                            <label class="control-label">Username</label>

                            <div class="controls">
                                <input type="text" id="request-helper-basicAuth-username" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Password</label>

                            <div class="controls">
                                <input type="password" id="request-helper-basicAuth-password" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <a
                                        class="btn btn-secondary request-helper-submit"
                                        data-type="basic">Refresh headers</a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="request-helper-form-description">
                    <h4>Note</h4>
                    The authorization header will be generated and added as a custom header.
                </div>
            </div>
            <div id="request-helper-digestAuth" class="request-helpers">
                <div class="request-helper-form-container">
                    <form class="form-horizontal">
                        <div class="control-group">
                            <label class="control-label">Username</label>

                            <div class="controls">
                                <input type="text" id="request-helper-digestAuth-username" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Realm</label>

                            <div class="controls">
                                <input type="text" id="request-helper-digestAuth-realm" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Password</label>

                            <div class="controls">
                                <input type="password" id="request-helper-digestAuth-password" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Nonce</label>

                            <div class="controls">
                                <input type="text" id="request-helper-digestAuth-nonce" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Algorithm</label>

                            <div class="controls">
                                <input type="text" id="request-helper-digestAuth-algorithm" class="clean-input"
                                       placeholder="MD5/MD5-sess, default = MD5" value="MD5"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">qop</label>

                            <div class="controls">
                                <input type="text" id="request-helper-digestAuth-qop" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Nonce count</label>

                            <div class="controls">
                                <input type="text" id="request-helper-digestAuth-nonceCount" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Client nonce</label>

                            <div class="controls">
                                <input type="text" id="request-helper-digestAuth-clientNonce" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Opaque</label>

                            <div class="controls">
                                <input type="text" id="request-helper-digestAuth-opaque" class="clean-input"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <a class="btn btn-secondary request-helper-submit"
                                        data-type="digest">Refresh headers</a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="request-helper-form-description">
                    <h4>Note</h4>
                    The authorization header will be generated and added as a custom header.
                </div>
            </div>
            <div id="request-helper-oAuth1" class="request-helpers">
                <div class="request-helper-form-container">
                    <form class="form-horizontal">
                        <div class="control-group">
                            <label class="control-label">Consumer Key</label>

                            <div class="controls">
                                <input type="text" id="request-helper-oauth1-consumerKey"
                                       class="clean-input signatureParam"
                                       key="oauth_consumer_key"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Consumer Secret</label>

                            <div class="controls">
                                <input type="text" id="request-helper-oauth1-consumerSecret" class="clean-input"
                                       key="oauth_consumer_secret"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Token</label>

                            <div class="controls">
                                <input type="text" id="request-helper-oauth1-token" class="clean-input signatureParam"
                                       key="oauth_token"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Token Secret</label>

                            <div class="controls">
                                <input type="text" id="request-helper-oauth1-tokenSecret" class="clean-input"
                                       key="oauth_token_secret"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Signature Method</label>

                            <div class="controls">
                                <input type="text" id="request-helper-oauth1-signatureMethod"
                                       class="clean-input signatureParam"
                                       value="HMAC-SHA1" key="oauth_signature_method"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Timestamp</label>

                            <div class="controls">
                                <input type="text" id="request-helper-oauth1-timestamp" class="clean-input signatureParam"
                                       key="oauth_timestamp"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Nonce</label>

                            <div class="controls">
                                <input type="text" id="request-helper-oauth1-nonce" class="clean-input signatureParam"
                                       key="oauth_nonce"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Version</label>

                            <div class="controls">
                                <input type="text" id="request-helper-oauth1-version" class="clean-input signatureParam"
                                       value="1.0"
                                       key="oauth_version"/>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">Realm</label>

                            <div class="controls">
                                <input type="text" id="request-helper-oauth1-realm" class="clean-input"
                                        placeholder="Optional"
                                       value=""
                                       key="oauth_realm"/>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">Add params to header</label>
                            <div class="controls">
                                <input type="checkbox" class="checkbox" id="request-helper-oauth1-header"/>
                            </div>
                        </div>
                        
                        <div class="control-group">
                            <label class="control-label">Auto add parameters</label>
                            <div class="controls">
                                <input type="checkbox" class="checkbox" id="request-helper-oauth1-auto"/>                        
                            </div>
                        </div>

                        <div class="control-group">
                            <div class="controls">
                                <a class="btn btn-secondary request-helper-submit"
                                   data-type="oAuth1">
                                    Refresh request
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="request-helper-form-description">
                    <h4>Note</h4>
                    If auto addition is enabled, OAuth parameters will be added when you send the request
                </div>
            </div>
        </div>

        <div id="request-meta">
            <div class="request-meta-actions">
                <a class="request-meta-actions-togglesize" data-action="minimize">
                    <img src="img/circle_minus.png"/>
                </a>
            </div>
            <h5 id="request-name"></h5><span id="request-last-saved-time">Saved</span>

            <div id="request-description-container">
                <p id="request-description"></p>

                <div id="request-samples">
                    <h4>Sample responses</h4>
                    <table class="table table-striped table-bordered"></table>
                </div>
            </div>
        </div>

        <div id="request-url" class="clearfix">
            <div id="request-url-wrapper">
                <div id="request-url-container">
                    <input type="text" name="url" id="url" tabindex="1" class="input-text-light"
                           placeholder="Enter request URL here" value="<%=request.getParameter("testUrl") %>>"/>
                </div>
            </div>
            <div id="request-modifiers">
                <div id="request-method-container">
                    <select id="request-method-selector">
                        <option value="GET" selected>GET</option>
                        <option value="POST">POST</option>
                        <option value="PUT">PUT</option>
                        <option value="PATCH">PATCH</option>
                        <option value="DELETE">DELETE</option>
                        <option value="COPY">COPY</option>
                        <option value="HEAD">HEAD</option>
                        <option value="OPTIONS">OPTIONS</option>                            
                        <option value="LINK">LINK</option>
                        <option value="UNLINK">UNLINK</option>
                        <option value="PURGE">PURGE</option>
                    </select>
                </div>
                <div id="request-url-buttons-container">
                    <button class="btn"
                            id="url-keyvaleditor-actions-open"><i
                            class="icon-edit"></i> URL params
                    </button>
                    <button class="btn"
                            id="headers-keyvaleditor-actions-open"><i
                            class="icon-edit"></i> Headers (<span class="headers-count">0</span>)
                    </button>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <div id="url-keyvaleditor-container" class="row" style="margin-left: 0px; display: none;">
            <div id="url-keyvaleditor"></div>    
        </div>

        <div id="headers-keyvaleditor-container" class="row clearfix" style="margin-left: 0px; display: none;">
            <div class="keyvaleditor-left">
                <div id="headers-keyvaleditor"></div>
            </div>
            <div class="keyvaleditor-right">
                <div id="headers-keyvaleditor-actions">
                    <input type="button" id="headers-keyvaleditor-actions-manage-presets"
                           class="btn"
                           rel="popover" 
                           data-trigger="hover"
                           data-placement="bottom" data-content="Presets let you define groups of headers for quick addition" data-original-title="Header presets"
                           value="Manage presets"/><br/>           
                </div>
            </div>
        </div>

        <div id="data">
            <div class="clearfix">
                <div id="data-mode-selector" class="btn-group clearfix"
                     data-toggle="buttons-radio">
                    <a class="btn" data-mode="params">form-data</a>
                    <a class="btn" data-mode="urlencoded">x-www-form-urlencoded</a>
                    <a class="btn" data-mode="raw">raw</a>
                </div>
                <div id="body-editor-mode-selector">
                    <div class="btn-group">
                        <a class="dropdown" data-toggle="dropdown">
                            <span id="body-editor-mode-item-selected">Text</span>
                            <span class="caret" style="margin-top: 8px;"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a data-editor-mode="text" data-language="text">Text</a></li>
                            <li><a data-editor-mode="javascript" data-language="json">JSON</a></li>
                            <li><a data-editor-mode="xml" data-language="xml">XML</a></li>
                            <li><a data-editor-mode="xml" data-language="html">HTML</a></li>
                        </ul>                
                    </div>
                </div>
            </div>
            <div id="body-data-containers">
                <div id="formdata-keyvaleditor-container" class="row" style="margin-left: 0;">
                    <div id="formdata-keyvaleditor"></div>
                </div>
                <div id="urlencoded-keyvaleditor-container" class="row" style="margin-left: 0;">
                    <div id="urlencoded-keyvaleditor"></div>
                </div>
                <div id="body-data-container">
                    <textarea name="data" id="body" tabindex="4" class="inputText"></textarea>
                    <pre id="body-editor-mode-selector-format-result">
                    </pre>
                </div>
            </div>
        </div>    
    </div>

    <div id="request-preview">
        <div id="request-preview-header" class="dropdown">
            <span class="request-preview-header-title">Preview</span>
            <a data-toggle="dropdown-toggle" class="dropdown-toggle request-preview-header-limitations">
                Limitations
            </a>
            <ul class="dropdown-menu" role="menu">
                <li>Automatic headers sent by Chrome can not be previewed</li>
                <li>Can not preview form-data files</li>
            </ul>
        </div>
        <div id="request-preview-content">
        </div>
    </div>

<div id="request-actions" class="clearfix">
    <div id="request-actions-primary">
        <button class="btn btn-primary" data-loading-text="Fetching data..." type="button"
                data-complete-text="Send request" id="submit-request" tabindex="5">
            Send
        </button>
        <button class="btn"
                id="update-request-in-collection">Save
        </button>
        <button class="btn"
                data-action="preview"
                id="preview-request">Preview
        </button>
        <button class="btn"
                id="add-to-collection"
                href="#modal-add-to-collection"
                data-toggle="modal" data-backdrop="static"
                data-keyboard="true">Add to collection
        </button>
    </div>
    <div id="request-actions-secondary">
        <button class="btn btn-danger" id="request-actions-reset">Reset</button>
    </div>
</div>
</section>

<section id="response">
    <div id="response-waiting-container">
        <h3>Loading...</h3>
        <button id="cancel-request" class="btn">Cancel request</button>
    </div>
    <div id="response-failed-container">
        <h3>Could not get any response</h3>

        <p>
            This seems to be like an error connecting to <span id="connection-error-url"></span>.
            The response status was 0.<br/>
            Check out the
            <a href="http://www.w3.org/TR/XMLHttpRequest/#the-status-attribute" target="_blank">W3C XMLHttpRequest Level
                2 spec</a>
            for more details about when this happens.
        </p>
    </div>
    <div id="response-success-container">
        <div id="response-top-bar">
            <ul class="response-tabs clearfix">
                <li class="active" data-section="body">Body</li>
                <li data-section="cookies" id="response-tabs-cookies">Cookies</li>
                <li data-section="headers">Headers</li>
            </ul>
            <div id="response-status">
            </div>

            <div id="response-time">
                <span class="label">Time</span>
                <span class="data">0 millisecs</span>
            </div>

            <div id="response-sample-status" class="span1">
                <span class="label label-info">Sample</span>
            </div>
        </div>

        <div id="response-data-container" class="clearfix">
            <div id="response-data" style="display:none" class="clearfix">
                <div id="response-data-options" class="clearfix">
                    <div id="response-formatting" class="btn-group clearfix" data-toggle="buttons-radio">
                        <a data-type="parsed" class="btn">Pretty</a>
                        <a data-type="raw" class="btn">Raw</a>
                        <a data-type="preview" class="btn">Preview</a>
                    </div>
                    <div id="response-actions" class="clearfix">
                        <a class="btn"
                           rel="tooltip"
                           data-placement="bottom"
                           data-original-title="Toggle size"
                           id="response-body-toggle">
                            <img src="img/full-screen-alt-4.png"
                                 style="width:16px; height:16px; vertical-align: middle;"/>
                        </a>
                    </div>
                    <div id="response-pretty-modifiers" class="clearfix">
                        <a class="btn"
                           rel="tooltip"
                           data-placement="bottom"
                           data-original-title="Toggle wrapping"
                           id="response-body-line-wrapping">
                            <img src="img/right_indent.png"
                                 style="width:16px; height:16px; vertical-align: middle;"/>
                        </a>

                        <div id="response-language" class="btn-group clearfix" data-toggle="buttons-radio">
                            <a data-mode="javascript" class="btn">JSON</a>
                            <a data-mode="html" class="btn">XML</a>
                        </div>
                    </div>                    
                    <div id="response-collection-request-actions" class="clearfix">                        
                        <span id="response-sample-save-start-container">
                            <a class="btn"
                               rel="tooltip"
                               data-placement="bottom"
                               data-original-title="Save sample response"
                               id="response-sample-save-start">
                                <i class="icon-bookmark"></i>
                            </a>
                        </span>
                        <span id="response-sample-save-form">
                            <form class="form-inline">
                                <input type="text" class="input-small" placeholder="Name" id="response-sample-name">
                                <a class="btn"
                                   rel="tooltip"
                                   data-placement="bottom"
                                   data-original-title="Save"
                                   id="response-sample-save">
                                    <i class="icon-ok-sign"></i>
                                </a>
                                <a class="btn"
                                   rel="tooltip"
                                   data-placement="bottom"
                                   data-original-title="Cancel"
                                   id="response-sample-cancel">
                                    <i class="icon-remove-sign"></i>
                                </a>
                            </form>
                        </span>
                    </div>

                </div>
                <div id="response-editors">
                    <div id="response-as-code">
                        <textarea id="code-data" data-formatted="false"></textarea>
                    </div>
                    <div id="response-as-text">
                        <textarea id="code-data-raw"></textarea>
                    </div>
                    <div id="response-as-preview">
                        <iframe src=""></iframe>
                    </div>
                    <div id="response-as-image"></div>
                </div>
            </div>
        </div>
        <div id="response-cookies-container">
            <table id="response-cookies" class="table table-striped table-bordered">
                <thead>
                <th>Name</th>
                <th>Value</th>
                <th>Domain</th>
                <th>Path</th>
                <th>Expires</th>
                <th>HTTP</th>
                <th>Secure</th>
                </thead>
                <tbody id="response-cookies-items">
                </tbody>
            </table>
        </div>
        <div id="response-headers-container">
            <ul id="response-headers"></ul>
        </div>
    </div>
</section>
</div>
</div>
<div id="modal-new-collection" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>Create a new collection</h3>
    </div>
    <div class="modal-body">
        <form class="form form-horizontal" id="form-new-collection">
            <div class="control-group" id="new-collection-container">
                <label class="control-label">Collection name</label>

                <div class="controls">
                    <input type="text" class="medium clean-input" name="new-collection-blank"
                           id="new-collection-blank"/>
                </div>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <a class="btn btn-primary">Create</a>
        <a data-dismiss="modal" class="btn btn-secondary">Cancel</a>
    </div>
</div>
<div id="modal-edit-collection" class="modal hide fade" tabindex="-1">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>
        <h3>Edit collection</h3>
    </div>
    <div class="modal-body">
        <div id="edit-collection-details">
            <form class="form form-horizontal" id="form-edit-collection">
                <input type="hidden" name="collection-id" class="collection-id"/>
                <input type="text" name="collection-name" class="medium clean-input collection-name"/>
            </form>
        </div>

        <div id="edit-collection-requests">
            <ul id="edit-collection-requests-list"></ul>
        </div>
    </div>
    <div class="modal-footer">
        <a class="btn btn-primary">Edit</a>
        <a data-dismiss="modal" class="btn btn-secondary">Cancel</a>
    </div>
</div>
<div id="modal-edit-collection-request" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>Edit request</h3>
    </div>
    <div class="modal-body">
        <form class="form-horizontal" id="form-edit-collection-request">
            <div class="control-group">
                <label class="control-label" for="new-collection">Request name</label>

                <div class="controls">
                    <div class="input">
                        <input type="hidden" class="collection-request-id"/>
                        <input type="text" class="medium clean-input collection-request-name" data-tabindex="1"/>
                    </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="new-collection">Request description</label>

                <div class="controls">
                    <div class="input">
                        <textarea class="medium collection-request-description" data-tabindex="2"></textarea>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <a class="btn btn-primary" data-tabindex="3">Edit</a>
        <a data-dismiss="modal" class="btn btn-secondary" data-tabindex="4">Cancel</a>
    </div>
</div>
<div id="modal-add-to-collection" class="modal fade" data-keyboard="true">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>Add request to a collection</h3>
    </div>
    <div class="modal-body">
        <form class="form-horizontal" id="form-add-to-collection">
            <div class="control-group" id="select-collection-container">
                <label class="control-label" for="select-collection">Existing collection</label>

                <div class="controls">
                    <select name="select-collection" class="medium" id="select-collection">
                        <option value="_select">Select</option>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="new-collection">or create a new one</label>

                <div class="controls">
                    <div class="input">
                        <input type="text" class="medium clean-input" id="new-collection"/>
                    </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="new-collection">Request name</label>

                <div class="controls">
                    <div class="input">
                        <input type="text" class="medium clean-input" id="new-request-name"/>
                    </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="new-collection">Request description</label>

                <div class="controls">
                    <div class="input">
                        <textarea class="medium" id="new-request-description"></textarea>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <a class="btn btn-primary">Add to collection</a>
        <a data-dismiss="modal" class="btn btn-secondary">Cancel</a>
    </div>
</div>
<div id="modal-share-collection" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal" id="modal-share-collection-close">x</a>

        <h3>Share collection</h3>
    </div>

    <div class="modal-body">
        <div>
            <h4>Share as a link</h4>

            <p>Upload your collection to getpostman.com and get a link to share with others.</p>
            <pre id="share-collection-link"></pre>
            <a id="share-collection-get-link" data-collection-id="" class="btn">Upload</a>
        </div>
        <div style="margin-top: 20px;">
            <h4>Download as a file</h4>

            <p>Get a JSON file to share with others or for backing up the collection.</p>
            <a id="share-collection-download" data-collection-id="" class="btn">Download</a>
        </div>
        <hr/>
    </div>
</div>
<div id="modal-import-collection" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">x</a>

        <h3>Import a collection</h3>
    </div>

    <div class="modal-body">
        <h4>Import from disk</h4>

        <div class="modal-import-alerts"></div>
        <div id="import-collection-dropzone">
            <h3>Drop files here or</h3>
            <input type="file" id="collection-files-input"
                   name="files[]" multiple/>
        </div>
        <hr/>
        <div id="import-collection-url-container">
            <h4>Import from a URL</h4>

            <div class="control-group">
                <div class="controls">
                    <input type="text"
                           class="large clean-input"
                           placeholder="Enter URL and press import"
                           id="import-collection-url-input"/>
                </div>
            </div>
            <div class="control-group">
                <a
                        id="import-collection-url-submit"
                        class="btn btn-primary">Import</a>
            </div>
        </div>
    </div>
</div>
<div id="modal-delete-collection" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">x</a>

        <h3>Are you sure?</h3>
    </div>

    <div class="modal-body">
        <p>
            Are you sure you want to delete <span id="modal-delete-collection-name"></span>?
        </p>
    </div>

    <div class="modal-footer">
        <a data-collection-id=""
            id="modal-delete-collection-yes"
            data-dismiss="modal"
            class="btn btn-danger">Yes</a>
        <a data-dismiss="modal" class="btn">No</a>
    </div>
</div>
<div id="modal-delete-collection-request" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">x</a>

        <h3>Are you sure?</h3>
    </div>

    <div class="modal-body">
        <p>
            Are you sure you want to delete <span id="modal-delete-collection-request-name"></span>?
        </p>
    </div>

    <div class="modal-footer">
        <a data-collection-id=""
            id="modal-delete-collection-request-yes"
            data-dismiss="modal"
            class="btn btn-danger">Yes</a>
        <a data-dismiss="modal" class="btn">No</a>
    </div>
</div>
<div id="modal-environments" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">x</a>
        <h3>Manage environments</h3>
    </div>

    <div class="modal-body">
        <div id="environments-list-wrapper">
            <p>
                Environments help you customize requests according to variables.
            <span id="environments-list-help-detail">
              Variables can be used in the
              following form - {{variable}}. The string {{variable}} will be replaced with its corresponding value.
              For example, for an environment variable 'url' with the value 'http://localhost'
              , you will have to use {{url}} in the request URL field. {{url}} will be replaced by http://localhost
              when the request is sent.
            </span><a id="environments-list-help-toggle">Tell me more</a>
            </p>

            <div class="toolbar">
                <button class="btn  environments-actions-add">
                    Add
                </button>
                <button class="btn  environments-actions-import">
                    Import
                </button>
                <button class="btn  environments-actions-manage-globals">
                    Globals
                </button>
            </div>
            <table id="environments-list" class="table table-striped table-bordered"
                   style="margin-top: 10px;">
                <tbody>
                </tbody>
            </table>
        </div>
        <div id="environment-editor">
            <input type="text" name="environment-editor-name" id="environment-editor-name" class="clean-input"
                   placeholder="New environment"/>
            <input type="hidden" name="environment-editor-id" id="environment-editor-id" value="0" class="clean-input"/>

            <div id="environment-keyvaleditor"></div>
        </div>
        <div id="environment-importer">
            <p>Select environment files from your desktop</p>

            <div id="environment-importer-confirmations"></div>
            <input type="file" id="environment-files-input"
                   name="files[]" multiple/>
        </div>
        <div id="globals-editor">
            <p>Globals are common values across all environments.</p>

            <div id="globals-keyvaleditor"></div>
        </div>
        <div class="modal-footer">
            <a class="btn btn-primary environments-actions-add-submit">Submit</a>
            <a class="btn environments-actions-add-back">Back</a>
        </div>
    </div>
</div>
<div id="modal-header-presets" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">x</a>

        <h3>Manage header presets</h3>
    </div>

    <div class="modal-body">
        <div id="header-presets-list-wrapper">
            <p>
                Quickly add groups of header key/value pairs to the request. Start typing the name of
                the preset name and it'll show up in the dropdown list.
            </p>

            <div class="toolbar">
                <button class="btn  header-presets-actions-add">
                    Add
                </button>
            </div>
            <table id="header-presets-list" class="table table-striped table-bordered"
                   style="margin-top: 10px;">
                <tbody>
                </tbody>
            </table>
        </div>
        <div id="header-presets-editor">
            <input type="text" name="header-presets-editor-name" id="header-presets-editor-name" class="clean-input"
                   placeholder="New preset name"/>
            <input type="hidden" name="header-presets-editor-id" id="header-presets-editor-id" value="0"
                   class="clean-input"/>

            <div id="header-presets-keyvaleditor"></div>
        </div>

        <div class="modal-footer">
            <a class="btn btn-primary header-presets-actions-submit">Submit</a>
            <a class="btn header-presets-actions-back">Back</a>
        </div>
    </div>
</div>
<div id="modal-settings" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>Settings</h3>
    </div>
    <div class="modal-body">
        <form class="form-horizontal">
            <div class="control-group">
                <label class="control-label" for="history-count">Max history items</label>

                <div class="controls">
                    <select class="medium" name="history-count" id="history-count">
                        <option value="50">50</option>
                        <option value="100">100</option>
                        <option value="200">200</option>
                        <option value="-1">Unlimited</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="auto-save-request">Auto save request</label>

                <div class="controls">
                    <select class="medium" name="auto-save-request" id="auto-save-request">
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="retain-link-headers">Retain headers on clicking on links</label>

                <div class="controls">
                    <select class="medium" name="retain-link-headers" id="retain-link-headers">
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="send-no-cache-header">Send no-cache header</label>

                <div class="controls">
                    <select class="medium" name="send-no-cache-header" id="send-no-cache-header">
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="language-detection">Language detection</label>

                <div class="controls">
                    <select class="medium" name="language-detection" id="language-detection">
                        <option value="auto">Automatic detection</option>
                        <option value="javascript">Force JSON</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="variable-delimiter">Variable delimiter</label>

                <div class="controls">
                    <input type="text" name="variable-delimiter" id="variable-delimiter"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="use-postman-proxy">Use Postman proxy?</label>

                <div class="controls">
                    <select class="medium" name="use-postman-proxy" id="use-postman-proxy">
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>

                    <p class="help-block">
                        See <a
                            href="https://github.com/a85/POSTMan-Chrome-Extension/wiki/Postman-Proxy">documentation</a>
                        for usage instructions.
                    </p>
                </div>

            </div>

            <div class="control-group" id="postman-proxy-url-container">
                <label class="control-label" for="postman-proxy-url">Postman proxy URL</label>

                <div class="controls">
                    <input type="text" name="postman-proxy-url" id="postman-proxy-url"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="have-donated">Donated to Postman?</label>

                <div class="controls">
                    <select class="medium" name="have-donated" id="have-donated">
                        <option value="true">Yes</option>
                        <option value="false">No</option>
                    </select>

                    <p class="help-block">
                        Bad things will happen to you if you lie here.
                    </p>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
<div id="modal-spread-the-word" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>Make Postman better!</h3>
    </div>
    <div class="modal-body">
        <table class="table table-striped">
            <tr>
                <td>
                    <strong>Pay through your credit card or Paypal</strong>

                    <div class="paypal-donate-form">
                        If you found Postman useful, pay through your credit card or
                        Paypal to help the project grow even more!
                        The payment will go into the design, development and maintenance of the project.

                        <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
                            <input type="hidden" name="cmd" value="_s-xclick">
                            <input type="hidden" name="hosted_button_id" value="UZTSEWB887WDJ">
                            <input type="image" src="https://www.paypalobjects.com/en_GB/i/btn/btn_paynowCC_LG.gif"
                                   border="0" name="submit" alt="PayPal — The safer, easier way to pay online.">
                            <img alt="" border="0" src="https://www.paypalobjects.com/en_GB/i/scr/pixel.gif" width="1"
                                 height="1">
                        </form>

                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <a target="_blank"
                       href="https://chrome.google.com/webstore/detail/fdmmgilgnpjigdojojpjoooidkmcomcm/reviews">Write a
                        review</a>

                    <p>
                        We would love a good review. A bad review would hurt but make it as informative as possible!
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <a target="_blank" href="https://github.com/a85/POSTMan-Chrome-Extension">Check out the source
                        code</a>

                    <p>
                        Found a bug or want to add a feature? Let us know or checkout the code.
                        Postman is licensed under the Apache Licence, Version 2.0.
                    </p>
                </td>
            </tr>
            <tr>
                <td>
                    <strong>Share Postman</strong>

                    <div class="spreadtheword-sharebuttons">
                        <div id="about-postman-social-buttons" class="clearfix">
                            <div id="about-postman-twitter-button"></div>
                            <div id="about-postman-plus-one-button"></div>
                            <div id="about-postman-facebook-button"></div>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>
<div id="modal-shortcuts" class="modal fade">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>

        <h3>Shortcuts</h3>
    </div>
    <div class="modal-body">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Action</th>
                <th>Shortcut key</th>
            </tr>
            </thead>
            <tr>
                <td>New request</td>
                <td><strong>Alt + n</strong></td>
            </tr>
            <tr>
                <td>Preview request</td>
                <td><strong>Alt + p</strong></td>
            </tr>
            <tr>
                <td>Edit URL</td>
                <td><strong>Backspace</strong></td>
            </tr>
            <tr>
                <td>Edit headers</td>
                <td><strong>h</strong></td>
            </tr>
            <tr>
                <td>Send request</td>
                <td><strong>Enter/Return</strong></td>
            </tr>
            <tr>
                <td>Maximize/minimze response</td>
                <td><strong>f</strong></td>
            </tr>
            <tr>
                <td>Add request to collection</td>
                <td><strong>a</strong></td>
            </tr>
            <tr>
                <td>Clear history</td>
                <td><strong>Alt + c</strong></td>
            </tr>
            <tr>
                <td>Manage environments</td>
                <td><strong>e</strong></td>
            </tr>
            <tr>
                <td>Toggle Quicklook window</td>
                <td><strong>q</strong></td>
            </tr>
            <tr>
                <td>This window</td>
                <td><strong>?</strong></td>
            </tr>
        </table>
    </div>
</div>
<script type="text/javascript" src="js/ga.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/underscore-min.js"></script>
<script type="text/javascript" src="js/jsonlint.js"></script>

<script type="text/javascript" src="js/noty/jquery.noty.js"></script>
<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/topRight.js"></script>
<script type="text/javascript" src="js/noty/themes/default.js"></script>

<script type="text/javascript" src="js/crypto/rollups/md5.js"></script>

<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" src="js/dropbox/sha1.js"></script>
<script type="text/javascript" src="js/dropbox/oauth.js"></script>
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/httpstatuscodes.js"></script>
<script type="text/javascript" src="js/httpheaders.js"></script>
<script type="text/javascript" src="codemirror/lib/codemirror.js"></script>
<script type="text/javascript" src="codemirror/lib/util/formatting.js"></script>
<script type="text/javascript" src="codemirror/lib/util/foldcode.js"></script>
<script type="text/javascript" src="codemirror/mode/xmlpure/xmlpure.js"></script>
<script type="text/javascript" src="codemirror/mode/javascript/javascript.js"></script>
<script type="text/javascript" src="codemirror/mode/xml/xml.js"></script>
<script type="text/javascript" src="codemirror/mode/htmlmixed/htmlmixed.js"></script>
<script type="text/javascript" src="js/codemirror.overlayParser.js"></script>
<script type="text/javascript" src="js/vkbeautify.js"></script>
<script type="text/javascript" src="js/jquery.keyvalueeditor.js"></script>
<script type="text/javascript" src="js/jquery.hotkeys.js"></script>
<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="js/jquery.jscrollpane.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="js/bootstrap-modal.js"></script>
<script type="text/javascript" src="js/handlebars.js"></script>
<script type="text/javascript" src="js/templates.js"></script>
<script type="text/javascript" src="js/requester.js"></script>
</body>
</html>
