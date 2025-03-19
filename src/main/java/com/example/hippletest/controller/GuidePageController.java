package com.example.hippletest.controller;

import com.example.hippletest.domain.Form;
import com.example.hippletest.domain.Portfolio;
import com.example.hippletest.service.FormService;
import com.example.hippletest.service.GuideService;
import com.example.hippletest.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guidePage")
@RequiredArgsConstructor

@Tag(name = "가이드 페이지 API", description = "가이드 측면의 API입니다.")
public class GuidePageController {
    private final UserService userService;
    private final FormService formService;
    private final GuideService guideService;

    //가이드의 이름 보기
    @GetMapping("/getGuideName/{id}")
    public String getGuideName(@PathVariable Long id) {
        return userService.getInfoGuideName(id);
    }

    //가이드가 가지고 있는 견적서 리스트 확인
    @GetMapping("/{guideId}/getForms")
    public List<Form> getGuideForms(@PathVariable Long guideId) {
        return userService.getForms(guideId);
    }

    //견적서 클릭 시, 하나의 견적서 보기
    @GetMapping("/{formId}/getForm")
    public Form getForm(@PathVariable Long formId) {
        return formService.getForm(formId);
    }

    //가이드 포트폴리오 저장 ########################
    @PostMapping("/savePortfolio/{guideId}")
    public Portfolio savePortfolio(@PathVariable Long guideId, @RequestBody Portfolio portfolio) {
        return guideService.savePortfolio(guideId, portfolio);
    }

}
