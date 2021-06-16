package com.fly.model.parent;

import com.fly.model.parent.embedded.Address;
import com.fly.model.parent.embedded.Brand;
import com.fly.model.parent.embedded.Owner;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Entity
@AttributeOverride(name="identifier", column = @Column(name = "VIN"))
@Data
@Getter
@Setter
public class Car extends Vehicle{

    private String model;

    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "BRAND_NAME", length = 5)),
            @AttributeOverride(name = "address.name", column = @Column(name = "ADDRESS_NAME"))
    })
    private Brand brand;

    @ElementCollection
    @AttributeOverrides({
        @AttributeOverride(name="key.name", column = @Column(name = "OWNER_NAME")),
            @AttributeOverride(name = "key.surname", column = @Column(name = "OWNER_SURNAME")),
            @AttributeOverride(name = "value.name", column = @Column(name = "ADDRESS_NAME"))
    })
    Map<Owner, Address> owners;

    /**
     * Output: separate table is created as below
     *
     * mysql> desc car_owners;
     * +---------------+--------------+------+-----+---------+-------+
     * | Field         | Type         | Null | Key | Default | Extra |
     * +---------------+--------------+------+-----+---------+-------+
     * | car_id        | bigint       | NO   | PRI | NULL    |       |
     * | city          | varchar(255) | YES  |     | NULL    |       |
     * | address_name  | varchar(255) | YES  |     | NULL    |       |
     * | owner_name    | varchar(255) | NO   | PRI | NULL    |       |
     * | owner_surname | varchar(255) | NO   | PRI | NULL    |       |
     * +---------------+--------------+------+-----+---------+-------+
     * 5 rows in set (0.00 sec)
     */
}
