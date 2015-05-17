package za.ac.cput.kristen.timetable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.kristen.timetable.domain.Lesson;

/**
 * Created by kris on 5/12/15.
 */
@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long>
{

}
