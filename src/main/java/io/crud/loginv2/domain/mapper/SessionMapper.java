package io.crud.loginv2.domain.mapper;

import io.crud.loginv2.data.entity.SessionEntity;
import io.crud.loginv2.domain.model.SessionDomain;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper {
    private final UserMapper userMapper;

    public SessionMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public SessionDomain fromSessionEntityToDomain(SessionEntity sessionEntity) {
        return new SessionDomain(
                sessionEntity.getId(),
                sessionEntity.getStartTime(),
                sessionEntity.getEndTime(),
                userMapper.fromEntityToDomain(sessionEntity.getUserEntity()));
    }

    public SessionEntity fromSessionDomainToEntity(SessionDomain sessionDomain) {
        return new SessionEntity(
                sessionDomain.id(),
                sessionDomain.startTime(),
                sessionDomain.endTime(),
                userMapper.fromDomainToEntity(sessionDomain.userDomain()));
    }
}
