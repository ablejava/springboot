package com.imooc.diveinspringboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring framework 应用事件引导类
 *
 * @author 小马哥
 * @since 2018/5/17
 */
public class SpringApplicationEventBootstrap {

    /**
     * Spring 应用事件
     * 普通应用事件: ApplicationEvent
     * 应用上下文事件: ApplicationContextEvent Spring 应用监听器
     * 接口编程模型: ApplicationListener
     * 注解编程模型: @EventListener Spring 应用事广播器
     * 接口: ApplicationEventMulticaster 实现类: SimpleApplicationEventMulticaster
     * 执行模式:同步或异步
     * @param args
     */
    public static void main(String[] args) {
        // 创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听到事件: " + event);
        });

        // 启动上下文
        context.refresh();
        // 发送事件
        context.publishEvent("HelloWorld");
        context.publishEvent("2018");
        context.publishEvent(new ApplicationEvent("小马哥") {

        });

        // 关闭上下文
        context.close();
    }
}
