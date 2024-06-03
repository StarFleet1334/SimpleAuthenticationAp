package com.auth.simple.action;


import com.auth.simple.api.request.UserLoginRequest;
import com.auth.simple.api.request.UserRegisterRequest;
import com.auth.simple.entity.User;
import com.auth.simple.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAction.class);

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public boolean exists(UserRegisterRequest userRegisterRequest) {
        return userRepository.existsByEmail(userRegisterRequest.getEmail());
    }

    public void register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public boolean login(UserLoginRequest userLoginRequest) {
        return userRepository.findByEmail(userLoginRequest.getEmail())
                .map(user -> {
                    boolean passwordMatches = bCryptPasswordEncoder.matches(userLoginRequest.getPassword(), user.getPassword());
                    return passwordMatches;
                })
                .orElseGet(() -> {
                    System.out.println("Debug: No user found with email: " + userLoginRequest.getEmail());
                    return false;
                });
    }



    public User convertToUser(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword());
        return user;
    }
}
