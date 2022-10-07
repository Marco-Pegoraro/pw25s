package br.edu.utfpr.pb.pw25s.server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "tb_register")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String agency;

    @NotNull
    private String bank;

    @NotNull
    @JoinColumn(name = "User_id")
    @ManyToOne
    private User user;

    @NotNull
    private String account;

    @NotNull
    private String accountType;
}
