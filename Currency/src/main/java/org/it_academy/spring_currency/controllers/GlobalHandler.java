package org.it_academy.spring_currency.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    public List<Map<String, String>> handle(IllegalArgumentException exception) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", exception.getMessage());
        return mapList;
    }

    @ExceptionHandler
    public List<Map<String, String>> handle(JsonProcessingException exception) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", exception.getMessage());
        return mapList;
    }

    @ExceptionHandler
    public List<Map<String, String>> handle(JsonMappingException exception) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", exception.getMessage());
        return mapList;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public List<Map<String, String>> handle(Throwable exception) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("logref", "error");
        map.put("message", exception.getMessage());
        return mapList;
    }
}
