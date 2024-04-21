package io.crud.loginv2.data.repository;

import io.crud.loginv2.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, UUID> {
}
