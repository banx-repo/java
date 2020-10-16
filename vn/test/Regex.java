package vn.test;

public enum Regex {
    COMMAND("(^.[^ ]+)"), OPTION(" (-.[^ ]*)"), ID(" ([0-9]+)"), NAME(" ([\\w ]+)"),
    BIRTHDAY(" ([0-9]{1,2}[ ][0-9]{1,2}[ ][0-9]{4})"), PHONE(" ([0-9]+)"), EMAIL(" (\\w+@\\w+.\\w+)");

    private String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
