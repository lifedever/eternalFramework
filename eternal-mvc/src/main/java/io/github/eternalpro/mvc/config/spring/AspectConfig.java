package io.github.eternalpro.mvc.config.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by gefangshuai on 2015/6/23.
 */
@Aspect
@ImportResource("classpath:/aop-config.xml")
public class AspectConfig {
    @Pointcut("@within(org.springframework.stereotype.Service)")
    public void serviceAnnotatedClass() {}
}
