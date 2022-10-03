package br.edu.utfpr.pb.pw25s.server.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    private Long id;

    @NotNull
    @Size(min = 4)
    private String username;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 6)
    private String password;

    private String phone;
}
