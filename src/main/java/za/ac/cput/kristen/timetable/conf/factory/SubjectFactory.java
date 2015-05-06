package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Subject;

/**
 * Created by kris on 5/4/15.
 */
public class SubjectFactory
{
    public static Subject createSubject(String code, String name, int credits)
    {
        Subject subject = new Subject
                .Builder(code)
                .name(name)
                .credits(credits)
                .build();
        return subject;
    }
}
