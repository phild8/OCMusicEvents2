package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import static edu.orangecoastcollege.cs273.ocmusicevents2.R.id.eventImageView;
import static edu.orangecoastcollege.cs273.ocmusicevents2.R.id.eventTitleTextView;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);


        Intent intent = getIntent();

        String title = intent.getStringExtra("Title");
        String details = intent.getStringExtra("Details");
        String time = intent.
        String imageFileName = title.replace(" ", "") + ".jpeg";

        ImageView mEventImageView = (ImageView) findViewById(eventImageView);
        TextView mEventTitleTextView = (TextView) findViewById(eventTitleTextView);
        TextView mEventDateDayTextView = (TextView) findViewById(R.id.eventDateDayTextView);
        TextView mEventTimeTextView = (TextView) findViewById(R.id.eventTimeTextView);
        TextView mEventLocationTextView = (TextView) findViewById(R.id.eventLocationTextView);
        TextView mEventAddress1TextView = (TextView) findViewById(R.id.eventAddress1TextView);
        TextView mEventAddress2TextView = (TextView) findViewById(R.id.eventAddress2TextView);

        AssetManager am = this.getAssets();
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, title);
            mEventImageView.setImageDrawable(image);
        }
        catch (IOException e)
        {
            Log.e("OC Music Events", "Error loading image: " + imageFileName, e);
        }
        mEventTitleTextView.setText(title);
        mEventDateDayTextView.setText(details);
        mEventTimeTextView.setText();
        mEventLocationTextView.setText();
        mEventAddress1TextView.setText();
        mEventAddress2TextView.setText();
    }

    protected void goBackToList(View v)
    {
        finish();
    }
}
