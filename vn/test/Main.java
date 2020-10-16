package vn.test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
        String s;
        String cmd;
        String prompt = ">> ";

        while (true) {
            System.out.print(prompt);
            s = in.nextLine().trim().replaceAll("\\s+", " ");

            if ("".equals(s)) {
                continue;
            }

            if ("quit".equals(s)) {
                break;
            }

            cmd = parser.command(s);

            if (!Command.include(cmd)) {
                System.out.println("Unknow command '" + cmd + "'");
                continue;
            }

            main: switch (cmd) {
                case "help":
                    System.out.println("Help");
                    break;

                case "create":
                    ArrayList<String> opt = parser.option(s);

                    if (opt == null) {
                        Help.create();
                        break;
                    }

                    for (String o : opt) {
                        if (!Option.create(o)) {
                            System.out.println("Unknow option '" + o + "'");
                            break main;
                        }
                    }

                    String[] val = parser.create(s);
                    for (String v : val) {
                        System.out.println(v);
                    }
                    manager.create(s);
                    break;

                case "read":
                    manager.read(s);
                    break;

                case "update":
                    manager.update(s);
                    break;

                case "delete":
                    manager.delete(s);
                    break;
            }
        }

        in.close();
    }
}
