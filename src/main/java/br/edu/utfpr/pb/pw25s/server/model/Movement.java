package br.edu.utfpr.pb.pw25s.server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity(name = "tb_movement")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal value;

    @JoinColumn(name = "Register_id")
    private Long moveAccount;

    @Size(min = 2, max = 1024)
    @Column(length = 1024)
    private String description;

    @NotNull
    private Boolean type;
}
