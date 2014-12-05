package com.rmoug.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = "Course.findAll", query = "select o from Course o") })
@XmlRootElement
public class Course implements Serializable {
    private static final long serialVersionUID = 5039038930223641039L;
    @Column(name = "COURSE_NUMBER", nullable = false, length = 6)
    private String courseNumber;
    @Column(nullable = false)
    private Integer credits;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(length = 60)
    private String instructor;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(length = 30)
    private String schedule;

    public Course() {
    }

    public Course(String courseNumber, Integer credits, BigDecimal id, String instructor, String name,
                  String schedule) {
        this.courseNumber = courseNumber;
        this.credits = credits;
        this.id = id;
        this.instructor = instructor;
        this.name = name;
        this.schedule = schedule;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
