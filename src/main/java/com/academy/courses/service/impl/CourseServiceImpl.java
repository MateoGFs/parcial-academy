package com.academy.courses.service.impl;

import java.util.List;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.academy.courses.dto.CourseResponse;
import com.academy.courses.dto.CreateCourseRequest;
import com.academy.courses.entity.Course;

import com.academy.courses.exception.ResourceNotFoundException;
import com.academy.courses.repository.CourseRepository;

import com.academy.courses.service.CourseService;
 
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
 
    private final CourseRepository courseRepository;
    
 
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        
    }
 
    @Override
    public CourseResponse create(CreateCourseRequest request) {
        Course course = new Course();
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setCredits(request.getCredits());
 
        
 
        Course saved = courseRepository.save(course);
        return toResponse(saved);
    }
 
    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return courseRepository.findAll().stream().map(this::toResponse).toList();
    }
 
    @Override
    @Transactional(readOnly = true)
    public CourseResponse getById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course " + id + " not found"));
        return toResponse(course);
    }
 
    private CourseResponse toResponse(Course course) {
        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setName(course.getName());
        response.setDescription(course.getDescription());
        response.setCredits(course.getCredits());
        
        response.setCreatedAt(course.getCreatedAt());
        response.setUpdatedAt(course.getUpdatedAt());
        return response;
    }
}