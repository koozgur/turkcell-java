package org.example.business;

import org.example.core.logging.Logger;
import org.example.dataAccess.JdbcCourseDao;
import org.example.dataAccess.CourseDao;
import org.example.entities.Course;

import java.util.List;

public class CourseManager {
    CourseDao productDao;
    private List<Logger> loggerList;
     public CourseManager(CourseDao productDao, List<Logger> loggerList){
         this.productDao = productDao;
         this.loggerList = loggerList;
     }
    public void add(Course course) throws Exception { //business rules
        if(course.getPrice() < 0){
            throw new Exception("Course price should be greater than 0.");
        }
        for(Logger logger: loggerList){
            if(logger.checkOccurence(course)){
                throw new Exception("Failed to add course with id: " + course.getId() + " to the database.");
            }
        }
        productDao.add(course);

        for(Logger logger : loggerList){ //add course to all loggers
            logger.log(course);
        }

    }


}
