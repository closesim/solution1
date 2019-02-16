package com.solution.solution.service;

import com.solution.solution.model.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppService implements AppServiceInt, InitializingBean {

    /**
     * Service method to process the collection
     *
     * @param dataList the data
     * @return most recent 5 elements
     */
    public List<Data> sendList(List<Data> dataList) {
        int skip = amountSkip(dataList.size());
        List<Data> resultData = dataList.stream().skip(Math.max(0, skip)).collect(Collectors.toList());
        Collections.reverse(resultData);
        return resultData;
    }

    /**
     * The amount of elements to skip
     * @param size size of collection
     * @return number of elements to skip
     */
    private int amountSkip(int size) {
        if (size <= 5) return 0;
        return size - 5;
    }

    @PostConstruct
    public void springPostConstruct() {
        System.out.println("---AppService PostConstruct---");
    }

    @PreDestroy
    public void springPreDestroy() {
        System.out.println("---AppService PreDestroy---");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---AppService.afterPropertiesSet---");
    }
}
