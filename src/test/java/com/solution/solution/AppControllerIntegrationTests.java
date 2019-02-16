package com.solution.solution;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solution.solution.controller.AppController;
import com.solution.solution.model.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Controller  testing case
 *
 * @Author Miguel Borja
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppControllerIntegrationTests {


    @Autowired
    protected WebApplicationContext wac;
    MockMvc mockMvc;
    @Autowired
    AppController appController;


    private List<Data> data1;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.appController).build();// Standalone context

        data1 = new LinkedList<>();
        data1.add(new Data("e1"));
        data1.add(new Data("e2"));
        data1.add(new Data("e3"));
        data1.add(new Data("e4"));
        data1.add(new Data("e5"));
        data1.add(new Data("e6"));
    }

    @Test
    public void test1() throws Exception {

        mockMvc.perform(post("/test/recent").content(asJsonString(data1)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].value", is("e6")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].value", is("e5")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].value", is("e4")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].value", is("e3")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[4].value", is("e2")));
    }

}
