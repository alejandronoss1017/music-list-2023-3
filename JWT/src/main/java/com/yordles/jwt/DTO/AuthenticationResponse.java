package com.yordles.jwt.DTO;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

/**
 * @class: JWTToken
 * @description: This class is used to return the JWT token
 * @annotations:
 * @AllArgsConstructor for Lombok to generate a constructor with all the arguments
 * @Getter for Lombok to generate the getters
 * @Setter for Lombok to generate the setters
 */
@Getter
@Setter
@Generated
@AllArgsConstructor
public class AuthenticationResponse {
    // @Generated for Lombok to generate a constructor with all the arguments
    @Generated
    // token for the JWT token
    private String token;
}