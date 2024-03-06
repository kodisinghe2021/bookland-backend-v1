package org.nksofttech.userprofileservice.controller;

import lombok.AllArgsConstructor;
import org.nksofttech.userprofileservice.dto.UserDto;
import org.nksofttech.userprofileservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
  private UserService userService;

//  @PostMapping("/save")
//  private UserDto saveUser(@RequestBody UserDto user) {
//    UserDto userDto = userService.saveUser(user);
//    return userDto;
//  }

  @PostMapping("/registration-mobile")
  private String regByMobile(@RequestBody UserDto user) {
    String jwtToken = userService.registerUser(user);
    return jwtToken;
  }

//  @GetMapping("/get/{user-mobile}")
//  private UserDto getUser(@PathVariable(value = "user-mobile") String userMobile) {
//    return userService.getUserByMobile(userMobile);
//  }

}
