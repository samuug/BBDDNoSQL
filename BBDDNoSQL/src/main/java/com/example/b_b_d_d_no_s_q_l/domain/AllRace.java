package com.example.b_b_d_d_no_s_q_l.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("allRaces")
@Getter
@Setter
public class AllRace {

    @NotNull
    @Id
    private String id;

    private LocalDate date;

    @Size(max = 255)
    private String p1;

    @Size(max = 255)
    private String p2;

    @Size(max = 255)
    private String p3;

    @Size(max = 255)
    private String p4;

    @Size(max = 255)
    private String p5;

    @Size(max = 255)
    private String p6;

    @Size(max = 255)
    private String p7;

    @Size(max = 255)
    private String p8;

    @Size(max = 255)
    private String p9;

    @Size(max = 255)
    private String p10;

    @Size(max = 255)
    private String p11;

    @Size(max = 255)
    private String p12;

    @Size(max = 255)
    private String p13;

    @Size(max = 255)
    private String p14;

    @Size(max = 255)
    private String p15;

    @Size(max = 255)
    private String p16;

    @Size(max = 255)
    private String p17;

    @Size(max = 255)
    private String p18;

    @Size(max = 255)
    private String p19;

    @Size(max = 255)
    private String p20;

    @Size(max = 255)
    private String p21;

    @Size(max = 255)
    private String p22;

    @Size(max = 255)
    private String p23;

    @Size(max = 255)
    private String p24;

    @Size(max = 255)
    private String p25;

    @Size(max = 255)
    private String p26;

    @Size(max = 255)
    private String p27;

    @Size(max = 255)
    private String p28;

    @Size(max = 255)
    private String p29;

    @Size(max = 255)
    private String p30;

    @Size(max = 255)
    private String p31;

    @Size(max = 255)
    private String p32;

    @Size(max = 255)
    private String p33;

    @Size(max = 255)
    private String p34;

    @Size(max = 255)
    private String p35;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

}
