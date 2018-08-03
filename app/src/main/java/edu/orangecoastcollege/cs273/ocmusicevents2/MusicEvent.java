package edu.orangecoastcollege.cs273.ocmusicevents2;

import java.util.Objects;

/**
 * The MusicEvent class is a place holder for data corresponding to music events
 * occurring within Orange County, including title, date, day, time, location,
 * address and a corresponding image.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class MusicEvent {

    private String mTitle;
    private String mDate;
    private String mDay;
    private String mTime;
    private String mLocation;
    private String mAddress1;
    private String mAddress2;
    private String mImageName;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String day) {
        mDay = day;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getAddress1() {
        return mAddress1;
    }

    public void setAddress1(String address1) {
        mAddress1 = address1;
    }

    public String getAddress2() {
        return mAddress2;
    }

    public void setAddress2(String address2) {
        mAddress2 = address2;
    }

    public String getImageName() {
        return mImageName;
    }

    public void setImageName(String imageName) {
        mImageName = imageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicEvent)) return false;
        MusicEvent that = (MusicEvent) o;
        return Objects.equals(mTitle, that.mTitle) &&
                Objects.equals(mDate, that.mDate) &&
                Objects.equals(mDay, that.mDay) &&
                Objects.equals(mTime, that.mTime) &&
                Objects.equals(mLocation, that.mLocation) &&
                Objects.equals(mAddress1, that.mAddress1) &&
                Objects.equals(mAddress2, that.mAddress2) &&
                Objects.equals(mImageName, that.mImageName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mTitle, mDate, mDay, mTime, mLocation, mAddress1, mAddress2, mImageName);
    }

    @Override
    public String toString() {
        return "MusicEvent{" +
                "mTitle='" + mTitle + '\'' +
                ", mDate='" + mDate + '\'' +
                ", mDay='" + mDay + '\'' +
                ", mTime='" + mTime + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mAddress1='" + mAddress1 + '\'' +
                ", mAddress2='" + mAddress2 + '\'' +
                ", mImageName='" + mImageName + '\'' +
                '}';
    }
}
