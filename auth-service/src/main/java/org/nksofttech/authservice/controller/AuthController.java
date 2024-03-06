package org.nksofttech.authservice.controller;

import org.nksofttech.authservice.dto.UserDto;
import org.nksofttech.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  private AuthService authService;
  @GetMapping("login-by-mobile")
  public String loginByMobile(@RequestParam(value = "mobile-number") String username, @RequestParam String password) {
    return username+" "+password;
  }

  @GetMapping("registration-by-mobile")
  public UserDto regByMobile(@RequestParam(value = "mobile-number") String username, @RequestParam String password) {
   UserDto userDto = authService.getUserFromMobile(username,password);
    return userDto;
  }

  @GetMapping("get-user-data")
  public UserDto regByMobile() {
   UserDto d = authService.getUser();
    return d;
  }

}
