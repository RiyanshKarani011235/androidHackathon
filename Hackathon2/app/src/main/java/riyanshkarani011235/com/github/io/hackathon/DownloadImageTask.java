package riyanshkarani011235.com.github.io.hackathon;

/**
 * Created by ironstein on 24/12/16.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
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

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private final ImageView mDestination;
    private final String mUrl;

    public DownloadImageTask(Context context, ImageView destination, String url) {
        mDestination = destination;
        mUrl = url;
    }

    protected Bitmap doInBackground(String... urls) {
        String urlDisplay = mUrl;
        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(urlDisplay).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap result) {
        mDestination.setImageBitmap(result);
    }
}
