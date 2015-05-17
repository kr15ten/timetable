package za.ac.cput.kristen.timetable.service;

import za.ac.cput.kristen.timetable.domain.Course;
import za.ac.cput.kristen.timetable.domain.Subject;

import java.util.List;

/**
 * Created by kris on 4/16/15.
 */
public interface CourseService
{
    List<Course> getCourses();

    List<Subject> getSubjects(String courseCode);
}
