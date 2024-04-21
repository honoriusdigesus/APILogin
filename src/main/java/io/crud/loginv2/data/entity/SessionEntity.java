package io.crud.loginv2.data.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class SessionEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @OneToOne
    @JoinColumn(name = "user_login_id")
    private UserEntity userEntity;

    public SessionEntity() {
    }

    public SessionEntity(UUID id, LocalDateTime startTime, LocalDateTime endTime, UserEntity userEntity) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userEntity = userEntity;
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}