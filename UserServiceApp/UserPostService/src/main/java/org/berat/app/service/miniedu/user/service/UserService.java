package org.berat.app.service.miniedu.user.service;

import com.bakgul.user.data.dal.UserPostServiceHelper;
import com.bakgul.user.data.entity.dto.UserSaveDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   private final UserPostServiceHelper m_userServiceHelper;

    public UserService(UserPostServiceHelper userServiceHelper) {
        m_userServiceHelper = userServiceHelper;
    }

    public UserSaveDTO saveUser(UserSaveDTO userDto) {
        return m_userServiceHelper.saveUser(userDto);
    }
}

