package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {


    @Id
    private Integer id;

    @NotEmpty(message = "name can't be empty")
    @Size(min = 2)
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    private Integer points;

    private Double wallet;

    private boolean loyalty = false;


    @OneToOne
    @MapsId // PK
    @JsonIgnore
    private MyUser myUser;



}
