package io.crud.loginv2.domain.usecase;

import io.crud.loginv2.data.repository.SessionRepositoryJPA;
import io.crud.loginv2.domain.mapper.SessionMapper;
import io.crud.loginv2.domain.model.SessionDomain;
import org.springframework.stereotype.Component;

@Component
public class CreateSessionCaseUse {
    private final SessionRepositoryJPA sessionRepository;
    private final SessionMapper sessionMapper;


    public CreateSessionCaseUse(SessionRepositoryJPA sessionRepository, SessionMapper sessionMapper) {
        this.sessionRepository = sessionRepository;
        this.sessionMapper = sessionMapper;
    }

    public SessionDomain createSession(SessionDomain sessionDomain){
        return sessionMapper.fromSessionEntityToDomain(sessionRepository.save(sessionMapper.fromSessionDomainToEntity(sessionDomain)));
    }
}
