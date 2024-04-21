package io.crud.loginv2.persistence.mapper;

import io.crud.loginv2.domain.model.UserDomain;
import io.crud.loginv2.persistence.model.UserPresenter;
import org.springframework.stereotype.Component;

@Component
public class UserPresenterMapper {
    public UserDomain fromPresenterToDomain(UserPresenter userPresenter){
        return new UserDomain(
                userPresenter.id(),
                userPresenter.name(),
                userPresenter.email(),
                userPresenter.password());
    }
    public UserPresenter fromDomainToPresenter(UserDomain userDomain){
        return new UserPresenter(
                userDomain.id(),
                userDomain.name(),
                userDomain.email(),
                userDomain.password());
    }
}
