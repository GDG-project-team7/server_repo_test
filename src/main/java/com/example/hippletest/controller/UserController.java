package com.example.hippletest.controller;

import com.example.hippletest.domain.Guide;
import com.example.hippletest.domain.Traveler;
import com.example.hippletest.service.GuideService;
import com.example.hippletest.service.TravelerService;
import com.example.hippletest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final TravelerService travelerService;
    private final GuideService guideService;

    @PostMapping("/saveGuide")
    public ResponseEntity<Map<String, Long>> saveGuide(@RequestBody Guide guide) {
        Long guideId = guideService.saveGuide(guide);
        Map<String, Long> response = new HashMap<>();
        response.put("userId", guideId);  // JSON 형태로 변환됨
        return ResponseEntity.ok(response);
    }

    @PostMapping("/saveTraveler")
    public ResponseEntity<Traveler> saveTraveler(@RequestBody Traveler traveler) {
        return ResponseEntity.ok().body(userService.saveUserTraveler(traveler));
    }


//    @GetMapping("/login")
//    public ResponseEntity<TokenDto> login(@RequestBody UserLogin userLogin) {
//        return ResponseEntity.ok().body(userService.loginUser(userLogin));
//    }
//
//    @GetMapping
//    public ResponseEntity<UserInfo> getUser(Principal principal) {
//        return ResponseEntity.ok().body(userService.getUser(principal));
//    }
}