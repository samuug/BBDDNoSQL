package com.example.b_b_d_d_no_s_q_l.rest;

import com.example.b_b_d_d_no_s_q_l.model.DriverStandingsDTO;
import com.example.b_b_d_d_no_s_q_l.service.DriverStandingsService;
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
@RequestMapping(value = "/api/driverStandingss", produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverStandingsResource {

    private final DriverStandingsService driverStandingsService;

    public DriverStandingsResource(final DriverStandingsService driverStandingsService) {
        this.driverStandingsService = driverStandingsService;
    }

    @GetMapping
    public ResponseEntity<List<DriverStandingsDTO>> getAllDriverStandingss() {
        return ResponseEntity.ok(driverStandingsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverStandingsDTO> getDriverStandings(
            @PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(driverStandingsService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createDriverStandings(
            @RequestBody @Valid final DriverStandingsDTO driverStandingsDTO) {
        final Long createdId = driverStandingsService.create(driverStandingsDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateDriverStandings(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final DriverStandingsDTO driverStandingsDTO) {
        driverStandingsService.update(id, driverStandingsDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteDriverStandings(@PathVariable(name = "id") final Long id) {
        driverStandingsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
