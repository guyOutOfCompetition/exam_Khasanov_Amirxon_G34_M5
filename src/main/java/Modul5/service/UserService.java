package Modul5.service;

import Modul5.domain.User;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

public interface UserService {
    List<User> USERS = new ArrayList<>();
    User login(String username, String pasword);
    void  registration(User user) throws MessagingException;
    void editPassvord(User user, String newPassword) throws MessagingException;
}
