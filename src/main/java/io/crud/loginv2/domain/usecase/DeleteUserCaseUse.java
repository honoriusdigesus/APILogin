package io.crud.loginv2.domain.usecase;

import io.crud.loginv2.data.entity.UserEntity;
import io.crud.loginv2.data.repository.UserRepositoryJPA;
import io.crud.loginv2.domain.mapper.UserMapper;
import io.crud.loginv2.domain.model.UserDomain;
import io.crud.loginv2.exception.UserNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DeleteUserCaseUse {
    private final UserRepositoryJPA userRepositoryJPA;
    private final UserMapper userMapper;

    public DeleteUserCaseUse(UserRepositoryJPA userRepositoryJPA, UserMapper userMapper) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.userMapper = userMapper;
    }

    public UserDomain deleteUser(UUID id) {
        UserEntity userEntity = userRepositoryJPA
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("Associated user not found"));
        userRepositoryJPA.deleteById(userEntity.getId());
        System.out.println("User deleted successfully");
        return userMapper.fromEntityToDomain(userEntity);
    }
}
