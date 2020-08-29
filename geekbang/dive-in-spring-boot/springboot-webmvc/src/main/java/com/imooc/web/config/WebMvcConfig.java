package com.imooc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring Web MVC 配置（类）
 *
 * @author 小马哥
 * @since 2018/5/20
 */
@Configuration
/**
 * 取消EnableWebMvc注解,
 * 在WebMvcAutoConfiguration中标注了@ConditionalOnMissingBean({WebMvcConfigurationSupport.class})
 * 在spring.factories中 #EnableAutoConfiguration=会自动装配WebMvcAutoConfiguration
 *
 * 当WebMvcConfigurationSupport类不存在时使用application.property中的自动配置
 * 由于注解@EnableWebMvc 会加载DelegatingWebMvcConfiguration类，这个类是WebMvcConfigurationSupport的子类，如果不标注这个注解
 * 那么者子类就不会创建，父类WebMvcConfigurationSupport就也不回创建，当这个父类不会创建时，就会使用application.property中当自动配置
 */
 // @EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

//     <!--<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
//        <!--<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
//        <!--<property name="prefix" value="/WEB-INF/jsp/"/>-->
//        <!--<property name="suffix" value=".jsp"/>-->
//    <!--</bean>-->
//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                System.out.println("拦截中...");
                return true;
            }
        });
    }
}
