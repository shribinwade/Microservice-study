package com.micro.user.service.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {


    private String id;
    private String hotelId;
    private String userId;
    private Integer rating;
    private String feedback;
    private Hotel hotel;
}
