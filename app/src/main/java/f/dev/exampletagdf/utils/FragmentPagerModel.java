package f.dev.exampletagdf.utils;

import android.support.v4.app.Fragment;

/**
 * Created by sati on 30/06/2015.
 */
public class FragmentPagerModel {

    private Fragment fragment;
    private CharSequence title;

    public FragmentPagerModel(Fragment fragment, CharSequence title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public CharSequence getTitle() {
        return title;
    }
}
