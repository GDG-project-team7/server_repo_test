package com.example.hippletest.repository;

import com.example.hippletest.domain.Traveler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelerRepository extends JpaRepository<Traveler, Long> {
}
