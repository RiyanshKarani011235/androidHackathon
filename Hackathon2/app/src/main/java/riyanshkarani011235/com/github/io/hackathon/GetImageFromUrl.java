package riyanshkarani011235.com.github.io.hackathon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static riyanshkarani011235.com.github.io.hackathon.R.id.imageView;

/**
 * Created by ironstein on 24/12/16.
 */

public class GetImageFromUrl {

    public static Bitmap getImageBitmap(String url) {

        Bitmap bitmap = null;
        try {
            InputStream in = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;

    }
}
