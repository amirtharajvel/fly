package com.fly.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@NoArgsConstructor
@Getter
@Table(uniqueConstraints = @UniqueConstraint(name = "UniqueNameAndEmail", columnNames = {"name"}))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @OneToOne
    private Account account;

    public Employee(String name) {
        this.name = name;
    }
}
