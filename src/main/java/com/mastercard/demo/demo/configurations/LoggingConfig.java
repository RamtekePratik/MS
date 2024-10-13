package com.mastercard.demo.demo.configurations;

import com.mastercard.demo.demo.configurations.conditional.MyConditionalBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

    @Bean
    @ConditionalOnProperty(name = "logging.enabled", havingValue = "true")
    public MyConditionalBean myConditionalBean()
    {
        return new MyConditionalBean();
    }


}
