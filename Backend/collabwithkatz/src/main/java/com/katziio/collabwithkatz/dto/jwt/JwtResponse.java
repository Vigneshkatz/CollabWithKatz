package com.katziio.collabwithkatz.dto.jwt;

import lombok.Builder;

@Builder
public class JwtResponse {
    private String jwtToken;
    private String username;
}
