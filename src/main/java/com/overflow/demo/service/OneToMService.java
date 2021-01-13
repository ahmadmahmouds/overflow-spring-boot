package com.overflow.demo.service;

import com.overflow.demo.models.Answer;
import com.overflow.demo.repository.AnswerRepo;
import com.overflow.demo.repository.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OneToMService {
    private  final AnswerRepo answerRepo;
    private final QuestionRepo questionRepo;

    public OneToMService(AnswerRepo answerRepo, QuestionRepo questionRepo) {
        this.answerRepo = answerRepo;
        this.questionRepo = questionRepo;
    }

    public Answer addAnswer(Answer answer){
        return answerRepo.save(answer);
    }

    public List<Answer>findAllAnswer(){
        return answerRepo.findAll();
    }
    public Answer findAnswer(Long id){
        Optional<Answer> answer=answerRepo.findById(id);
        if (answer.isPresent()){
            return answer.get();
        }
        return null;
    }
}
