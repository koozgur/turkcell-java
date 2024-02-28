package org.example.dataAccess;

import org.example.entities.Course;

public interface CourseDao {
    //since we have multiple database possibilities, we will bind them to a root class rather than depending on themselves.
    void add(Course course);
}
