package io.crud.loginv2.config;

import io.crud.loginv2.domain.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {
    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }
}
