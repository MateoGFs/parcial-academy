package com.academy.courses.entity;

import java.time.Instant;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "course")
public class Course {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, length = 150)
    private String name;
 
    @Column(length = 2000)
    private String description;
 
    @Column(nullable = false)
    private Integer credits;
 
    //@ManyToOne
    
    //@JoinColumn(name = "instructor_id")
    //private Instructor instructor;
 
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
 
    @Column(nullable = false)
    private Instant updatedAt;
 
    @PrePersist
    void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
 
    @PreUpdate
    void onUpdate() {
        this.updatedAt = Instant.now();
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
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
 
    //public Instructor getInstructor() {
    //    return instructor;
    //}
 
    //public void setInstructor(Instructor instructor) {
    //    this.instructor = instructor;
    //}
 
    public Instant getCreatedAt() {
        return createdAt;
    }
 
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
 
    public Instant getUpdatedAt() {
        return updatedAt;
    }
 
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
