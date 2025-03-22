package com.example.hippletest.domain;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Guide extends User {
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio; // Guide는 1개의 Portfolio를 가짐

    @OneToMany(mappedBy = "guide", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Form> forms = new ArrayList<>(); // Guide는 여러 개의 Form을 가짐

    public Guide(String password, String userName, boolean isGuide, int regionId, String email, String phoneNumber, int birthday6Numbers, String userAccountName, boolean gender) {
        super(password, userName, true, regionId, email, phoneNumber, birthday6Numbers, userAccountName, gender);

        this.portfolio = null; // ✅ Portfolio는 나중에 설정 가능
        this.forms = null;
    }
}