package vn.test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Pattern pattern;
    Matcher matcher;
    ArrayList<String> opt;
    ArrayList<String> val;

    public Matcher match(String s, String regex) {
        pattern = Pattern.compile(regex);
        return pattern.matcher(s);
    }

    public String command(String s) {
        matcher = match(s, Regex.COMMAND.getRegex());
        return matcher.find() ? matcher.group() : null;
    }

    public ArrayList<String> option(String s) {
        matcher = match(s, Regex.OPTION.getRegex());
        opt = new ArrayList<>();

        while (matcher.find()) {
            opt.add(matcher.group().trim());
        }

        return opt.size() > 0 ? opt : null;
    }

    public Integer id(String s) {
        matcher = match(s, Option.ID.getOption() + Regex.ID.getRegex());
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            System.out.println("Invalid id");
            return null;
        }
    }

    public String name(String s) {
        matcher = match(s, Option.NAME.getOption() + Regex.NAME.getRegex());
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            System.out.println("Invalid name");
            return null;
        }
    }

    public String birthday(String s) {
        matcher = match(s, Option.BIRTHDAY.getOption() + Regex.BIRTHDAY.getRegex());
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            System.out.println("Invalid birthday");
            return null;
        }
    }

    public String phone(String s) {
        matcher = match(s, Option.PHONE.getOption() + Regex.PHONE.getRegex());
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            System.out.println("Invalid phone");
            return null;
        }
    }

    public String email(String s) {
        matcher = match(s, Option.PHONE.getOption() + Regex.EMAIL.getRegex());
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            System.out.println("Invalid email");
            return null;
        }
    }

    public String[] create(String s) {
        String name = name(s);
        if (name == null) {
            return null;
        }
        String birthday = birthday(s);

        String phone = phone(s);
        String email = email(s);
        return new String[] { name, birthday, phone, email };
    }
}
