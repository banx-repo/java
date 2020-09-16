package vn.techmaster.lab3;

import java.util.Scanner;

public class Enum {
    enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN
    };

    static Day[][] createCalendar(int daysOfMonth, Day firstDayOfMonth) {
        int daysOfWeek = 7;
        int weeksOfMonth = (int) Math.ceil((daysOfMonth + firstDayOfMonth.ordinal()) / (float) daysOfWeek);

        Day[] day = Day.values();
        Day[][] calendar = new Day[weeksOfMonth][];
        int d = firstDayOfMonth.ordinal();

        loop: for (int i = 0;; i++) {
            calendar[i] = new Day[daysOfMonth / daysOfWeek > 0 ? daysOfWeek - d : daysOfMonth % daysOfWeek];

            for (int j = 0; j < calendar[i].length; j++) {
                calendar[i][j] = day[d + j];
                daysOfMonth--;

                if (daysOfMonth <= 0) {
                    break loop;
                }
            }

            d = 0;
        }

        return calendar;
    }

    static void printCalendar(Day[][] calendar) {
        int length = calendar.length;
        int day = 1;

        for (int i = 0; i < length; i++) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < calendar[i].length; j++) {
                String s = day + "-" + calendar[i][j];
                stringBuilder.append(String.format("%7s", s));
                day++;
            }

            if (i == 0) {
                System.out.printf("%49s\n", stringBuilder);
                continue;
            }

            System.out.println(stringBuilder);
        }
    }

    static Day getDay(Day[][] calendar, int day) {
        int week = 0;

        for (Day[] d : calendar) {
            if (day > d.length) {
                day -= d.length;
                week++;
                continue;
            }
            break;
        }

        return calendar[week][day - 1];
    }

    static void compare(Day[][] calendar, int a, int b) {
        Day da = getDay(calendar, a);
        Day db = getDay(calendar, b);

        if (da == db) {
            System.out.printf("Yep! 2 ngày %d và %d cùng là thứ %s!\n", a, b, da);
            return;
        }

        System.out.printf("No! %d là thứ %s - %d là thứ %s\n", a, da, b, db);
    }

    public static void main(String[] args) {
        int daysOfMonth = 31;
        Day firstDayOfMonth = Day.SAT;

        Day[][] calendar = Enum.createCalendar(daysOfMonth, firstDayOfMonth);

        Enum.printCalendar(calendar);

        Scanner scanner = new Scanner(System.in);
        System.out.println("So sánh 2 ngày trong tháng có cùng thứ hay không?");
        System.out.print("Ngày 1: ");
        int a = scanner.nextInt();
        System.out.print("Ngày 2: ");
        int b = scanner.nextInt();
        scanner.close();

        compare(calendar, a, b);
    }
}