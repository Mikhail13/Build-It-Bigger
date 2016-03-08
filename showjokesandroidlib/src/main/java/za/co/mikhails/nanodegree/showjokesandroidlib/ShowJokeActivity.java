package za.co.mikhails.nanodegree.showjokesandroidlib;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ShowJokeActivity extends ActionBarActivity {

    public static final String JOKE_TEXT = "joke_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        String stringExtra = getIntent().getStringExtra(JOKE_TEXT);
        ShowJokeActivityFragment fragment = (ShowJokeActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragment.setJokeText(stringExtra);
    }

}
