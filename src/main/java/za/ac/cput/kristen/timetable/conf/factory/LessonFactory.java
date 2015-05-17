package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.*;

/**
 * Created by kris on 5/4/15.
 */
public class LessonFactory
{
    public static Lesson createLesson(String topic, Boolean prac)
    {
        Lesson lesson = new Lesson
                .Builder()
                .topic(topic)
                .practical(prac)
                .build();
        return lesson;
    }
}
