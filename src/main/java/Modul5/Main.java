package Modul5;

import Modul5.domain.DateApi;
import Modul5.domain.User;
import Modul5.service.UserService;
import Modul5.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    static Scanner scInt = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws IOException, InterruptedException, MessagingException {

        while (true){
            User user = loginAndRegestr();
            while (true){
                printMainMenu();
                int userChoise = scInt.nextInt();
                if (userChoise == 0){
                    break;
                }
                switch (userChoise){
                    case 1 ->{
                        System.out.println("Enter new password ");
                        String newPassword = scStr.nextLine();
                        userService.editPassvord(user,newPassword);
                    }
                    case 2 ->{
                        System.out.println("About which date want to know? ");
                        System.out.println("Enter month");
                        int month = scInt.nextInt();
                        System.out.println("Enter day");
                        int day = scInt.nextInt();

                    }
                }
            }
        }
    }

    public static void significantPart(int month, int day) throws IOException, InterruptedException {
        String formatter = String.format("https://numbersapi.p.rapidapi.com/%s/%s/date?fragment=true&json=true", month ,day );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://numbersapi.p.rapidapi.com/6/21/date?fragment=true&json=true"))
                .header("X-RapidAPI-Key", "b565374268msh60c0d2e0de714d4p185990jsn88433488225e")
                .header("X-RapidAPI-Host", "numbersapi.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        Gson gson = new Gson();
        DateApi api = gson.fromJson(response.body(), DateApi.class);
        System.out.println(api);
    }

    public static User loginAndRegestr() throws MessagingException {
        while(true){
        printStartMenu();
        int uuserInput = scInt.nextInt();
        if(uuserInput == 0){
            break;
        }
        switch (uuserInput) {
            case 1 -> {
                System.out.println("Enter Username");
                String username = scStr.nextLine();
                System.out.println("Enter Password");
                String password = scStr.nextLine();
                User user = userService.login(username, password);
                return user;
            }
            case 2 -> {
                System.out.println("Enter Name");
                String name = scStr.nextLine();
                System.out.println("Enter Username");
                String username = scStr.nextLine();
                System.out.println("Enter Password");
                String password = scStr.nextLine();
                System.out.println("Enter age");
                Integer age = scInt.nextInt();
                System.out.println("Enter email");
                String email = scStr.nextLine();
                User user = User.builder()
                        .name(name)
                        .age(age)
                        .email(email)
                        .password(password)
                        .username(username)
                        .build();
                userService.registration(user);
            }
        }
        }
        throw new RuntimeException();
    }

    public static void printStartMenu() {
        System.out.println("""
                1. Login
                2. Registrtion
                0.Exit
                """);
    }
    public static void printMainMenu(){
        System.out.println("""
                1.Change password
                2.Get information about date
                0.Log Out
                """);
    }
}