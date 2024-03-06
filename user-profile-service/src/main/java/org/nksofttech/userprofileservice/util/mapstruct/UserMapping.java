package org.nksofttech.userprofileservice.util.mapstruct;
import org.mapstruct.Mapper;
import org.nksofttech.userprofileservice.dto.UserDto;
import org.nksofttech.userprofileservice.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapping {
  UserEntity userDtoToEntity(UserDto user);

  UserDto userEntityToDto(UserEntity userEntity);
}
