package org.nksofttech.userprofileservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.nksofttech.userprofileservice.util.enums.Gender;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
  @Id
  private String mobileNumber;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(nullable = false)
  private String imageUrl;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Gender gender;
  @Column(columnDefinition = "TINYINT default 1")
  private boolean userEnable;
}
