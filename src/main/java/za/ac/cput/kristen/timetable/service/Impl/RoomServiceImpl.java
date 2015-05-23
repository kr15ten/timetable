package za.ac.cput.kristen.timetable.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Room;
import za.ac.cput.kristen.timetable.repository.RoomRepository;
import za.ac.cput.kristen.timetable.service.RoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/6/15.
 */
@Service
public class RoomServiceImpl implements RoomService
{
    @Autowired
    RoomRepository repository;

    public List<Room> getRooms()
    {
        List<Room> allRooms = new ArrayList<Room>();

        Iterable<Room> rooms = repository.findAll();
        for(Room room: rooms)
        {
            allRooms.add(room);
        }

        return allRooms;
    }

    @Override
    public List<Lesson> getLessons(String id) {
        return repository.findOne(id).getLessons();
    }

    @Override
    public List<Room> getLaboratoryRooms()
    {
        List<Room> allRooms = new ArrayList<Room>();

        Iterable<Room> rooms = repository.findAll();
        for(Room room: rooms)
        {
            if(room.getLab())
                allRooms.add(room);
        }

        return allRooms;
    }
}
