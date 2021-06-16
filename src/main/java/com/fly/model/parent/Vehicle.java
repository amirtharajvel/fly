package com.fly.model.parent;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;
    private String identifier;
    private Integer numberOfWheels;

}
