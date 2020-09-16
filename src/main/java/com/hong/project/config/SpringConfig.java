package com.hong.project.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(
        value = {"com.hong.project"},
        excludeFilters =
        @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {Controller.class, ControllerAdvice.class}
        )
)
public class SpringConfig {

}
