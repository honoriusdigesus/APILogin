package io.crud.loginv2.persistence.model;

import java.util.UUID;

public record UserPresenter(UUID id, String name, String email, String password) {
}