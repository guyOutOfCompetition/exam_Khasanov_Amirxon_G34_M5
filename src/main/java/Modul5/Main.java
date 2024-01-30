package Modul5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://numbersapi.p.rapidapi.com/1/1/date?fragment=true&json=true"))
                .header("X-RapidAPI-Key", "af9116a428msh4b750dd4631aa07p138e80jsna48c4dd95f88")
                .header("X-RapidAPI-Host", "numbersapi.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}