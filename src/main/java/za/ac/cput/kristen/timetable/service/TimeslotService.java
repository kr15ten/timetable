package za.ac.cput.kristen.timetable.service;

import za.ac.cput.kristen.timetable.domain.Timeslot;

import java.util.List;

/**
 * Created by kris on 4/16/15.
 */
public interface TimeslotService
{
    List<Timeslot> getTimeslots();
}
