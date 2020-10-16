package vn.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Pattern pattern;
    Matcher matcher;

    private String parse(Regex reg, String s, Boolean msg) {
        pattern = Pattern.compile(reg.get());
        matcher = pattern.matcher(s);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            if (msg) {
                System.out.println(reg.toString().toLowerCase() + " không hợp lệ!");
            }
            return null;
        }
    }

    public String command(String s) {
        return parse(Regex.COMMAND, s, true);
    }

    public String uid(String s) {
        return parse(Regex.UID, s, true);
    }

    public String aid(String s) {
        return parse(Regex.AID, s, true);
    }

    public String name(String s) {
        return parse(Regex.NAME, s, true);
    }

    public String username(String s) {
        return parse(Regex.USERNAME, s, true);
    }

    public String password(String s) {
        return parse(Regex.PASSWORD, s, true);
    }

    public String value(String s) {
        return parse(Regex.VALUE, s, true);
    }

    public String period(String s) {
        return parse(Regex.PERIOD, s, true);
    }

    public String rate(String s) {
        return parse(Regex.RATE, s, true);
    }

    public String show(String s) {
        if (parse(Regex.PAYMENT, s, false) != null) {
            return parse(Regex.PAYMENT, s, false);
        } else {
            return parse(Regex.ACCOUNT, s, false);
        }
    }
}
