package io.github.eternalpro.api.config;

import io.github.eternalpro.api.config.spring.APIResolverConfiguration;
import io.github.eternalpro.mvc.config.WebInitUtils;
import io.github.eternalpro.mvc.config.spring.I18NConfigurtion;
import io.github.eternalpro.mvc.config.spring.JPAConfiguration;
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
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(JPAConfiguration.class);
        ctx.register(I18NConfigurtion.class);
        ctx.register(APIResolverConfiguration.class);
        ctx.setServletContext(container);
        /* add ContextLoaderListener */
        container.addListener(new ContextLoaderListener(ctx));
       /* charEncodingfilter */
        WebInitUtils.addCharEncodingfilter(container);
        /* openEntityManagerInViewFilter */
        WebInitUtils.addOpenEntityManagerInViewFilter(container);

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
