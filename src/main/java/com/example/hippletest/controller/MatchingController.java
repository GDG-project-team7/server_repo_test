package com.example.hippletest.controller;

import com.example.hippletest.domain.Form;
import com.example.hippletest.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matching")
@RequiredArgsConstructor
public class MatchingController {
    private final FormService formService;

    // 1. Traveler가 Guide를 선택하고 Form을 제출
    @PostMapping("/{travelerId}/select-guide/{guideId}")
    public ResponseEntity<String> submitForm(
            @PathVariable Long travelerId,
            @PathVariable Long guideId,
            @RequestBody Form formRequest) {

        return ResponseEntity.ok().body(formService.submitForm(travelerId, guideId, formRequest));
    }

    // 2. Guide의 견적서 수락
    @PatchMapping("/{formId}/acceptForm/{guideId}")
    public ResponseEntity<String> acceptFormStatus(@PathVariable Long formId, @PathVariable Long guideId) {
        return ResponseEntity.ok().body(formService.acceptFormStatus(formId, guideId));
    }

    // 3. Guide의 견적서 거절
    @PatchMapping("/{formId}/rejectForm")
    public ResponseEntity<String> rejectFormStatus(@PathVariable Long formId) {
        return ResponseEntity.ok().body(formService.rejectFormStatus(formId));
    }
}
