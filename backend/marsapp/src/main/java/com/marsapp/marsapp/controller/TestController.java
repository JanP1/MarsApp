package com.marsapp.marsapp.controller;

import com.marsapp.marsapp.model.Test;
import com.marsapp.marsapp.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    // Get all rows
    @GetMapping
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    // Add a new row
    @PostMapping
    public Test create(@RequestBody Test test) {
        return testRepository.save(test);
    }

    // Update a row
    @PutMapping("/{id}")
    public Test update(@PathVariable Long id, @RequestBody Test testDetails) {
        Test test = testRepository.findById(id).orElseThrow();
        test.setName(testDetails.getName());
        return testRepository.save(test);
    }

    // Delete a row
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        testRepository.deleteById(id);
    }
}
