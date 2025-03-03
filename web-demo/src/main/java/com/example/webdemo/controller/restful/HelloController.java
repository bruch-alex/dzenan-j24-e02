package com.example.webdemo.controller.restful;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

// @Controller and @ResponseBody can be replaced by @RestController
//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

  private final List<String> userNames = List.of("Mickey", "Minnie", "Donald", "Goofy");

  //  @RequestMapping(method = RequestMethod.GET)
  @GetMapping
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping(value = "/from-spring")
  public String helloFromSpring() {
    return "Hello from Spring MVC application!";
  }

  @GetMapping({"/random-number", "/random-number/{times}"})
  public List<Integer> randomNumber(
      @PathVariable(required = false) Integer times,
      @RequestParam(required = false, defaultValue = "true") boolean multiple)
  {
    if (times == null) {
      times = 1;
    }
    int randomNumber = (int) (Math.random() * 100);
    List<Integer> randomNumberList = new ArrayList<>();
    if (multiple) {
      for (int i = 0; i < times; i++) {
        randomNumberList.add(randomNumber);
      }
    } else {
      randomNumberList.add(randomNumber);
    }

    return randomNumberList;
  }

  @GetMapping("/users/names/{userName}/{times}")
  public List<String> getUserNames(
      @PathVariable String userName,
      @PathVariable(value = "times") Integer numberOfTimes
  ) {
    List<String> userNameMultipleTimes = new ArrayList<>();
    if (userNames.contains(userName)) {
      for (int i = 0; i < numberOfTimes; i++) {
        userNameMultipleTimes.add(userName);
      }
    } else {
      throw new RuntimeException(String.format("User with name %s not found", userName));
    }

    return userNameMultipleTimes;
  }

}





