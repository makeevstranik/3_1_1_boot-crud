package com.makeev.bootcrud.pp_3_1_1_bootcrud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @NotBlank(message = "enter name")
    @Size(min=4, max=30, message = "min4max30")
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @NotBlank(message = "enter lastname")
    @Size(min=4, max=30, message = "min4max30")
    private String lastName;

    @Column(name="age")
    @NotNull
    @Min(value=0, message=">0")
    @Max(value = 150, message = "<150")
    private int age;

    @Column(name = "email")
    @NotNull
    @NotBlank(message = "enter email")
    @Email(message = "not valid email")
    private String email;
}
