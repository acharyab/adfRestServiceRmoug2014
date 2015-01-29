package com.rmoug.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = "StudentCourse.findAll", query = "select o from StudentCourse o"),
                 @NamedQuery(name = "StudentCourse.findStudentCourseById", query = "select o from StudentCourse o where o.studentId = ?1")
                })
@Table(name = "STUDENT_COURSE")
@XmlRootElement
public class StudentCourse implements Serializable {
    private static final long serialVersionUID = 6002553573630871522L;
    @Temporal(TemporalType.DATE)
    @Column(name = "COMPLETE_DATE")
    private Date completeDate;
    @Column(name = "COURSE_ID", nullable = false)
    private BigDecimal courseId;
    private BigDecimal grade;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generic_seq")
    @SequenceGenerator( name="generic_seq", sequenceName="GENERIC_SEQ", allocationSize=1)           
    private BigDecimal id;
    @Column(name = "STUDENT_ID", nullable = false)
    private BigDecimal studentId;

    public StudentCourse() {
    }

    public StudentCourse(Date completeDate, BigDecimal courseId, BigDecimal grade, BigDecimal id, BigDecimal studentId) {
        this.completeDate = completeDate;
        this.courseId = courseId;
        this.grade = grade;
        this.id = id;
        this.studentId = studentId;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public BigDecimal getCourseId() {
        return courseId;
    }

    public void setCourseId(BigDecimal courseId) {
        this.courseId = courseId;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getStudentId() {
        return studentId;
    }

    public void setStudentId(BigDecimal studentId) {
        this.studentId = studentId;
    }
}
