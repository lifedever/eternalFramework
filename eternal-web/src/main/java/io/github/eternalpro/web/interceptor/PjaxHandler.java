package io.github.eternalpro.web.interceptor;

import io.github.eternalpro.web.core.annotation.Pjax;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * pjax 后端相应 Handler
 * Created by gefangshuai on 2015/6/18.
 */
@Component
public class PjaxHandler extends HandlerInterceptorAdapter {

    private Logger logger = Logger.getLogger(PjaxHandler.class);

    /**
     * controller执行完，跳转视图之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String _pjax = request.getParameter("_pjax");
        if (StringUtils.isNotBlank(_pjax)) {
            logger.debug("pjax container: " + _pjax);
        }
        if (StringUtils.isBlank(_pjax) && hasPjaxAnnotation((HandlerMethod) handler)) {
            logger.debug("--- render layout ! --- ");
            response.setHeader("X-PJAX-URL", request.getServletPath().trim());
            modelAndView.setViewName("layout/home");
            request.setAttribute("isPjax", "true");
        }else{
            request.setAttribute("isPjax", "false");
        }
    }

    private boolean hasPjaxAnnotation(HandlerMethod handler) {
        return handler.getMethod().isAnnotationPresent(Pjax.class);
    }
}
