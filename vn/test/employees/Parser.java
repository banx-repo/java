package vn.test.employees;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private Pattern pattern;
    private Matcher matcher;

    public String parseCommand(String s) {
        pattern = Pattern.compile(Regex.CMD.getRegex());
        matcher = pattern.matcher(s);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    public String parseName(String s) {
        pattern = Pattern.compile(Regex.NAME.getRegex());
        matcher = pattern.matcher(s);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    public LocalDate parseDate(String s) {
        pattern = Pattern.compile(Regex.DATE.getRegex());
        matcher = pattern.matcher(s);

        if (matcher.find()) {
            String[] dateString = matcher.group(1).split("[^0-9]");
            int dayOfMonth = Integer.parseInt(dateString[0]);
            int month = Integer.parseInt(dateString[1]);
            int year = Integer.parseInt(dateString[2]);
            return LocalDate.of(year, month, dayOfMonth);
        }

        return null;
    }

    public Integer parseId(String s) {
        pattern = Pattern.compile(Regex.ID.getRegex());
        matcher = pattern.matcher(s);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        return null;
    }

    public boolean getAll(String s) {
        return Pattern.matches(Regex.ALL.getRegex(), s);
    }
}
