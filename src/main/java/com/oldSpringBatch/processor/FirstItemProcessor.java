package com.oldSpringBatch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class FirstItemProcessor implements ItemProcessor<Integer, Integer> {
    @Override
    public Integer process(Integer integer) throws Exception {
        System.out.println("Inside item processor");
        return integer;
    }
}
