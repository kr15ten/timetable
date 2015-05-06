package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.*;

/**
 * Created by kris on 5/4/15.
 */
public class LessonFactory
{
    public static Lesson createLesson(Timeslot slot, Lecturer lecturer,
                                      Room room, za.ac.cput.kristen.timetable.domain.Class clss, Subject subject,
                                      String topic, Boolean prac)
    {
        Lesson lesson = new Lesson
                .Builder(slot, lecturer, clss, subject)
                .room(room)
                .topic(topic)
                .practical(prac)
                .build();
        return lesson;
    }
}
