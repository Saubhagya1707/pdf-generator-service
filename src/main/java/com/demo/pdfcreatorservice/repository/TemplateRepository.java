package com.demo.pdfcreatorservice.repository;

import com.demo.pdfcreatorservice.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template, String> {
}