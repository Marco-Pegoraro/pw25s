package br.edu.utfpr.pb.pw25s.server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotNull
    private BigDecimal paidValue;

    @JoinColumn(name = "Register_id")
    @ManyToOne
    private Register register;

    @JoinColumn(name = "User_id")
    @ManyToOne
    private User user;

    @Size(min = 2, max = 1024)
    @Column(length = 1024)
    private String description;

    @NotNull
    private String date;

    @NotNull
    @NotEmpty
    private String type;
}
