package com.imooc.diveinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication} 引导类
 *
 * @author 小马哥
 * @since 2018/5/16
 */
public class SpringApplicationBootstrap {

    /**
     * 深入理解springApplication的生命周期和作用域
     *
     * 根据当前应用 ClassPath 中是否存在相关实现类来推断 Web 应用的类型
     * org.springframework.boot.SpringApplication#deduceWebApplicationType()推断 Web 应用类型
     *
     *
     * 根据 Main 线程执行堆栈判断实际的引导类
     * org.springframework.boot.SpringApplication#deduceMainApplicationClass()推断引导类
     * ApplicationConfiguration，而是SpringApplicationBootstrap
     * @param args
     */
    public static void main(String[] args) {
//        SpringApplication.run(ApplicationConfiguration.class,args);

        Set<String> sources = new HashSet();
        /**
         *
         * 配置Class 名称
         *
         *
         * 技术
         *  加载应用事件监听器( ApplicationListener )
         *  利用 Spring 工厂加载机制，实例化 ApplicationListener 实现类，并排序对象集合
         *  SpringApplication 运行阶段
         *   实现类: org.springframework.core.io.support.SpringFactoriesLoader
         *      加载配置资源: META-INF/spring.factories
         *          排序: AnnotationAwareOrderComparator#sort， 如果没实现Order则默认不排序
         * 输出：
         * ConfigurableApplicationContext.id = org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@503f91c3
         * After application.id = application
         */
        sources.add(ApplicationConfiguration.class.getName());

        /**
         * springApplication准备阶段，就是SpringApplication()初始化阶段
         *
         * public SpringApplication(ResourceLoader resourceLoader, Class... primarySources) {
         *         this.sources = new LinkedHashSet();
         *         this.bannerMode = Mode.CONSOLE;
         *         this.logStartupInfo = true;
         *         this.addCommandLineProperties = true;
         *         this.headless = true;
         *         this.registerShutdownHook = true;
         *         this.additionalProfiles = new HashSet();
         *         this.resourceLoader = resourceLoader;
         *         Assert.notNull(primarySources, "PrimarySources must not be null");
         *         // 配置springboot bean的源，如@Configuration或xml
         *         this.primarySources = new LinkedHashSet(Arrays.asList(primarySources));
         *
         *         // 推断web的应用类型
         *         this.webApplicationType = this.deduceWebApplicationType();
         *
         */
                /**
                 *
                 * 利用 Spring 工厂加载机制，实例化 ApplicationContextInitializer 实现类，并排序对象集合。
                 *
                 * 实现类: org.springframework.core.io.support.SpringFactoriesLoader
                 * 配置资源: META-INF/spring.factories
                 * 排序: AnnotationAwareOrderComparator#sort
                 * @param args
                 */
         /**
         *         // 用 Spring 工厂加载机制加载应用上下文初始化器ApplicationContextInitializer
         *         this.setInitializers(this.getSpringFactoriesInstances(ApplicationContextInitializer.class));
         *
         *         // 加载应用监听器
         *         this.setListeners(this.getSpringFactoriesInstances(ApplicationListener.class));
         *
         *         // 推断引导类（Main Class）
         *         this.mainApplicationClass = this.deduceMainApplicationClass();
         *     }
         */
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        springApplication.run(args);

    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }

}
