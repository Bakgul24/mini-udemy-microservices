package com.bakgul.user.data.dal;

import com.bakgul.user.data.entity.User;
import com.bakgul.user.data.repository.IUserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Lazy
public class UserServiceHelper {
    private final IUserRepository m_userRepository;

    public UserServiceHelper(IUserRepository userRepository) {
        m_userRepository = userRepository;
    }

    public Optional<User> findUserByEmail(String email) {
        return m_userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        return m_userRepository.save(user);
    }

    public Iterable<User> findByName(String name) {
        return m_userRepository.findByFirstName(name);
    }
}
