package io.github.eternalpro.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.Map;
import java.util.Properties;

/**
 * Created by gefangshuai on 2015/6/16.
 */
@Configuration
@ComponentScan("io.github.eternalpro.api")
@EnableWebMvc
public class APIResolverConfiguration extends WebMvcConfigurerAdapter{

    /**
     * config urlResolver
     * @return
     */
    @Bean
    public ViewResolver setupViewResolver() {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setContentNegotiationManager(getContentNegotiationManager());
        return viewResolver;
    }

    private ContentNegotiationManager getContentNegotiationManager() {
        ContentNegotiationManagerFactoryBean manager = new ContentNegotiationManagerFactoryBean();
        manager.setFavorParameter(true);
        manager.setFavorPathExtension(true);
        manager.setParameterName("mediaType");
        manager.setDefaultContentType(MediaType.APPLICATION_JSON);
        manager.setMediaTypes(getMediaTypes());
        return manager.getObject();
    }

    private Properties getMediaTypes() {
        Properties properties = new Properties();
        properties.setProperty("json", MediaType.APPLICATION_JSON_VALUE);
        properties.setProperty("xml", MediaType.APPLICATION_XML_VALUE);
        return properties;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

}
