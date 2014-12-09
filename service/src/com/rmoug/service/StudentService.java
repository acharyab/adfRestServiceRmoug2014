package com.rmoug.service;

import com.rmoug.business.StudentCourseBeanLocal;

import com.rmoug.entities.Student;
import com.rmoug.entities.StudentCourse;

import java.util.List;

import javax.inject.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ejb.EJB;


@Singleton
@Path("service")
public class StudentService {
    
    @EJB
    StudentCourseBeanLocal StudentBean;
    
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
    public List<Student> getStudentFindAll(){
        
        return StudentBean.getStudentFindAll();
        
    }
    
}
