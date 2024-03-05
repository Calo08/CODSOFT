package org.example;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private List<Student> students;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
        } else {
            System.out.println("Sorry, this course is full.");
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public static void displayAvailableCourses(List<Course> courses) {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course.getCode() + " - " + course.getTitle() + " (" + course.getStudents().size() + "/" + course.getCapacity() + ")");
        }
    }
}
