package io.crud.loginv2.domain.model;

import java.util.UUID;

public record UserDomain(UUID id, String name, String email, String password) {
}
