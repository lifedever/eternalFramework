<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/taglibs.jsp"%>

<layout:front>
    <jsp:attribute name="css"></jsp:attribute>
    <jsp:attribute name="main">
        <div class="row">
            <div class="col-md-12">
                <table class="table">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>用户名</th>
                        <th>密码</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user" varStatus="i">
                        <tr>
                            <td>${i.index + 1}</td>
                            <td>${user.username}</td>
                            <td>${user.password}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="js">
    </jsp:attribute>
</layout:front>