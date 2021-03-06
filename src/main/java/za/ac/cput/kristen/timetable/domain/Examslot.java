package za.ac.cput.kristen.timetable.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/04/13.
 */
@Embeddable
public class Examslot implements Serializable {
    private int term;
    private Date startDate, endDate;

    private Examslot() {
    }

    public Examslot(Builder builder) {
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

    public static class Builder {
        private int term;
        private Date startDate, endDate;

        public Builder(Date startDate, Date endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Builder term(int term) {
            this.term = term;
            return this;
        }

        public Builder copy(Examslot exmslot) {
            this.term = exmslot.term;
            this.endDate = exmslot.endDate;
            this.startDate = exmslot.startDate;
            return this;
        }

        public Examslot build() {
            return new Examslot(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Examslot)) return false;

        Examslot examslot = (Examslot) o;

        if (endDate != null ? !endDate.equals(examslot.endDate) : examslot.endDate != null) return false;
        if (startDate != null ? !startDate.equals(examslot.startDate) : examslot.startDate != null) return false;

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
        return "Examslot{" +
                "term=" + term +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
