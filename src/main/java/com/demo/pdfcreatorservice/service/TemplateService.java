package com.demo.pdfcreatorservice.service;

import com.demo.pdfcreatorservice.controller.TemplateController;
import com.demo.pdfcreatorservice.dto.TemplateDto;

public interface TemplateService {
    TemplateDto create(TemplateController.TemplateRequest request, String userEmail);
}
