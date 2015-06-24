<%@tag pageEncoding="UTF-8"  body-content="empty"%>
<%@include file="/taglibs.jsp"%>

<nav class="navbar navbar-masthead navbar-default navbar-toolbar navbar-fixed-top">
    <div class="container-fluid bg-whitesmoke">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><spring:message code="app_title"/> </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="container">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/">Home <span class="sr-only">(current)</span></a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right" data-pjax>
                    <shiro:authenticated>
                        <li class="dropdown">
                            <a href="/logout" class="dropdown-toggle" data-toggle="dropdown">
                                <shiro:principal/>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin">控制面板</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/logout">退出</a></li>
                            </ul>
                        </li>
                    </shiro:authenticated>
                    <shiro:guest>
                        <li><a href="/signup">注册</a></li>
                        <li><a href="/signin">登录</a></li>
                    </shiro:guest>
                </ul>
            </div>
        </div>
    </div>
</nav>