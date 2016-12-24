package riyanshkarani011235.com.github.io.hackathon;

import android.app.Activity;
import android.graphics.Bitmap;

/**
 * Created by ironstein on 24/12/16.
 */

public class News {

    private String mDescription;
    private String mName;
    private String mCity;
    private String mTime;
    private String mComments;
    private String mImgUrl;
    private String mPimgUrl;

    public News(String description, String name, String city, String time, String comments, String imageUrl, String pimgUrl) {
        mDescription = description;
        mName = name;
        mCity = city;
        mTime = time;
        mComments = comments;
        mImgUrl = imageUrl;
        mPimgUrl = pimgUrl;
    }

    @Override
    public String toString() {
        String returnString = "";
        returnString += "description : " + mDescription + "\n";
        returnString += "name : " + mName + "\n";
        returnString += "city : " + mCity + "\n";
        returnString += "time : " + mTime + "\n";
        returnString += "comments : " + mComments + "\n";
        returnString += "imageUrl : " + mImgUrl + "\n";
        returnString += "pimgUrl : " + mPimgUrl + "\n";
        return returnString;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getName() {
        return mName;
    }

    public String getCity() {
        return mCity;
    }

    public String getTime() {
        return mTime;
    }

    public String getComments() {
        return mComments;
    }

    public String getImgUrl() {
        return mImgUrl;
    }

    public String getPImgUrl() {
        return mPimgUrl;
    }
}
