package com.example.hippletest.dto;

import com.example.hippletest.domain.Portfolio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePortfolioDto {
    private Long id;
    private String title;
    private String introduction;
    private String travelPlace;
    private String foodPlace;
    private String photoPlace;
    private String userName;

    public ResponsePortfolioDto(Portfolio portfolio) {
        this.id = portfolio.getId();
        this.title = portfolio.getTitle();
        this.introduction = portfolio.getIntroduction();
        this.travelPlace = portfolio.getTravelPlace();
        this.foodPlace = portfolio.getFoodPlace();
        this.photoPlace = portfolio.getPhotoPlace();
        this.userName = portfolio.getGuide().getUserName();
    }
}
