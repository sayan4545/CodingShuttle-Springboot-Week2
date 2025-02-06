package com.springbootweb.springboot.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class MainController {
    @GetMapping("/home")
    public ResponseEntity<ModelAndView> modelAndView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("view");
        mav.addObject("message","Welcome to SpringMVC!!");
        //Map<String, Object> newmap = mav.getModel();
        return new ResponseEntity<>(mav,HttpStatus.CREATED);
    }
}
