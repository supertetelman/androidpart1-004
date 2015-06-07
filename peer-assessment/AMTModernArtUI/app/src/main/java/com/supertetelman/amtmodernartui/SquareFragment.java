package com.supertetelman.amtmodernartui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.graphics.Color;
public class SquareFragment extends Fragment {
    private int c1, c2, c3, c4, c5, c6;
    private View v1, v2, v3, v4 ,v5 ,v6;
    public SquareFragment(){

    }

    //statndard onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_square, container, false);

        //import colors
        c1 = getResources().getColor(R.color.c1);
        c2 = getResources().getColor(R.color.c2);
        c3 = getResources().getColor(R.color.c3);
        c4 = getResources().getColor(R.color.c4);
        c5 = getResources().getColor(R.color.c5);
        c6 = getResources().getColor(R.color.c6);

        //import views
        v1 = (View) view.findViewById((R.id.v1));
        v2 = (View) view.findViewById((R.id.v2));
        v3 = (View) view.findViewById((R.id.v3));
        v4 = (View) view.findViewById((R.id.v4));
        v5 = (View) view.findViewById((R.id.v5));
        v6 = (View) view.findViewById((R.id.v6));

        //Override the slider to it changes colors when updated
        final SeekBar seekBar = (SeekBar)view.findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                changeColors(1 - ((float) progress / 100));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        return view;
    }

    //Update the square colors
    private void changeColors(float percent) {
        //v1.setBackgroundColor(updatedColor(c1,percent));
        //v2.setBackgroundColor(updatedColor(c2,percent));
        v3.setBackgroundColor(updatedColor(c3,percent));
        v4.setBackgroundColor(updatedColor(c4,percent));
        v5.setBackgroundColor(updatedColor(c5,percent));
        v6.setBackgroundColor(updatedColor(c6,percent));
    }

//Function to take a value from the slider and original color and return a new value
    private int updatedColor(int color, float percentage)
    {
        int r = (int)((float)Color.red(color) * percentage);
        int g = Color.green(color);
        int b = (int)((float)Color.blue(color) * percentage);
        int a = Color.alpha(color);

        return Color.argb(a,r,g,b);
    }
}
