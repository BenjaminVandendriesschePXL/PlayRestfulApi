package service.impl;

import controllers.UserDTO;
import controllers.UserRequest;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<UserDTO> findAllUsers() {
        return null;
    }

    @Override
    public UserDTO findUserById(Long userId) {
        return null;
    }

    @Override
    public Long createUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long userId, UserRequest userRequest) {
        return null;
    }

    @Override
    public boolean deleteUser(Long userId) {
        return false;
    }
}
