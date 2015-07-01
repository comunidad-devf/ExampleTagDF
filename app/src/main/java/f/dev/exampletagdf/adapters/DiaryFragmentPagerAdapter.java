package f.dev.exampletagdf.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import f.dev.exampletagdf.utils.FragementPagerModel;

/**
 * Created by sati on 30/06/2015.
 */
public class DiaryFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<FragementPagerModel> fragementPagerModels;

    public DiaryFragmentPagerAdapter(FragmentManager fm, List<FragementPagerModel> fragementPagerModels) {
        super(fm);
        this.fragementPagerModels = fragementPagerModels;
    }

    @Override
    public Fragment getItem(int position) {
        return fragementPagerModels.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragementPagerModels.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragementPagerModels.get(position).getTitle();
    }


}
