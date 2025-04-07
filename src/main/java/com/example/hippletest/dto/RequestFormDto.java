package com.example.hippletest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestFormDto {
    private Long guideId;
    private Long travelerId;
    private Long age;
    private boolean gender;
    private String requestText;
    private Long travelDate;
    //TODO: chane enum type
    private String isAccepted;
}
