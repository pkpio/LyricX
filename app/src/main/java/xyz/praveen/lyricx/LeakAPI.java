package xyz.praveen.lyricx;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import xyz.praveen.lyricx.model.GetLyricResult;

/**
 * Created by praveen on 08.06.15.
 */
public interface LeakAPI {

    @GET("/Leak")
    void SendLeak(
            @Query("data") String data,
            Callback<String> cb
    );
}
