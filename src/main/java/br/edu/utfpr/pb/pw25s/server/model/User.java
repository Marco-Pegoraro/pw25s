package br.edu.utfpr.pb.pw25s.server.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 4, max = 255)
    private String name;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 6, max = 254)
    private String password;

    private String phone;
}
