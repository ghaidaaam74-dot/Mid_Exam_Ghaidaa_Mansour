package com.example.mid_exam_ghaidaa_mansour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.example.mid_exam_ghaidaa_mansour.extra.TITLE";
    public static final String EXTRA_ARTIST = "com.example.mid_exam_ghaidaa_mansour.extra.ARTIST";
    public static final String EXTRA_YEAR = "com.example.mid_exam_ghaidaa_mansour.extra.YEAR";
    private static final String STATE_INDEX = "current_index";

    private int mCurrentIndex = 0;

    private int[] mImages;
    private String[] mTitles;
    private String[] mArtists;
    private String[] mYears;

    private TextView mCounterTextView;
    private ImageView mArtworkImageView;
    private TextView mTitleTextView;
    private TextView mArtistYearTextView;
    private Button mPreviousButton;
    private Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCounterTextView = findViewById(R.id.counterTextView);
        mArtworkImageView = findViewById(R.id.artworkImageView);
        mTitleTextView = findViewById(R.id.titleTextView);
        mArtistYearTextView = findViewById(R.id.artistYearTextView);
        mPreviousButton = findViewById(R.id.previousButton);
        mNextButton = findViewById(R.id.nextButton);


        initArtworksData();

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(STATE_INDEX, 0);
        }

        updateArtworkUI();
    }

    private void initArtworksData() {
        mImages = new int[]{
                R.drawable.view,
                R.drawable.view2,
                R.drawable.view3,
                R.drawable.view4,
                R.drawable.view5,
                R.drawable.view6
        };

        mTitles = new String[]{
                getString(R.string.view_title_1),
                getString(R.string.view_title_2),
                getString(R.string.view_title_3),
                getString(R.string.view_title_4),
                getString(R.string.view_title_5),
                getString(R.string.view_title_6)
        };

        mArtists = new String[]{
                getString(R.string.view_artist_1),
                getString(R.string.view_artist_2),
                getString(R.string.view_artist_3),
                getString(R.string.view_artist_4),
                getString(R.string.view_artist_5),
                getString(R.string.view_artist_6)
        };

        mYears = new String[]{
                getString(R.string.view_year_1),
                getString(R.string.view_year_2),
                getString(R.string.view_year_3),
                getString(R.string.view_year_4),
                getString(R.string.view_year_5),
                getString(R.string.view_year_6)
        };
    }

    private void updateArtworkUI() {
        if (mTitles.length > 0) {
            mCounterTextView.setText((mCurrentIndex + 1) + " / " + mTitles.length);
            mArtworkImageView.setImageResource(mImages[mCurrentIndex]);
            mTitleTextView.setText(mTitles[mCurrentIndex]);
            mArtistYearTextView.setText(mArtists[mCurrentIndex] + " (" + mYears[mCurrentIndex] + ")");

            mPreviousButton.setEnabled(mCurrentIndex > 0);
            mNextButton.setEnabled(mCurrentIndex < mTitles.length - 1);
        }
    }

    public void previousArtwork(View view) {
        if (mCurrentIndex > 0) {
            mCurrentIndex--;
            updateArtworkUI();
        }
    }

    public void nextArtwork(View view) {
        if (mCurrentIndex < mTitles.length - 1) {
            mCurrentIndex++;
            updateArtworkUI();
        }
    }

    public void openArtworkDetails(View view) {
        Intent intent = new Intent(this, ArtworkDetailsActivity.class);
        intent.putExtra(EXTRA_TITLE, mTitles[mCurrentIndex]);
        intent.putExtra(EXTRA_ARTIST, mArtists[mCurrentIndex]);
        intent.putExtra(EXTRA_YEAR, mYears[mCurrentIndex]);
        startActivity(intent);
    }

    public void visitWebsite(View view) {
        String url = getString(R.string.website_url);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_INDEX, mCurrentIndex);
    }
}
