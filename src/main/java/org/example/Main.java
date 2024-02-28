package org.example;

import org.example.business.CourseManager;
import org.example.core.logging.DatabaseLogger;
import org.example.core.logging.FileLogger;
import org.example.core.logging.Logger;
import org.example.core.logging.MailLogger;
import org.example.dataAccess.CourseDao;
import org.example.dataAccess.HibernateCourseDao;
import org.example.dataAccess.JdbcCourseDao;
import org.example.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Course>courseList = new ArrayList<>();
        Course course1 = new Course(1, "Java Back-End Bootcamp", 10, "Back-End", 200);
        Course course2 = new Course(2, "Kotlin Bootcamp", 100, "Android", 100);
        Course course3 = new Course(3, ".NET Crash Course", 250, "Back-End", 190);
        courseList.add(course1);
        courseList.add(course3);
        courseList.add(course2);


        List<Logger> loggerList = new ArrayList<>();
        loggerList.add(new DatabaseLogger());
        loggerList.add(new FileLogger());
        loggerList.add(new MailLogger());


        CourseDao courseDao1 = new JdbcCourseDao();
        CourseDao courseDao2 = new HibernateCourseDao();

        CourseManager courseManager = new CourseManager(courseDao1, loggerList);


        for(Course course: courseList){
            try {
                courseManager.add(course);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}