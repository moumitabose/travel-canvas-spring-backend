package com.tourism.travel_canvas.service;

import com.tourism.travel_canvas.model.Test;
import com.tourism.travel_canvas.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements  TestService{

    @Autowired
    private TestRepository testRepository;


    @Override
    public Test saveTestDetails(Test test) {
        return  testRepository.save(test);
    }
}
