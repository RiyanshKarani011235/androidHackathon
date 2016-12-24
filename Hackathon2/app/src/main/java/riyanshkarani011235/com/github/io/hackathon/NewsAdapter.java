package riyanshkarani011235.com.github.io.hackathon;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ironstein on 24/12/16.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    static class ViewHolder {
        TextView description;
        TextView name;
        TextView city;
        TextView time;
        TextView comments;
        TextView imageUrl;
        TextView pimgUrl;
        ImageView image;
    }

    ViewHolder viewHolder;

    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View newsView = convertView;

        if(newsView == null) {
            // inflate new view
            newsView = LayoutInflater.from(getContext()).inflate(R.layout.news_card, parent, false);

            // initialize ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.description = (TextView) newsView.findViewById(R.id.description);
            viewHolder.name = (TextView) newsView.findViewById(R.id.name);
            viewHolder.city = (TextView) newsView.findViewById(R.id.city);
            viewHolder.time = (TextView) newsView.findViewById(R.id.time);
            viewHolder.comments = (TextView) newsView.findViewById(R.id.comments);
            viewHolder.imageUrl = (TextView) newsView.findViewById(R.id.image_url);
            viewHolder.image = (ImageView) newsView.findViewById(R.id.image);
            newsView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) newsView.getTag();
        }

        final News news = getItem(position);
        viewHolder.description.setText(news.getDescription());
        viewHolder.name.setText(news.getName());
        viewHolder.city.setText(news.getCity());
        viewHolder.time.setText(news.getTime());
        viewHolder.comments.setText(news.getComments());
        viewHolder.imageUrl.setText(news.getImgUrl());

//        Drawable drawable = viewHolder.image.getDrawable();
//        boolean hasImage = (drawable != null);
//
//        if (hasImage && (drawable instanceof BitmapDrawable)) {
//            hasImage = ((BitmapDrawable)drawable).getBitmap() != null;
//        }
//        if(!hasImage) {
//            new DownloadImageTask(getContext(), viewHolder.image, news.getImgUrl());
//        }
//        return newsView;
        viewHolder.image.setImageBitmap(GetImageFromUrl.getImageBitmap(news.getImgUrl()));
        return newsView;
    }

}
