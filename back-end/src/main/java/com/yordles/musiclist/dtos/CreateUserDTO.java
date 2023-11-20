
package com.yordles.musiclist.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CreateUserDTO
 */

@Data
@NoArgsConstructor
public class CreateUserDTO {
    private String email;
    private String username;
    private String password;
}