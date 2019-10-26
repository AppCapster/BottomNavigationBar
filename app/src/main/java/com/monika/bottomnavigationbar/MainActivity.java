package com.monika.bottomnavigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBottomBar();

    }

    private void setupBottomBar() {
        final Toolbar toolbar = findViewById(R.id.homeToolbar);
        toolbar.setTitle(R.string.title_events);
        setSupportActionBar(toolbar);

        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_bar);

        BottomBarItem item1 = new BottomBarItem(R.drawable.ic_event_available_black_24dp, R.string.title_events);
        BottomBarItem item2 = new BottomBarItem(R.drawable.ic_dashboard_black_24dp, R.string.title_inapp);
        BottomBarItem item3 = new BottomBarItem(R.drawable.ic_notifications_black_24dp, R.string.title_notifications);
        BottomBarItem item4 = new BottomBarItem(R.drawable.ic_settings_black_24dp, R.string.title_settings);

        bottomNavigationBar
                .addTab(item1)
                .addTab(item2)
                .addTab(item3)
                .addTab(item4);
        Fragment fragment = MyFragment.newInstance("monika", "kale");
        loadFragment(fragment);
        bottomNavigationBar.setOnSelectListener(new BottomNavigationBar.OnSelectListener() {
            @Override
            public void onSelect(int position) {
                Fragment fragment;
                switch (position) {
                    case 0:
                        toolbar.setTitle(R.string.title_events);
                        fragment = MyFragment.newInstance("monika", "kale");
                        loadFragment(fragment);
                        break;
                    case 1:
                        toolbar.setTitle(R.string.title_inapp);
                        fragment = MyFragment.newInstance("monika1", "kale1");
                        loadFragment(fragment);
                        break;
                    case 2:
                        toolbar.setTitle(R.string.title_notifications);
                        fragment = MyFragment.newInstance("Key", "Value");
                        loadFragment(fragment);
                        break;
                    case 3:
                        toolbar.setTitle(R.string.title_settings);
                        fragment = MyFragment.newInstance("Key1", "Value1");
                        loadFragment(fragment);
                        break;
                }
            }
        });

        //only for translucent system navbar
//        if (shouldAddNavigationBarPadding()) {
//            //if your bottom bar has fixed height
//            //you'll need to increase its height as well
//            bottomNavigationBar.setPadding(0, 0, 0, getSystemNavigationBarHeight());
//        }
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
