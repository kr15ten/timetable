package za.ac.cput.kristen.timetable.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by student on 2015/04/13.
 */
@Embeddable
public class Timeslot implements Serializable
{
    private String day;
    private Time start, end;
    private int rotationalWeek;

    private Timeslot(){}

    private Timeslot(Builder build)
    {
        day = build.day;
        start = build.start;
        end = build.end;
        rotationalWeek = build.rotationalWeek;
    }

    public String getDay()
    {
        return day;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    public int getRotationalWeek()
    {
        return rotationalWeek;
    }

    public static class Builder
    {
        private String day;
        private Time start, end;
        private int rotationalWeek;

        public Builder(String day, Time start, Time end)
        {
            this.day = day;
            this.start = start;
            this.end = end;
        }

        public Builder rotationalWeek(int week)
        {
            rotationalWeek = week;
            return this;
        }

        public Builder copy(Timeslot slot)
        {
            this.day = slot.day;
            this.start = slot.start;
            this.end = slot.end;
            return this;
        }

        public Timeslot build()
        {
            return new Timeslot(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Timeslot)) return false;

        Timeslot timeslot = (Timeslot) o;

        if (day != null ? !day.equals(timeslot.day) : timeslot.day != null) return false;
        if (end != null ? !end.equals(timeslot.end) : timeslot.end != null) return false;
        if (start != null ? !start.equals(timeslot.start) : timeslot.start != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Timeslot{" +
                "day=" + day +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
