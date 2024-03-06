package org.nksofttech.authservice.service;

import org.nksofttech.authservice.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
  @Autowired
  private APIClientUser apiClientUser;

  public UserDto getUser(){
  UserDto d =  apiClientUser.getUserByMobile("0772189735");
  return d;
  }


  public UserDto getUserFromMobile(String username, String password) {
    UserDto userDto = apiClientUser.getUserByMobile(username);
    return userDto;
  }
}
