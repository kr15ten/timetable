package za.ac.cput.kristen.timetable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.kristen.timetable.domain.Room;

/**
 * Created by kris on 5/6/15.
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, String>
{
}
