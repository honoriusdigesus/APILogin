package io.crud.loginv2.config;

import io.crud.loginv2.domain.mapper.SessionMapper;
import io.crud.loginv2.domain.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MappersConfig {
    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public SessionMapper sessionMapper(UserMapper userMapper) {
        return new SessionMapper(userMapper);
    }

}
