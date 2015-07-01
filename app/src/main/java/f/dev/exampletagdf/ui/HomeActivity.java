package f.dev.exampletagdf.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import f.dev.exampletagdf.R;
import f.dev.exampletagdf.fragments.AboutFragment;
import f.dev.exampletagdf.fragments.DiaryFragment;
import f.dev.exampletagdf.fragments.GuetsFragment;
import f.dev.exampletagdf.fragments.MapEventFragment;
import f.dev.exampletagdf.interfaces.ReplaceToolbar;

public class HomeActivity extends AppCompatActivity implements ReplaceToolbar {

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Bind(R.id.navigation_view)
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        setupDrawerContent();

        replaceFragment(new DiaryFragment());

    }

    private void setupDrawerContent() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                Log.d("Entro", "menuitem");
                switch (menuItem.getItemId()) {
                    case R.id.item_nav_explore:
                        replaceFragment(new DiaryFragment());
                        break;
                    case R.id.item_nav_people:
                        replaceFragment(new GuetsFragment());
                        break;
                    case R.id.item_nav_map:
                        replaceFragment(new MapEventFragment());
                        break;
                    case R.id.item_nav_info:
                        replaceFragment(new AboutFragment());
                        break;
                }

                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


    private void replaceFragment (Fragment newFragment)
    {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, newFragment)
                .commit();
    }

    @Override
    public void onReplaceToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
