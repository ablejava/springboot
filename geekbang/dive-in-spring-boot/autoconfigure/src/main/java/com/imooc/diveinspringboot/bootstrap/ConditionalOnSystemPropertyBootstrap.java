package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 系统属性条件引导类
 *
 * @author 小马哥
 * @since 2018/5/15
 */
public class ConditionalOnSystemPropertyBootstrap {

    /**
     * 当条件满足时，创建Bean为方法名helloWorld
     * @return
     */
    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "Mercy") //OnSystemPropertyCondition#matches()返回一个boolean
    public String helloWorld() {
        return "Hello,World 小马哥";
    }

    /**
     * 基于条件装配
     *
     *@Conditional
     *
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        // 通过名称和类型获取 helloWorld Bean
        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
