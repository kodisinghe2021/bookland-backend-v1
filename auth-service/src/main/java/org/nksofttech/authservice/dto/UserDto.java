package org.nksofttech.authservice.dto;

import org.nksofttech.authservice.util.enums.Gender;

public class UserDto {
  private String mobileNumber;
  private String firstName;
  private String lastName;
  private String imageUrl;
  private Gender gender;
  private boolean userEnable;

  public UserDto(String mobileNumber, String firstName, String lastName, String imageUrl, Gender gender, boolean userEnable) {
    this.mobileNumber = mobileNumber;
    this.firstName = firstName;
    this.lastName = lastName;
    this.imageUrl = imageUrl;
    this.gender = gender;
    this.userEnable = userEnable;
  }

  public UserDto() {
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public boolean isUserEnable() {
    return userEnable;
  }

  public void setUserEnable(boolean userEnable) {
    this.userEnable = userEnable;
  }

  @Override
  public String toString() {
    return "UserDto{" +
            "mobileNumber='" + mobileNumber + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", gender=" + gender +
            ", userEnable=" + userEnable +
            '}';
  }
}
