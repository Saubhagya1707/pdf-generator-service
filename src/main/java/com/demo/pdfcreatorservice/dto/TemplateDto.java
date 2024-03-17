package com.demo.pdfcreatorservice.dto;

import com.demo.pdfcreatorservice.model.Template;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TemplateDto {
    String id;
    String code;
    UserDto user;
    Template.Visibility visibility;
    Instant createdDt;
    String name;

    public static TemplateDto of(Template template){
        return TemplateDto.builder()
                .id(template.getId())
                .name(template.getName())
                .code(template.getCode())
                .createdDt(template.getCreatedDt())
                .visibility(template.getVisibility())
                .user(UserDto.of(template.getCreatedBy()))
                .build();
    }

}
