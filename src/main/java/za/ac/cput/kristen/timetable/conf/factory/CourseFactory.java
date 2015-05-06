package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Course;
import za.ac.cput.kristen.timetable.domain.Subject;

import java.util.List;

/**
 * Created by kris on 5/4/15.
 */
public class CourseFactory
{
    public static Course createCourse(String courseCode, String name,
                                      String qualification, int years,
                                      int credits, List<Subject> subjects)
    {
        Course course = new Course
                .Builder(courseCode)
                .name(name)
                .qualification(qualification)
                .years(years)
                .subjects(subjects)
                .credits(credits)
                .build();
        return course;
    }

}
