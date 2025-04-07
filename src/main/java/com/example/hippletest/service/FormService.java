package com.example.hippletest.service;

import com.example.hippletest.domain.Form;
import com.example.hippletest.domain.Guide;
import com.example.hippletest.domain.Traveler;
import com.example.hippletest.repository.FormRepository;
import com.example.hippletest.repository.GuideRepository;
import com.example.hippletest.repository.TravelerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormService {
    private final FormRepository formRepository;
    private final GuideRepository guideRepository;
    private final TravelerRepository travelerRepository;

    public Form getForm(Long id) {
        return formRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 견적서를 찾을 수 없습니다."));
    }

    public String submitForm(Long travelerId, Long guideId, Form formRequest) {
        Traveler traveler = travelerRepository.findById(travelerId)
                .orElseThrow(() -> new RuntimeException("Traveler를 찾을 수 없습니다."));
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new RuntimeException("Guide를 찾을 수 없습니다."));

        Form form = new Form(formRequest.getAge(), formRequest.isGender(), formRequest.getRequestText(), formRequest.getTravelDate(), "pending", traveler);
        formRepository.save(form);

        return "해당 견적서가 가이드에게 요청되었습니다.";
    }

    @Transactional
    public String acceptFormStatus(Long formId, Long guideId) {
        Form form = formRepository.findById(formId)
                .orElseThrow(() -> new RuntimeException("해당 견적서를 찾을 수 없습니다."));

        form.setIsAccepted("Accept");
        form.setGuideInForm(guideRepository.findById(guideId)
                .orElseThrow(() -> new RuntimeException("매칭하려는 guide의 ID를 존재하지 않습니다.")));

        return "성공적으로 수락되었습니다.";
    }

    @Transactional
    public String rejectFormStatus(Long formId) {
        Form form = formRepository.findById(formId)
                .orElseThrow(() -> new RuntimeException("해당 견적서를 찾을 수 없습니다."));

        form.setIsAccepted("Reject");
        return "견적서를 거절하였습니다.";
    }
}