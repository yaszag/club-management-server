package com.sportsclubmanagement.clubmanagement.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SignUpRequest {
    private String username;
    private String password;

}

