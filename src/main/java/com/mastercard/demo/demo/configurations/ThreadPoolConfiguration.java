package com.mastercard.demo.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfiguration {


    @Bean
    public ThreadPoolTaskExecutor taskExecutor()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setKeepAliveSeconds(1);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("Thread Pool Executor - ");
        executor.initialize();

        return executor;
    }
}
