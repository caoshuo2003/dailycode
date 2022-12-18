package JudgeDate;

import java.time.LocalDate;

public class InvalidMonthException extends Exception {
    private Date date;
    public InvalidMonthException() {
    }
    public InvalidMonthException(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String PrintDateException() {
        return String.format("%d/%d/%d不是日期",
                date.getYear(), date.getMonth(), date.getDay());
    }
}
