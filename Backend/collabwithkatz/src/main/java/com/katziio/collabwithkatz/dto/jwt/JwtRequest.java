package com.katziio.collabwithkatz.dto.jwt;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtRequest {
    private String email;
    private String password;
}
