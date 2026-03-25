package com.academy.courses.controller;

import java.util.List;
 
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
 
import com.academy.courses.dto.CourseResponse;
import com.academy.courses.dto.CreateCourseRequest;
import com.academy.courses.service.CourseService;
 
import jakarta.validation.Valid;
 
@RestController
@RequestMapping("/api/courses")
public class CourseController {
 
    private final CourseService courseService;
 
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
 
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse create(@Valid @RequestBody CreateCourseRequest request) {
        return courseService.create(request);
    }
 
    @GetMapping
    public List<CourseResponse> list() {
        return courseService.list();
    }
 
    @GetMapping("/{id}")
    public CourseResponse getById(@PathVariable Long id) {
        return courseService.getById(id);
    }
}