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
            <a class="navbar-brand" href="#"><spring:message code="app_title"/> </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Link</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/signup">注册</a></li>
                <li><a href="#">登录</a></li>
            </ul>
        </div>
    </div>
</nav>