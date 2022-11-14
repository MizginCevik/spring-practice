package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;

}
