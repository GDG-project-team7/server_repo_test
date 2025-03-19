package com.example.hippletest.repository;

import com.example.hippletest.domain.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    List<Guide> findAllByRegionId(Long regionId);
}