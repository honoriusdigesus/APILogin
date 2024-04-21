package io.crud.loginv2.domain.usecase;

import io.crud.loginv2.data.repository.UserRepositoryJPA;
import io.crud.loginv2.domain.mapper.UserMapper;
import io.crud.loginv2.domain.model.UserDomain;
import io.crud.loginv2.exception.InvalidEmailFormatException;
import io.crud.loginv2.exception.InvalidPasswordUserException;
import io.crud.loginv2.exception.InvalidUserNameException;
import io.crud.loginv2.utils.Validator;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCaseUses {
    private final UserRepositoryJPA userRepository;
    private final UserMapper userMapper;
    private final Validator validator;

    public CreateUserCaseUses(UserRepositoryJPA userRepository, UserMapper userMapper, Validator validator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.validator = validator;
    }

    public UserDomain createUser(UserDomain userDomain){
        if (validator.isValidEmail(userDomain.email()) == false || userDomain.email().isBlank() ||userDomain.email().isBlank()){
            throw new InvalidEmailFormatException("Invalid email format: "+userDomain.email());
        }

        if (validator.isValidPassword(userDomain.password()) == false ){
            throw new InvalidPasswordUserException("The password must meet the following: minimum 8 characters." +
                    "Maximum 32 characters." +
                    "It must have uppercase and lowercase letters, at least 1 number and a special character");
        }

        if (userDomain.name().isBlank()){
            throw new InvalidUserNameException("User name is required");
        }

        return userMapper.fromEntityToDomain(userRepository.save(userMapper.fromDomainToEntity(userDomain)));
    }
}
