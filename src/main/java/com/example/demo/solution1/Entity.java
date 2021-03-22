package com.example.demo.solution1;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@javax.persistence.Entity
class Entity {

    @Id
    @Column(length = 1000)
    private String id;

    @Column(length = 1000)
    private String value;

}
