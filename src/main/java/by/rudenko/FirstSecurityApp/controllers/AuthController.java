package by.rudenko.FirstSecurityApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/auth")
public class AuthController {

  @GetMapping("/login")
  public String loginPage() {
    return "auth/login";
  }
}
