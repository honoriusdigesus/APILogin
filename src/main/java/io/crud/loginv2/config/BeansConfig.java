package io.crud.loginv2.config;

import io.crud.loginv2.data.repository.SessionRepositoryJPA;
import io.crud.loginv2.data.repository.UserRepositoryJPA;
import io.crud.loginv2.domain.mapper.SessionMapper;
import io.crud.loginv2.domain.mapper.UserMapper;
import io.crud.loginv2.domain.usecase.CreateUserCaseUses;
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
    public CreateUserCaseUses createUserCaseUses(UserRepositoryJPA userRepository, UserMapper userMapper, Validator validator){
        return new CreateUserCaseUses(userRepository, userMapper, validator);
    }

    @Bean
    public InitSessionCaseUse initSessionCaseUse(SessionRepositoryJPA sessionRepositoryJPA, UserRepositoryJPA userRepositoryJPA, SessionMapper sessionMapper, Validator validator){
        return new InitSessionCaseUse(sessionRepositoryJPA, userRepositoryJPA, sessionMapper, validator);
    }

}