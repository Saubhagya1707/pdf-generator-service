package com.demo.pdfcreatorservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "code", columnDefinition = "text")
    String code;

    @CreationTimestamp
    Instant createdDt;

    @UpdateTimestamp
    Instant updatedDt;

    @Enumerated(EnumType.STRING)
    Visibility visibility;

    String name;

    @ManyToOne
    @JoinColumn
    User createdBy;

    public enum Visibility{
        PRIVATE, PUBLIC
    }
}
