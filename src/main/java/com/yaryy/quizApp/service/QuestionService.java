package com.yaryy.quizApp.service;

import com.yaryy.quizApp.DAO.QuestionDAO;
import com.yaryy.quizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> addQuestion(Question question){
        try {
            return new ResponseEntity<>(questionDAO.save(question), HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace();
        }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public void deleteQuestion(int questionId) {
        questionDAO.deleteById(questionId);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public void updateQuestion(Question question) {
        questionDAO.save(question);
    }
}
