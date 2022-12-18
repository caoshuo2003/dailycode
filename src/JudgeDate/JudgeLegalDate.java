package JudgeDate;

public interface JudgeLegalDate {
    // 判断月份是否合法
    void JudgeMonth(Date date) throws InvalidMonthException;

    // 判断月份天数是否合法
    void JudgeDaysOfMonth(Date date) throws InvalidDaysException;
}
