package za.ac.cput.kristen.timetable.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/13.
 */
@Entity
public class Lesson implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String topic;
    private Boolean prac;

    private Lesson() {
    }

    public Lesson(Builder builder) {
        topic = builder.topic;
        prac = builder.prac;
    }

    public Long getId()
    {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Boolean getPrac() {
        return prac;
    }

    public static class Builder {
        private String topic;
        private Boolean prac;

        public Builder() {

        }


        public Builder topic(String topic) {
            this.topic = topic;
            return this;
        }

        public Builder practical(Boolean prac) {
            this.prac = prac;
            return this;
        }

        public Builder copy(Lesson lesson) {
            this.topic = lesson.topic;
            this.prac = lesson.prac;
            return this;
        }

        public Lesson build() {
            return new Lesson(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;

        return !(id != null ? !id.equals(lesson.id) : lesson.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                '}';
    }
}
