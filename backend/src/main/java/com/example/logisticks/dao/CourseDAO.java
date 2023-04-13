package com.example.logisticks.dao;
import com.example.logisticks.models.Course;
import java.util.List;

public interface CourseDAO {
    int save(Course course);
    int update(Course course, int id);
    int delete(int id);
    List<Course> getAll();
    Course getById(int id);
}
