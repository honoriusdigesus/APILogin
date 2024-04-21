package io.crud.loginv2.data.repository;

import io.crud.loginv2.data.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface SessionRepositoryJPA extends JpaRepository<SessionEntity, UUID> {
    @Query("SELECT s FROM SessionEntity s WHERE s.userEntity.id = :userId")
    Optional<SessionEntity> getSessionByUserId(@Param("userId") UUID userId);
}
