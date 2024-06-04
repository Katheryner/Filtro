package com.riwi.filtro.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String text;
    private String type;
    private Boolean active;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL,orphanRemoval = false)
    private List<OptionQuestion>options;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id",referencedColumnName = "id")
    private Survey survey;

}
