package ru.krestyankin.quiz.domain;

public class TestResult {
    private final Student student;
    private final String result;

    public TestResult(Student student, String result) {
        this.student = student;
        this.result = result;
    }

    @Override
    public String toString() {
        return student.getFirstName() + " " + student.getLastName() + ": "+result;
    }
}
