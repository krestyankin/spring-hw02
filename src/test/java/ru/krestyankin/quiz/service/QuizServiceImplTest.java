package ru.krestyankin.quiz.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.CommandNotCurrentlyAvailable;
import org.springframework.shell.Shell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class QuizServiceImplTest {
    @Autowired
    private Shell shell;

    @MockBean
    private UserInterfaceService ui;

    @Autowired
    private QuizService quizService;

    private static final String COMMAND_START = "start";
    private static final String COMMAND_LOGIN = "login";
    private static final String QUIZ_PASSED = "Passed";
    private static final String QUIZ_FAILED = "Failed";

    @DisplayName(" должен возвращать правильный результат тестирования")
    @Test
    void getMark() {
        assertThat(quizService.getMark(1,1)).isEqualTo(QUIZ_PASSED);
        assertThat(quizService.getMark(0,1)).isEqualTo(QUIZ_FAILED);
    }

    @DisplayName(" должен быть недоступен до логина и доступен после")
    @Test
    void shouldBeUnavailableBeforeLoginAndAvalilableAfterLogin() {
        Object res =  shell.evaluate(() -> COMMAND_START);
        assertThat(res).isInstanceOf(CommandNotCurrentlyAvailable.class);

        given(ui.getString()).willReturn("Test");
        shell.evaluate(() -> COMMAND_LOGIN);
        res =  shell.evaluate(() -> COMMAND_START);
        assertThat(res).isNull();
    }
}