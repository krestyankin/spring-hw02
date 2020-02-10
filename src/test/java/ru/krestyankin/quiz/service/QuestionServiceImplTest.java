package ru.krestyankin.quiz.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.krestyankin.quiz.domain.Question;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    @Mock
    private UserInterfaceService ui;

    @DisplayName("должен принимать правильный ответ")
    @Test
    void shouldAcceptCorrectAnswer() {
        given(ui.getString()).willReturn("ANSWER");
        QuestionServiceImpl questionService = new QuestionServiceImpl(ui);
        Question q = new Question("Question", "(?i)Answer");
        assertTrue(questionService.askQuestion(q));
    }

    @DisplayName("должен отклонять неправильный")
    @Test
    void shouldDeclineIncorrectAnswer() {
        given(ui.getString()).willReturn("Wrong answer");
        QuestionServiceImpl questionService = new QuestionServiceImpl(ui);
        Question q = new Question("Question", "(?i)Answer");
        assertFalse(questionService.askQuestion(q));
    }
}