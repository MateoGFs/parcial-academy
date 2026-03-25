package com.academy.courses.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
 
public class CreateCourseRequest {
 
    @NotBlank(message = "name is required")
    @Size(max = 150, message = "name must be <= 150 chars")
    private String name;
 
    @Size(max = 2000, message = "description must be <= 2000 chars")
    private String description;
 
    @NotNull(message = "credits is required")
    @Min(value = 1, message = "credits must be at least 1")
    private Integer credits;
 
    private Long instructorId;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public Integer getCredits() {
        return credits;
    }
 
    public void setCredits(Integer credits) {
        this.credits = credits;
    }
 
    public Long getInstructorId() {
        return instructorId;
    }
 
    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
}