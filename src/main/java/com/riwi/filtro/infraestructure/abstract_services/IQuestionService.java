package com.riwi.filtro.infraestructure.abstract_services;

import com.riwi.filtro.api.dto.request.QuestionRequest;
import com.riwi.filtro.api.dto.response.QuestionResp;

public interface IQuestionService extends CrudService<QuestionRequest,QuestionResp, Long>{
    public final String FIELD_BY_SORT = "type";
}
