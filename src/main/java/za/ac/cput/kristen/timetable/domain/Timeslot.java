package za.ac.cput.kristen.timetable.domain;

import java.io.Serializable;
import java.sql.Time;

/**
 * Created by student on 2015/04/13.
 */
public class Timeslot implements Serializable
{
    private String day;
    private Time start, end;

    private Timeslot(){}

    private Timeslot(Builder build)
    {
        day = build.day;
        start = build.start;
        end = build.end;
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


    public static class Builder
    {
        private String day;
        private Time start, end;

        public Builder(String day, Time start, Time end)
        {
            this.day = day;
            this.start = start;
            this.end = end;
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
