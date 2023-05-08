package service;

import controllers.UserDTO;
import controllers.UserRequest;

import java.util.List;

public interface UserService {

    List<UserDTO> findAllUsers();
    UserDTO findUserById(Long userId);
    Long createUser(UserRequest userRequest);
    UserDTO updateUser(Long userId, UserRequest userRequest);
    boolean deleteUser(Long userId);
}
