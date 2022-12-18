package JudgeDate;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Test {
    public static void main(String[] args) {
        Date dateTest = new Date(Integer.parseInt(args[0]),
                Integer.parseInt(args[1]), Integer.parseInt(args[2]));

        // 使用接口创建匿名类
        JudgeLegalDate judge = new JudgeLegalDate() {
            @Override
            public void JudgeMonth(Date date) throws InvalidMonthException {
                if (date.getMonth() < 1 || date.getMonth() > 12) {
                    throw new InvalidMonthException(date);
                }
            }
            @Override
            public void JudgeDaysOfMonth(Date date) throws InvalidDaysException {
                // 利用LocalDate类中getDayOfMonth方法计算月份天数
                LocalDate dateCheck = LocalDate.of(date.getYear(),
                        date.getMonth(), 1);
                int daysOfMonth = dateCheck.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
                if (date.getDay() >= daysOfMonth || date.getDay() <= 0) {
                    throw new InvalidDaysException(date);
                }
            }
        };

        try {
            judge.JudgeMonth(dateTest);
            judge.JudgeDaysOfMonth(dateTest);
            System.out.println(dateTest.PrintDate()+"是有效日期");
        }catch(InvalidMonthException e) {
            // 月份错误
            System.out.println(e.PrintDateException());
        }catch(InvalidDaysException e) {
            // 月份天数错误
            System.out.println(e.PrintDateException());
        }
    }
}
