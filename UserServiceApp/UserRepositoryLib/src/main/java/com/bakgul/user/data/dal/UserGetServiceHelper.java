package com.bakgul.user.data.dal;

import com.bakgul.user.data.entity.User;
import com.bakgul.user.data.repository.IUserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Lazy
public class UserGetServiceHelper {
    private final IUserRepository m_userRepository;

    public UserGetServiceHelper(IUserRepository userRepository) {
        m_userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return m_userRepository.findByEmail(email);
    }

    public Iterable<User> findByName(String name) {
        return m_userRepository.findByFirstName(name);
    }
    public boolean existsUserById(int id) { return m_userRepository.existsById(id);}
}
