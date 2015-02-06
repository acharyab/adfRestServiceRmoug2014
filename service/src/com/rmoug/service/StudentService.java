package com.rmoug.service;

import com.rmoug.business.StudentCourseBeanLocal;

import com.rmoug.entities.Course;
import com.rmoug.entities.Student;
import com.rmoug.entities.StudentCourse;

import com.rmoug.entities.StudentCourseVw;

import java.math.BigDecimal;

import java.util.List;

import javax.inject.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ejb.EJB;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.codehaus.jackson.map.ObjectMapper;

@Singleton
@Path("service")
public class StudentService {
    
    @EJB
    StudentCourseBeanLocal studentBean;
    
    public StudentService() {
        super();
    }

    @GET
    @Produces("text/plain")
    @Path("/hello")
    public String helloWorld(){       
        return "Hello RMOUG 2015";
    }
    
    @GET
    @Produces("application/json")
    @Path("/student")
    public List<Student> getStudentFindAll(@QueryParam("studentId") Integer studentId){    
        List<Student> students;
        if (studentId != null){
            students = studentBean.getStudentById(studentId);
        }else{
            students = studentBean.getStudentFindAll();
        }
        
        return students;       
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/studentCourse") 
    public List<StudentCourseVw> getStudentsForCourse(@QueryParam("courseId") BigDecimal courseId) {
        
      List<StudentCourseVw> studentsForCourse;
      
      if (courseId != null)
          studentsForCourse = studentBean.getStudentsForCourse(courseId);
      else
          throw new WebApplicationException(Response.Status.BAD_REQUEST);
      
      return studentsForCourse;
    }
    
    
    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Path("/studentCourse")
    public Response addStudentToCourse(StudentCourse studentCourse) {
        StudentCourse newSc= new StudentCourse();
        newSc = studentBean.persistStudentCourse(studentCourse);
        return Response.ok().build();
    } 
    

    @DELETE
    @Consumes (MediaType.APPLICATION_JSON)
    @Path("/studentCourse")
    public Response removeStudentFromCourse(StudentCourse studentCourse) {
        studentBean.removeStudentCourse(studentCourse);
        return Response.ok().build();
    }  

    @DELETE
    @Path("/studentCourse/{studentCourseId}")
    public Response removeStudentFromCourseParam(@PathParam("studentCourseId") String studentCourseId) {
        StudentCourse sc = new StudentCourse();
        sc.setId(new BigDecimal(studentCourseId));
        studentBean.removeStudentCourse(sc);
        return Response.ok().build();
    }     
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/student")
    public Response updateStudent(Student student){
       studentBean.mergeStudent(student);
        return Response.ok().build(); 
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/course")
    public List<Course> getAllCourses(){
        return studentBean.getCourseFindAll();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/coursesForStudent") 
    public List<StudentCourseVw> getCoursesForStudent(@QueryParam("studentId") BigDecimal studentId) {
        
      List<StudentCourseVw> courseForStudent;
      
      if (studentId != null)
          courseForStudent = studentBean.getCoursesByStudent(studentId);
      else
          throw new WebApplicationException(Response.Status.BAD_REQUEST);
      
      return courseForStudent;
    }
    
    
}
