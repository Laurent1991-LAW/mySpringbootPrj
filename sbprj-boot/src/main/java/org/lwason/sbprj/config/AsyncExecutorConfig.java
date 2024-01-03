package org.lwason.sbprj.config;


import lombok.extern.slf4j.Slf4j;
import org.lwason.sbprj.decorator.MyTaskDecorator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@EnableAsync
@Configuration
public class AsyncExecutorConfig implements AsyncConfigurer {

    @Value("${async.executor. thread. corePoolSize:6}")
    private Integer corePoolSize;
    @Value("${async.executor.thread.maxPoolSize:16}")
    private Integer maxPoolSize;
    @Value("${async. executor. thread.queueCapacity:200}")
    private Integer queueCapacity;
    @Value("${async, executor. thread.name.prefix:my_async_task_}")
    private String namePrefix;

    @Override
    @Bean
    @Primary
    public Executor getAsyncExecutor() {
        log.info("ThreadPoolTaskExecutor init begins");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(namePrefix);
        executor.setTaskDecorator(new MyTaskDecorator());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        log.info("ThreadPoolTaskExecutor init ends");
        return executor;
    }
}
