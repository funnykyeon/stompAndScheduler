package com.example.stompandscheduler;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;

/**
 * 스케줄 동기화로 구독시 주기적인 메세지 전송
 */
@EnableScheduling
@AllArgsConstructor
@Configuration
public class SchedulerConfig {

    private static final Logger LOGGER = LogManager.getLogger(SchedulerConfig.class);
    private final GreetingRepository greetingRepository;

    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 3000)
    public void sendAdhocMessages() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        LOGGER.info("sendAdhocMessages:" + timeStamp.toString());
        Greeting greeting = new Greeting("Thanks for your subscription" + timeStamp);
        template.convertAndSend("/topic/greetings", greeting);
        greetingRepository.save(greeting);

    }
}
