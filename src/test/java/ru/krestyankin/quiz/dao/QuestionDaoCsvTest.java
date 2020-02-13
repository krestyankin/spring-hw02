package ru.krestyankin.quiz.dao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.krestyankin.quiz.config.AppConfig;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class QuestionDaoCsvTest {

    @Autowired
    private QuestionDao questionDao;

    @DisplayName("должен возвращать вопрос по номеру")
    @Test
    void getByNum() {
        assertEquals("Question", questionDao.getByNum(0).getQuestion());
        assertEquals("Answer", questionDao.getByNum(0).getAnswer());
    }

    @DisplayName("должен возвращать количество записей")
    @Test
    void count() {
        assertEquals(1, questionDao.count());
    }
}