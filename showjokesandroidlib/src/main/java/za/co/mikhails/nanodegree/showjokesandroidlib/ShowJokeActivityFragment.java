package za.co.mikhails.nanodegree.showjokesandroidlib;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowJokeActivityFragment extends Fragment {

    public ShowJokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_joke, container, false);
    }

    public void setJokeText(String text) {
        TextView textView = (TextView) getView().findViewById(R.id.libraryJokeTextView);
        textView.setText(text);
    }
}
