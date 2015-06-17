<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/taglibs.jsp" %>

<layout:front>
    <jsp:attribute name="css"></jsp:attribute>
    <jsp:attribute name="main">
        <div class="container">
            <div class="row  margin20-t">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading bordered-b">
                            <span class="font-large">创建您的永恒账户</span>
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
                                <div class="form-group">
                                    <label for="confirm_password">确认密码</label>

                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                        <input type="password" class="form-control" id="confirm_password" placeholder="最少6个字符">
                                    </div>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> 我同意 <a href="#" class="a-decoration">《网站协议》</a>
                                    </label>
                                </div>
                                <button type="submit" class="btn btn-primary">注册</button>
                                <a href="/signin" class="btn btn-default">登录</a>
                            </form>
                        </div>
                        <div class="panel-footer">
                            注册称为永恒用户，享受健康生活！
                        </div>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    </jsp:attribute>
    <jsp:attribute name="js">
    </jsp:attribute>
</layout:front>
