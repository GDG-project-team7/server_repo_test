package com.example.hippletest.repository;

import com.example.hippletest.domain.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}
