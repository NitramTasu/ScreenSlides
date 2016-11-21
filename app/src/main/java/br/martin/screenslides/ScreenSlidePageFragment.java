package br.martin.screenslides;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Martin on 18/11/2016.
 */

public class ScreenSlidePageFragment extends Fragment {
    private String content = "Empty";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        TextView textView = (TextView)rootView.findViewById(R.id.text1);

        textView.setText(content);

        return rootView;
    }

    public static ScreenSlidePageFragment create(String content){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();

        fragment.content = content;
        return fragment;
    }
}
