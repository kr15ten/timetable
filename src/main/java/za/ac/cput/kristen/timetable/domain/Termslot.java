package za.ac.cput.kristen.timetable.domain;

import java.util.Date;

/**
 * Created by student on 2015/04/13.
 */
public class Termslot
{
    private int term;
    private Date startDate, endDate;


    private Termslot()
    {
    }

    public Termslot(Builder builder)
    {
        term = builder.term;
        startDate = builder.startDate;
        endDate = builder.endDate;
    }

    public int getTerm() {
        return term;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public static class Builder
    {
        private int term;
        private Date startDate, endDate;

        public Builder(Date startDate, Date endDate)
        {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Builder term(int term)
        {
            this.term = term;
            return this;
        }

        public Termslot build()
        {
            return new Termslot(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Termslot)) return false;

        Termslot termslot = (Termslot) o;

        if (endDate != null ? !endDate.equals(termslot.endDate) : termslot.endDate != null) return false;
        if (startDate != null ? !startDate.equals(termslot.startDate) : termslot.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Termslot{" +
                "term=" + term +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
