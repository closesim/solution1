package com.solution.solution.controller;

import com.solution.solution.model.Data;
import com.solution.solution.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Miguel Borja
 */
@RestController
@RequestMapping(value = "/test")
public class AppController {

    @Autowired
    private AppService appService;

    @PostMapping(value = "/recent", produces = "application/json")
    public @ResponseBody List<Data> searchSync(@RequestBody List<Data> list) {
        return appService.sendList(list);
    }

}
