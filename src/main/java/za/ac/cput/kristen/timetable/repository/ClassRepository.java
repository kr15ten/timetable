package za.ac.cput.kristen.timetable.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by kris on 4/16/15.
 */
public interface ClassRepository extends CrudRepository<Class, Long>
{
    public Class findByCode(String code);
}