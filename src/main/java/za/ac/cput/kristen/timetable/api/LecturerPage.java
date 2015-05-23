package za.ac.cput.kristen.timetable.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.kristen.timetable.domain.*;
import za.ac.cput.kristen.timetable.model.LecturerResource;
import za.ac.cput.kristen.timetable.model.RoomResource;
import za.ac.cput.kristen.timetable.model.SubjectResource;
import za.ac.cput.kristen.timetable.service.LecturerService;
import za.ac.cput.kristen.timetable.service.RoomService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/17/15.
 */

@RestController
@RequestMapping("api/lecturer/**")
public class LecturerPage
{
    @Autowired
    private LecturerService service;

    @Autowired
    private RoomService roomService;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String Index()
    {
        return "Visit lecturer details";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LecturerResource getLecturer(@PathVariable Long id)
    {
        LecturerResource hateoas;
        Lecturer lecturer = service.getLecturer(id);

        LecturerResource res = new LecturerResource
                .Builder(lecturer.getName(), lecturer.getSurname())
                .qualifications(lecturer.getQualification())
                .subjects(lecturer.getSubjects())
                .lessons(lecturer.getLessons())
                .build();

        Link lecturerDetails = new
                Link("http://localhost:8080/api/lecturer/" + res.getEmpNo().toString())
                .withRel("lecturer");

        res.add(lecturerDetails);
        hateoas = res;

        //return service.getLecturer(id);
        return hateoas;
    }

    @RequestMapping(value = "/subjects/{id}", method = RequestMethod.GET)
    public List<SubjectResource> getSubjects(@PathVariable Long id)
    {
        List<SubjectResource> hateoas = new ArrayList<>();
        List<Subject> subjects = service.getSubjects(id);

        for(Subject subject: subjects)
        {
            SubjectResource res = new SubjectResource
                    .Builder(subject.getCode(), subject.getName())
                    .credits(subject.getCredits())
                    .lessons(subject.getLessons())
                    .build();

            Link courseSubjects = new
                    Link("http://localhost:8080/api/lecturer/subjects/" + res.getCode().toString())
                    .withRel("subjects");

            res.add(courseSubjects);
            hateoas.add(res);
        }
        //return service.getSubjects(id);
        return hateoas;
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<RoomResource> getRooms()
    {
        List<RoomResource> hateoas = new ArrayList<>();
        List<Room> rooms = roomService.getRooms();

        for(Room room: rooms)
        {
            RoomResource res = new RoomResource
                    .Builder(room.getRoomNumber())
                    .size(room.getSize())
                    .lab(room.getLab())
                    .lessons(room.getLessons())
                    .build();

            Link buildingRooms = new
                    Link("http://localhost:8080/api/lecturer/room/" + res.getRoomNumber().toString())
                    .withRel("rooms");

            res.add(buildingRooms);
            hateoas.add(res);
        }
        //return roomService.getRooms();
        return hateoas;
    }

    @RequestMapping(value = "/rooms/laboratories", method = RequestMethod.GET)
    public List<RoomResource> getLaboratoryRooms()
    {
        List<RoomResource> hateoas = new ArrayList<>();
        List<Room> rooms = roomService.getLaboratoryRooms();

        for(Room room: rooms)
        {
            RoomResource res = new RoomResource
                    .Builder(room.getRoomNumber())
                    .size(room.getSize())
                    .lab(room.getLab())
                    .lessons(room.getLessons())
                    .build();

            Link buildingRooms = new
                    Link("http://localhost:8080/api/lecturer/room/" + res.getRoomNumber().toString())
                    .withRel("laboratories");

            res.add(buildingRooms);
            hateoas.add(res);
        }
        //return roomService.getLaboratoryRooms();
        return hateoas;
    }
}
