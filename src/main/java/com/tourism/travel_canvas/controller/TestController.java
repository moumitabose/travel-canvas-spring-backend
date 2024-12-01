package com.tourism.travel_canvas.controller;


import com.tourism.travel_canvas.model.Test;
import com.tourism.travel_canvas.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {

    @Autowired
private TestService testService;

    @PostMapping("/testsave")
    public Test saveTestDetails(@RequestBody Test test)
    {
      return testService.saveTestDetails(test);
    }
}
