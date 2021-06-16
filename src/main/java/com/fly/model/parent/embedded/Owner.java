package com.fly.model.parent.embedded;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Owner {

    private String name;
    private String surname;


}
