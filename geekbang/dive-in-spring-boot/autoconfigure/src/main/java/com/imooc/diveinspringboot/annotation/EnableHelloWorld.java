package com.imooc.diveinspringboot.annotation;

import com.imooc.diveinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *  激活 HelloWorld 模块
 *
 * @author 小马哥
 * @since 2018/5/14
 *
 * 基于注解驱动
 */
@Retention(RetentionPolicy.RUNTIME) // 在运行时可通过反射加载注解
@Target(ElementType.TYPE)
@Documented
// @Import(HelloWorldConfiguration.class)   // 基于注解驱动方式装配
@Import(HelloWorldImportSelector.class) // 基于接口编程方式
public @interface EnableHelloWorld {
}
