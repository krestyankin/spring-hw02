package ru.krestyankin.quiz.service;

import org.springframework.stereotype.Service;
import ru.krestyankin.quiz.domain.TestResult;

@Service
public class TestResultServiceImpl implements TestResultService {
    private final UserInterfaceService ui;
    private final LocalizationService localizationService;

    public TestResultServiceImpl(UserInterfaceService ui, LocalizationService localizationService) {
        this.ui = ui;
        this.localizationService = localizationService;
    }

    public void store(TestResult testResult) {
        ui.writeString(localizationService.getValue("testResult.complete")+": \n"+ testResult.toString());
    }
}
