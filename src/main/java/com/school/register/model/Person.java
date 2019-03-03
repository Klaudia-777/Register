package com.school.register.model;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class Person {
    @Id
    private String id;
    private String name;
    private String lastname;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
}

