package com.example.planepassengers.controller.dto;

import com.example.planepassengers.entity.types.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class PassengerFlightDto {

    // not null
    // not empty "    "
    // not blank "".strip() / .trim()

    @NotBlank
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email format is incorrect")
    @Length(min = 5, max = 50, message = "Email length should be between 5 and 50 chars")
    private String email; // "    "

    @NotNull
    private TicketType ticketType; // "ticketType" : "C-ECONOMY"

    // Validation API
    // hibernate-validator
}
