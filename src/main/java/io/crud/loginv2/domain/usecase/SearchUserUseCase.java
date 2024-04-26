package io.crud.loginv2.domain.usecase;

import io.crud.loginv2.data.repository.UserRepositoryJPA;
import io.crud.loginv2.domain.mapper.UserMapper;
import io.crud.loginv2.domain.model.UserDomain;
import io.crud.loginv2.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SearchUserUseCase {
    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;

    public SearchUserUseCase(UserRepositoryJPA userRepositoryJPA, UserMapper userMapper) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.userMapper = userMapper;
    }

    public UserDomain searchUser(UUID id) {
        return userMapper.fromEntityToDomain(userRepositoryJPA.findById(id).orElseThrow(() -> new UserNotFoundException("Associated user not found")));
    }
}
