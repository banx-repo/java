package vn.test.employees;

import java.time.LocalDate;
import java.util.Scanner;

import vn.lib.ClearScreen;

public class Main {
    public static void main(String[] args) {
        HumanResource hr = new HumanResource();
        Employee e = null;
        Parser parser = new Parser();
        Scanner in = new Scanner(System.in);
        String prompt = ">> ";
        String command = "";
        String s = "";
        Integer id = null;
        String name = null;
        LocalDate date = null;

        ClearScreen.clear();

        System.out.println("ABC Company Human Resource Management Program");
        System.out.println("Type 'help' to see instructions");

        app: while (true) {
            System.out.print(prompt);
            s = in.nextLine().trim().replaceAll("\\s+", " ");

            if ("".equals(s)) {
                continue;
            }

            command = parser.parseCommand(s);

            switch (command) {
                case "quit":
                    System.out.println("Have fun...");
                    break app;

                case "help":
                    Printer.help();
                    break;

                case "add":
                    name = parser.parseName(s);
                    date = parser.parseDate(s);

                    if (name == null || date == null) {
                        Printer.create();
                        break;
                    }

                    e = hr.create(name, date);
                    Printer.printEmployee(e, id);
                    break;

                case "get":
                    if (parser.getAll(s)) {
                        hr.printAll();
                        break;
                    }

                    id = parser.parseId(s);

                    if (id == null) {
                        Printer.read();
                        break;
                    }

                    e = hr.read(id);
                    Printer.printEmployee(e, id);
                    break;

                case "update":
                    id = parser.parseId(s);
                    name = parser.parseName(s);
                    date = parser.parseDate(s);

                    if (id == null || (name == null && date == null)) {
                        Printer.update();
                        break;
                    }

                    e = hr.update(id, name, date);
                    Printer.printEmployee(e, id);
                    break;

                case "delete":
                    id = parser.parseId(s);

                    if (id == null) {
                        Printer.delete();
                        break;
                    }

                    e = hr.delete(id);
                    Printer.printEmployee(e, id);
                    break;

                default:
                    System.out.println("Unknow command '" + command + "'");
            }
        }

        in.close();
    }

}
