package io.crud.loginv2.data.repository;

import io.crud.loginv2.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, UUID> {
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email AND u.password = :password")
    Optional<UserEntity> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
