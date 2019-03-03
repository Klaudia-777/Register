package com.school.register.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Class {
    @Id
    private String id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,optional = false,mappedBy = "ownClass")
    private Teacher tutor;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "aClass")
    private Set<Student> students;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "aClass")
    private Set<Subject> subjects;
    private String academicPeriod;
    private String code;
}
