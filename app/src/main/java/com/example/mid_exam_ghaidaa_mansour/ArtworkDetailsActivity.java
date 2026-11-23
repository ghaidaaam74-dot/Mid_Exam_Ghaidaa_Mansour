package com.example.mid_exam_ghaidaa_mansour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView detailsInfoTextView = findViewById(R.id.detailsInfoTextView);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra(MainActivity.EXTRA_TITLE);
            String artist = intent.getStringExtra(MainActivity.EXTRA_ARTIST);
            String year = intent.getStringExtra(MainActivity.EXTRA_YEAR);

            String detailsText = "Title: " + (title != null ? title : "N/A") + "\n"
                    + "Artist: " + (artist != null ? artist : "N/A") + "\n"
                    + "Year: " + (year != null ? year : "N/A");

            if (detailsInfoTextView != null) {
                detailsInfoTextView.setText(detailsText);
            }
        }
    }

    public void goBack(View view) {
        finish();
    }
}
