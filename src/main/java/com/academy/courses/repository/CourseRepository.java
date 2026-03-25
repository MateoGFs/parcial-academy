package com.academy.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.academy.courses.entity.Course;
 
public interface CourseRepository extends JpaRepository<Course, Long> {
}
