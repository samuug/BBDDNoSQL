package com.example.b_b_d_d_no_s_q_l.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ConstructorStandingsDTO {

    private Long id;

    @Size(max = 255)
    private String pos;

    @Size(max = 255)
    private String team;

    private Integer pts;

    private Integer year;

}
