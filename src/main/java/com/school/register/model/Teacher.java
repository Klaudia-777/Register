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
public class Teacher extends Person{
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "teacher")
    private Set<Subject> subjects;

    @OneToOne
    @JoinColumn(name="class_id")
    private Class ownClass;

}
