package com.riwi.filtro.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.filtro.Util.enums.SortType;
import com.riwi.filtro.api.dto.errors.ErrorsResp;
import com.riwi.filtro.api.dto.request.UserRequest;
import com.riwi.filtro.api.dto.response.UserResp;
import com.riwi.filtro.infraestructure.abstract_services.IUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    
    @Autowired
    private final IUserService user;
    @Operation(summary = "Get the entire user list in a paginated manner")
    @GetMapping
    public ResponseEntity<Page<UserResp>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        
        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }

        return ResponseEntity.ok(this.user.findAll(page -1, size, sortType));
    }

    @Operation(summary = "Get an user by its ID number")
    @ApiResponse(responseCode = "404", description = "When the ID is not found", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResp> get(@PathVariable Long id){
        return ResponseEntity.ok(this.user.get(id));
    }

    @Operation(summary = "Create an user")
    @ApiResponse(responseCode = "400", description = "When the request is not valid", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorsResp.class))
    })
    @PostMapping
    public ResponseEntity<UserResp> create(
       @Validated @RequestBody UserRequest request
    ){
        return ResponseEntity.ok(this.user.create(request));
    }
    @PutMapping(path = "/{id}" )
    public ResponseEntity<UserResp> update(
        @Validated @RequestBody UserRequest request,
        @PathVariable Long id
    ){
        return ResponseEntity.ok(this.user.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.user.delete(id);

        return ResponseEntity.noContent().build();
    }
}
