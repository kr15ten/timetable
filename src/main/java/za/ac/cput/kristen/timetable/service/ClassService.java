package za.ac.cput.kristen.timetable.service;

import za.ac.cput.kristen.timetable.domain.*;
import za.ac.cput.kristen.timetable.domain.Class;

import java.util.List;

/**
 * Created by kris on 4/16/15.
 */
public interface ClassService
{
    List<Class> getClasses();
}
