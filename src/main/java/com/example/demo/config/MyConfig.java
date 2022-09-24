package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

@Configuration

/**
 * @Configuration：指明当前类是一个配置类；就是来代替之前的Spring配置文件
 *
 * 在配置文件中用<bean></bean>标签添加组件
 */

public class MyConfig {
    //将方法的返回值添加到容器中；容器这个组件id就是方法名

}
