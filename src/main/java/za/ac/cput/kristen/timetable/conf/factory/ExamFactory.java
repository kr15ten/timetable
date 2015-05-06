package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Exam;
import za.ac.cput.kristen.timetable.domain.Subject;

import java.util.Date;

/**
 * Created by kris on 5/4/15.
 */
public class ExamFactory
{
    public static Exam createExam(Date startTime, double hours,
                                  double subjectContribution,
                                  String topic, Subject subject,
                                  Boolean prac)
    {
        Exam exam = new Exam
                .Builder(subjectContribution, topic, subject)
                .startTime(startTime)
                .hours(hours)
                .practical(prac)
                .build();
        return exam;
    }
}
