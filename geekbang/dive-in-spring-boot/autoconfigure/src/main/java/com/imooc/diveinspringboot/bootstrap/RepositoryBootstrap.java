package com.imooc.diveinspringboot.bootstrap;

import com.imooc.diveinspringboot.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 仓储的引导类
 *
 * @author 小马哥
 * @since 2018/5/14
 */
@ComponentScan(basePackages = "com.imooc.diveinspringboot.repository")
public class RepositoryBootstrap {

    /**
     * spring中bean的层次性，将MyFirstLevelRepository定义为一个Repository的bean
     * @Repository
     *      @FirstLevelRepository
     *          @SecondLevelRepository
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // myFirstLevelRepository Bean 是否存在
        MyFirstLevelRepository myFirstLevelRepository =
                context.getBean("myFirstLevelRepository",MyFirstLevelRepository.class);

        System.out.println("myFirstLevelRepository Bean : "+myFirstLevelRepository);

        // 关闭上下文
        context.close();
    }
}
