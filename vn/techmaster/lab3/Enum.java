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

        System.out.println();

        for (Day d : Day.values()) {
            System.out.printf("%7s", d);
        }

        System.out.println();

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

    static void compare(Day[][] calendar, int daysOfMonth) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("So sánh 2 ngày trong tháng có cùng thứ hay không?");
        int da;
        int db;

        String msg = String.format("Ngày phải là số nguyên lớn hơn 0 và nhỏ hơn %d: ", daysOfMonth + 1);
        int count = 0;

        do {
            System.out.print(count++ > 0 ? msg : "Ngày thứ nhất: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Không hợp lệ! Vui lòng nhập lại: ");
                scanner.next();
            }

            da = scanner.nextInt();

        } while (da < 1 || da > daysOfMonth);

        count = 0;

        do {
            System.out.print(count++ > 0 ? msg : "Ngày thứ hai: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Không hợp lệ! Vui lòng nhập lại: ");
                scanner.next();
            }

            db = scanner.nextInt();
        } while (db < 1 || db > daysOfMonth);

        scanner.close();

        Day a = getDay(calendar, da);
        Day b = getDay(calendar, db);

        if (a == b) {
            System.out.printf("Yep! 2 ngày %d và %d cùng là thứ %s!\n", da, db, a);
            return;
        }

        System.out.printf("No! %d là thứ %s - %d là thứ %s\n", da, a, db, b);
    }

    public static void main(String[] args) {
        int daysOfMonth = 31;
        Day firstDayOfMonth = Day.SAT;

        Day[][] calendar = Enum.createCalendar(daysOfMonth, firstDayOfMonth);

        Enum.printCalendar(calendar);

        compare(calendar, daysOfMonth);
    }
}