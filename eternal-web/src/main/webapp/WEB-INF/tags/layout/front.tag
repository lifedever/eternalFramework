<%@tag pageEncoding="UTF-8" %>
<%@ include file="/taglibs.jsp" %>

<%@ attribute name="main" fragment="true" description="主体信息，注意：用jsp:attribute调用，不要把此标签设置到属性上" %>
<%@ attribute name="css" fragment="true" description="需要引入的额外的css信息或自定义的css，注意：用jsp:attribute调用，不要把此标签设置到属性上" %>
<%@ attribute name="js" fragment="true" description="需要引入的额外的js信息或自定义的js，注意：用jsp:attribute调用，不要把此标签设置到属性上" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <static:css/>
    <jsp:invoke fragment="css"/>
    <title><spring:message code="app_title"/> </title>
</head>
<body>
<div class="mainContainer">
    <jsp:invoke fragment="main"/>
</div>
<static:js/>
<jsp:invoke fragment="js"/>
</body>
</html>