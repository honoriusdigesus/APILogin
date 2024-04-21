package io.crud.loginv2.persistence.controller;


import io.crud.loginv2.domain.usecase.InitSessionCaseUse;
import io.crud.loginv2.persistence.mapper.SessionPresenterMapper;
import io.crud.loginv2.persistence.model.SessionPresenter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("login")
public class InitSessionController {
    private final InitSessionCaseUse initSessionCaseUse;
    private final SessionPresenterMapper sessionPresenterMapper;

    public InitSessionController(InitSessionCaseUse initSessionCaseUse, SessionPresenterMapper sessionPresenterMapper) {
        this.initSessionCaseUse = initSessionCaseUse;
        this.sessionPresenterMapper = sessionPresenterMapper;
    }

    @GetMapping("/{email}/{password}")
    public Optional<SessionPresenter> findSessionByUserId(@PathVariable String email, @PathVariable String password) {
        return initSessionCaseUse.initSession(email,password).map(sessionPresenterMapper::fromSessionDomainToSessionPresenter);
    }
}
