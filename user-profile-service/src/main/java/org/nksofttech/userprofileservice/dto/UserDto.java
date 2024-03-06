package org.nksofttech.userprofileservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nksofttech.userprofileservice.util.enums.Gender;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
  private String mobileNumber;
  private String password;
  private String firstName;
  private String lastName;
  private String imageUrl;
  private Gender gender;
  private boolean userEnable;
}
