package com.supertetelman.amtmodernartui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.content.Intent;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.graphics.Rect;

import android.widget.TextView;



//TODO Display 5 differently colored rectangles ( 1 white, 1 gray, 1 color, 1 red, 1 black)
//TODO OPtional add a slider that modifies the rectangle colours


public class AmtModernArt extends ActionBarActivity {
    static final String MOMA_URL = "http://www.MoMA.org";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_amt_modern_art);

        if (savedInstanceState == null) {
       ;
            getFragmentManager().beginTransaction().add(R.id.fragment_container, new SquareFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_amt_modern_art, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.more_information) {
            onClickMoreInformation();
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean onClickMoreInformation() {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        openMomaUrl();
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(AmtModernArt.this);
        builder.setMessage("Would you like to learn more by visiting the MoMA website?");
        builder.setPositiveButton("Visit Moma", dialogClickListener);
        builder.setNegativeButton("Not Now", dialogClickListener);
        builder.show();
        return true;
    }

    private boolean openMomaUrl() {
        Intent momaBrowseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(MOMA_URL));
        startActivity(momaBrowseIntent);
        return true;
    }
}




