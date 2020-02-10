package ru.krestyankin.quiz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.krestyankin.quiz.service.QuizService;


@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuizService Quiz = context.getBean(QuizService.class);

        Quiz.start();

        context.close();
    }
}
