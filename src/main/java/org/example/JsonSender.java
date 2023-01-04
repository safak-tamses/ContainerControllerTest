package org.example;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonSender {

    public int send(String url, String jsonData) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonData))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse response = client.send(request,HttpResponse.BodyHandlers.ofString());
        return response.statusCode();

    }


}
