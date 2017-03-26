/**
 * Created by bigi on 26.03.2017.
 */

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static final String API_URL = "https://dnevnik.gamekillers.ru/";

    public static class Contributor {
        public final String login;
        public final String contributions;

        public Contributor(String login, String contributions) {
            this.login = login;
            this.contributions = contributions;
        }
    }

    public interface GitHub {
        @POST("dnevnik/login")
        Call<List<Contributor>> contributors(@FieldMap Map<String, String> map);
        //Call<Object> getReg(@FieldMap Map<String, String> map);
    }

    public static void main(String... args) throws IOException {
        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        GitHub github = retrofit.create(GitHub.class);
        Map<String,String> mapjs = new HashMap<String, String>();
        mapjs.put("login", "admin");
        mapjs.put("password", "password");
        // Create a call instance for looking up Retrofit contributors.
        Call<List<Contributor>> call = github.contributors(mapjs);

        // Fetch and print a list of the contributors to the library.
        List<Contributor> contributors = call.execute().body();
        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }
    }
}
