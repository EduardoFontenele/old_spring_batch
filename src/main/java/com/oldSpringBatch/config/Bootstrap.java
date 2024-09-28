package com.oldSpringBatch.config;

import com.oldSpringBatch.service.JobRunner;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final JobRunner jobRunner;

    @Override
    public void run(String... args) throws Exception {
        jobRunner.runJob();
    }
}
