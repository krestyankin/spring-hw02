package ru.krestyankin.quiz.service;

import ru.krestyankin.quiz.domain.Question;

public interface QuestionService {
  boolean askQuestion(Question question);
}
