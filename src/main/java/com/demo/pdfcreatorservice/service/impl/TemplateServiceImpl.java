package com.demo.pdfcreatorservice.service.impl;

import com.demo.pdfcreatorservice.controller.TemplateController;
import com.demo.pdfcreatorservice.dto.TemplateDto;
import com.demo.pdfcreatorservice.model.Template;
import com.demo.pdfcreatorservice.repository.TemplateRepository;
import com.demo.pdfcreatorservice.repository.UserRepository;
import com.demo.pdfcreatorservice.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {
    private final TemplateRepository templateRepository;
    private final UserRepository userRepository;


    @Override
    public TemplateDto create(TemplateController.TemplateRequest request, String userEmail) {
        return TemplateDto.of(templateRepository.save(
                Template.builder()
                        .name(request.getName())
                        .code(request.getCode())
                        .visibility(Template.Visibility.PUBLIC)
                        .createdBy(userRepository.findByEmail(userEmail).orElseThrow())
                        .build()
        ));
    }
}
