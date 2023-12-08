package com.example.b_b_d_d_no_s_q_l.repos;

import com.example.b_b_d_d_no_s_q_l.domain.ConstructorStandings;
import com.example.b_b_d_d_no_s_q_l.service.PrimarySequenceService;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class ConstructorStandingsListener extends AbstractMongoEventListener<ConstructorStandings> {

    private final PrimarySequenceService primarySequenceService;

    public ConstructorStandingsListener(final PrimarySequenceService primarySequenceService) {
        this.primarySequenceService = primarySequenceService;
    }

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<ConstructorStandings> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(primarySequenceService.getNextValue());
        }
    }

}
