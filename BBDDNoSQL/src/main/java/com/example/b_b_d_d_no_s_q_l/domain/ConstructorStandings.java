package com.example.b_b_d_d_no_s_q_l.domain;

import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("constructorStandingses")
@Getter
@Setter
public class ConstructorStandings {

    @Id
    private Long id;

    @Size(max = 255)
    private String pos;

    @Size(max = 255)
    private String team;

    private Integer pts;

    private Integer year;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

}
