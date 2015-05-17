package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Subject;

import java.util.List;

/**
 * Created by kris on 5/4/15.
 */
public class SubjectFactory
{
    public static Subject createSubject(String code, String name, int credits, List<Lesson> lessons)
    {
        Subject subject = new Subject
                .Builder(code, name)
                .credits(credits)
                .lessons(lessons)
                .build();
        return subject;
    }
}
