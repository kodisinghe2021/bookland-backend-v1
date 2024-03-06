package org.nksofttech.userprofileservice.repository;

import org.nksofttech.userprofileservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<UserEntity,String>{
}
