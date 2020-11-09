package com.example.demo.Controller;

import com.example.demo.Annotation.SystemControllerLog;
import com.example.demo.Servive.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("get")
    @SystemControllerLog(description = "Test Get")
    public String get(){
        return "Test Get Done";
    }

    @PostMapping("post")
    @SystemControllerLog(description = "Test Post")
    public String post(){
        return "Test Post Done";
    }

    @GetMapping("service")
    public String service(){
        return testService.test();
    }
}
