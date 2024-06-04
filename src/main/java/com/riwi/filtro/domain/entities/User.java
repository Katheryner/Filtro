package com.riwi.filtro.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private  String email;
    @Column(length = 10, nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean active;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Survey>surveys;
}
