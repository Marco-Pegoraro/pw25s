package br.edu.utfpr.pb.pw25s.server.model;

import javax.validation.constraints.NotNull;

public class Register {

    @NotNull
    private User user;

    @NotNull
    private Integer number;

    @NotNull
    private String agency;

    @NotNull
    private String bank;

    @NotNull
    private String type;
}
