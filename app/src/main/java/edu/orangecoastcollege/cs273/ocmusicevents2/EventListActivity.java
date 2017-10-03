package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

/**
 * The Controller of the first activity. Loads and displays a ListView with ListViewItems of
 * images, titles, and dates. Allows the user to interact with the UI and select a band that
 * they would like to find out more about.
 *
 * @author Phillip Davis
 * @version 1
 */
public class EventListActivity extends ListActivity {

    private List<MusicEvent> mAllEventsList;


    /**
     * Loads the ListView that has the ListItemViews inside.
     * @param savedInstanceState Loads a saved instance if there is one.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            mAllEventsList = JSONLoader.loadJSONFromAsset(this);
        } catch (IOException e){
            Log.e("OC Music Events", "Error loading from JSON", e);
        }

        //setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
        setListAdapter(new EventListAdapter(this, R.layout.music_event_list_item, mAllEventsList));

    }

    /**
     * Starts the second activity. The activity is based on the ListViewItem that the user has
     * selected. The the activity sends the title, date, date, time, location, address1,
     * address2, and the imagename to the second activity.
     * @param l The ListView that contains the data to be displayed
     * @param v The ListViewItem that user has selected.
     * @param position The position of the ListViewItem inside of the ListView
     * @param id the ID of the ListViewItem
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);

        MusicEvent selectedEvent = mAllEventsList.get(position);

        detailsIntent.putExtra("Title", selectedEvent.getTitle());
        detailsIntent.putExtra("Date", selectedEvent.getDate());
        detailsIntent.putExtra("Day", selectedEvent.getDay());
        detailsIntent.putExtra("Time", selectedEvent.getTime());
        detailsIntent.putExtra("Location", selectedEvent.getLocation());
        detailsIntent.putExtra("Address1", selectedEvent.getAddress1());
        detailsIntent.putExtra("Address2", selectedEvent.getAddress2());
        detailsIntent.putExtra("ImageName", selectedEvent.getImageName());

        startActivity(detailsIntent);
    }
}
