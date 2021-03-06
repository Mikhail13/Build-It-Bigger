package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import za.co.mikhails.nanodegree.jokeslib.JokeSource;
import za.co.mikhails.nanodegree.showjokesandroidlib.ShowJokeActivity;

public class MainActivity extends ActionBarActivity implements AsyncTaskResultListener {

    private final JokeSource jokeSource = new JokeSource();
    private MainActivityFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAttachFragment(android.support.v4.app.Fragment fragment) {
        super.onAttachFragment(fragment);
        this.fragment = (MainActivityFragment) fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        fragment.showLoadingIndicator(true);

        // *** Get joke from Java Library ***
//        final String newJoke = jokeSource.getJoke();
//        Toast.makeText(this, newJoke, Toast.LENGTH_SHORT).show();

        // *** Launch Activity from Android Library ***
//        Intent intent = new Intent(this, ShowJokeActivity.class);
//        intent.putExtra(ShowJokeActivity.JOKE_TEXT, newJoke);
//        startActivity(intent);

        // *** Run async task to fetch joke from GCE ***
        new GetJokeAsyncTask(this).execute(getResources().getString(R.string.backend_base_url));
    }

    @Override
    public void setResult(String result) {
        fragment.showLoadingIndicator(false);

        Intent intent = new Intent(this, ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.JOKE_TEXT, result);
        this.startActivity(intent);
    }
}
