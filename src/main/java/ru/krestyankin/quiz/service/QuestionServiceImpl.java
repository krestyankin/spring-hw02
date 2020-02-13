package ru.krestyankin.quiz.service;

import org.springframework.stereotype.Service;
import ru.krestyankin.quiz.domain.Question;

import java.util.regex.Pattern;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final UserInterfaceService ui;

    public QuestionServiceImpl(UserInterfaceService ui) {
        this.ui = ui;
    }

    public boolean askQuestion(Question question) {
        ui.writeString(question.getQuestion());
        return Pattern.matches(question.getAnswer(), ui.getString().trim());
    }
}
