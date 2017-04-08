package bigi.testretoflistv;

/**
 * Created by bigi on 08.04.2017.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {

   // @GET("discover/movie?api_key=ba8e8a114ce7fc27aa71ebec8c0b1afe&language=ru-RU&")
  //  Call<ExampleRandom> RandomZp(@Query("page") int Rj);
    @GET("android/jsonandroid")
    Call<JSONResponse> getJSON();
}