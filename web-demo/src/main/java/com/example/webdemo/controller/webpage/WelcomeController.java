package com.example.webdemo.controller.webpage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {

  @GetMapping
  public String welcome(Model model) {
    model.addAttribute("welcomeText",
        "This is welcome text which is provided to the page dynamically!");
    return "welcome";
  }

  // path needs to be /welcome/everybody
  @GetMapping("/everybody")
  public String welcomeEverybody() {
    return "welcomeEverybody";
  }
}
