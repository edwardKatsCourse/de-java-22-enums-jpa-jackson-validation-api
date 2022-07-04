package com.example.planepassengers;

import com.example.planepassengers.entity.PassengerTicket;
import com.example.planepassengers.entity.types.TicketType;
import com.example.planepassengers.repository.PassengerTicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    private final PassengerTicketRepository passengerTicketRepository;

    @Override
    public void run(String... args) throws Exception {

//        PassengerTicket passenger1 = PassengerTicket.builder()
//                .ticketType(TicketType.BUSINESS)
//                .name("John")
//                .build();
//
//        PassengerTicket passenger2 = PassengerTicket.builder()
//                .ticketType(TicketType.VIP)
//                .name("Sarah")
//                .build();
//
//        PassengerTicket passenger3 = PassengerTicket.builder()
//                .ticketType(TicketType.ECONOMY)
//                .name("Andrew")
//                .build();
//
//        passengerTicketRepository.saveAll(List.of(passenger1, passenger2, passenger3));

        // severity level
        // GREEN, YELLOW, ORANGE, RED

        passengerTicketRepository.findAll()
                .forEach(x -> System.out.println(x.getName() + " -> " + x.getTicketType()));

    }
}
