package com.sportsclubmanagement.clubmanagement.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {

    private Long id;
    private final String tokenType = "Bearer";
    private String accessToken;
    private String username;

}
