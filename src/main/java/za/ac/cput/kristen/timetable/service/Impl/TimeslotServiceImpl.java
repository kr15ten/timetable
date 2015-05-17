package za.ac.cput.kristen.timetable.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Timeslot;
import za.ac.cput.kristen.timetable.repository.TimeslotRepository;
import za.ac.cput.kristen.timetable.service.TimeslotService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/12/15.
 */
@Service
public class TimeslotServiceImpl implements TimeslotService
{
    @Autowired
    TimeslotRepository repository;

    public List<Timeslot> getTimeslots()
    {
        List<Timeslot> allTimeslots = new ArrayList<Timeslot>();

        Iterable<Timeslot> timeslots = repository.findAll();
        for (Timeslot timeslot: timeslots)
        {
            allTimeslots.add(timeslot);
        }

        return allTimeslots;
    }

    @Override
    public List<Lesson> getLessons(Long id) {
        return repository.findOne(id).getLessons();
    }
}
