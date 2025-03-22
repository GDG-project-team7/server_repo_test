package com.example.hippletest.service;

import com.example.hippletest.domain.Guide;
import com.example.hippletest.domain.Portfolio;
import com.example.hippletest.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelerService {
    private final GuideRepository guideRepository;

    @Transactional(readOnly = true)
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
