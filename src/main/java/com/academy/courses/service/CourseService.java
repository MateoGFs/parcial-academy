package com.academy.courses.service;

import java.util.List;
 
import com.academy.courses.dto.CourseResponse;
import com.academy.courses.dto.CreateCourseRequest;
 
public interface CourseService {
 
    CourseResponse create(CreateCourseRequest request);
 
    List<CourseResponse> list();
 
    CourseResponse getById(Long id);
}
