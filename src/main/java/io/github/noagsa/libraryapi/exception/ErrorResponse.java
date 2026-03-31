package io.github.noagsa.libraryapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.web.server.ServerHttpSecurity;

import java.time.Instant;

public record ErrorResponse(String message, HttpStatus httpStatus, Instant timestamp, String path) {
}
