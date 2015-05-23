package za.ac.cput.kristen.timetable.service;

import za.ac.cput.kristen.timetable.domain.Course;
import za.ac.cput.kristen.timetable.domain.Student;

import java.util.List;

/**
 * Created by kris on 4/16/15.
 */
public interface StudentService
{
    List<Student> getStudents();

    Student getStudent(Long id);

    String getCoursecode(Long id);
}
