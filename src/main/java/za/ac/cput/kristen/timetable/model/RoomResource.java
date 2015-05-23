package za.ac.cput.kristen.timetable.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.kristen.timetable.domain.Lesson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/23/15.
 */
public class RoomResource extends ResourceSupport
{
    private String roomNumber;
    private int size;
    private Boolean lab;

    private List<Lesson> lessons;


    private RoomResource()
    {

    }

    public RoomResource(Builder builder) {
        roomNumber = builder.roomNumber;
        size = builder.size;
        lab = builder.lab;
        lessons = builder.lessons;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getSize() {
        return size;
    }

    public Boolean getLab() {
        return lab;
    }

    public List<Lesson> getLessons()
    {
        return lessons;
    }

    public Lesson getLesson(int i)
    {
        return lessons.get(i);
    }

    public static class Builder {
        private String roomNumber;
        private int size;
        private Boolean lab;
        private List<Lesson> lessons;

        public Builder(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public Builder lab(Boolean lab) {
            this.lab = lab;
            return this;
        }

        public Builder addLesson(Lesson lesson)
        {
            if (lessons.isEmpty())
                lessons = new ArrayList<Lesson>();

            lessons.add(lesson);
            return this;
        }

        public Builder lessons(List<Lesson> lessons)
        {
            this.lessons = lessons;
            return this;
        }

        public Builder copy(RoomResource room) {
            this.roomNumber = room.roomNumber;
            this.size = room.size;
            this.lab = room.lab;
            this.lessons = room.lessons;
            return this;
        }

        public RoomResource build() {
            return new RoomResource(this);
        }
    }
}
