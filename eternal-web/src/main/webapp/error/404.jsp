<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/taglibs.jsp" %>
<html>
<head>
    <title><spring:message code="app_title"/></title>
    <static:css/>
</head>
<body>
<widget:nav/>
<div class="container">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <div class="alert alert-danger" role="alert">
                <div>
                    页面找不到！
                </div>
                <div class="margin10-t">
                    <a class="text-danger" href="/">返回首页</a>
                    |
                    <a href="javascript:history.go(-1)">返回上一页</a>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<widget:footer/>
</body>
</html>
