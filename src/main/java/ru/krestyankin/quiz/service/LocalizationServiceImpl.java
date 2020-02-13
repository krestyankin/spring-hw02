package ru.krestyankin.quiz.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

public class LocalizationServiceImpl implements LocalizationService {
    private final MessageSource messageSource;
    private final Locale locale;

    public LocalizationServiceImpl(MessageSource messageSource, String language, String country) {
        this.messageSource = messageSource;
        this.locale=new Locale(language, country);
    }

    public String getValue(String key) {

        return messageSource.getMessage(key, null, locale);
    }
}
