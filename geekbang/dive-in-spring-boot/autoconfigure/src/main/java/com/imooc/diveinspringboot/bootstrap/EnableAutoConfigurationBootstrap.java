package com.imooc.diveinspringboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableAutoConfiguration} 引导类
 *
 * @author 小马哥
 * @since 2018/5/15
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    /**
     * springboot实现自动装配的实现方法
     *
     * 1. 激活自动装配 - @EnableAutoConfiguration
     * 2. 实现自动装配 - XXXAutoConfiguration
     * 3. 配置自动装配实现 - META-INF/spring.factories
     *
     * @param args
     */
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld =
                context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();

    }
}
