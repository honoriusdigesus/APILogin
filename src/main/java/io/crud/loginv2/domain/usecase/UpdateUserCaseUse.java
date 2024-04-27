package io.crud.loginv2.domain.usecase;

import io.crud.loginv2.data.repository.UserRepositoryJPA;
import io.crud.loginv2.domain.mapper.UserMapper;
import io.crud.loginv2.domain.model.UserDomain;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserCaseUse {
    private final UserRepositoryJPA userRepository;
    private final UserMapper userMapper;
    private final SearchUserUseCase searchUserUseCase;

    public UpdateUserCaseUse(UserRepositoryJPA userRepository, UserMapper userMapper, SearchUserUseCase searchUserUseCase) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.searchUserUseCase = searchUserUseCase;
    }

    public UserDomain update(UserDomain userDomain) {
        UserDomain userFound = searchUserUseCase.searchUser(userDomain.id());
        if (userFound != null){
            UserDomain updatedUser = new UserDomain(
                    userDomain.id(),
                    userDomain.name(),
                    userDomain.email(),
                    userDomain.password()
            );

            return userMapper.fromEntityToDomain(userRepository.save(userMapper.fromDomainToEntity(updatedUser)));
        }
        return userMapper.fromEntityToDomain(userRepository.save(userMapper.fromDomainToEntity(userDomain)));
    }
}
