package org.nksofttech.userprofileservice.service;

import org.nksofttech.userprofileservice.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  UserDto saveUser(UserDto user);

  UserDto getUserByMobile(String userMobile);

  String registerUser(UserDto user);
}
