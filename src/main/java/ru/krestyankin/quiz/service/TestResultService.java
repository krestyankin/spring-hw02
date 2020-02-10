package ru.krestyankin.quiz.service;

import ru.krestyankin.quiz.domain.TestResult;

public interface TestResultService {
    void store(TestResult testResult);
}
