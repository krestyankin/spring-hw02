package ru.krestyankin.quiz.dao;

import ru.krestyankin.quiz.domain.Question;

public interface QuestionDao {
    Question getByNum(int num);
    int count();
}
