package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LeakController {

    private final List<String> memoryLeakList = new ArrayList<>();

    @GetMapping("/leak")
    public String leakMemory() {
        for (int i = 0; i < 1000; i++) {
            memoryLeakList.add("Leaking memory... " + System.currentTimeMillis());
        }
        return "Memory leaking...";
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to the memory leak demo!";
    }
}
