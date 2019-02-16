package com.solution.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Author Miguel Borja
 */

@SpringBootApplication
public class SolutionApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(SolutionApplication.class, args);
    }

}

