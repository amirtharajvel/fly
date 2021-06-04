package com.fly.model;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class Department {

    @Id
    private Long id;

    private String name;

    public Department(String name) {
        this.name = name;
    }
}
