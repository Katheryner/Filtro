package com.riwi.filtro.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.filtro.Util.enums.SortType;
import com.riwi.filtro.api.dto.request.UserRequest;
import com.riwi.filtro.api.dto.response.UserResp;
import com.riwi.filtro.domain.entities.User;
import com.riwi.filtro.domain.repositories.UserRepository;
import com.riwi.filtro.infraestructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserResp create(UserRequest request) {
        User user = this.requestToEntity(request);

       return this.entityToResp(this.userRepository.save(user));
    }

    @Override
    public UserResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public UserResp update(UserRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<UserResp> getAll(int page, int size, SortType sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");

    }
    private UserResp entityToResp(User entity){

        return UserResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .active(entity.getActive())
                .build();
    }
    private User requestToEntity(UserRequest request){

        return User.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .active(request.getActive())
                    .build();
    }
    
}