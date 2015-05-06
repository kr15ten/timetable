package za.ac.cput.kristen.timetable.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.kristen.timetable.domain.Class;

/**
 * Created by kris on 4/16/15.
 */
@Repository
public interface ClassRepository extends CrudRepository<Class, String>
{
    //public Class findByCode(String code);
}