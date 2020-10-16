package vn.test;

public enum Command {
    CREATE("create"), READ("read"), UPDATE("update"), DELETE("delete"), HELP("help");

    private String cmd;

    Command(String cmd) {
        this.cmd = cmd;
    }

    public String getCmd() {
        return this.cmd;
    }

    public static boolean include(String s) {
        for (Command c : Command.values()) {
            if (c.getCmd().equalsIgnoreCase(s)) {
                return true;
            }
        }

        return false;
    }
}
