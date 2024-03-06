package org.nksofttech.userprofileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootApplication
@EnableEurekaClient
public class  UserProfileServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserProfileServiceApplication.class, args);

    //:::::::::::::: THIS CODE MUST EXECUTE JUST A ONE TIME
//    SecureRandom random = new SecureRandom();
//    System.out.println("1:::::::::::::::: " + random);
//
//    byte[] key = new byte[32];
//    System.out.println("2:::::::::::::::::: " + key);
//    random.nextBytes(key);
//    System.out.println("3::::::::::::::::::: " + key);
//    String base64Key = Base64.getEncoder().encodeToString(key);
//    System.out.println("Generated Secret Key: " + base64Key);
    //:::::::::::::: THIS CODE MUST EXECUTE JUST A ONE TIME

  }

}
