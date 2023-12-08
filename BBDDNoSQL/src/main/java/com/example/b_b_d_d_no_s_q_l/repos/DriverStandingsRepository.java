package com.example.b_b_d_d_no_s_q_l.repos;

import com.example.b_b_d_d_no_s_q_l.domain.DriverStandings;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DriverStandingsRepository extends MongoRepository<DriverStandings, Long> {
}
