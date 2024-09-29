package com.oldSpringBatch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JobRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Map<String, Job> jobs;

    public JobRunner(Map<String, Job> jobs) {
        this.jobs = jobs;
    }

    @Async
    public void runJob(String jobName) {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        try {
            switch (jobName) {
                case "Monique":
                    jobLauncher.run(jobs.get("chunkJob"), jobParameters);
                    break;
                case "Eduardo":
                    jobLauncher.run(jobs.get("taskletJob"), jobParameters);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
