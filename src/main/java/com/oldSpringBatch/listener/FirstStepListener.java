package com.oldSpringBatch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FirstStepListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
      log.info("-------- BEFORE STEP EXECUTION");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("-------- AFTER STEP EXECUTION");
        return null;
    }
}
