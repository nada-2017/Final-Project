package com.example.finalproject.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class MyUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "username can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String username;
    @NotEmpty(message = "password can't be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @NotEmpty(message = "email can't be empty")
    @Email(message = "invalid email",regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;
    @NotEmpty(message = "phone number can't be empty")
    @Column(columnDefinition ="varchar(10)")
    private String phoneNumber;
    @NotEmpty(message = "role can't be empty")
    @Column(columnDefinition = "varchar(30) not null check(role ='customer' or role='provider')")
    private String role;


    @OneToOne(cascade = CascadeType.ALL , mappedBy = "myUser")
    @PrimaryKeyJoinColumn
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "myUser")
    @PrimaryKeyJoinColumn
    private Provider provider;
}
