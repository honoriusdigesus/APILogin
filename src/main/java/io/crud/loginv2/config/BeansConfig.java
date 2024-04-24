package io.crud.loginv2.config;

import io.crud.loginv2.data.repository.SessionRepositoryJPA;
import io.crud.loginv2.data.repository.UserRepositoryJPA;
import io.crud.loginv2.domain.mapper.SessionMapper;
import io.crud.loginv2.domain.mapper.UserMapper;
import io.crud.loginv2.domain.usecase.CreateUserCaseUse;
import io.crud.loginv2.domain.usecase.DeleteUserCaseUse;
import io.crud.loginv2.domain.usecase.InitSessionCaseUse;
import io.crud.loginv2.utils.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    private final UserMapper userMapper;

    public BeansConfig(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Bean
    public CreateUserCaseUse createUserCaseUses(UserRepositoryJPA userRepository, UserMapper userMapper, Validator validator){
        return new CreateUserCaseUse(userRepository, userMapper, validator);
    }

    @Bean
    public InitSessionCaseUse initSessionCaseUse(SessionRepositoryJPA sessionRepositoryJPA, UserRepositoryJPA userRepositoryJPA, SessionMapper sessionMapper, Validator validator){
        return new InitSessionCaseUse(sessionRepositoryJPA, userRepositoryJPA, sessionMapper, validator);
    }

    @Bean
    public DeleteUserCaseUse deleteUserCaseUses(UserRepositoryJPA userRepositoryJPA, UserMapper userMapper){
        return new DeleteUserCaseUse(userRepositoryJPA, userMapper);
    }

}
