package com.springsecurity.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class JwtRequest {

    private String email;
    private String password;

}
