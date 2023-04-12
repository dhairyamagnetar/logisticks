package com.example.logisticks.controllers;

import com.example.logisticks.models.Course;
import com.example.logisticks.dao.CourseDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CourseController {
    @Autowired
    private CourseDAO cDAO;

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return cDAO.getAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id){
        return cDAO.getById(id);
    }

    @PostMapping("/courses")
    public String saveCourse(@RequestBody Course course){
        return cDAO.save(course) + " Number of rows saved to the database";
    }

    @PutMapping("/courses/{id}")
    public String updateCourse(@RequestBody Course course, @PathVariable int id){
        return cDAO.update(course, id) + "Number of updated in the database";
    }

    @DeleteMapping("/courses/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return cDAO.delete(id) + "Number of rows deleted";
    }
}
