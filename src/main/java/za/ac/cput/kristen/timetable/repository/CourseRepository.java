package za.ac.cput.kristen.timetable.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.kristen.timetable.domain.Course;

/**
 * Created by kris on 4/16/15.
 */
public interface CourseRepository extends CrudRepository<Course, Long>
{
    public Course findByCode(String code);
}