<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
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
                        <%=exception.getMessage()%>
                    </div>
                    <div>
                        <a href="#">返回首页</a>

                    </div>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
    </div>
    <widget:footer/>
</body>
</html>
