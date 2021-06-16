package com.fly.model.parent;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name="identifier", column = @Column(name = "VIN"))
@Data
public class Car extends Vehicle{

    private String model;

    private String name;

}
