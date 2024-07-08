package org.example.task1blogwithlogin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDto {

    private String fName;
    private String lName;
    private String email;
    private String password;
}
