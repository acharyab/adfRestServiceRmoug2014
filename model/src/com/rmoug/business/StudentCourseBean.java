package com.rmoug.business;

import com.rmoug.entities.Course;

import com.rmoug.entities.Student;

import com.rmoug.entities.StudentCourse;

import com.rmoug.entities.StudentCourseVw;

import java.math.BigDecimal;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "StudentCourseBean")
public class StudentCourseBean implements StudentCourseBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "model")
    private EntityManager em;

    public StudentCourseBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public Course persistCourse(Course course) {
        em.persist(course);
        return course;
    }

    public Course mergeCourse(Course course) {
        return em.merge(course);
    }

    public void removeCourse(Course course) {
        course = em.find(Course.class, course.getId());
        em.remove(course);
    }

    /** <code>select o from Course o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Course> getCourseFindAll() {
        return em.createNamedQuery("Course.findAll", Course.class).getResultList();
    }

    public Student persistStudent(Student student) {
        em.persist(student);
        return student;
    }

    public Student mergeStudent(Student student) {
        return em.merge(student);
    }

    public void removeStudent(Student student) {
        student = em.find(Student.class, student.getId());
        em.remove(student);
    }

    /** <code>select o from Student o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Student> getStudentFindAll() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }

    public StudentCourse persistStudentCourse(StudentCourse studentCourse) {
        em.persist(studentCourse);
        return studentCourse;
    }

    public StudentCourse mergeStudentCourse(StudentCourse studentCourse) {
        return em.merge(studentCourse);
    }

    public void removeStudentCourse(StudentCourse studentCourse) {
        studentCourse = em.find(StudentCourse.class, studentCourse.getId());
        em.remove(studentCourse);
    }

    /** <code>select o from StudentCourse o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<StudentCourse> getStudentCourseFindAll() {
        return em.createNamedQuery("StudentCourse.findAll", StudentCourse.class).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<StudentCourseVw> getStudentsForCourse(BigDecimal courseId){
       return em.createNamedQuery("StudentCourseVw.findStudentbyCourse", StudentCourseVw.class).setParameter(1, courseId).getResultList();
    }

}
