package ru.krestyankin.quiz.dao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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