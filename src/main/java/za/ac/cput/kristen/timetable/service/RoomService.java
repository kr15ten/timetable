package za.ac.cput.kristen.timetable.service;

import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Room;

import java.util.List;

/**
 * Created by kris on 5/6/15.
 */
public interface RoomService
{
    List<Room> getRooms();

    List<Lesson> getLessons(String id);

    List<Room> getLaboratoryRooms();
}
