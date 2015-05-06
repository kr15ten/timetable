package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Termslot;

import java.util.Date;

/**
 * Created by kris on 5/4/15.
 */
public class TermslotFactory
{
    public static Termslot createTermslot(int term, Date startDate, Date endDate)
    {
        Termslot termslot = new Termslot
                .Builder(startDate, endDate)
                .term(term)
                .build();
        return termslot;
    }
}
