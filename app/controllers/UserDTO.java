package controllers;

public record UserDTO(Long id,
                      String nickname,
                      String email,
                      String password) {
}
