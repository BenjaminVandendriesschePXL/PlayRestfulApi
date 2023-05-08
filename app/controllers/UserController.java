package controllers;

import service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    public UserDTO getUserById(Long id){
        return userService.findUserById(id);
    }
}
