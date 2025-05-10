package com.example.hippletest.service;

import com.example.hippletest.domain.Guide;
import com.example.hippletest.domain.Portfolio;
import com.example.hippletest.dto.ResponsePortfolioDto;
import com.example.hippletest.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public ResponsePortfolioDto getPortfolioByGuideId(Long guideId) {
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new RuntimeException("Guide not found with ID: " + guideId));

        Portfolio portfolio = guide.getPortfolio();

        if (portfolio == null) {
            throw new RuntimeException("Portfolio not found for Guide with ID: " + guideId);
        }

        ResponsePortfolioDto portfolioDto = new ResponsePortfolioDto(portfolio);

        return portfolioDto;
    }
}
