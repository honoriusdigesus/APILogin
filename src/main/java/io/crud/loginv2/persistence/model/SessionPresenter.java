package io.crud.loginv2.persistence.model;

import io.crud.loginv2.domain.model.UserDomain;

import java.time.LocalDateTime;
import java.util.UUID;

public class SessionPresenter {
    private UUID id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private UserDomain userDomain;


    public SessionPresenter() {
    }

    public SessionPresenter(UUID id, LocalDateTime startTime, LocalDateTime endTime, UserDomain userDomain) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userDomain = userDomain;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public UserDomain getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(UserDomain userDomain) {
        this.userDomain = userDomain;
    }
}
