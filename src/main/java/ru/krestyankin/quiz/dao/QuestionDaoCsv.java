package ru.krestyankin.quiz.dao;

import org.springframework.core.io.ClassPathResource;
import ru.krestyankin.quiz.domain.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class QuestionDaoCsv implements QuestionDao {
    private final List<Question> questions;

    public QuestionDaoCsv(String filename) throws IOException {
        questions = new ArrayList<Question>();
        CSVReader reader = new CSVReader(new InputStreamReader(new ClassPathResource(filename).getInputStream()));
        String[] row;
        while ((row = reader.readNext()) != null){
            if(row.length==2)
                questions.add(new Question(row[0], row[1]));
        }
        Collections.shuffle(questions);
    }

    public Question getByNum(int num) {
        return questions.get(num);
    }

    public int count() {
        return questions.size();
    }
}
