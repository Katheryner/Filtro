package com.riwi.filtro.infraestructure.abstract_services;

import com.riwi.filtro.api.dto.request.UserRequest;
import com.riwi.filtro.api.dto.response.UserResp;

public interface IUserService extends CrudService <UserRequest, UserResp, Long>{
    public final String FIELD_BY_SORT = "userName";
}
