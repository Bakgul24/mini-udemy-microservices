package org.berat.app.service.miniedu.user.service;

import com.bakgul.user.data.dal.UserServiceHelper;
import com.bakgul.user.data.entity.User;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserService {
    private final UserServiceHelper m_userServiceHelper;

    public UserService(UserServiceHelper userServiceHelper) {
        m_userServiceHelper = userServiceHelper;
    }

    public Optional<User> findByEmail(String email) {
        return m_userServiceHelper.findUserByEmail(email);
    }
}

