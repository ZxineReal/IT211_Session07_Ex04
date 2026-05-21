package com.example.session07_ex04.service.impl;

import com.example.session07_ex04.exception.ResourceNotFoundException;
import com.example.session07_ex04.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    public String getCourseById(String courseId) {
        if (courseId == null || !courseId.equals("CS101")) {
            throw new ResourceNotFoundException("Khóa học", courseId);
        }
        return "Course: CS101 - Lập trình Spring Boot AOP";
    }

    public void updateCourse(String courseId, String newName) {
        if (courseId == null || !courseId.equals("CS101")) {
            throw new ResourceNotFoundException("Khóa học", courseId);
        }
        System.out.println("Đã cập nhật khóa học " + courseId + " thành: " + newName);
    }

    public void deleteCourse(String courseId) {
        if (courseId == null || !courseId.equals("CS101")) {
            throw new ResourceNotFoundException("Khóa học", courseId);
        }
        System.out.println("Đã xóa khóa học " + courseId);
    }
}