package org.iesvdm.preproyectoapirest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "badge")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long Id;

    @Enumerated(EnumType.STRING)
    private UBadge badgeName;

    private Long streakConnection;

    private Long numTasksDone;

    @Column(columnDefinition = "text")
    private String defaultText;

    @OneToMany(mappedBy = "badge")
    @JsonIgnore
    private Set<User> userSet = new HashSet<>();

    public Badge (Long id) {
        this.Id = id;
    }
}
