package io.crud.loginv2.domain.usecase;


import io.crud.loginv2.data.entity.SessionEntity;
import io.crud.loginv2.data.entity.UserEntity;
import io.crud.loginv2.data.repository.SessionRepositoryJPA;
import io.crud.loginv2.data.repository.UserRepositoryJPA;
import io.crud.loginv2.domain.mapper.SessionMapper;
import io.crud.loginv2.domain.model.SessionDomain;
import io.crud.loginv2.exception.InvalidEmailNullOrBlankException;
import io.crud.loginv2.utils.Validator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Component
public class InitSessionCaseUse {
    private final SessionRepositoryJPA sessionRepositoryJPA;
    private final UserRepositoryJPA userRepositoryJPA;
    private final SessionMapper sessionMapper;
    private final Validator validator;

    public InitSessionCaseUse(SessionRepositoryJPA sessionRepositoryJPA, UserRepositoryJPA userRepositoryJPA, SessionMapper sessionMapper, Validator validator) {
        this.sessionRepositoryJPA = sessionRepositoryJPA;
        this.userRepositoryJPA = userRepositoryJPA;
        this.sessionMapper = sessionMapper;
        this.validator = validator;
    }


    public Optional<SessionDomain> initSession(String email, String password) {

        if (email == null || email.equals(String.valueOf(""))) {
            throw new InvalidEmailNullOrBlankException("User email cannot be null or blank");
        }
        Optional<UserEntity> userFound = userRepositoryJPA.findByEmailAndPassword(email, password);

        if (userFound.isPresent()) {
            UserEntity userEntity = userFound.get();
            System.out.println("Username and password are correct");

            Optional<SessionEntity> sessionFound = sessionRepositoryJPA.getSessionByUserId(userEntity.getId());
            if (sessionFound.isPresent()) {
                LocalDateTime currentTime = LocalDateTime.now();
                SessionEntity sessionEntity = sessionFound.get();

                if (sessionEntity.getEndTime().isBefore(currentTime)) {
                    sessionEntity.setStartTime(currentTime);
                    sessionEntity.setEndTime(currentTime.plusMinutes(5));
                    SessionEntity sessionUpdate = sessionRepositoryJPA.save(sessionEntity);
                    System.out.println("Session updated successfully.");
                    return Optional.ofNullable(sessionMapper.fromSessionEntityToDomain(sessionUpdate));
                } else {
                    long minutesUntilExpiration = ChronoUnit.MINUTES.between(currentTime, sessionEntity.getEndTime());
                    System.out.println("Session is valid and expires in " + minutesUntilExpiration + " minutes");
                    return Optional.ofNullable(sessionMapper.fromSessionEntityToDomain(sessionEntity));
                }

            } else {
                SessionEntity mySession = new SessionEntity();
                mySession.setStartTime(LocalDateTime.now());
                mySession.setEndTime(LocalDateTime.now().plusMinutes(5));
                mySession.setUserEntity(userFound.get());
                SessionEntity sessionUpdate = sessionRepositoryJPA.save(mySession);
                System.out.println("Session created successfully.");
                return Optional.ofNullable(sessionMapper.fromSessionEntityToDomain(mySession));
            }

        } else {
            throw new InvalidEmailNullOrBlankException("Verify your details to log in");
        }
    }
}
