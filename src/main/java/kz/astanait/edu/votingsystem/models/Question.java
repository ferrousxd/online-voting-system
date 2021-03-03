package kz.astanait.edu.votingsystem.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "questions")
public class Question {
    @Id
    @SequenceGenerator(
            name = "questions_sequence",
            sequenceName = "questions_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "questions_sequence"
    )
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "title")
    private String title;

    @NonNull
    @OneToMany(
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            }
    )
    @Column(name = "option_id")
    private Set<Option> options = new HashSet<>();
}