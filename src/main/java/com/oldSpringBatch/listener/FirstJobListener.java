package com.oldSpringBatch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FirstJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("LISTENING BEFORE THE JOB EXECUTION - {}", jobExecution.getJobId());
        jobExecution.getExecutionContext().putString("author", "Eduardo Fontenele");

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("LISTENING AFTER THE JOB EXECUTION");
        log.info("{}", jobExecution.getExecutionContext().get("author"));
    }
}
