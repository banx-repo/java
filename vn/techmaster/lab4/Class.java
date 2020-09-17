package vn.techmaster.lab4;

import java.util.Date;

public class Class {
    int id;
    Date[] dates;
    Room room;
    Course course;
    SubjectTeacher subjectTeacher;
    Checking[] listCheckings;

    Class(int id, Date[] dates, Room room, Course course, SubjectTeacher subjectTeacher, Checking[] listCheckings) {
        this.id = id;
        this.dates = dates;
        this.room = room;
        this.course = course;
        this.subjectTeacher = subjectTeacher;
        this.listCheckings = listCheckings;
    }
}
