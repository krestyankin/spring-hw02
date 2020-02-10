package ru.krestyankin.quiz.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @DisplayName("корректно создаётся конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Student student = new Student("Ivanov", "Ivan");
        assertEquals("Ivanov", student.getFirstName());
        assertEquals("Ivan", student.getLastName());
    }
}