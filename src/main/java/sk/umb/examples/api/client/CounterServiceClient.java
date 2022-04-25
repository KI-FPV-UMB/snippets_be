package sk.umb.examples.api.client;

import sk.umb.examples.api.api.CounterService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CounterServiceClient implements CounterService {
    private final HttpClient httpClient = HttpClient.newBuilder().build();

    @Override
    public int increment(int number) {
        try {
            return getFromUrl(number);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getFromUrl(int number) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(new URI("http://localhost:8080/api/" + number))
                                         .GET()
                                         .build();

        String responseBody = httpClient.send(request,
                                              HttpResponse.BodyHandlers.ofString())
                                         .body();

        return Integer.parseInt(responseBody);
    }
}
