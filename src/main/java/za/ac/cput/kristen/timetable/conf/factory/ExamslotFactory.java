package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Examslot;

import java.util.Date;

/**
 * Created by kris on 5/4/15.
 */
public class ExamslotFactory
{
    public static Examslot createExamslot(int term, Date startDate,
                                          Date endDate)
    {
        Examslot examslot = new Examslot
                .Builder(startDate, endDate)
                .term(term)
                .build();
        return examslot;
    }
}
