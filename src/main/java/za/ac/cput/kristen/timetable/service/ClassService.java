package za.ac.cput.kristen.timetable.service;

import za.ac.cput.kristen.timetable.domain.Class;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Student;

import java.util.List;

/**
 * Created by kris on 4/16/15.
 */
public interface ClassService
{
    List<Class> getClasses();

    List<Student> getStudents(String classCode);

    List<Lesson> getLessons(String classCode);
}
