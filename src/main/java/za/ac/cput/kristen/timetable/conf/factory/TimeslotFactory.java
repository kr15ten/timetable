package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Timeslot;

import java.sql.Time;

/**
 * Created by kris on 5/4/15.
 */
public class TimeslotFactory
{
    public static Timeslot createTimeslot(String day, Time start, Time end,
                                          int rotationalWeek)
    {
        Timeslot timeslot = new Timeslot
                .Builder(day, start, end)
                .rotationalWeek(rotationalWeek)
                .build();
        return timeslot;
    }
}
