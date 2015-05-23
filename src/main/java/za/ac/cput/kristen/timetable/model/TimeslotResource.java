package za.ac.cput.kristen.timetable.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.kristen.timetable.domain.Lesson;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kris on 5/23/15.
 */
public class TimeslotResource extends ResourceSupport
{
    private Long resId;
    private String day;
    private Time start, end;
    private int rotationalWeek = 0;

    private List<Lesson> lessons;


    private TimeslotResource() {
    }

    public TimeslotResource(Builder build) {
        day = build.day;
        start = build.start;
        end = build.end;
        rotationalWeek = build.rotationalWeek;
        lessons = build.lessons;
    }

    public Long getResId()
    {
        return resId;
    }

    public String getDay() {
        return day;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    public int getRotationalWeek() {
        return rotationalWeek;
    }

    public List<Lesson> getLessons()
    {
        return lessons;
    }

    public static class Builder {
        private String day;
        private Time start, end;
        private int rotationalWeek;
        private List<Lesson> lessons;

        public Builder(String day, Time start, Time end) {
            this.day = day;
            this.start = start;
            this.end = end;
        }

        public Builder rotationalWeek(int week) {
            rotationalWeek = week;
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

        public Builder copy(TimeslotResource slot) {
            this.day = slot.day;
            this.start = slot.start;
            this.end = slot.end;
            this.lessons = slot.lessons;
            return this;
        }

        public TimeslotResource build() {
            return new TimeslotResource(this);
        }
    }
}
