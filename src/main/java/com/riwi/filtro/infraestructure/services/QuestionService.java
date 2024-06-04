package com.riwi.filtro.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.filtro.Util.enums.SortType;
import com.riwi.filtro.api.dto.request.QuestionRequest;
import com.riwi.filtro.api.dto.request.UserRequest;
import com.riwi.filtro.api.dto.response.QuestionResp;
import com.riwi.filtro.api.dto.response.UserResp;
import com.riwi.filtro.domain.entities.Question;
import com.riwi.filtro.domain.entities.User;
import com.riwi.filtro.domain.repositories.QuestionRepository;
import com.riwi.filtro.infraestructure.abstract_services.IQuestionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public QuestionResp create(QuestionRequest request) {
        
        Question question = this.requestToEntity(request);

       return this.entityToResp(this.questionRepository.save(question));
    }

    @Override
    public QuestionResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public QuestionResp update(QuestionRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<QuestionResp> findAll(int page, int size, SortType sortType) {
       if (page < 0)
            page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }

        this.questionRepository.findAll(pagination);

      return this.questionRepository.findAll(pagination)
        .map(this::entityToResp);
    }
    private QuestionResp entityToResp(Question entity){ 

        return QuestionResp.builder()
                .id(entity.getId())
                .text(entity.getText())
                .type(entity.getType())
                .active(entity.getActive())
                .options(entity.getOptions())
                .build();   
    }
    private Question requestToEntity(QuestionRequest request){

        return User.builder()
                    .text(request.getText())
                    .type(request.getType())
                    .active(request.getActive())
                    .options(request.getOptions())
                    .build();
    }
}
