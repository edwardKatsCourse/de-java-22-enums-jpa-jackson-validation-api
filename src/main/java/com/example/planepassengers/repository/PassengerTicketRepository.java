package com.example.planepassengers.repository;

import com.example.planepassengers.entity.PassengerTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerTicketRepository extends JpaRepository<PassengerTicket, Long> {
}
