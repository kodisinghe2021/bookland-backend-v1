package org.nksofttech.authservice.service;

import org.nksofttech.authservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "USER-PROFILE-SERVICE")
public interface APIClientUser {
  @GetMapping("/api/user/get-user-by-mobile/{user-mobile}")
  UserDto getUserByMobile(@PathVariable(value = "user-mobile") String userMobile);

  @PostMapping("/api/user/save")
  UserDto saveUser(@RequestBody UserDto user);
}
