package za.ac.cput.kristen.timetable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.kristen.timetable.domain.Student;

/**
 * Created by kris on 5/2/15.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{
    public Student findByCode(String code);
}
