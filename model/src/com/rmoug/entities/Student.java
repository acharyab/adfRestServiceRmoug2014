package com.rmoug.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = "Student.findAll", query = "select o from Student o") })
@XmlRootElement
public class Student implements Serializable {
    private static final long serialVersionUID = 8169970994223395995L;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dob;
    @Column(nullable = false, length = 1)
    private String gender;
    private Integer gpa;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(length = 60)
    private String photo;
    @Column(nullable = false, length = 60)
    private String year;

    public Student() {
    }

    public Student(Date dob, String gender, Integer gpa, BigDecimal id, String name, String photo, String year) {
        this.dob = dob;
        this.gender = gender;
        this.gpa = gpa;
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.year = year;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getGpa() {
        return gpa;
    }

    public void setGpa(Integer gpa) {
        this.gpa = gpa;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
