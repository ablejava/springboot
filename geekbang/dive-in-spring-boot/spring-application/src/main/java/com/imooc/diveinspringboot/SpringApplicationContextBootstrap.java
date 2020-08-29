package com.imooc.diveinspringboot;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring 应用上下文 引导类
 *
 * @author 小马哥
 * @since 2018/5/17
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {

    /**
     * springboot的事件监听机制
     *Spring Boot 通过 SpringApplicationRunListener 的实现类 EventPublishingRunListener 利用 Spring Framework 事件
     * API ，广播 Spring Boot 事件。
     *
     * 自定义事件监听器，读取application.property文件中的属性
     * 实现类：BeforeConfigFileApplicationListener
     *      加载配置资源: META-INF/spring.factories
     *         排序: AnnotationAwareOrderComparator#sort，
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Web Reactive: AnnotationConfigReactiveWebServerApplicationContext
         * Web Servlet: AnnotationConfigServletWebServerApplicationContext
         * 非 Web: AnnotationConfigApplicationContext
         */
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
//                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("ConfigurableApplicationContext 类型：" + context.getClass().getName());
        /**
         * Web Reactive: StandardEnvironment
         * Web Servlet: StandardServletEnvironment
         * 非 Web: StandardEnvironment
         */
        System.out.println("Environment 类型：" + context.getEnvironment().getClass().getName());

        // 关闭上下文
        context.close();
    }
}
