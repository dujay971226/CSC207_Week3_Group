import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoreDB {

    public static String[] findJournal(String content, String entityType) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        HttpUrl.Builder urlBuilder
                = HttpUrl.parse("https://api.core.ac.uk/v3/search/" + entityType + "/")
                .newBuilder();
        urlBuilder.addQueryParameter("api_key", "gauLY1I9Himz3kJOxdhpQEv52q0lP4BW");
        urlBuilder.addQueryParameter("q", content);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();


        Response response = client.newCall(request).execute();
        System.out.println(response);
        JSONObject responseBody = new JSONObject(response.body().string());


        JSONArray result = responseBody.getJSONArray("results");
        List<String> converter = new ArrayList<>();
        for(int i = 0; i < result.length(); i++){
            converter.add(result.getJSONObject(i).toString());
        }
        int size = converter.size();
        return converter.toArray(new String[size]);
    }

}
