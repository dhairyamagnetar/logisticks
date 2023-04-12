package com.example.logisticks.dao;

import com.example.logisticks.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.logisticks.dao.CourseDAO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class CourseDAOimpl implements CourseDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int save(Course course) {
        return jdbcTemplate.update("insert into course(id, title, description, link) values (?, ?, ?, ?)", course.getCourseId(), course.getTitle(), course
                .getDescription(), course.getLink());
    }

    @Override
    public int update(Course course, int id) {
        return jdbcTemplate.update("update course set title=?, description=?, link=? where id=?", course.getDescription(), course.getDescription(), course.getLink(), id);
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from course where id=?", id);
    }

    @Override
    public List<Course> getAll() {
        return jdbcTemplate.query("select * from course", new BeanPropertyRowMapper<Course>(Course.class));
    }
    @Override
    public Course getById(int id) {
         return jdbcTemplate.queryForObject("select * from course where id = ?", new BeanPropertyRowMapper<Course>(Course.class), id);
    }
}
