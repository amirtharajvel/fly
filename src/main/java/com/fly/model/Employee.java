package com.fly.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Setter
@NoArgsConstructor
@Getter
@SQLDelete(sql = "UPDATE employee SET deleted = true WHERE id = ?")
//@Where(clause = "deleted = false") Exclude this to retrieve all deleted data
@FilterDef(name = "deleteEmployeeFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deleteEmployeeFilter", condition = "deleted = :isDeleted")
@Table(uniqueConstraints = @UniqueConstraint(name = "UniqueNameAndEmail", columnNames = {"name"}))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @OneToOne
    private Account account;

    private boolean deleted = false;

    public Employee(String name) {
        this.name = name;
    }
}
