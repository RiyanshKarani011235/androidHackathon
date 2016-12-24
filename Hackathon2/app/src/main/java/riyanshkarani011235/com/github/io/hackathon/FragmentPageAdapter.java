package riyanshkarani011235.com.github.io.hackathon;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by shubh on 24-12-2016.
 */

public class FragmentPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };
    private Context context;

    public FragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return MusicTabFragment.newInstance(null, null);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if(position==0)
            return context.getResources().getString(R.string.music_string);
        else
            return context.getResources().getString(R.string.news_string);


    }
}
