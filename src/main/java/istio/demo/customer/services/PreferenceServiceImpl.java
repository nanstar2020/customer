package istio.demo.customer.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Component
public class PreferenceServiceImpl implements PreferenceService{
    @Value("${PREFERENCE_URL}")
    private String PREFERENCE_URL;

    public String getPreference() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://" + PREFERENCE_URL + "/preference")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (InterruptedException|IOException ex) {
            return "Unable to get preference";
        }
    }
}
