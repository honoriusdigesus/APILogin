package io.crud.loginv2.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record SessionDomain(UUID id,
                            LocalDateTime startTime,
                            LocalDateTime endTime,
                            UserDomain userDomain) {
}
