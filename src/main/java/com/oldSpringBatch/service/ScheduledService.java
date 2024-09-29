package com.oldSpringBatch.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Scheduled(cron = "*/10 * * * * *")
    public void printHi() {
        System.out.println("HI, SOMEONE THERE?");
    }
}
