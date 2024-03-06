package org.nksofttech.userprofileservice.service.Impl;

import lombok.AllArgsConstructor;
import org.nksofttech.userprofileservice.dto.UserDto;
import org.nksofttech.userprofileservice.entity.UserEntity;
import org.nksofttech.userprofileservice.exception.NotFoundException;
import org.nksofttech.userprofileservice.exception.WriteAbortedException;
import org.nksofttech.userprofileservice.repository.UserRepo;
import org.nksofttech.userprofileservice.service.UserService;
import org.nksofttech.userprofileservice.util.mapstruct.UserMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private UserRepo userRepo;
  private UserMapping userMapping;
  private JwtService jwtService;
  private PasswordEncoder passwordEncoder;
  @Override
  public UserDto saveUser(UserDto user) {
    try {
      if (!userRepo.existsById(user.getMobileNumber())) {
        UserEntity userEntity = userMapping.userDtoToEntity(user);
        userEntity.setUserEnable(true);
        // ENCODE THE PASSWORD
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        UserEntity entity = userRepo.save(userEntity);
        return userMapping.userEntityToDto(entity);
      } else {
        throw new WriteAbortedException("user-already-in-the-list");
      }
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public UserDto getUserByMobile(String userMobile) {
    System.out.println("here we are ");
    try {
      if (userRepo.existsById(userMobile)) {
        UserEntity userEntity = userRepo.findById(userMobile).get();
        UserDto userDto = userMapping.userEntityToDto(userEntity);
        System.out.println("::::::::::::::USER Caught:::::::" + userDto.toString());
        return userDto;
      } else {
        throw new NotFoundException("user-not-found");
      }
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String registerUser(UserDto user) {
    UserDto newUser = saveUser(user);
    try {
     String token = jwtService.createJwtToken(newUser.getMobileNumber(),user.getPassword());
     return token;
    } catch (Exception e) {
      userRepo.deleteById(newUser.getMobileNumber());
      throw new RuntimeException(e);
    }
  }
}
