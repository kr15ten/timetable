package za.ac.cput.kristen.timetable.conf.factory;

import za.ac.cput.kristen.timetable.domain.Room;

/**
 * Created by kris on 5/4/15.
 */
public class RoomFactory
{
    public static Room createRoom(String roomNumber, int size, Boolean lab)
    {
        Room room = new Room
                .Builder(roomNumber)
                .size(size)
                .lab(lab)
                .build();
        return room;
    }
}
