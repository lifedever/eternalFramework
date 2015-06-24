package io.github.eternalpro.web.config;

import io.github.eternalpro.mvc.config.WebInitUtils;
import io.github.eternalpro.mvc.config.spring.I18NConfigurtion;
import io.github.eternalpro.mvc.config.spring.JPAConfiguration;
import io.github.eternalpro.web.config.spring.WebResolverConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 全局web配置，使spring mvc生效
 */
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(JPAConfiguration.class);
        ctx.register(I18NConfigurtion.class);
        ctx.register(WebResolverConfiguration.class);
        ctx.setServletContext(context);
        /* add ContextLoaderListener */
        context.addListener(new ContextLoaderListener(ctx));
        /* charEncodingfilter  support */
        WebInitUtils.addCharEncodingfilter(context);
        /* openEntityManagerInViewFilter support */
        WebInitUtils.addOpenEntityManagerInViewFilter(context);
        /* shiro filter support */
        WebInitUtils.addShiroFilter(context);
        ServletRegistration.Dynamic servlet = context.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

        
    }
}
