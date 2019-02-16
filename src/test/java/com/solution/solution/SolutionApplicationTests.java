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

import static org.junit.Assert.assertEquals;

/**
 * Unit tests
 *
 * @Author Miguel Borja
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SolutionApplicationTests {

    private List<Data> data1;
    private List<Data> data2;
    private List<Data> data3;
    @Autowired
    private AppService appService;

    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp() {
        data1 = new LinkedList<>();
        data1.add(new Data("e1"));
        data1.add(new Data("e2"));
        data1.add(new Data("e3"));
        data1.add(new Data("e4"));
        data1.add(new Data("e5"));
        data1.add(new Data("e6"));

        data2 = new LinkedList<>();
        data2.add(new Data("e1"));
        data2.add(new Data("e2"));
        data2.add(new Data("e3"));

        data3 = new LinkedList<>();
        data3.add(new Data("e3"));
        data3.add(new Data("e1"));
        data3.add(new Data("e6"));
        data3.add(new Data("e0"));
        data3.add(new Data("e9"));
        data3.add(new Data("e8"));

    }

    @Test
    public void test() {
        List<Data> expectedResult = new LinkedList<>();
        expectedResult.add(data1.get(5));
        expectedResult.add(data1.get(4));
        expectedResult.add(data1.get(3));
        expectedResult.add(data1.get(2));
        expectedResult.add(data1.get(1));

        List<Data> result = appService.sendList(data1);

        assertEquals(result, expectedResult);
    }

    @Test
    public void test2() {
        List<Data> expectedResult = new LinkedList<>();
        expectedResult.add(data2.get(2));
        expectedResult.add(data2.get(1));
        expectedResult.add(data2.get(0));

        List<Data> result = appService.sendList(data2);

        assertEquals(result, expectedResult);
    }

    @Test
    public void test3() {
        List<Data> expectedResult = new LinkedList<>();
        expectedResult.add(data3.get(5));
        expectedResult.add(data3.get(4));
        expectedResult.add(data3.get(3));
        expectedResult.add(data3.get(2));
        expectedResult.add(data3.get(1));

        List<Data> result = appService.sendList(data3);

        assertEquals(result, expectedResult);
    }

}

