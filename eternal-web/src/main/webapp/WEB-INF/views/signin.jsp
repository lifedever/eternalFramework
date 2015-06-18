<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/taglibs.jsp" %>
<div class="container">
    <div class="row  margin20-t">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading bordered-b">
                    <span class="font-large">登录您的<spring:message code="app_title"/>账户</span>
                </div>
                <div class="panel-body">
                    <form>
                        <div class="form-group">
                            <label for="username">用户名</label>

                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input type="text" class="form-control" id="username" placeholder="不能超过10个字符">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password">密码</label>

                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" id="password" placeholder="最少6个字符">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">登录</button>
                        <a href="/signup" class="btn btn-default">注册</a>
                    </form>
                </div>
                <div class="panel-footer text-info">
                    <strong>进入<spring:message code="app_title"/>，享受健康生活！</strong>
                </div>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
