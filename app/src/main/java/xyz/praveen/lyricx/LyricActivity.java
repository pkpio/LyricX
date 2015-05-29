package xyz.praveen.lyricx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


public class LyricActivity extends AppCompatActivity implements Callback<GetLyricResult> {
    ImageView albumartView;
    AutofitTextView songTitleView;
    AutofitTextView artistView;
    AutofitTextView rankView;
    TextView songLyricsView;

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

        // Setup a REST adapter
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Param.API_ENDPOINT)
                .setConverter(new SimpleXmlConverter())
                .build();

        // An Instance of API using REST adapter
        ChartLyricsAPI clApi = restAdapter.create(ChartLyricsAPI.class);

        // Make an API search call
        clApi.searchLyricDirect(artist, song, this);
    }

    @Override
    public void success(GetLyricResult mLyric, Response response) {
        songTitleView.setText(mLyric.getLyricSong());
        artistView.setText(mLyric.getLyricArtist());
        songLyricsView.setText(mLyric.getLyric());
        rankView.setText(getString(R.string.l_rank, mLyric.getLyricRank()));
        Picasso.with(this)
                .load(mLyric.getLyricCovertArtUrl())
                .placeholder(R.drawable.albumart)
                .error(R.drawable.albumart)
                .into(albumartView);
    }

    @Override
    public void failure(RetrofitError error) {
        rankView.setText(getString(R.string.l_rank, 0));
        songLyricsView.setText(error.toString());
    }
}
