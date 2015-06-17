package io.github.eternalpro.web.config;

import io.github.eternalpro.web.config.spring.I18NConfigurtion;
import io.github.eternalpro.web.config.spring.JPAConfiguration;
import io.github.eternalpro.web.config.spring.WebResolverConfiguration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
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
        ctx.register(WebResolverConfiguration.class);
        ctx.setServletContext(container);
        /* add ContextLoaderListener */
        container.addListener(new ContextLoaderListener(ctx));
        /* charEncodingfilter */
        FilterRegistration charEncodingfilter = container.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        charEncodingfilter.setInitParameter("encoding", "UTF-8");
        charEncodingfilter.setInitParameter("forceEncoding", "true");
        charEncodingfilter.addMappingForUrlPatterns(null, false, "/*");

        /* openEntityManagerInViewFilter */
        FilterRegistration openEntityManagerInViewFilter = container.addFilter("openEntityManagerInViewFilter", OpenEntityManagerInViewFilter.class);
        openEntityManagerInViewFilter.addMappingForUrlPatterns(null, false , "/*");

        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
