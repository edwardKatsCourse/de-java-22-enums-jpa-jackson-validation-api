package com.example.planepassengers.controller;

import com.example.planepassengers.controller.dto.InputValidationResponseDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InputValidationResponseDTO> handleInputError(MethodArgumentNotValidException ex) {

        // email -> @Email
        // name -> @NotNull
        // email -> @NotBlank

        // Map<field, list<errors>>
        var responseBody = ex.getFieldErrors().stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(
                                DefaultMessageSourceResolvable::getDefaultMessage,
                                Collectors.toList()
                        )
                ));
        // groupingBy(
        //  1. item -> key
        //  2. Collectors.mappingBy -> Map<String, List<String>>
        //  OR
        //  2. Collectors.counting -> Map<String, Long>
        // )

        // toMap(
        // 1. item -> key
        // 2. item -> value
        // 3. conflict (value1, value2) -> value?
        // 4. TreeMap::new
        // )
        InputValidationResponseDTO response = InputValidationResponseDTO.builder()
                .status(HttpStatus.BAD_REQUEST)
//                .message(ex.getMessage())
                .errors(responseBody)
                .build();


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);

    }
}
