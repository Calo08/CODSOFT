package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;
    private int totalQuestions;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
        this.totalQuestions = questions.size();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            Collections.shuffle(options); // shuffle options to randomize their order
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i+1) + ". " + options.get(i));
            }
            System.out.print("Enter your answer (1-" + options.size() + "): ");
            int answer = scanner.nextInt();
            long startTime = System.currentTimeMillis();
            long endTime = startTime + question.getTimeLimit();
            while (System.currentTimeMillis() < endTime) {
                if (question.isCorrect(answer)) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "/" + totalQuestions);
                    break;
                } else {
                    System.out.println("Incorrect. The correct answer is " + question.getCorrectOption());
                    System.out.println("Your score is now " + score + "/" + totalQuestions);
                    break;
                }
            }
            if (System.currentTimeMillis() >= endTime) {
                System.out.println("Time's up! The correct answer is " + question.getCorrectOption());
            }
        }
        System.out.println("Your final score is " + score + "/" + totalQuestions);
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", "Paris", 3, 60000));
        questions.add(new Question("Who is the current president of the United States?", "Joe Biden", 1, 60000));
        questions.add(new Question("What is the largest planet in the solar system?", "Jupiter", 2, 60000));
        questions.add(new Question("Who wrote the novel 'Pride and Prejudice'?", "Jane Austen", 1, 60000));
        questions.add(new Question("What is the smallest prime number?", "2", 1, 60000));
        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}

class Question {
    private String question;
    private String correctOption;
    private List<Integer> correctOptionIndex;
    private List<String> options;
    private long timeLimit;

    public Question(String question, String correctOption, int correctOptionIndex, long timeLimit) {
        this.question = question;
        this.correctOption = correctOption;
        this.correctOptionIndex = new ArrayList<>();
        this.options = new ArrayList<>();
        this.timeLimit = timeLimit;
        this.options.add("New York");
        this.options.add("London");
        this.options.add("Paris");
        this.options.add("Berlin");
        this.correctOptionIndex.add(correctOptionIndex);
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int answer) {
        return correctOptionIndex.contains(answer);
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public long getTimeLimit() {
        return timeLimit;
    }
}
