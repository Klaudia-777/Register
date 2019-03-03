package com.school.register.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Subject {
    @Id
    private String id;
    @Enumerated(value = EnumType.STRING)
    private SubjectType type;
    @ManyToOne(fetch = FetchType.EAGER) // o tym zpomnielismy :D
    @JoinColumn(name="class_id")
    private Class aClass;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id")
    private Teacher teacher;
}
