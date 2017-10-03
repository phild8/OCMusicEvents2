package edu.orangecoastcollege.cs273.ocmusicevents2;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * This is a interface Creates a object that will be displayed in a ListView. The the object will
 * have a picture title and details.
 *
 * @author Phillip Davis
 * @version 1.0
 *
 * Created by pdavis11 on 9/26/2017.
 */

public class EventListAdapter extends ArrayAdapter<MusicEvent>{

    private Context mContext;
    private int mResource;
    private List<MusicEvent> mAllEventsList;

    // context = Activity that uses the adapter (EventListActivity)
    // resource = Layout file to inflate (R.layout.music_event_list_item)
    // objects = List<MusicEvent>
    public EventListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<MusicEvent> allMusicEvents) {
        super(context, resource, allMusicEvents);

        mContext = context;
        mResource = resource;
        mAllEventsList = allMusicEvents;
    }

    /**
     * This inflates the view object and loads the views for the object to display. ImageView,
     * TextView, and another TextView.
     *
     * @param position The position the object is in the ListView.
     * @param convertView @Nullable
     * @param parent @NonNull
     * @return The the ListViewItem to add to the list.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Use "Inflater" to inflate the custom layout we just made (R.layout.music_event_list_item)
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // Inflating the custom layout for one single item in the list (repeated  multiple times)
        View listItemView = inflater.inflate(mResource, null);

        ImageView listItemImageView = (ImageView) listItemView.findViewById(R.id.listItemImageView);
        TextView listItemTitleTextView = (TextView) listItemView.findViewById(R.id.listItemTitleTextView);
        TextView listItemDateTextView = (TextView) listItemView.findViewById(R.id.listItemDateTextView);

        MusicEvent selectedEvent = mAllEventsList.get(position);
        listItemTitleTextView.setText(selectedEvent.getTitle());
        listItemDateTextView.setText(selectedEvent.getDate());

        // Use the AssetManager to retrieve the image
        AssetManager am = mContext.getAssets();


        try { // Try - Catch because file may not be there
            InputStream stream = am.open(selectedEvent.getImageName());
            Drawable image = Drawable.createFromStream(stream, selectedEvent.getTitle());
            listItemImageView.setImageDrawable(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listItemView;

    }
}
