package com.solution.solution;

import com.solution.solution.model.Data;
import com.solution.solution.service.AppService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Service test case
 *
 * @Author Miguel Borja
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceIntegrationTest {
    @Autowired
    AppService service;

    private List<Data> data1;

    @Before
    public void setUp() {
        data1 = new LinkedList<>();
        data1.add(new Data("e1"));
        data1.add(new Data("e2"));
        data1.add(new Data("e3"));
        data1.add(new Data("e4"));
        data1.add(new Data("e5"));
        data1.add(new Data("e6"));
    }

    @Test
    public void test1() {
        List<Data> data = service.sendList(data1);
        assertThat(data).isNotNull().isNotEmpty();
    }
}
