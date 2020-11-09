package com.example.demo.Servive;

import com.example.demo.Annotation.SystemServiceLog;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @SystemServiceLog(description = "Test Service")
    public String test(){
        return "Test Service Done";
    }
}
