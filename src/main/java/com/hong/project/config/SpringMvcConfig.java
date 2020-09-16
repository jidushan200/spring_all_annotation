package com.hong.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @EnableWebMvc开启处理器高级功能
 */

@Configuration
@ComponentScan("com.hong.project.web")
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurationSupport {
    /**
     * @Description：配置视图解析器
     */
    @Bean("viewResolver")
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * @Description：转发委派未处理的请求,将DispatchServlet映射到“/”
     * @Detail： 通过转发到Servlet容器的“默认” Servlet，配置处理程序以委派未处理的请求。
     * 常见的用法是将DispatcherServlet映射到“/”，从而覆盖Servlet容器对静态资源的默认处理。
     */
    @Override
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        /**
         * Enable forwarding to the "default" Servlet identified by the given name.
         * This is useful when the default Servlet cannot be autodetected,
         */
        configurer.enable();
    }
}
