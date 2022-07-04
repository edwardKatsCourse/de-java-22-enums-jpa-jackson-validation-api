package com.example.planepassengers.controller;


import com.example.planepassengers.controller.dto.PassengerFlightDto;
import com.example.planepassengers.entity.PassengerTicket;
import com.example.planepassengers.repository.PassengerTicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class PassengerController {

    private final PassengerTicketRepository passengerTicketRepository;

    @PostMapping("/api/passengers")
    public void createPassenger(@RequestBody @Valid PassengerFlightDto request) {
        var passenger = PassengerTicket.builder()
                .name(request.getName())
                .ticketType(request.getTicketType())
                .build();

        passengerTicketRepository.save(passenger);
    }
}
