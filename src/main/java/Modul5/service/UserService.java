package Modul5.service;

import Modul5.domain.User;

public interface UserService {
    User login(String username, String pasword);
    void  registration(User user);
}
