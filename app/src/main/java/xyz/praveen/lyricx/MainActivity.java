package xyz.praveen.lyricx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.s_search_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final EditText artistView = (EditText) findViewById(R.id.s_artist);
        final EditText songView = (EditText) findViewById(R.id.s_song);
        String artist = artistView.getText().toString();
        String song = songView.getText().toString();

        if (artist.length() == 0) {
            artistView.setError(getString(R.string.s_artist_error));
            return;
        }

        if (song.length() == 0) {
            songView.setError(getString(R.string.s_song_error));
            return;
        }

        Intent i = new Intent(this, LyricActivity.class);
        i.putExtra("artist", artist);
        i.putExtra("song", song);
        startActivity(i);
    }
}
