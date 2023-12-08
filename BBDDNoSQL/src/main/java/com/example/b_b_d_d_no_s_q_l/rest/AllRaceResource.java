package com.example.b_b_d_d_no_s_q_l.rest;

import com.example.b_b_d_d_no_s_q_l.model.AllRaceDTO;
import com.example.b_b_d_d_no_s_q_l.service.AllRaceService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/allRaces", produces = MediaType.APPLICATION_JSON_VALUE)
public class AllRaceResource {

    private final AllRaceService allRaceService;

    public AllRaceResource(final AllRaceService allRaceService) {
        this.allRaceService = allRaceService;
    }

    @GetMapping
    public ResponseEntity<List<AllRaceDTO>> getAllAllRaces() {
        return ResponseEntity.ok(allRaceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AllRaceDTO> getAllRace(@PathVariable(name = "id") final String id) {
        return ResponseEntity.ok(allRaceService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<String> createAllRace(@RequestBody @Valid final AllRaceDTO allRaceDTO,
            final BindingResult bindingResult) throws MethodArgumentNotValidException {
        if (!bindingResult.hasFieldErrors("id") && allRaceDTO.getId() == null) {
            bindingResult.rejectValue("id", "NotNull");
        }
        if (!bindingResult.hasFieldErrors("id") && allRaceService.idExists(allRaceDTO.getId())) {
            bindingResult.rejectValue("id", "Exists.allRace.id");
        }
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(new MethodParameter(
                    this.getClass().getDeclaredMethods()[0], -1), bindingResult);
        }
        final String createdId = allRaceService.create(allRaceDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAllRace(@PathVariable(name = "id") final String id,
            @RequestBody @Valid final AllRaceDTO allRaceDTO) {
        allRaceService.update(id, allRaceDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteAllRace(@PathVariable(name = "id") final String id) {
        allRaceService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
