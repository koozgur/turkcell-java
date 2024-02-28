package org.example.core.logging;

import org.example.entities.Course;

public class MailLogger implements Logger{
    @Override
    public void log(Course course){
        loggerId.add(course.getId());
        loggerCourseName.add(course.getName());
        loggerCategoryName.add(course.getCategoryName());
        System.out.println("Logged the course with id: " + course.getId() + " to the mail.");
    }

    @Override
    public boolean checkOccurence(Course course) {
        if(loggerId.contains(course.getId())){
            System.out.println("Can not add the course, that course id already exists.");
            return true;
        }
        else if(loggerCourseName.contains(course.getName())){
            System.out.println("Can not add the course, that course name already exists.");
            return true;
        }
        else if(loggerCategoryName.contains(course.getCategoryName())){
            System.out.println("Can not add the course, that category name already exists.");
            return true;
        }
        else
            return false;
    }

}
