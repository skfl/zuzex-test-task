package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.HouseDTO;
import com.skfl.zuzextesttask.dtos.response.DeleteResponse;
import com.skfl.zuzextesttask.services.HouseService;
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
@RequestMapping("/house")
@AllArgsConstructor
@Validated
public class HouseController {
    private final HouseService houseService;

    @Operation(
            summary = "Find the house by its id",
            description = "Retrieves house id and return house with such id from db",
            tags = "House",
            parameters = {@Parameter(name = "id", description = "House id to find")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found house", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HouseDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "No house with such id was found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid house id", content = @Content)})
    @GetMapping("{id}")
    public HouseDTO getHouseById(@PathVariable("id") @Min(0) Long id) {
        return houseService.readHouseById(id);
    }

    @Operation(
            summary = "Add the house to db",
            description = "Retrieves house data and put this data to db",
            tags = "House",
            parameters = {@Parameter(name = "houseDTO", description = "House data to add")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added house", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HouseDTO.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid house data", content = @Content)})
    @PostMapping
    public HouseDTO addHouse(@Valid @RequestBody HouseDTO houseDTO) {
        return houseService.createHouse(houseDTO);
    }

    @Operation(
            summary = "Update the house by its id",
            description = "Retrieves house id and updates house with such id from db by set values from input",
            tags = "House",
            parameters = {@Parameter(name = "id", description = "House id to update"), @Parameter(name = "houseDTO", description = "House data to update")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated house data", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HouseDTO.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "404", description = "No housen with such id was found", content = @Content)})
    @PutMapping("{id}")
    public HouseDTO updateHouse(@Valid @RequestBody HouseDTO houseDTO, @PathVariable("id") @Min(0) Long id) {
        return houseService.updateHouse(houseDTO, id);
    }

    @Operation(
            summary = "Delete the house by its id",
            description = "Retrieves house id and delete car with such id from db",
            tags = "House",
            parameters = {@Parameter(name = "id", description = "House id to delete")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful delete message", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DeleteResponse.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid house id", content = @Content),
            @ApiResponse(responseCode = "404", description = "No House with such id was found", content = @Content)})
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteHouse(@PathVariable("id") @Min(0) Long id) {
        houseService.deleteHouseById(id);
        return ResponseEntity.ok()
                .body(DeleteResponse.builder().message("House successfully deleted").build());
    }
}
