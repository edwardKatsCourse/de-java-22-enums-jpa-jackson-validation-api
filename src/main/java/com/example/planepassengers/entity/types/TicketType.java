package com.example.planepassengers.entity.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TicketType {

    // Multitone
    VIP(3, "A-VIP"),
    BUSINESS(1, "B-BUSINESS"),
    ECONOMY(2, "C-ECONOMY")
    ;


    private final Integer ticketTypeId;
    private final String externalTypeId;
    // ctor(ticketTypeId)
    // getter

    public static TicketType findByTypeId(Integer typeId) {
        if (typeId == null) {
            return null;
        }

        return Arrays.stream(TicketType.values())
                .filter(x -> x.getTicketTypeId().equals(typeId))
                .findFirst()
                .orElse(null);
    }

    @JsonCreator
    // Jackson | org.fasterxml
    // @JsonCreator - object MUST be created/deserialized ONLY via this method
    public static TicketType findByExternalTypeId(String typeId) {
        if (typeId == null) {
            return null;
        }

        return Arrays.stream(TicketType.values())
                .filter(x -> x.getExternalTypeId().equals(typeId))
                .findFirst()
                .orElse(null);
    }

}

// TicketType BUSINESS = new TicketType();

//class Main {
//    public static void main(String[] args) {
//        // 2
//        TicketType type = TicketType.getByTypeId(1);
//
//
//        System.out.println(type);
//    }
//}