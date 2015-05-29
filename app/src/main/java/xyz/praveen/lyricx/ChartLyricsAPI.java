package xyz.praveen.lyricx;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import xyz.praveen.lyricx.model.GetLyricResult;

/**
 * Created by praveen on 28/5/15.
 */
public interface ChartLyricsAPI {

    @GET("/SearchLyricDirect")
    void searchLyricDirect(
            @Query("artist") String artist,
            @Query("song") String song,
            Callback<GetLyricResult> cb
    );

    @GET("/SearchLyricDirect")
    GetLyricResult searchLyricDirect(
            @Query("artist") String artist,
            @Query("song") String song
    );

}
