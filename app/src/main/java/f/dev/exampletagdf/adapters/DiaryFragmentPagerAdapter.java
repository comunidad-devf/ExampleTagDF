package f.dev.exampletagdf.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import f.dev.exampletagdf.utils.FragmentPagerModel;

/**
 * Created by sati on 30/06/2015.
 */
public class DiaryFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<FragmentPagerModel> fragmentPagerModels;

    public DiaryFragmentPagerAdapter(FragmentManager fm, List<FragmentPagerModel> fragmentPagerModels) {
        super(fm);
        this.fragmentPagerModels = fragmentPagerModels;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentPagerModels.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragmentPagerModels.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentPagerModels.get(position).getTitle();
    }


}
