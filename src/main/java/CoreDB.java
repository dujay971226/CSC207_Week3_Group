package main.java;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class CoreDB {

    private static final String API_URL = "https://api.core.ac.uk/";
    // load API_TOKEN from env variable.
    private static final String API_TOKEN = System.getenv("gauLY1I9Himz3kJOxdhpQEv52q0lP4BW");

    public static String getApiToken() {
        return API_TOKEN;
    }

    public Search findJournal(String content, String entityType) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("https://api.core.ac.uk/v3/search/" + entityType + "/").newBuilder();
        urlBuilder.addQueryParameter("api_key", "gauLY1I9Himz3kJOxdhpQEv52q0lP4BW");
        urlBuilder.addQueryParameter("q", content);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response);
    }

}
