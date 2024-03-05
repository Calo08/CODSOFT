package org.example;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Course> courses;
    private List<Student> students;

    public DataBase() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Course getCourse(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    public Student getStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        DataBase db = new DataBase();

        // add courses
        db.addCourse(new Course("CS101", "Introduction to Computer Science", "Learn the basics of computer programming.", 30));
        db.addCourse(new Course("MATH101", "Calculus I", "Learn single variable calculus.", 40));
        db.addCourse(new Course("ENGL101", "English Composition I", "Learn to write clear and concise essays.", 50));

        // add students
        db.addStudent(new Student("12345", "John Doe"));


    }
}

