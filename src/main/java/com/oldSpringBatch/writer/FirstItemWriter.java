package com.oldSpringBatch.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FirstItemWriter implements ItemWriter<Integer> {
    @Override
    public void write(List<? extends Integer> list) throws Exception {
        System.out.println("Inside item writer");

        list.forEach(System.out::println);
    }
}
