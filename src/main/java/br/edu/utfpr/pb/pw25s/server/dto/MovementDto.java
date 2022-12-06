package br.edu.utfpr.pb.pw25s.server.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MovementDto {

    private Long id;

    @NotNull
    private BigDecimal value;

    @Size(min = 2, max = 1024)
    @Column(length = 1024)
    private String description;

    @NotNull
    private String date;

    @NotNull
    private String type;

    private RegisterDto register;

}
