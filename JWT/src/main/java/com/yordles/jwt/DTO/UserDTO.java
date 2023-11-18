package com.yordles.jwt.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @class: UserDTO
 * @description: This class is used to return the user information
 * @annotations:
 * @AllArgsConstructor for Lombok to generate a constructor with all the arguments
 * @Builder for Lombok to generate a builder
 * @Data for Lombok to generate the getters and setters
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    // username for the user
    private String username;
    // email for the user
    private String email;
    // password for the user
    private String password;
}
