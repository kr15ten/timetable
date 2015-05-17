package za.ac.cput.kristen.timetable.service;

import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Timeslot;

import java.util.List;

/**
 * Created by kris on 5/12/15.
 */
public interface TimeslotService
{
    List<Timeslot> getTimeslots();

    List<Lesson> getLessons(Long id);
}
