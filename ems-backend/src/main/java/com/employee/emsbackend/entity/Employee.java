package com.employee.emsbackend.entity;

//entities are persistence stored as a record in the database.
// you can call it schema in terms of mongoDb or models in terms of nodejs


import jakarta.persistence.*;
import lombok.AllArgsConstructor; // to create args constructor
import lombok.Getter;  // this annotation provides getter methods without including them in your boiler code
import lombok.NoArgsConstructor; // to create no args constructor
import lombok.Setter; // this annotation provides setter methods without including them in your boiler code

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @Id // to make id as primary key( uniquely identify the entity in the database)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this strategy using autoincrement  feature to increase id
    private Long id;

    @Column(name="first_name") // to map entity member with table column name(here firstName will be mapped with first_name column in employees table). By default field name is taken as column name if we don't specify
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_id", nullable= false,unique = true)
    private String email;
}
