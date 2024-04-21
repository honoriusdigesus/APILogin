package io.crud.loginv2.persistence.mapper;

import io.crud.loginv2.domain.model.SessionDomain;
import io.crud.loginv2.persistence.model.SessionPresenter;
import org.springframework.stereotype.Component;

@Component
public class SessionPresenterMapper {
    public SessionPresenter fromSessionDomainToSessionPresenter(SessionDomain sessionDomain) {
        return new SessionPresenter(
                sessionDomain.id(),
                sessionDomain.startTime(),
                sessionDomain.endTime(),
                sessionDomain.userDomain());
    }

    public SessionDomain fromSessionPresenterToSessionDomain(SessionPresenter sessionPresenter) {
        return new SessionDomain(
                sessionPresenter.getId(),
                sessionPresenter.getStartTime(),
                sessionPresenter.getEndTime(),
                sessionPresenter.getUserDomain());
    }
}