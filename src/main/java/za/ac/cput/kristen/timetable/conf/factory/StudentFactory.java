package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Student;

/**
 * Created by kris on 5/4/15.
 */
public class StudentFactory
{
    public static Student createStudent(String name, String surname,
                                        String courseCode, int creditsEarned,
                                        int courseYear)
    {
        Student stud = new Student
                .Builder(name, surname)
                .courseCode(courseCode)
                .creditsEarned(creditsEarned)
                .courseYear(courseYear)
                .build();
        return stud;
    }
}
