package com.example.hippletest.service;

import com.example.hippletest.domain.Guide;
import com.example.hippletest.domain.Portfolio;
import com.example.hippletest.repository.GuideRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuideService {
    private final GuideRepository guideRepository;

    @Transactional
    public Guide saveGuide(Guide guide){
        guideRepository.save(guide);
        return guide;
    }

    @Transactional
    public Portfolio savePortfolio(Long guideId, Portfolio portfolio){
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new EntityNotFoundException("Guide not found"));

        guide.setPortfolio(portfolio);
        guideRepository.save(guide);

        return portfolio;
    }
}
