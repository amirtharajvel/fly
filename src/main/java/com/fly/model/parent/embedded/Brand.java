package com.fly.model.parent.embedded;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDate;

@Embeddable
public class Brand {

    private String name;
    private LocalDate foundationDate;

    @Embedded
    private Address address;


}
