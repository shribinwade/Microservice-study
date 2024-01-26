package com.micro.hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "HOTEL_SERVICE")
public class Hotel {

    @Id
    @Column(name = "ID")
    private String hotelId;

    private String name;

    private String location;

    private String about;

}
