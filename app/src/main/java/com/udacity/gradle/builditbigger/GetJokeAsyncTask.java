package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import za.co.mikhails.nanodegree.jokes.backend.myApi.MyApi;
import za.co.mikhails.nanodegree.showjokesandroidlib.ShowJokeActivity;

public class GetJokeAsyncTask extends AsyncTask<String, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    public GetJokeAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... urls) {
        String result = null;
        if (urls.length == 1) {
            if (myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl(urls[0])
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                myApiService = builder.build();
            }

            try {
                result = myApiService.getJoke().execute().getData();
            } catch (IOException e) {
                result = e.getMessage();
            }
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.JOKE_TEXT, result);
        context.startActivity(intent);
    }
}
