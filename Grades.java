package org.example;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter of subjects: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];
        int total = 0;
        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
            total += marks[i];
        }
        float avg = (float) total / n;
        String grade = "";
        if (avg >= 90) {
            grade = "A";
        } else if (avg >= 80) {
            grade = "B";
        } else if (avg >= 70) {
            grade = "C";
        } else if (avg >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + avg + "%");
        System.out.println("Grade: " + grade);
    }
}
