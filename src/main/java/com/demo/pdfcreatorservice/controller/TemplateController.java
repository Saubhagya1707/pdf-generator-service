package com.demo.pdfcreatorservice.controller;

import com.demo.pdfcreatorservice.dto.TemplateDto;
import com.demo.pdfcreatorservice.service.TemplateService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TemplateController {
    private final TemplateService templateService;

    @PostMapping("/template")
    public TemplateDto create(@RequestBody TemplateRequest request, Principal principal){
        return templateService.create(request, principal.getName());
    }

    @Data
    public static class TemplateRequest{
        String name;
        String code;
    }

}
