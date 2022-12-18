package JudgeDate;

public class InvalidDaysException extends Exception {
    private Date date;

    public InvalidDaysException() {
    }

    public InvalidDaysException(Date date) {
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
