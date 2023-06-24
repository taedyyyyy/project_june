package com.ohgiraffers.mtvsreserve.members.login.domain.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDTO {

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
}
