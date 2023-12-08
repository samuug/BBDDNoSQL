package com.example.b_b_d_d_no_s_q_l.service;

import com.example.b_b_d_d_no_s_q_l.domain.DriverStandings;
import com.example.b_b_d_d_no_s_q_l.model.DriverStandingsDTO;
import com.example.b_b_d_d_no_s_q_l.repos.DriverStandingsRepository;
import com.example.b_b_d_d_no_s_q_l.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class DriverStandingsService {

    private final DriverStandingsRepository driverStandingsRepository;

    public DriverStandingsService(final DriverStandingsRepository driverStandingsRepository) {
        this.driverStandingsRepository = driverStandingsRepository;
    }

    public List<DriverStandingsDTO> findAll() {
        final List<DriverStandings> driverStandingses = driverStandingsRepository.findAll(Sort.by("id"));
        return driverStandingses.stream()
                .map(driverStandings -> mapToDTO(driverStandings, new DriverStandingsDTO()))
                .toList();
    }

    public DriverStandingsDTO get(final Long id) {
        return driverStandingsRepository.findById(id)
                .map(driverStandings -> mapToDTO(driverStandings, new DriverStandingsDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final DriverStandingsDTO driverStandingsDTO) {
        final DriverStandings driverStandings = new DriverStandings();
        mapToEntity(driverStandingsDTO, driverStandings);
        return driverStandingsRepository.save(driverStandings).getId();
    }

    public void update(final Long id, final DriverStandingsDTO driverStandingsDTO) {
        final DriverStandings driverStandings = driverStandingsRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(driverStandingsDTO, driverStandings);
        driverStandingsRepository.save(driverStandings);
    }

    public void delete(final Long id) {
        driverStandingsRepository.deleteById(id);
    }

    private DriverStandingsDTO mapToDTO(final DriverStandings driverStandings,
            final DriverStandingsDTO driverStandingsDTO) {
        driverStandingsDTO.setId(driverStandings.getId());
        driverStandingsDTO.setPos(driverStandings.getPos());
        driverStandingsDTO.setDriver(driverStandings.getDriver());
        driverStandingsDTO.setNacionality(driverStandings.getNacionality());
        driverStandingsDTO.setCar(driverStandings.getCar());
        driverStandingsDTO.setPts(driverStandings.getPts());
        driverStandingsDTO.setYear(driverStandings.getYear());
        return driverStandingsDTO;
    }

    private DriverStandings mapToEntity(final DriverStandingsDTO driverStandingsDTO,
            final DriverStandings driverStandings) {
        driverStandings.setPos(driverStandingsDTO.getPos());
        driverStandings.setDriver(driverStandingsDTO.getDriver());
        driverStandings.setNacionality(driverStandingsDTO.getNacionality());
        driverStandings.setCar(driverStandingsDTO.getCar());
        driverStandings.setPts(driverStandingsDTO.getPts());
        driverStandings.setYear(driverStandingsDTO.getYear());
        return driverStandings;
    }

}
