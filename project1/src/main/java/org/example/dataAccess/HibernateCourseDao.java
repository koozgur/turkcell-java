package org.example.dataAccess;

import org.example.entities.Course;

public class HibernateCourseDao implements CourseDao {
    @Override
    public void add(Course course){
        //db access
        System.out.println("Course with id " + course.getId() + " successfully added to the Hibernate database");
    }
}
