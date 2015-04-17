package za.ac.cput.kristen.timetable.domain;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by student on 2015/04/13.
 */
@Entity
public class Lesson implements Serializable
{
    private Timeslot slot;
    private Lecturer lecturer;
    private Room room;
    private Class clss;
    private Subject subject;
    private String topic;
    private Boolean prac;

    private Lesson()
    {}

    public Lesson(Builder builder)
    {
        slot = builder.slot;
        lecturer = builder.lecturer;
        room = builder.room;
        clss = builder.clss;
        subject = builder.subject;
        topic = builder.topic;
        prac = builder.prac;
    }

    public Timeslot getSlot() {
        return slot;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public Room getRoom() {
        return room;
    }

    public Class getClss() {
        return clss;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    public Boolean getPrac() {
        return prac;
    }

    public static class Builder
    {
        private Timeslot slot;
        private Lecturer lecturer;
        private Room room;
        private Class clss;
        private Subject subject;
        private String topic;
        private Boolean prac;

        public Builder(Timeslot slot, Lecturer lecturer, Class clss, Subject subject)
        {
            this.slot = slot;
            this.lecturer = lecturer;
            this.clss = clss;
            this.subject = subject;
        }

        public Builder room(Room room)
        {
            this.room = room;
            return this;
        }

        public Builder topic(String topic)
        {
            this.topic = topic;
            return this;
        }

        public Builder practical(Boolean prac)
        {
            this.prac = prac;
            return this;
        }

        public Lesson build()
        {
            return new Lesson(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson)) return false;

        Lesson lesson = (Lesson) o;

        if (clss != null ? !clss.equals(lesson.clss) : lesson.clss != null) return false;
        if (lecturer != null ? !lecturer.equals(lesson.lecturer) : lesson.lecturer != null) return false;
        if (slot != null ? !slot.equals(lesson.slot) : lesson.slot != null) return false;
        if (subject != null ? !subject.equals(lesson.subject) : lesson.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = slot != null ? slot.hashCode() : 0;
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        result = 31 * result + (clss != null ? clss.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Lesson{" +
                "slot=" + slot +
                ", lecturer=" + lecturer +
                ", clss=" + clss +
                ", room=" + room +
                ", subject=" + subject +
                ", topic='" + topic + '\'' +
                ", prac=" + prac +
                '}';
    }
}
