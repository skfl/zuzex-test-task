package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.dtos.response.DeleteResponse;
import com.skfl.zuzextesttask.services.CitizenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citizen")
@AllArgsConstructor
@Validated
public class CitizenController {
    private final CitizenService citizenService;

    @Operation(
            summary = "Find the citizen by its id",
            description = "Retrieves citizen id and return citizen with such id from db",
            tags = "Citizen",
            parameters = {@Parameter(name = "id", description = "Citizen id to find")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found citizen", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CitizenDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "No citizen with such id was found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid car id", content = @Content)})
    @GetMapping("{citizen-id}")
    public CitizenDTO getCitizenById(@PathVariable("citizen-id") @Min(0) Long citizenId) {
        return citizenService.readCitizenById(citizenId);
    }

    @Operation(
            summary = "Add the citizen to db",
            description = "Retrieves citizen data and put this data to db",
            tags = "Citizen",
            parameters = {@Parameter(name = "citizenDTO", description = "Citizen data to add")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added citizen", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CitizenDTO.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid citizen data", content = @Content)})
    @PostMapping
    public CitizenDTO addCitizen(@Valid @RequestBody CitizenDTO citizenDTO) {
        return citizenService.createCitizenWithPassport(citizenDTO);
    }

    @Operation(
            summary = "Update the citizen by its id",
            description = "Retrieves citizen id and updates citizen with such id from db by set values from input",
            tags = "Citizen",
            parameters = {@Parameter(name = "id", description = "Citizen id to update"), @Parameter(name = "citizenDTO", description = "Citizen data to update")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated citizen data", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CitizenDTO.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "404", description = "No citizen with such id was found", content = @Content)})
    @PutMapping("{citizen-id}")
    public CitizenDTO updateCitizen(@Valid @RequestBody CitizenDTO citizenDTO, @PathVariable("citizen-id") @Min(0) Long citizenId) {
        return citizenService.updateCitizen(citizenDTO, citizenId);
    }


    @Operation(
            summary = "Delete the Citizen by its id",
            description = "Retrieves Citizen id and delete car with such id from db",
            tags = "Citizen",
            parameters = {@Parameter(name = "id", description = "Citizen id to delete")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful delete message", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DeleteResponse.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid citizen id", content = @Content),
            @ApiResponse(responseCode = "404", description = "No Citizen with such id was found", content = @Content)})
    @DeleteMapping("{citizen-id}")
    public ResponseEntity<?> deleteCitizen(@PathVariable("citizen-id") @Min(0) Long citizenId) {
        citizenService.deleteCitizenById(citizenId);
        return ResponseEntity.ok()
                .body(DeleteResponse.builder().message("Citizen successfully deleted").build());
    }
}
