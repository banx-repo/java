package vn.test.employees;

public enum Regex {
    CMD("^([.[^ ]]+)[ ]*"), ID(" id=([0-9]{1,3})[ ]*"), NAME(" name=([a-zA-Z]+)[ ]*"),
    DATE(" date=([0-9]{1,2}[-/.][0-9]{1,2}[-/.][0-9]{4})[ ]*"), ALL("get all[ ]*");

    private String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
