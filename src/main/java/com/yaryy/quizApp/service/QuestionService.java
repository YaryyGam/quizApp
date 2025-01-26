package com.yaryy.quizApp.service;

import com.yaryy.quizApp.DAO.QuestionDAO;
import com.yaryy.quizApp.model.Question;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }

    public void addQuestion(Question question){
        questionDAO.save(question);
    }

    public void deleteQuestion(int questionId) {
        questionDAO.deleteById(questionId);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }
}
