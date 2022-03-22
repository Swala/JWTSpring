package com.example.jwtauth.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private Date deadline;

    @Column
    private String description;

    //should be manyToOne, unidirectional relation where flag does not know about the relation
    @ManyToOne(cascade = CascadeType.ALL)
    private Flag flag;

    /*@ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;*/

    public Project() {}

    public Project(String name, Date deadline, String description) {
        this.name = name;
        this.deadline = deadline;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

   /* public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/

}
