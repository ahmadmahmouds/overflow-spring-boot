package com.overflow.demo.service;
import com.overflow.demo.models.Question;
import com.overflow.demo.models.QuestionTag;
import com.overflow.demo.models.Tag;
import com.overflow.demo.repository.QTRepo;
import com.overflow.demo.repository.QuestionRepo;
import com.overflow.demo.repository.TagRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManyToMService {
    private final QuestionRepo questionRepo;
    private final TagRepo tagRepo;
    private  final QTRepo qtRepo;

    public ManyToMService(QuestionRepo questionRepo, TagRepo tagRepo, QTRepo qtRepo) {
        this.questionRepo = questionRepo;
        this.tagRepo = tagRepo;
        this.qtRepo = qtRepo;
    }

    public List<Question> findAllQuestion(){
        return this.questionRepo.findAll();
    }
    public List<Tag> findAllTag(){
        return this.tagRepo.findAll();
    }

    public Question addQuestion(Question question){
        return questionRepo.save(question);
    }

    public Tag addTag(Tag tag){
        return tagRepo.save(tag);
    }
    public Question findQuestion(Long id){
        Optional<Question> question=questionRepo.findById(id);
        if (question.isPresent()){
            return question.get();
        }
        return null;

    }


    public Tag findTag(Long id){
        Optional<Tag> tag=tagRepo.findById(id);
        if (tag.isPresent()){
            return tag.get();
        }
        return null;

    }

    public QuestionTag addAssociation(QuestionTag questionTag){

        return qtRepo.save(questionTag);
    }

    public void addTagsToQuestions(String question, String[] tags) {
        Question newq = new Question(question);
        Question newquestion = addQuestion(newq);
        Tag newTag;
        QuestionTag newTQ;
        List<Tag> alltags = findAllTag();
        for (int i = 0; i < tags.length; i++) {
            if(alltags.size()==0){
                newTag = new Tag(tags[i]);
                addTag(newTag);
                newTQ = new QuestionTag(newquestion, newTag);
                addAssociation(newTQ);
                break;
            }
            for (int j = 0; j < alltags.size(); j++) {
                if (tags[i].equals(alltags.get(j).getSubject())) {
                    newTQ = new QuestionTag(newquestion, alltags.get(j));
                    addAssociation(newTQ);
                } else {
                    newTag = new Tag(tags[i]);
                    newTQ = new QuestionTag(newquestion, newTag);
                    addAssociation(newTQ);
                }

            }
        }
    }




}
