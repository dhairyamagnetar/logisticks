package com.example.logisticks.models;

public class Course {
    private int id;
    private String title;
    private String description;
    private String link;

    public Course(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }
    public Course(){}
    public int getCourseId() {
        return id;
    }
    public void setCourseId(int courseId) {
        this.id = courseId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
