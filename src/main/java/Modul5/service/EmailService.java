package Modul5.service;

import javax.mail.MessagingException;

public interface EmailService {
    void sendEmail(String toEmail, int msg) throws MessagingException;
}
