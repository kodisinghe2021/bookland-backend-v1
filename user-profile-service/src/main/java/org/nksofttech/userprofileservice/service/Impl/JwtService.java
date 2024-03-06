package org.nksofttech.userprofileservice.service.Impl;

import org.nksofttech.userprofileservice.entity.UserEntity;
import org.nksofttech.userprofileservice.repository.UserRepo;
import org.nksofttech.userprofileservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UserRepo userRepo;
  @Autowired
  private JwtUtil jwtUtil;

  // create Jwt token
  public String createJwtToken(String un, String pw) throws Exception {
    // authenticating the user
    authenticateUser(un, pw);
    // loading user by username
    UserDetails userDetails = loadUserByUsername(un);
    // create jwt token
    String generatedToken = jwtUtil.generateToken(userDetails);

    return generatedToken;

  }

  @Override
  public UserDetails loadUserByUsername(String un) {
    Optional<UserEntity> user = userRepo.findById(un);
    if (user.isPresent()) {
      return new org.springframework.security.core.userdetails.User(
              user.get().getMobileNumber(),
              user.get().getPassword(),
              getAuthorities(user.get())
      );
    } else {
      throw new UsernameNotFoundException("user-not-found-with-username" + un);
    }
  }

  private Set getAuthorities(UserEntity userEntity) {
    Set<SimpleGrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    return authorities;
  }

  private void authenticateUser(String un, String pw) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(un, pw));
    } catch (AuthenticationException e) {
      throw new RuntimeException(e);
    }
  }
}
