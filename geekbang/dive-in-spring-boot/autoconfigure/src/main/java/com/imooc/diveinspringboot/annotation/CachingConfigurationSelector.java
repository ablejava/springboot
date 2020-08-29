package com.imooc.diveinspringboot.annotation;

import com.imooc.diveinspringboot.configuration.HelloWorldConfiguration;
import org.springframework.cache.annotation.ProxyCachingConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld {@link ImportSelector} 实现
 *
 * @author 小马哥
 * @since 2018/5/14
 */
public class CachingConfigurationSelector extends AdviceModeImportSelector<EnableHelloWorld> {



    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        switch (adviceMode) {
            case PROXY:
                return new String[] { AutoProxyRegistrar.class.getName(), ProxyCachingConfiguration.class.getName() };
            case ASPECTJ:
                return new String[] {
                        AnnotationConfigUtils.CONFIGURATION_ANNOTATION_PROCESSOR_BEAN_NAME

                };
            default:
                return new String[]{HelloWorldConfiguration.class.getName()};

        }
    }
}
