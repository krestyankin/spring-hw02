package ru.krestyankin.quiz.service;

public interface QuizService {
    void start();
    String getMark(int rightAnswers, int totalQuestions);
}
