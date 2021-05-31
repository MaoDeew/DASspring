package com.das.dasspring.control.controlCargas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    private ArrayList<Controlador> controlador = new ArrayList<>();

    @Bean(name = "taskExecutor")
    public Executor taskExecutor(){
        try {
            controlador.add(new Controlador());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("userThread");
        executor.initialize();
        this.controlador.get(0).Concurrencia();
        return executor;
    }
}
