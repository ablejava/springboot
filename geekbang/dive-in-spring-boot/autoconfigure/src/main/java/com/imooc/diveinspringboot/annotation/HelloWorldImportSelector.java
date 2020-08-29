package com.imooc.diveinspringboot.annotation;

import com.imooc.diveinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld {@link ImportSelector} 实现
 *
 * @author 小马哥
 * @since 2018/5/14
 */
public class HelloWorldImportSelector implements ImportSelector {

    /**
     * 比注解驱动方式装载更灵活
     * 可以在selectImports方法类根据条件返回要装配的哪个bean
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
