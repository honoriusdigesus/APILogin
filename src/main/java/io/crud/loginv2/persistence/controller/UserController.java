package io.crud.loginv2.persistence.controller;

import io.crud.loginv2.domain.usecase.CreateUserCaseUses;
import io.crud.loginv2.persistence.mapper.UserPresenterMapper;
import io.crud.loginv2.persistence.model.UserPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    private final CreateUserCaseUses createUserCaseUses;
    private final UserPresenterMapper userPresenterMapper;

    public UserController(CreateUserCaseUses createUserCaseUses, UserPresenterMapper userPresenterMapper) {
        this.createUserCaseUses = createUserCaseUses;
        this.userPresenterMapper = userPresenterMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<UserPresenter> create(@RequestBody UserPresenter userPresenter) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userPresenterMapper.fromDomainToPresenter(createUserCaseUses.createUser(userPresenterMapper.fromPresenterToDomain(userPresenter))));
    }
}
