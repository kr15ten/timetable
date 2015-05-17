package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Lecturer;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Subject;

import java.util.List;

/**
 * Created by kris on 5/4/15.
 */
public class LecturerFactory
{
    public static Lecturer createLecturer(String name,
                                          String surname, String qualification,
                                          List<Subject> subjects, List<Lesson> lessons)
    {
        Lecturer lecturer = new Lecturer
                .Builder(name, surname)
                .qualifications(qualification)
                .subject(subjects)
                .lessons(lessons)
                .build();
        return lecturer;
    }
}
