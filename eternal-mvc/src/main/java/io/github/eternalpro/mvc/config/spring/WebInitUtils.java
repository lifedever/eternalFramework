package io.github.eternalpro.mvc.config.spring;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.EnumSet;
import java.util.HashSet;

/**
 * 初始化web工具类
 * Created by gefangshuai on 2015/6/19.
 */
public class WebInitUtils {

    /**
     * utf8编码保持拦截器
     * @param context
     */
    public static void addCharEncodingfilter(ServletContext context) {
        FilterRegistration charEncodingfilter = context.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        charEncodingfilter.setInitParameter("encoding", "UTF-8");
        charEncodingfilter.setInitParameter("forceEncoding", "true");
        charEncodingfilter.addMappingForUrlPatterns(null, false, "/*");
    }

    /**
     * hibernate session
     * @param context
     */
    public static void addOpenEntityManagerInViewFilter(ServletContext context){
        FilterRegistration openEntityManagerInViewFilter = context.addFilter("openEntityManagerInViewFilter", OpenEntityManagerInViewFilter.class);
        openEntityManagerInViewFilter.addMappingForUrlPatterns(null, false , "/*");
    }

    /**
     * shiro filter
     * @param context
     */
    public static void addShiroFilter(ServletContext context) {
        FilterRegistration shiroFilter = context.addFilter("shiroFilter", DelegatingFilterProxy.class);
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR, DispatcherType.INCLUDE);
        shiroFilter.addMappingForUrlPatterns(dispatcherTypes, false , "/*");
    }
}
