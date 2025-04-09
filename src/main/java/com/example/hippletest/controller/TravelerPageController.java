package com.example.hippletest.controller;

import com.example.hippletest.domain.Guide;
import com.example.hippletest.domain.Portfolio;
import com.example.hippletest.dto.ResponsePortfolioDto;
import com.example.hippletest.service.TravelerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "여행자 페이지 API", description = "여행자 측면의 로직 API입니다.")
@RequestMapping("/travelerPage")
public class TravelerPageController {
    private final TravelerService travelerService;

    // 각 지역의 가이드들을 검색합니다.
    @GetMapping("/getRegionGuideList/{regionId}")
    public ResponseEntity<List<Guide>> guideListByRegionId(@PathVariable Long regionId){
        return ResponseEntity.ok().body(travelerService.getRegionGuide(regionId));
    }

    // 한 명의 가이드를 조회합니다. //일단 안씀
    @GetMapping("/getGuide/{guideId}")
    public ResponseEntity<Guide> getGuideById(@PathVariable Long guideId){
        return ResponseEntity.ok().body(travelerService.getGuide(guideId));
    }

    // 가이드의 포트폴리오를 조회합니다.
    @GetMapping("/getPortfolio/{guideId}")
    public ResponseEntity<ResponsePortfolioDto> getPortfolioByGuideId(@PathVariable Long guideId){
        return ResponseEntity.ok().body(travelerService.getPortfolioByGuideId(guideId));
    }
}
