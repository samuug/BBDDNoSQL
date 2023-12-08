package com.example.b_b_d_d_no_s_q_l.repos;

import com.example.b_b_d_d_no_s_q_l.domain.DriverStandings;
import com.example.b_b_d_d_no_s_q_l.service.PrimarySequenceService;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class DriverStandingsListener extends AbstractMongoEventListener<DriverStandings> {

    private final PrimarySequenceService primarySequenceService;

    public DriverStandingsListener(final PrimarySequenceService primarySequenceService) {
        this.primarySequenceService = primarySequenceService;
    }

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<DriverStandings> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(primarySequenceService.getNextValue());
        }
    }

}
