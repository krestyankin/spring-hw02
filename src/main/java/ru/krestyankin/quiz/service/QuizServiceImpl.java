package ru.krestyankin.quiz.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.stereotype.Service;
import ru.krestyankin.quiz.dao.QuestionDao;
import ru.krestyankin.quiz.domain.Student;
import ru.krestyankin.quiz.domain.TestResult;

@Service
@ShellComponent
public class QuizServiceImpl implements QuizService {
    private final StudentService studentService;
    private final QuestionDao questions;
    private final QuestionService questionService;
    private final TestResultService testResultService;
    private final LocalizationService localizationService;
    private final int percentToPass;
    private final int QuestionsToAsk;
    private Student student;

    public QuizServiceImpl(StudentService studentService, QuestionDao questions, QuestionService questionService,
                           TestResultService testResultService, LocalizationService localizationService,
                           @Value("${quiz.percentToPass}") int percentToPass,
                           @Value("${quiz.questionsToAsk}") int getQuestionsToAsk) {
        this.studentService = studentService;
        this.questions = questions;
        this.questionService = questionService;
        this.testResultService = testResultService;
        this.localizationService = localizationService;
        this.percentToPass = percentToPass;
        this.QuestionsToAsk = getQuestionsToAsk;
    }

    public String getMark(int rightAnswers, int totalQuestions) {
        return (100*rightAnswers/totalQuestions>=percentToPass?localizationService.getValue("quiz.passed"):localizationService.getValue("quiz.failed"));
    }

    @ShellMethod(value = "Login", key = {"login", "l"})
    public void login() {
        student=studentService.getStudent();
    }

    @ShellMethod(value = "Start quiz", key = {"start", "run"})
    @ShellMethodAvailability(value = "isLoggedIn")
    public void start() {
        if(questions.count()<QuestionsToAsk)
            throw new RuntimeException(localizationService.getValue("quiz.tooFewQuestionsError")+": " + questions.count() + " < " + QuestionsToAsk);
        int rightAnswers=0;
        for(int i=0; i<QuestionsToAsk; i++){
            rightAnswers+=(questionService.askQuestion(questions.getByNum(i))?1:0);
        }
        testResultService.store(new TestResult(student, getMark(rightAnswers, QuestionsToAsk)));
    }

    private Availability isLoggedIn(){
        return student==null?Availability.unavailable(localizationService.getValue("quiz.notLoggedInError")):Availability.available();
    }
}
