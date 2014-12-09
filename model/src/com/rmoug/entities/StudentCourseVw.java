package com.rmoug.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = "StudentCourseVw.findAll", query = "select o from StudentCourseVw o"),
                @NamedQuery(name = "StudentCourseVw.findStudentbyCourse", query = "select o from StudentCourseVw o where o.courseId = ?1") })
@Table(name = "STUDENT_COURSE_VW")
@XmlRootElement
public class StudentCourseVw implements Serializable {
    private static final long serialVersionUID = -2331883788688658541L;
    @Column(name = "COURSE_ID", nullable = false)
    private BigDecimal courseId;
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
    @Column(name = "STUDENT_ID", nullable = false)
    private BigDecimal studentId;
    @Column(nullable = false, length = 60)
    private String year;

    public StudentCourseVw() {
    }

    public StudentCourseVw(BigDecimal courseId, Date dob, String gender, Integer gpa, BigDecimal id, String name,
                           String photo, BigDecimal studentId, String year) {
        this.courseId = courseId;
        this.dob = dob;
        this.gender = gender;
        this.gpa = gpa;
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.studentId = studentId;
        this.year = year;
    }

    public BigDecimal getCourseId() {
        return courseId;
    }

    public void setCourseId(BigDecimal courseId) {
        this.courseId = courseId;
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

    public BigDecimal getStudentId() {
        return studentId;
    }

    public void setStudentId(BigDecimal studentId) {
        this.studentId = studentId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
