package ru.krestyankin.quiz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.krestyankin.quiz.dao.QuestionDao;
import ru.krestyankin.quiz.dao.QuestionDaoCsv;
import ru.krestyankin.quiz.service.LocalizationService;
import ru.krestyankin.quiz.service.LocalizationServiceImpl;

import java.io.IOException;

@Configuration
public class AppConfig {
    @Bean
    public LocalizationService localizationService(MessageSource messageSource, @Value("${locale.language}") String language, @Value("${locale.country}") String country){
        return new LocalizationServiceImpl(messageSource, language, country);
    }

    @Bean
    public QuestionDao questionDao(LocalizationService localizationService) throws IOException {
        return new QuestionDaoCsv(localizationService.getValue("questions.filename"));
    }
}
