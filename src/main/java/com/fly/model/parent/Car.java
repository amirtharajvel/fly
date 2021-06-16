package com.fly.model.parent;

import com.fly.model.parent.embedded.Brand;
import lombok.Data;

import javax.persistence.*;

@Entity
@AttributeOverride(name="identifier", column = @Column(name = "VIN"))
@Data
public class Car extends Vehicle{

    private String model;

    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "BRAND_NAME", length = 5)),
            @AttributeOverride(name = "address.name", column = @Column(name = "ADDRESS_NAME"))
    })
    private Brand brand;
}
