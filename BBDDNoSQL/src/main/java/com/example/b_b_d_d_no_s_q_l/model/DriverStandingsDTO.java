package com.example.b_b_d_d_no_s_q_l.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DriverStandingsDTO {

    private Long id;

    private Integer pos;

    @Size(max = 255)
    private String driver;

    @Size(max = 255)
    private String nacionality;

    @Size(max = 255)
    private String car;

    private Integer pts;

    private Integer year;

}
