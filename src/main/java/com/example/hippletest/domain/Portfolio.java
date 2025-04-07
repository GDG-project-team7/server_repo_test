package com.example.hippletest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Hibernate 프록시 필드 무시
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guide_id")
    private Guide guide;

    private String title;
    private String introduction;
    private String travelPlace;
    private String foodPlace;
    private String photoPlace;

    public Portfolio(String title, String travelPlace, String foodPlace, String photoPlace, String introduction) {
        this.title = title;
        this.travelPlace = travelPlace;
        this.foodPlace = foodPlace;
        this.photoPlace = photoPlace;
        this.introduction = introduction;
    }
}
