package org.example.core.logging;

import org.example.entities.Course;

import java.util.ArrayList;
import java.util.List;

public interface Logger {
        List<Integer>loggerId = new ArrayList<>();
        List<String>loggerCourseName = new ArrayList<>();
        List<String>loggerCategoryName = new ArrayList<>();
        void log(Course course);

        boolean checkOccurence(Course course);
}
