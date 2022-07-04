package com.example.stompandscheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = { "com.example.stompandscheduler" })
@Import({WebSocketConfig.class, SchedulerConfig.class})
public class StompAndSchedulerApplication extends SpringBootServletInitializer {
    private static final Logger LOGGER = LogManager.getLogger(StompAndSchedulerApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StompAndSchedulerApplication.class);
    }

    public static void main(String[] args) {
        LOGGER.info("spring stomp application starts...");
        SpringApplication.run(StompAndSchedulerApplication.class, args);
    }

}
