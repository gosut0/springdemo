package com.koiwaLearning.batch.configuration;

import com.koiwaLearning.batch.listener.MyChunkListener;
import com.koiwaLearning.batch.listener.MyJobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class ListenerDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job listenerJob() {
        return jobBuilderFactory.get("listenerJob")
                .start(listenerStep1())
                .listener(new MyJobListener())
                .build();
    }

    @Bean
    public Step listenerStep1() {

        return stepBuilderFactory.get("listenerStep1")
                .<String, String>chunk(2)  // 每读完指定的数据，在进行输出处理, 泛型表明，读取String  输出String
                .faultTolerant()
                .listener(new MyChunkListener())
                .reader(read())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemWriter<String> writer() {
        return new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> items) throws Exception {
                for (String str : items) {
                    System.out.println(str);
                }
            }
        };
    }

    @Bean
    public ItemReader<String> read() {
        return new ListItemReader<>(Arrays.asList("aaa","bbb","ccc","ddd","eee","fff"));
    }
}
