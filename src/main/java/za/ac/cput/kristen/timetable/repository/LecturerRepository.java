package za.ac.cput.kristen.timetable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.kristen.timetable.domain.Lecturer;

/**
 * Created by kris on 5/2/15.
 */
@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Long>
{
}
