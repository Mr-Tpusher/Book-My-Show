package com.tpusher.bms.service;

import com.tpusher.bms.dto.request.RegisterUserRequest;
import com.tpusher.bms.dto.request.UserLoginRequest;
import com.tpusher.bms.entity.User;
import com.tpusher.bms.exception.IncorrectPasswordException;
import com.tpusher.bms.exception.UserNameAlreadyExistsException;
import com.tpusher.bms.exception.UserNotFoundException;
import com.tpusher.bms.repository.UserRepository;
import com.tpusher.bms.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    public User registerUser(RegisterUserRequest request) {

        // 1. check if username already exists
        userRepository.findByUsername(request.getUsername())
                .ifPresent(u -> {
                    throw new UserNameAlreadyExistsException("user name already exists");
                });

        // 2. encode the password
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        // 3. create the entity
        User user1 = new User(
                request.getUsername(),
                hashedPassword,
                request.getUserRole()
        );

        // 4. save the user
        return userRepository.save(user1);
    }

    public String login(UserLoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found for username=" + request.getUsername()));

        boolean passwordMatched = passwordEncoder.matches(request.getPassword(), user.getHashedPassword());
        if (!passwordMatched) {
            throw new IncorrectPasswordException("incorrect password provided.");
        }
        return jwtUtil.generateToken(user.getId(),user.getUsername(), user.getUserRole());
    }
}
