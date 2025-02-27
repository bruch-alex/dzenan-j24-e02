package com.example.webdemo.controller.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller and @ResponseBody can be replaced by @RestController
//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

//  @RequestMapping(method = RequestMethod.GET)
  @GetMapping
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping(value = "/from-spring")
  public String helloFromSpring() {
    return "Hello from Spring MVC application!";
  }

}
