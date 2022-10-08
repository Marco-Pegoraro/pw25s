package br.edu.utfpr.pb.pw25s.server.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterDto {

    private Long id;

    @NotNull
    private String agency;

    @NotNull
    private String bank;

    @NotNull
    private String account;

    @NotNull
    private String accountType;
}
