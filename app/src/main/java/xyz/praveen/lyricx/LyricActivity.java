package xyz.praveen.lyricx;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobprofs.retrofit.converters.SimpleXmlConverter;
import com.squareup.picasso.Picasso;

import me.grantland.widget.AutofitTextView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import xyz.praveen.lyricx.model.GetLyricResult;


public class LyricActivity extends AppCompatActivity {
    ImageView albumartView;
    AutofitTextView songTitleView;
    AutofitTextView artistView;
    AutofitTextView rankView;
    TextView songLyricsView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric);

        // Get search info
        Bundle extras = getIntent().getExtras();
        String artist = extras.getString("artist");
        String song = extras.getString("song");

        // Init widgets
        albumartView = (ImageView) findViewById(R.id.l_albumart);
        songTitleView = (AutofitTextView) findViewById(R.id.l_title);
        artistView = (AutofitTextView) findViewById(R.id.l_artist);
        rankView = (AutofitTextView) findViewById(R.id.l_rank);
        songLyricsView = (TextView) findViewById(R.id.l_lyrics);
        context = this;

        // Setup a REST adapter
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Param.API_ENDPOINT)
                .setConverter(new SimpleXmlConverter())
                .build();

        // An Instance of API using REST adapter
        ChartLyricsAPI clApi = restAdapter.create(ChartLyricsAPI.class);

        // Async Callback to act on result
        Callback<GetLyricResult> mCb = new Callback<GetLyricResult>() {
            @Override
            public void success(GetLyricResult getLyricResult, Response response) {
                songTitleView.setText(getLyricResult.getLyricSong());
                artistView.setText(getLyricResult.getLyricArtist());
                songLyricsView.setText(getLyricResult.getLyric());
                rankView.setText(getString(R.string.l_rank, getLyricResult.getLyricRank()));
                Picasso.with(context).load(getLyricResult.getLyricCovertArtUrl())
                        .into(albumartView);
                getLyricResult.getLyricRank();
            }

            @Override
            public void failure(RetrofitError error) {
                songLyricsView.setText(error.toString());
            }
        };

        // Make an API search call
        clApi.searchLyricDirect(artist, song, mCb);
    }
}
