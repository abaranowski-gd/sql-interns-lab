package com.griddynamics.sqlinternslab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEWER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reviewer {

    @Id
    @Column(name = "rId")
    private Long rId;

    @Column(name = "name")
    private String name;
}
