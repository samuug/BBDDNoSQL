package com.example.b_b_d_d_no_s_q_l.service;

import com.example.b_b_d_d_no_s_q_l.domain.ConstructorStandings;
import com.example.b_b_d_d_no_s_q_l.model.ConstructorStandingsDTO;
import com.example.b_b_d_d_no_s_q_l.repos.ConstructorStandingsRepository;
import com.example.b_b_d_d_no_s_q_l.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ConstructorStandingsService {

    private final ConstructorStandingsRepository constructorStandingsRepository;

    public ConstructorStandingsService(
            final ConstructorStandingsRepository constructorStandingsRepository) {
        this.constructorStandingsRepository = constructorStandingsRepository;
    }

    public List<ConstructorStandingsDTO> findAll() {
        final List<ConstructorStandings> constructorStandingses = constructorStandingsRepository.findAll(Sort.by("id"));
        return constructorStandingses.stream()
                .map(constructorStandings -> mapToDTO(constructorStandings, new ConstructorStandingsDTO()))
                .toList();
    }

    public ConstructorStandingsDTO get(final Long id) {
        return constructorStandingsRepository.findById(id)
                .map(constructorStandings -> mapToDTO(constructorStandings, new ConstructorStandingsDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ConstructorStandingsDTO constructorStandingsDTO) {
        final ConstructorStandings constructorStandings = new ConstructorStandings();
        mapToEntity(constructorStandingsDTO, constructorStandings);
        return constructorStandingsRepository.save(constructorStandings).getId();
    }

    public void update(final Long id, final ConstructorStandingsDTO constructorStandingsDTO) {
        final ConstructorStandings constructorStandings = constructorStandingsRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(constructorStandingsDTO, constructorStandings);
        constructorStandingsRepository.save(constructorStandings);
    }

    public void delete(final Long id) {
        constructorStandingsRepository.deleteById(id);
    }

    private ConstructorStandingsDTO mapToDTO(final ConstructorStandings constructorStandings,
            final ConstructorStandingsDTO constructorStandingsDTO) {
        constructorStandingsDTO.setId(constructorStandings.getId());
        constructorStandingsDTO.setPos(constructorStandings.getPos());
        constructorStandingsDTO.setTeam(constructorStandings.getTeam());
        constructorStandingsDTO.setPts(constructorStandings.getPts());
        constructorStandingsDTO.setYear(constructorStandings.getYear());
        return constructorStandingsDTO;
    }

    private ConstructorStandings mapToEntity(final ConstructorStandingsDTO constructorStandingsDTO,
            final ConstructorStandings constructorStandings) {
        constructorStandings.setPos(constructorStandingsDTO.getPos());
        constructorStandings.setTeam(constructorStandingsDTO.getTeam());
        constructorStandings.setPts(constructorStandingsDTO.getPts());
        constructorStandings.setYear(constructorStandingsDTO.getYear());
        return constructorStandings;
    }

}
