package com.rmoug.service;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.rmoug.entities.*;

import org.codehaus.jackson.map.ObjectMapper;


public class StudentProvider {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
    }

    @Provider
    @Consumes(MediaType.APPLICATION_JSON)
    public static class StudentCourseJsonReader implements MessageBodyReader<StudentCourse> {


        @Override
        public boolean isReadable(Class<?> c, Type type, Annotation[] annotation, MediaType mediaType) {
            return c == StudentCourse.class;
        }

        @Override
        public StudentCourse readFrom(Class<StudentCourse> c, Type type, Annotation[] annotation,
                                        MediaType mediaType, MultivaluedMap<String, String> multivaluedMap,
                                        InputStream inputStream) throws IOException, WebApplicationException {
            return mapper.readValue(inputStream, StudentCourse.class);
        }
    }
    
    @Provider
    @Consumes(MediaType.APPLICATION_JSON)
    public static class CourseJsonReader implements MessageBodyReader<Course> {


        @Override
        public boolean isReadable(Class<?> c, Type type, Annotation[] annotation, MediaType mediaType) {
            return c == Course.class;
        }

        @Override
        public Course readFrom(Class<Course> c, Type type, Annotation[] annotation,
                                        MediaType mediaType, MultivaluedMap<String, String> multivaluedMap,
                                        InputStream inputStream) throws IOException, WebApplicationException {
            return mapper.readValue(inputStream, Course.class);
        }
    }  
    
    @Provider
    @Produces(MediaType.APPLICATION_JSON)
    public static class ObjectJsonWriter implements MessageBodyWriter<Object> {

        @Override
        public boolean isWriteable(Class<?> c, Type type, Annotation[] annotation, MediaType mediaType) {
            return true;
        }

        @Override
        public long getSize(Object list, Class<?> c, Type type, Annotation[] annotation,
                            MediaType mediaType) {
            return -1;
        }

        @Override
        public void writeTo(Object object, Class<?> c, Type type, Annotation[] annotation, MediaType mediaType,
                            MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException,
                                                                                                             WebApplicationException {
            mapper.writeValue(outputStream, object);
        }
    }    
    
    @Provider
    @Consumes(MediaType.APPLICATION_JSON)
    public static class StudentJsonReader implements MessageBodyReader<Student> {


        @Override
        public boolean isReadable(Class<?> c, Type type, Annotation[] annotation, MediaType mediaType) {
            return c == Student.class;
        }

        @Override
        public Student readFrom(Class<Student> c, Type type, Annotation[] annotation,
                                        MediaType mediaType, MultivaluedMap<String, String> multivaluedMap,
                                        InputStream inputStream) throws IOException, WebApplicationException {
            return mapper.readValue(inputStream, Student.class);
        }
    }
       
    
}