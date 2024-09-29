package com.oldSpringBatch.config;

import com.oldSpringBatch.listener.FirstJobListener;
import com.oldSpringBatch.listener.FirstStepListener;
import com.oldSpringBatch.processor.FirstItemProcessor;
import com.oldSpringBatch.reader.FirstItemReader;
import com.oldSpringBatch.service.ThirdTasklet;
import com.oldSpringBatch.writer.FirstItemWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Configuration
@Slf4j
public class SampleJob {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ThirdTasklet thirdTasklet;

    @Autowired
    private FirstJobListener firstJobListener;

    @Autowired
    private FirstStepListener firstStepListener;

    @Autowired
    private FirstItemReader firstItemReader;

    @Autowired
    private FirstItemProcessor firstItemProcessor;

    @Autowired
    private FirstItemWriter firstItemWriter;

    @Bean
    public Map<String, Job> jobs() {
        return Map.of("chunkJob", chunkJob(),
                "taskletJob", taskletJob());
    }

    private Job taskletJob() {
        return jobBuilderFactory.get("taskletJob")
                .start(taskletStep())
                .build();
    }

    public Job chunkJob() {
        return jobBuilderFactory.get("chunkJob")
                .start(chunkStep())
                .next(taskletStep())
                .build();
    }

    private Step chunkStep() {
        return stepBuilderFactory.get("chunkStep")
                .<Integer, Integer>chunk(3)
                .reader(firstItemReader)
                .processor(firstItemProcessor)
                .writer(firstItemWriter)
                .build();
    }

    private Step taskletStep() {
        return stepBuilderFactory.get("taskletStep")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        log.info("ALL DONE HERE IN THE SAMPLE JOB");
                        return RepeatStatus.FINISHED;
                    };
                }).build();
    }
}
