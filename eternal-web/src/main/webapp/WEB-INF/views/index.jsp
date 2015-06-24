<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/taglibs.jsp" %>

<layout:front>
    <jsp:attribute name="css"></jsp:attribute>
    <jsp:attribute name="main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="jumbotron text-center">
                        <h1>欢迎访问 <spring:message code="app_title"/> !</h1>
                        <a href="/signup" class="btn btn-primary btn-lg">&nbsp;&nbsp;注册&nbsp;&nbsp;</a>
                        <a href="/signin" class="btn btn-default btn-lg">&nbsp;&nbsp;登录&nbsp;&nbsp;</a>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="js">
    </jsp:attribute>
</layout:front>