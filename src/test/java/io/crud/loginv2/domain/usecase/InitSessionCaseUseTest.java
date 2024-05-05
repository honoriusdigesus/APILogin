package io.crud.loginv2.domain.usecase;

import io.crud.loginv2.data.entity.UserEntity;
import io.crud.loginv2.data.repository.SessionRepositoryJPA;
import io.crud.loginv2.data.repository.UserRepositoryJPA;
import io.crud.loginv2.domain.mapper.SessionMapper;
import io.crud.loginv2.domain.model.SessionDomain;
import io.crud.loginv2.exception.InvalidEmailNullOrBlankException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class InitSessionCaseUseTest {

    @Test
    void whenEmailIsNullShouldReturnException(){
        //Arrange
        SessionRepositoryJPA sessionRepositoryJPA = Mockito.mock(SessionRepositoryJPA.class);
        UserRepositoryJPA userRepositoryJPA = Mockito.mock(UserRepositoryJPA.class);
        SessionMapper sessionMapper = Mockito.mock(SessionMapper.class);
        CreateSessionCaseUse createSessionCaseUse = Mockito.mock(CreateSessionCaseUse.class);


        InitSessionCaseUse initSessionCaseUse = new InitSessionCaseUse(sessionRepositoryJPA,userRepositoryJPA,sessionMapper,createSessionCaseUse);
        //Act
        //Assert

        assertThrows(InvalidEmailNullOrBlankException.class, () -> initSessionCaseUse.initSession(null,null));
    }

    @Test
    void whenEmailAndPassIsValidShouldReturnSessionDomain(){
        //Arrange
        SessionRepositoryJPA sessionRepositoryJPA = Mockito.mock(SessionRepositoryJPA.class);
        UserRepositoryJPA userRepositoryJPA = Mockito.mock(UserRepositoryJPA.class);
        SessionMapper sessionMapper = Mockito.mock(SessionMapper.class);
        CreateSessionCaseUse createSessionCaseUse = Mockito.mock(CreateSessionCaseUse.class);
        SessionDomain sessionDomain = Mockito.mock(SessionDomain.class);

        UserEntity userEntity = Mockito.mock(UserEntity.class);

        given(userRepositoryJPA.findByEmailAndPassword("test@test.com", "123456"))
                .willReturn(Optional.of(userEntity));

        InitSessionCaseUse initSessionCaseUse = new InitSessionCaseUse(sessionRepositoryJPA,userRepositoryJPA,sessionMapper,createSessionCaseUse);
        //Act
        //Assert
        // verify(userRepositoryJPA.findByEmailAndPassword("test@test.com", "123456"));
        assertEquals(Optional.empty(), initSessionCaseUse.initSession("test@test.com","123456"));
    }

}