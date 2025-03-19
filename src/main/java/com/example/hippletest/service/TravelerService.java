package com.example.hippletest.service;

import com.example.hippletest.domain.Guide;
import com.example.hippletest.domain.Portfolio;
import com.example.hippletest.repository.GuideRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelerService {
    private final GuideRepository guideRepository;

    @Transactional
    public List<Guide> getRegionGuide(Long regionId){
        List<Guide> guideList;
        guideList = guideRepository.findAllByRegionId(regionId);

        return guideList;
    }

    public Guide getGuide(Long guideId){
        return guideRepository.findById(guideId)
                .orElseThrow(RuntimeException::new);
    }

    public Portfolio getPortfolioByGuideId(Long guideId){
        Guide guide = getGuide(guideId);
        Portfolio portfolio = guide.getPortfolio();

        return portfolio;
    }
}
