package com.example.sevencardstud;

import jakarta.servlet.annotation.WebServlet;
import okhttp3.*;
import org.json.JSONObject;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class Login {

    private static final String API_URL = "https://us-east-1.aws.data.mongodb-api.com/app/data-zijhp/endpoint/data/v1/action/find";
    private static final String API_KEY = "9FraaR50K7EYEiJhvH4WaOR08l991xPJRR5Wuo8jSZgNdgvhUHRlS0P93NcMFp60A"; // Replace with your API key

    private OkHttpClient client;

    public void Login() {
        this.client = new OkHttpClient();
    }

    public void login(OkHttpClient client) {
        this.client = client;
    }

    public boolean validateCredentials(String username, String password) {
        // Prepare payload
        JSONObject payload = new JSONObject();
        payload.put("collection", "users");
        payload.put("database", "users");
        payload.put("dataSource", "CS489");
        payload.put("query", "{username: \"" + username + "\", password: \"" + password + "\"}");

        // Make request to MongoDB API
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                payload.toString()
        );

        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("api-key", API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                assert response.body() != null;
                String responseBody = response.body().string();
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Assuming your MongoDB API returns an array of users
                return !jsonResponse.getJSONArray("users").isEmpty();
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        Login login = new Login();

        // Test
        if (login.validateCredentials("testUsername", "testPassword")) {
            System.out.println("Valid credentials!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}
