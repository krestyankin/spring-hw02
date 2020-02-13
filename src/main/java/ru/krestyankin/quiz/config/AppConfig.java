package ru.krestyankin.quiz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.krestyankin.quiz.dao.QuestionDao;
import ru.krestyankin.quiz.dao.QuestionDaoCsv;
import ru.krestyankin.quiz.service.LocalizationService;
import ru.krestyankin.quiz.service.LocalizationServiceImpl;

import java.io.IOException;
import java.util.Locale;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        ms.setDefaultLocale(Locale.ENGLISH);
        return ms;
    }

    @Bean
    public LocalizationService localizationService(MessageSource messageSource, @Value("${locale.language}") String language, @Value("${locale.country}") String country){
        return new LocalizationServiceImpl(messageSource, language, country);
    }

    @Bean
    public QuestionDao questionDao(LocalizationService localizationService) throws IOException {
        return new QuestionDaoCsv(localizationService.getValue("questions.filename"));
    }
}
