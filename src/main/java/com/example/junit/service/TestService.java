package com.example.junit.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String greet() {
        System.out.println("Hello World");
        return "HW";
    }

    public String sell() {
        System.out.println("Hello World!");
        return "dr layy wal pr ohn ";
    }

    public String buy(String toBuy) {
        return toBuy;
    }
}
