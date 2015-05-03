package za.ac.cput.kristen.timetable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.kristen.timetable.domain.Course;

/**
 * Created by kris on 4/16/15.
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, String>
{
    public Course findByCode(String code);
}
