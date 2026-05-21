package com.example.session07_ex04.service;

public interface CourseService {
    String getCourseById(String courseId);
    void updateCourse(String courseId, String newName);
    void deleteCourse(String courseId);
}