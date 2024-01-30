package Modul5.service.impl;

import Modul5.domain.User;
import Modul5.service.EmailService;
import Modul5.service.UserService;

import javax.mail.MessagingException;
import java.util.Random;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    static EmailService emailService = new EmailServiceImpl();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public User login(String username, String pasword) {
        for(User user : USERS){
            if(user.getUsername().equals(username) && user.getPassword().equals(pasword)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void registration(User user) throws MessagingException {
        int i = 5;
        do {
            Random random = new Random();
            int num = 10000 + random.nextInt(90000);
//            emailService.sendEmail(user.getEmail(), num);
            int emailAnswer = scanner.nextInt();
            if (num == emailAnswer) {
                USERS.add(user);
                break;
            }
        }while (i > 0);
    }

    @Override
    public void editPassvord(User user, String newPassword) throws MessagingException {
        int i = 5;
        do {
            Random random = new Random();
            int num = 10000 + random.nextInt(90000);
//            emailService.sendEmail(user.getEmail(), num);
            int emailAnswer = scanner.nextInt();
            if (num == emailAnswer) {
                user.setPassword(newPassword);
                break;
            }
        }while (i > 0);
    }
}
