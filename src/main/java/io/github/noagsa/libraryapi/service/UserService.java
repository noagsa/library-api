package io.github.noagsa.libraryapi.service;

import io.github.noagsa.libraryapi.dto.UserRegisterRequestDTO;
import io.github.noagsa.libraryapi.dto.UserResponseDTO;
import io.github.noagsa.libraryapi.exception.EmailAlreadyExistsException;
import io.github.noagsa.libraryapi.model.Role;
import io.github.noagsa.libraryapi.model.User;
import io.github.noagsa.libraryapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO registerUser(UserRegisterRequestDTO userRegisterRequestDTO) {
        if (userRepository.findByEmail(userRegisterRequestDTO.email()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        String encodedPassword = passwordEncoder.encode(userRegisterRequestDTO.password());
        User user = User.builder()
                .email(userRegisterRequestDTO.email())
                .password(encodedPassword)
                .role(Role.USER)
                .build();

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(savedUser.getUserId(), savedUser.getEmail());
    }
}
