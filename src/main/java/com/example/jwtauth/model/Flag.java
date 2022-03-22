package com.example.jwtauth.model;

import javax.persistence.*;

@Entity
@Table(name="flags")
public class Flag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column
    private EFlag name;

    public Flag() {}

    public Flag(EFlag name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EFlag getName() {
        return name;
    }

    public void setName(EFlag name) {
        this.name = name;
    }
}
