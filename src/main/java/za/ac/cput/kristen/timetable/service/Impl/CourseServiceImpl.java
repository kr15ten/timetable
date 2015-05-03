package za.ac.cput.kristen.timetable.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.kristen.timetable.domain.Course;
import za.ac.cput.kristen.timetable.repository.CourseRepository;
import za.ac.cput.kristen.timetable.service.CourseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/3/15.
 */
@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepository repository;

    public List<Course> getCourses()
    {
        List<Course> allCourses = new ArrayList<Course>();

        Iterable<Course> courses = repository.findAll();
        for(Course course: courses)
        {
            allCourses.add(course);
        }

        return allCourses;
    }
}
