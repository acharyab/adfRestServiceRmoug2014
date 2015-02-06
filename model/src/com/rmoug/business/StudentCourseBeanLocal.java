package com.rmoug.business;

import com.rmoug.entities.Course;
import com.rmoug.entities.Student;
import com.rmoug.entities.StudentCourse;

import com.rmoug.entities.StudentCourseVw;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;

@Local
public interface StudentCourseBeanLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    Course persistCourse(Course course);

    Course mergeCourse(Course course);

    void removeCourse(Course course);

    List<Course> getCourseFindAll();

    Student persistStudent(Student student);

    Student mergeStudent(Student student);

    void removeStudent(Student student);

    List<Student> getStudentFindAll();
    
    List<Student> getStudentById(Integer studentId);

    StudentCourse persistStudentCourse(StudentCourse studentCourse);

    StudentCourse mergeStudentCourse(StudentCourse studentCourse);

    void removeStudentCourse(StudentCourse studentCourse);

    List<StudentCourse> getStudentCourseFindAll();
    
    List<StudentCourseVw> getStudentsForCourse(BigDecimal courseId);
    
    List<StudentCourseVw> getCoursesByStudent(BigDecimal studentId);
    
    List<Student> getStudentNoCourse(BigDecimal courseId);
}
