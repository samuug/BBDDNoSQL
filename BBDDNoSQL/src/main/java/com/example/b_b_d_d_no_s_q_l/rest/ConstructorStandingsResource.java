package com.example.b_b_d_d_no_s_q_l.rest;

import com.example.b_b_d_d_no_s_q_l.model.ConstructorStandingsDTO;
import com.example.b_b_d_d_no_s_q_l.service.ConstructorStandingsService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/constructorStandingss", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConstructorStandingsResource {

    private final ConstructorStandingsService constructorStandingsService;

    public ConstructorStandingsResource(
            final ConstructorStandingsService constructorStandingsService) {
        this.constructorStandingsService = constructorStandingsService;
    }

    @GetMapping
    public ResponseEntity<List<ConstructorStandingsDTO>> getAllConstructorStandingss() {
        return ResponseEntity.ok(constructorStandingsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConstructorStandingsDTO> getConstructorStandings(
            @PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(constructorStandingsService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createConstructorStandings(
            @RequestBody @Valid final ConstructorStandingsDTO constructorStandingsDTO) {
        final Long createdId = constructorStandingsService.create(constructorStandingsDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateConstructorStandings(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final ConstructorStandingsDTO constructorStandingsDTO) {
        constructorStandingsService.update(id, constructorStandingsDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteConstructorStandings(
            @PathVariable(name = "id") final Long id) {
        constructorStandingsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
