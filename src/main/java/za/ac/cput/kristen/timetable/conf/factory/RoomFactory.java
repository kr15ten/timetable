package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Lesson;
import za.ac.cput.kristen.timetable.domain.Room;

import java.util.List;

/**
 * Created by kris on 5/4/15.
 */
public class RoomFactory
{
    public static Room createRoom(String roomNumber, int size, Boolean lab, List<Lesson> lessons)
    {
        Room room = new Room
                .Builder(roomNumber)
                .size(size)
                .lab(lab)
                .lessons(lessons)
                .build();
        return room;
    }
}
