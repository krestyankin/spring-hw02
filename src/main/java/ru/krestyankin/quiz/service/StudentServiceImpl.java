package ru.krestyankin.quiz.service;

import org.springframework.stereotype.Service;
import ru.krestyankin.quiz.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {
    private final UserInterfaceService ui;
    private final LocalizationService localizationService;

    public StudentServiceImpl(UserInterfaceService ui, LocalizationService localizationService) {
        this.ui = ui;
        this.localizationService=localizationService;
    }

    public Student getStudent() {
        String firstName;
        String lastName;
        ui.writeString(localizationService.getValue("student.askLastName"));
        firstName = ui.getString();
        ui.writeString(localizationService.getValue("student.askFirstName"));
        lastName = ui.getString();
        return new Student(firstName, lastName);
    }
}
