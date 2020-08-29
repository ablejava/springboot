package com.imooc.web.servlet.support;

import com.imooc.web.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * springmvc3.1到自动装配，依赖servlet3.0规范
 * servlet提供的实现接口
 *  spi接口：ServletContainerInitializer
 *  spring的适配：SpringServletContainerInitializer
 *
 *
 * Spring Web MVC 自动装配 默认实现
 *  spi接口基础接口: WebApplicationInitializer
 *  编程驱动: AbstractDispatcherServletInitializer
 *  注解驱动: AbstractAnnotationConfigDispatcherServletInitializer
 *
 * @author 小马哥
 * @since 2018/5/21
 */
public class DefaultAnnotationConfigDispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { // web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { // DispatcherServlet
        return new Class[]{DispatcherServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
