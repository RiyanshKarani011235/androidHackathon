package riyanshkarani011235.com.github.io.hackathon;

/**
 * Created by ironstein on 24/12/16.
 */

import android.app.Activity;
import android.content.Context;
import android.content.pm.LauncherApps;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.telecom.Call;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DownloadImageTask extends AsyncTask<String, Void, Boolean> {

    private String mUrl;
    private Bitmap mBitmap;
    private ImageView mImageView;

    public DownloadImageTask(String url, ImageView imageView) {
        mUrl = url;
        mImageView = imageView;
    }

    @Override
    protected Boolean doInBackground(String... urls) {

        // set up connection
        InputStream inputStream;
        try {
            URL url = new URL(mUrl);
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(10000 /* milliseconds */);
                connection.setConnectTimeout(15000 /* milliseconds */);
                try {
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);

                    // start the query
                    try {
                        connection.connect(); // if connection is not established, throws IOException
                        int response = connection.getResponseCode();
                        Log.i("resopnse code is", "" + response);
                        inputStream = connection.getInputStream();
                    } catch (java.io.IOException e) {
                        Log.e("error connecting", e.toString());
                        return false;
                    }
                } catch (java.net.ProtocolException e) {
                    Log.e("error set requestMethod", e.toString());
                    return false;
                }
            } catch (java.io.IOException e) {
                Log.e("url open conn. error", e.toString());
                return false;
            }
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
            return false;
        }

        mBitmap = getBitmapFromInputStream(inputStream);
        return true;
    }

    @Override
    public void onPostExecute(Boolean done) {
        if(done) {
            mImageView.setImageBitmap(mBitmap);
        }
    }

//    @Override
//    public void onPreExecute() {
//        mImageView.setImageBitmap(null);
//    }

    private Bitmap getBitmapFromInputStream(InputStream inputStream) {
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        return bitmap;
    }

}