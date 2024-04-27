package io.crud.loginv2.persistence.controller;

import io.crud.loginv2.domain.usecase.CreateUserCaseUse;
import io.crud.loginv2.domain.usecase.DeleteUserCaseUse;
import io.crud.loginv2.domain.usecase.SearchUserUseCase;
import io.crud.loginv2.domain.usecase.UpdateUserCaseUse;
import io.crud.loginv2.persistence.mapper.UserPresenterMapper;
import io.crud.loginv2.persistence.model.UserPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    private final CreateUserCaseUse createUserCaseUses;
    private final UserPresenterMapper userPresenterMapper;
    private final DeleteUserCaseUse deleteUserCaseUses;
    private final SearchUserUseCase searchUserUseCase;
    private final UpdateUserCaseUse updateUserCaseUses;

    public UserController(CreateUserCaseUse createUserCaseUses, UserPresenterMapper userPresenterMapper, DeleteUserCaseUse deleteUserCaseUses, SearchUserUseCase searchUserUseCase, UpdateUserCaseUse updateUserCaseUses) {
        this.createUserCaseUses = createUserCaseUses;
        this.userPresenterMapper = userPresenterMapper;
        this.deleteUserCaseUses = deleteUserCaseUses;
        this.searchUserUseCase = searchUserUseCase;
        this.updateUserCaseUses = updateUserCaseUses;
    }

    @PostMapping("/create")
    public ResponseEntity<UserPresenter> create(@RequestBody UserPresenter userPresenter) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userPresenterMapper.fromDomainToPresenter(createUserCaseUses.createUser(userPresenterMapper.fromPresenterToDomain(userPresenter))));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserPresenter> delete(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userPresenterMapper.fromDomainToPresenter(deleteUserCaseUses.deleteUser(id)));
    }

    @GetMapping("search/{id}")
    public ResponseEntity<UserPresenter> search(@PathVariable UUID id) {
        return ResponseEntity
               .status(HttpStatus.OK)
               .body(userPresenterMapper.fromDomainToPresenter(searchUserUseCase.searchUser(id)));
    }

    @PutMapping("update")
    public ResponseEntity<UserPresenter> update(@RequestBody UserPresenter userPresenter) {
        return ResponseEntity
               .status(HttpStatus.OK)
               .body(userPresenterMapper.fromDomainToPresenter(updateUserCaseUses.update(userPresenterMapper.fromPresenterToDomain(userPresenter))));
    }
}
