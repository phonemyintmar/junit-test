package com.example.junit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestServiceTest {

    @Test
    public void testtFirst(){
        Assertions.assertEquals("Hello World",greet());
    }
}