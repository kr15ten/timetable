package za.ac.cput.kristen.timetable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.kristen.timetable.domain.Timeslot;

/**
 * Created by kris on 5/12/15.
 */

@Repository
public interface TimeslotRepository extends CrudRepository<Timeslot, Long>
{
}
