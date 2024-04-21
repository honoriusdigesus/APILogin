package io.crud.loginv2.domain.mapper;

import io.crud.loginv2.data.entity.UserEntity;
import io.crud.loginv2.domain.model.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDomain fromEntityToDomain(UserEntity userEntity) {
        return new UserDomain(userEntity.getId(), userEntity.getUsername(), userEntity.getEmail(), userEntity.getPassword());
    }
    public UserEntity fromDomainToEntity(UserDomain userDomain) {
        return new UserEntity(userDomain.id(), userDomain.name(), userDomain.email(), userDomain.password());
    }
}
