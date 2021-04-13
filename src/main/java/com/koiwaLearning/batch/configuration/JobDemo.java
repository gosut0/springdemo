package com.koiwaLearning.batch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job jobDemoJob() {
        return jobBuilderFactory.get("jobDemoJob")
                // 普通的执行顺序
//                .start(demoStep1())
//                .next(demoStep2())
//                .next(demoStep3())
//                .build();

                // 追加条件的执行顺序  还有一些别的方法  fail stopAndRestart
                .start(demoStep1()).on("COMPLETED").to(demoStep2())
                .from(demoStep2()).on("COMPLETED").to(demoStep3())
                .from(demoStep3()).end()
                .build();
    }

    @Bean
    public Step demoStep1() {
        return stepBuilderFactory.get("demoStep1").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("demoStep1....");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step demoStep2() {
        return stepBuilderFactory.get("demoStep2").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("demoStep2....");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step demoStep3() {
        return stepBuilderFactory.get("demoStep3").tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("demoStep3....");
                return RepeatStatus.FINISHED;
            }
        }).build();
    }
}
