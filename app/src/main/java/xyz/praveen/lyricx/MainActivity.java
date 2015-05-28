package xyz.praveen.lyricx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mobprofs.retrofit.converters.SimpleXmlConverter;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import xyz.praveen.lyricx.model.GetLyricResult;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView helloTv = (TextView) findViewById(R.id.hello);

        // Rest adapter
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Param.API_ENDPOINT)
                .setConverter(new SimpleXmlConverter())
                .build();

        // Instance of API from adapter
        ChartLyricsAPI clApi = restAdapter.create(ChartLyricsAPI.class);

        // Callback
        Callback<GetLyricResult> mCb = new Callback<GetLyricResult>() {
            @Override
            public void success(GetLyricResult getLyricResult, Response response) {
                helloTv.setText(getLyricResult.getLyric());
            }

            @Override
            public void failure(RetrofitError error) {
                helloTv.setText(error.toString());
            }
        };

        // Make a call
        clApi.searchLyricDirect("michael jackson", "bad", mCb);
    }
}
