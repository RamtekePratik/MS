package com.mastercard.demo.demo.scheduling;

import org.apache.http.client.utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MinuteSchedular {

    private static final Logger LOGGER = LogManager.getLogger(MinuteSchedular.class);

    //@Scheduled(cron = "* * * * * ?")
    public void everyMinuteJob()
    {
        System.out.println("Scheduling Worked on : "+ LocalDateTime.now());
        LOGGER.debug("Scheduling Worked on : "+ LocalDateTime.now());
    }
}
