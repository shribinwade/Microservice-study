package com.micro.rating.service.entities;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document("user_ratings")
public class Rating {

    @Id

    private String id;

    private String hotelId;
    private String userId;
    private Integer rating;
    private String feedback;
}
