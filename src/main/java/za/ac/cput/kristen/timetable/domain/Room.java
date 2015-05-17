package za.ac.cput.kristen.timetable.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/13.
 */
@Entity
public class Room implements Serializable {
    @Id
    private String roomNumber;
    private int size;
    private Boolean lab;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room")
    private List<Lesson> lessons;

    private Room() {
    }

    public Room(Builder builder) {
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

        public Builder copy(Room room) {
            this.roomNumber = room.roomNumber;
            this.size = room.size;
            this.lab = room.lab;
            this.lessons = room.lessons;
            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (roomNumber != null ? !roomNumber.equals(room.roomNumber) : room.roomNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return roomNumber != null ? roomNumber.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", size=" + size +
                ", lab=" + lab +
                '}';
    }
}
