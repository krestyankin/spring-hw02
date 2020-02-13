package ru.krestyankin.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.krestyankin.quiz.service.QuizService;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QuizApplication.class, args);
		QuizService Quiz = context.getBean(QuizService.class);

		Quiz.start();
	}

}
