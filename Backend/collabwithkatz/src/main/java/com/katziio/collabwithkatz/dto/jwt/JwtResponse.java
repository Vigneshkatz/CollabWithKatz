package com.katziio.collabwithkatz.dto.jwt;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Builder
@Data
@Getter
@Setter
public class JwtResponse {
    private String jwtToken;
    private String username;
}
