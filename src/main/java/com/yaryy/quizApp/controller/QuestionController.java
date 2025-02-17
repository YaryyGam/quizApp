package com.yaryy.quizApp.controller;


import com.yaryy.quizApp.model.Question;
import com.yaryy.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{topic}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("topic") String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PutMapping("/updateQuestion")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        questionService.updateQuestion(question);
        return ResponseEntity.status(HttpStatus.OK).body(question);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/deleteQuestion/{questionId}")
    public String deleteQuestion(@PathVariable("questionId") int Id){
        questionService.deleteQuestion(Id);
        return "Deleted";
    }

}
