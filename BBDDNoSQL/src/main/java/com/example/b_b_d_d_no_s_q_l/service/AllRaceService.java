package com.example.b_b_d_d_no_s_q_l.service;

import com.example.b_b_d_d_no_s_q_l.domain.AllRace;
import com.example.b_b_d_d_no_s_q_l.model.AllRaceDTO;
import com.example.b_b_d_d_no_s_q_l.repos.AllRaceRepository;
import com.example.b_b_d_d_no_s_q_l.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AllRaceService {

    private final AllRaceRepository allRaceRepository;

    public AllRaceService(final AllRaceRepository allRaceRepository) {
        this.allRaceRepository = allRaceRepository;
    }

    public List<AllRaceDTO> findAll() {
        final List<AllRace> allRaces = allRaceRepository.findAll(Sort.by("id"));
        return allRaces.stream()
                .map(allRace -> mapToDTO(allRace, new AllRaceDTO()))
                .toList();
    }

    public AllRaceDTO get(final String id) {
        return allRaceRepository.findById(id)
                .map(allRace -> mapToDTO(allRace, new AllRaceDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public String create(final AllRaceDTO allRaceDTO) {
        final AllRace allRace = new AllRace();
        mapToEntity(allRaceDTO, allRace);
        allRace.setId(allRaceDTO.getId());
        return allRaceRepository.save(allRace).getId();
    }

    public void update(final String id, final AllRaceDTO allRaceDTO) {
        final AllRace allRace = allRaceRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(allRaceDTO, allRace);
        allRaceRepository.save(allRace);
    }

    public void delete(final String id) {
        allRaceRepository.deleteById(id);
    }

    private AllRaceDTO mapToDTO(final AllRace allRace, final AllRaceDTO allRaceDTO) {
        allRaceDTO.setId(allRace.getId());
        allRaceDTO.setDate(allRace.getDate());
        allRaceDTO.setP1(allRace.getP1());
        allRaceDTO.setP2(allRace.getP2());
        allRaceDTO.setP3(allRace.getP3());
        allRaceDTO.setP4(allRace.getP4());
        allRaceDTO.setP5(allRace.getP5());
        allRaceDTO.setP6(allRace.getP6());
        allRaceDTO.setP7(allRace.getP7());
        allRaceDTO.setP8(allRace.getP8());
        allRaceDTO.setP9(allRace.getP9());
        allRaceDTO.setP10(allRace.getP10());
        allRaceDTO.setP11(allRace.getP11());
        allRaceDTO.setP12(allRace.getP12());
        allRaceDTO.setP13(allRace.getP13());
        allRaceDTO.setP14(allRace.getP14());
        allRaceDTO.setP15(allRace.getP15());
        allRaceDTO.setP16(allRace.getP16());
        allRaceDTO.setP17(allRace.getP17());
        allRaceDTO.setP18(allRace.getP18());
        allRaceDTO.setP19(allRace.getP19());
        allRaceDTO.setP20(allRace.getP20());
        allRaceDTO.setP21(allRace.getP21());
        allRaceDTO.setP22(allRace.getP22());
        allRaceDTO.setP23(allRace.getP23());
        allRaceDTO.setP24(allRace.getP24());
        allRaceDTO.setP25(allRace.getP25());
        allRaceDTO.setP26(allRace.getP26());
        allRaceDTO.setP27(allRace.getP27());
        allRaceDTO.setP28(allRace.getP28());
        allRaceDTO.setP29(allRace.getP29());
        allRaceDTO.setP30(allRace.getP30());
        allRaceDTO.setP31(allRace.getP31());
        allRaceDTO.setP32(allRace.getP32());
        allRaceDTO.setP33(allRace.getP33());
        allRaceDTO.setP34(allRace.getP34());
        allRaceDTO.setP35(allRace.getP35());
        return allRaceDTO;
    }

    private AllRace mapToEntity(final AllRaceDTO allRaceDTO, final AllRace allRace) {
        allRace.setDate(allRaceDTO.getDate());
        allRace.setP1(allRaceDTO.getP1());
        allRace.setP2(allRaceDTO.getP2());
        allRace.setP3(allRaceDTO.getP3());
        allRace.setP4(allRaceDTO.getP4());
        allRace.setP5(allRaceDTO.getP5());
        allRace.setP6(allRaceDTO.getP6());
        allRace.setP7(allRaceDTO.getP7());
        allRace.setP8(allRaceDTO.getP8());
        allRace.setP9(allRaceDTO.getP9());
        allRace.setP10(allRaceDTO.getP10());
        allRace.setP11(allRaceDTO.getP11());
        allRace.setP12(allRaceDTO.getP12());
        allRace.setP13(allRaceDTO.getP13());
        allRace.setP14(allRaceDTO.getP14());
        allRace.setP15(allRaceDTO.getP15());
        allRace.setP16(allRaceDTO.getP16());
        allRace.setP17(allRaceDTO.getP17());
        allRace.setP18(allRaceDTO.getP18());
        allRace.setP19(allRaceDTO.getP19());
        allRace.setP20(allRaceDTO.getP20());
        allRace.setP21(allRaceDTO.getP21());
        allRace.setP22(allRaceDTO.getP22());
        allRace.setP23(allRaceDTO.getP23());
        allRace.setP24(allRaceDTO.getP24());
        allRace.setP25(allRaceDTO.getP25());
        allRace.setP26(allRaceDTO.getP26());
        allRace.setP27(allRaceDTO.getP27());
        allRace.setP28(allRaceDTO.getP28());
        allRace.setP29(allRaceDTO.getP29());
        allRace.setP30(allRaceDTO.getP30());
        allRace.setP31(allRaceDTO.getP31());
        allRace.setP32(allRaceDTO.getP32());
        allRace.setP33(allRaceDTO.getP33());
        allRace.setP34(allRaceDTO.getP34());
        allRace.setP35(allRaceDTO.getP35());
        return allRace;
    }

    public boolean idExists(final String id) {
        return allRaceRepository.existsByIdIgnoreCase(id);
    }

}
